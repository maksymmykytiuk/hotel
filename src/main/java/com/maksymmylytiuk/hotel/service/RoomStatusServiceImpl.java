package com.maksymmylytiuk.hotel.service;

import com.maksymmylytiuk.hotel.dao.RoomStatusDao;
import com.maksymmylytiuk.hotel.model.Guest;
import com.maksymmylytiuk.hotel.model.RoomStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RoomStatusServiceImpl implements RoomStatusService {

    @Autowired
    RoomStatusDao roomStatusDao;

    @Override
    public void save(RoomStatus roomStatus) {
        roomStatusDao.save(roomStatus);
    }

    @Override
    public RoomStatus getById(Long id) {
        return roomStatusDao.getOne(id);
    }

    @Override
    public boolean roomIsFreeInPeriod(Long id, Date from, Date to, Guest guest) {
        return roomStatusDao.roomIsNotCheckedinInPeriod(id, from, to)
                && roomStatusDao.roomIsNotBookedInPeriod(id, from, to, guest);
    }

    @Override
    public boolean roomIsFreeInPeriodAndGuest(Long id, Date from, Date to, Guest guest) {
        return roomStatusDao.roomIsFreeInPeriodAndGuest(id, from, to, guest);
    }
}
