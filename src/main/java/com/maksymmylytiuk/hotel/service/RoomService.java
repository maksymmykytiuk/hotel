package com.maksymmylytiuk.hotel.service;

import com.maksymmylytiuk.hotel.model.Room;

public interface RoomService {

    void save(Room room);

    Room getById(Long id);
}
