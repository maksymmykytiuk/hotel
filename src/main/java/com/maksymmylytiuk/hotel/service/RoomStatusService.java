package com.maksymmylytiuk.hotel.service;

import com.maksymmylytiuk.hotel.model.Guest;
import com.maksymmylytiuk.hotel.model.RoomStatus;

import java.util.Date;

public interface RoomStatusService {

    void save(RoomStatus roomStatus);

    RoomStatus getById(Long id);

    boolean roomIsFreeInPeriod(Long id, Date from, Date to, Guest guest);

    boolean roomIsFreeInPeriodAndGuest(Long id, Date from, Date to, Guest guest);
}
