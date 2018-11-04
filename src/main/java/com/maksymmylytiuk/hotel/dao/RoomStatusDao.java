package com.maksymmylytiuk.hotel.dao;

import com.maksymmylytiuk.hotel.model.Guest;
import com.maksymmylytiuk.hotel.model.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RoomStatusDao extends JpaRepository<RoomStatus, Long> {

    @Query("select case when count(r) = 0 then true else false end from Reception r where r.room.id = ?1 " +
            "and r.roomStatus.id = 2 " +
            "and r.from > ?2 " +
            "and r.to < ?3")
    boolean roomIsNotCheckedinInPeriod(Long id, Date from, Date to);

    @Query("select case when count(r) = 0 then true else false end from Reception r where r.room.id = ?1 " +
            "and r.roomStatus.id = 1 " +
            "and r.from > ?2 " +
            "and r.to < ?3 " +
            "and not r.guest = ?4")
    boolean roomIsNotBookedInPeriod(Long id, Date from, Date to, Guest guest);

    @Query("select case when count(r) = 0 then true else false end from Reception r where r.room.id = ?1 " +
            "and r.roomStatus.id = 2 " +
            "or r.roomStatus.id = 1 " +
            "and r.from > ?2 " +
            "and r.to < ?3 " +
            "and not r.guest = ?4")
    boolean roomIsFreeInPeriodAndGuest(Long id, Date from, Date to, Guest guest);
}
