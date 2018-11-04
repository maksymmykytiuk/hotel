package com.maksymmylytiuk.hotel.service;

import com.maksymmylytiuk.hotel.model.Reception;
import com.maksymmylytiuk.hotel.model.Room;
import com.maksymmylytiuk.hotel.model.RoomStatus;

import java.util.Date;
import java.util.List;

public interface ReceptionService {

    void save(Reception reception);

    List<Reception> getAll();

    List<Reception> getAllByStatusId(Long id);

    List<Reception> getAllByStatusAndPeriod(RoomStatus status, Date from, Date to);

    void delete(Long id);

    void update(Long id, Reception reception);

    Reception getById(Long id);

    List<Room> getAllFreeRoomInPeriod(Date from, Date to);
}
