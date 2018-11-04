package com.maksymmylytiuk.hotel.constants;

public class RoomStatusConstant {

    public static final Long FREE = 0L;
    public static final Long BOOKED = 1L;
    public static final Long CHECKED_IN = 2L;

    public static Long getByName(String name) {
        switch (name.toUpperCase()) {
            case "FREE":
                return FREE;
            case "BOOKED":
                return BOOKED;
            case "CHECKED_IN":
                return CHECKED_IN;
            default:
                return FREE;
        }
    }
}
