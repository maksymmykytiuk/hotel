package com.maksymmylytiuk.hotel.service;

import com.maksymmylytiuk.hotel.dao.RoomTypeDao;
import com.maksymmylytiuk.hotel.model.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired
    RoomTypeDao roomTypeDao;

    @Override
    public void save(RoomType roomType) {
        roomTypeDao.save(roomType);
    }

    @Override
    public RoomType getById(Long id) {
        return roomTypeDao.getOne(id);
    }
}
