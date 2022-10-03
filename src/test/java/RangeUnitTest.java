import napa.Range;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RangeUnitTest {
    @Test
    public void testConcatenate() {
        Range validAgesForHighSchool = Range.of(16, 18);
        assertEquals(false, validAgesForHighSchool.contains(5));
        assertEquals(true, validAgesForHighSchool.contains(17));

        Range open = Range.open(5, 7);
        assertEquals(false, open.contains(5));

        Range closed = Range.closed(5, 7);
        assertEquals(true, closed.contains(5));

        Range openClosed = Range.openClosed(5, 7);
        assertEquals(false, openClosed.contains(5));
        assertEquals(true, openClosed.contains(7));

        Range closedOpen = Range.closedOpen(5, 7);
        assertEquals(true, closedOpen.contains(5));
        assertEquals(false, closedOpen.contains(7));

        Range text = Range.open("abc", "xyz");
        assertEquals(true, text.contains("def"));

        Range decimals = Range.open(new BigDecimal("1.123"), new BigDecimal("1.23456789"));
        assertEquals(true, decimals.contains(new BigDecimal("1.12344")));

        Range dates = Range.closed(LocalDate.of(2022, Month.SEPTEMBER,
                01), LocalDate.of(2022, Month.SEPTEMBER, 30));
        assertEquals(false, dates.contains(LocalDate.now()));
    }
}
