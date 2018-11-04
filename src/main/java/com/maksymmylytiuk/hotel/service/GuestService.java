package com.maksymmylytiuk.hotel.service;

import com.maksymmylytiuk.hotel.model.Guest;

public interface GuestService {

    void save(Guest guest);

    Guest getById(Long id);
}
