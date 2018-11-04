package com.maksymmylytiuk.hotel.service;

import com.maksymmylytiuk.hotel.model.RoomType;

public interface RoomTypeService {

    void save(RoomType roomType);

    RoomType getById(Long id);
}
