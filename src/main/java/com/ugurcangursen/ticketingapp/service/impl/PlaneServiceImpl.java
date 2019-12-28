package com.ugurcangursen.ticketingapp.service.impl;

import com.ugurcangursen.ticketingapp.dao.PlaneDAO;
import com.ugurcangursen.ticketingapp.entity.Plane;
import com.ugurcangursen.ticketingapp.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlaneServiceImpl implements PlaneService {

    private PlaneDAO planeDAO;

    @Autowired
    public PlaneServiceImpl(PlaneDAO planeDAO) {
        this.planeDAO = planeDAO;
    }

    @Override
    @Transactional
    public void save(Plane plane) {
        planeDAO.save(plane);
    }

    @Override
    @Transactional
    public List<Plane> findAll() {
        return planeDAO.findAll();
    }

    @Override
    @Transactional
    public Plane findById(long id) {
        return planeDAO.findById(id);
    }

    @Override
    @Transactional
    public Plane findByName(String name) {
        return planeDAO.findByName(name);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        planeDAO.deleteById(id);
    }

    @Override
    @Transactional
    public Plane update(long id, Plane plane) {
        return planeDAO.update(id,plane);
    }
}
