package com.maksymmylytiuk.hotel.dao;

import com.maksymmylytiuk.hotel.model.Reception;
import com.maksymmylytiuk.hotel.model.Room;
import com.maksymmylytiuk.hotel.model.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReceptionDao extends JpaRepository<Reception, Long> {

    List<Reception> findAllByRoomStatusId(Long id);

    @Query("select r from Reception r where r.roomStatus.id = ?1 and r.from > ?2 and r.to < ?3")
    List<Reception> test(Long status, Date from, Date to);

    @Query("select r from Room r where r.id not in " +
            "(select r.room.id from Reception r where r.roomStatus.id = 1 or r.roomStatus.id = 2 and r.from > ?1 and r.to < ?2)")
    List<Room> getAllFreeRoomInPeriod(Date from, Date to);
}
