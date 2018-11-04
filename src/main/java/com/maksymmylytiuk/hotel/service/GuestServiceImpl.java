package com.maksymmylytiuk.hotel.service;

import com.maksymmylytiuk.hotel.dao.GuestDao;
import com.maksymmylytiuk.hotel.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("guestService")
public class GuestServiceImpl implements GuestService {

    @Autowired
    GuestDao guestDao;

    @Override
    public void save(Guest guest) {
        guestDao.save(guest);
    }

    @Override
    public Guest getById(Long id) {
        return guestDao.getOne(id);
    }
}
