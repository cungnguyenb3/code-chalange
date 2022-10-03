package napa;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class Range<T> implements Comparable<T>{
    private static volatile Range range;
    private volatile RangeType type;
    private Object lowerbound;
    private Object upperbound;

    private Range(Object lowerbound, Object upperbound, RangeType type) {
        if (range != null) {
            throw new UnsupportedOperationException("Use of(int lowerbound, int upperbound)");
        }

        this.lowerbound = lowerbound;
        this.upperbound = upperbound;
        this.type = type;
    }

    public static synchronized Range of(int lowerbound, int upperbound) {
        range = initOrUpdateInstance(lowerbound, upperbound, RangeType.CLOSED);
        return range;
    }

    public static synchronized Range open(Object lowerbound, Object upperbound) {
        range = initOrUpdateInstance(lowerbound, upperbound, RangeType.OPEN);
        return range;
    }

    public static synchronized Range closed(Object lowerbound, Object upperbound) {
        range = initOrUpdateInstance(lowerbound, upperbound, RangeType.CLOSED);
        return range;
    }

    public static synchronized Range openClosed(Object lowerbound, Object upperbound) {
        range = initOrUpdateInstance(lowerbound, upperbound, RangeType.OPEN_CLOSED);
        return range;
    }

    public static synchronized Range closedOpen(Object lowerbound, Object upperbound) {
        range = initOrUpdateInstance(lowerbound, upperbound, RangeType.CLOSED_OPEN);
        return range;
    }

    @Override
    public int compareTo(Object o) {
        if (o.getClass().equals(ClassImplComparable.INTEGER.getImplClass())) {
            Integer number = (Integer) o;
            Integer lowerbound = (Integer) this.lowerbound;
            return number.compareTo(lowerbound);
        }

        if (o.getClass().equals(ClassImplComparable.STRING.getImplClass())) {
            String text = (String) o;
            String lowerbound = (String) this.lowerbound;
            return text.compareTo(lowerbound);
        }

        if (o.getClass().equals(ClassImplComparable.LOCAL_DATE.getImplClass())) {
            LocalDate text = (LocalDate) o;
            LocalDate lowerbound = (LocalDate) this.lowerbound;
            return text.compareTo(lowerbound);
        }

        if (o.getClass().equals(ClassImplComparable.BIG_DECIMAL.getImplClass())) {
            BigDecimal bigDecimal = (BigDecimal) o;
            BigDecimal lowerbound = (BigDecimal) this.lowerbound;
            return bigDecimal.compareTo(lowerbound);
        }

        return 0;
    }

    public int compareToUpperbound(Object o) {
        if (o.getClass().equals(ClassImplComparable.INTEGER.getImplClass())) {
            Integer number = (Integer) o;
            Integer upperbound = (Integer) this.upperbound;
            return number.compareTo(upperbound);
        }

        if (o.getClass().equals(ClassImplComparable.STRING.getImplClass())) {
            String text = (String) o;
            String upperbound = (String) this.upperbound;
            return text.compareTo(upperbound);
        }

        if (o.getClass().equals(ClassImplComparable.LOCAL_DATE.getImplClass())) {
            LocalDate text = (LocalDate) o;
            LocalDate upperbound = (LocalDate) this.upperbound;
            return text.compareTo(upperbound);
        }

        if (o.getClass().equals(ClassImplComparable.BIG_DECIMAL.getImplClass())) {
            BigDecimal bigDecimal = (BigDecimal) o;
            BigDecimal upperbound = (BigDecimal) this.upperbound;
            return bigDecimal.compareTo(upperbound);
        }

        return 0;
    }

    public boolean contains(Object x) {
        if (range.type.equals(RangeType.OPEN)) {
            if (range.compareTo(x) > 0 && range.compareToUpperbound(x) < 0) {
                return true;
            }
        }
        if (range.type.equals(RangeType.CLOSED)) {
            if (range.compareTo(x) >= 0 && range.compareToUpperbound(x) <= 0) {
                return true;
            }
        }
        if (range.type.equals(RangeType.OPEN_CLOSED)) {
            if (range.compareTo(x) > 0 && range.compareToUpperbound(x) <= 0) {
                return true;
            }
        }
        if (range.type.equals(RangeType.CLOSED_OPEN)) {
            if (range.compareTo(x) >= 0 && range.compareToUpperbound(x) < 0) {
                return true;
            }
        }
        return false;
    }

    private static Range initOrUpdateInstance(Object lowerbound, Object upperbound, RangeType type) {
        validateCreateRange(lowerbound, upperbound);
        checkValidParam(lowerbound, upperbound);

        if (range == null) {
            range = new Range(lowerbound, upperbound, type);
        } else {
            range.lowerbound = lowerbound;
            range.upperbound = upperbound;
            range.type = type;
        }
        return range;
    }

    private static void validateCreateRange(Object lowerbound, Object upperbound) {
        if (lowerbound.getClass().equals(ClassImplComparable.INTEGER.getImplClass())
        && upperbound.getClass().equals(ClassImplComparable.INTEGER.getImplClass())) {
            Integer lowerboundNumber = (Integer) lowerbound;
            Integer upperboundNumber = (Integer) upperbound;
            if (lowerboundNumber > upperboundNumber) {
                throw new UnsupportedOperationException("lowerbound must not be greater than upperbound");
            }
        }
    }

    private static boolean checkValidParam(Object lowerbound, Object upperbound) {
        for (ClassImplComparable classImpl: ClassImplComparable.values()) {
            if (classImpl.getImplClass().equals(lowerbound.getClass())
            && classImpl.getImplClass().equals(upperbound.getClass())) {
                return true;
            }
        }
        return false;
    }
}
