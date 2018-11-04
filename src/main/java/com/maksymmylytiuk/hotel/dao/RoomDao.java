package com.maksymmylytiuk.hotel.dao;

import com.maksymmylytiuk.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomDao extends JpaRepository<Room, Long> {

}
