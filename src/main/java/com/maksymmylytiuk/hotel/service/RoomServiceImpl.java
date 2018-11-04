package com.maksymmylytiuk.hotel.service;

import com.maksymmylytiuk.hotel.dao.RoomDao;
import com.maksymmylytiuk.hotel.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomDao roomDao;

    @Override
    public void save(Room room) {
        roomDao.save(room);
    }

    @Override
    public Room getById(Long id) {
        return roomDao.getOne(id);
    }
}
