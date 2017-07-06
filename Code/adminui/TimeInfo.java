package adminui;

import java.sql.Time;

public enum TimeInfo {

    One("08:00"),Two("08:15"),Three("08:30"),Four("08:45"),
    One1("09:00"),Two2("09:15"),Three3("09:30"),Four4("09:45"),
    First("10:00"), Second("10:15"), Third("10:30"), Fourth("10:45"),
    First1("11:00"), Second1("11:15"), Third1("11:30"), Fourth1("11:45"),
    First2("12:00"), Second2("12:15"), Third2("12:30"), Fourth2("12:45"),
    First3("13:00"), Second3("13:15"), Third3("13:30"), Fourth3("13:45"),
    First4("14:00"), Second4("14:15"), Third4("14:30"), Fourth4("14:45"),
    First5("15:00"), Second5("15:15"), Third5("15:30"), Fourth5("15:45"),
    First6("16:00"), Second6("16:15"), Third6("16:30"), Fourth6("16:45"),
    First7("17:00"), Second7("17:15"), Third7("17:30"), Fourth7("17:45"),
    First8("18:00"), Second8("18:15"), Third8("18:30"), Fourth8("18:45"),
    First9("19:00"), Second9("19:15"), Third9("19:30"), Fourth9("19:45"),
    First10("20:00"), Second10("20:15"), Third10("20:30"), Fourth10("20:45"),
    First11("21:00"), Second11("21:15"), Third11("21:30"), Fourth11("21:45"),
    First12("22:00"), Second12("22:15"), Third12("22:30"), Fourth12("22:45"),
    First13("23:00"), Second13("23:15"), Third13("23:30"), Fourth13("23:45"),
    First14("24:05"), Second14("00:15"), Third14("00:30"), Fourth14("00:45"),
    First15("01:00"), Second15("01:15"), Third15("01:30");

    private Time timing;

    public Time getTiming() {
        return timing;
    }

    TimeInfo(String value) {
        this.timing = Time.valueOf(value + ":00");
    }
}
