package napa;

import java.math.BigDecimal;
import java.time.LocalDate;

public enum ClassImplComparable {
//    ABSTRACT_CHRONOLOGY(AbstractChronology .class);
    BIG_DECIMAL(BigDecimal.class),
//    BIG_INTEGER(BigInteger .class);
//    BOOLEAN(Boolean.class),
//    BYTE(Byte.class),
//    BYTE_BUFFER(ByteBuffer .class),
//    CHARACTER(Character.class),
//    CHAR_BUFFER(CharBuffer .class),
//    CHARSET(Charset .class),
//    COLLATION_KEY(CollationKey .class),
//    COMPOSITE_NAME(CompositeName .class),
//    COMPOUND_NAME(CompoundName .class),
//    DATE(Date .class),
//    SQL_DATE(java.sql.Date.class),
//    MINGUO_CHRONOLOGY(MinguoChronology .class),
//    MINGUO_DATE(MinguoDate .class),
//    MONTH_DAY(MonthDay .class),
//    OBJECT_NAME(ObjectName .class),
//    OBJECT_STREAM_FIELD(ObjectStreamField .class),
//    OFFSET_DATE_TIME(OffsetDateTime .class),
//    OFFSET_TIME(OffsetTime .class),
//    RDN(Rdn .class),
//    SHORT(Short.class),
//    SHORT_BUFFER(ShortBuffer .class),
    STRING(String.class),
//    THAI_BUDDHIST_CHRONOLOGY(ThaiBuddhistChronology .class),
//    THAI_BUDDHIST_DATE(ThaiBuddhistDate .class),
//    TIME(Time .class),
//    TIMESTAMP(Timestamp .class),
//    URI(URI .class),
//    UUID(UUID .class),
//    YEAR(Year .class),
//    YEA_MONTH(YearMonth .class),
//    ZONED_DATE_TIME(ZonedDateTime.class),
//    ZONE_OFFSET(ZoneOffset.class),
//    ZONE_OFFSET_TRANSITION(ZoneOffsetTransition .class),
//    DOUBLE(Double.class),
//    DOUBLE_BUFFER(DoubleBuffer .class),
//    DURATION(Duration.class),
//    FILE(File.class),
//    FILE_TIME(FileTime.class),
//    FLOAT(Float.class),
//    FLOAT_BUFFER(FloatBuffer .class),
//    GREGORIAN_CALENDAR(GregorianCalendar .class),
//    HIJRAH_CHRONOLOGY(HijrahChronology.class),
//    HIJRAH_DATE(HijrahDate.class),
//    INSTANT(Instant.class),
//    INTBUFFER(IntBuffer.class),
    INTEGER(Integer.class),
//    ISO_CHRONOLOGY(IsoChronology.class),
//    JAPANESE_CHRONOLOGY(JapaneseChronology.class),
//    JAPANESE_DATE(JapaneseDate.class),
//    LDAP_NAME(LdapName .class),
    LOCAL_DATE(LocalDate.class);
//    LOCAL_DATE_TIME(LocalDateTime.class),
//    LOCAL_TIME(LocalTime.class),
//    LONG(Long.class),
//    LONG_BUFFER(LongBuffer.class),
//    MAPPED_BYTE_BUFFER(MappedByteBuffer.class),

    private final Class c;

    private ClassImplComparable(Class c) {
        this.c = c;
    }

    public Class getImplClass() {
        return c;
    }
}
