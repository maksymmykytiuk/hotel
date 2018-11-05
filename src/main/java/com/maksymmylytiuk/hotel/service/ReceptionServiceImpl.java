package com.maksymmylytiuk.hotel.service;

import com.maksymmylytiuk.hotel.dao.ReceptionDao;
import com.maksymmylytiuk.hotel.model.Reception;
import com.maksymmylytiuk.hotel.model.Room;
import com.maksymmylytiuk.hotel.model.RoomStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Service
public class ReceptionServiceImpl implements ReceptionService {

    @Autowired
    ReceptionDao receptionDao;

    @Override
    public void save(Reception reception) {
        receptionDao.save(reception);
    }

    @Override
    public List<Reception> getAll() {
        return receptionDao.findAll();
    }

    @Override
    public List<Reception> getAllByStatusId(Long id) {
        return receptionDao.findAllByRoomStatusId(id);
    }

    @Override
    public List<Reception> getAllByStatusAndPeriod(RoomStatus status, Date from, Date to) {
        return receptionDao.getAllByStatusAndPeriod(status.getId(), from, to);
    }

    @Override
    public void delete(Long id) {
        receptionDao.deleteById(id);
    }

    @Override
    public void update(Long id, Reception reception) {
        receptionDao.saveAndFlush(reception);
    }

    @Override
    public Reception getById(Long id) {
        return receptionDao.getOne(id);
    }

    @Override
    public List<Room> getAllFreeRoomInPeriod(Date from, Date to) {
        return receptionDao.getAllFreeRoomInPeriod(from, to);
    }
}
