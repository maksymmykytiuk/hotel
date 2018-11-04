package com.maksymmylytiuk.hotel.dao;

import com.maksymmylytiuk.hotel.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestDao extends JpaRepository<Guest, Long> {

}
