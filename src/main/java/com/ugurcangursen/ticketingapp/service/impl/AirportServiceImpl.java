package com.ugurcangursen.ticketingapp.service.impl;

import com.ugurcangursen.ticketingapp.dao.AirportDAO;
import com.ugurcangursen.ticketingapp.entity.Airport;
import com.ugurcangursen.ticketingapp.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {

    private AirportDAO airportDAO;

    @Autowired
    public AirportServiceImpl(AirportDAO airportDAO) {
        this.airportDAO = airportDAO;
    }

    @Override
    @Transactional
    public void save(Airport airport) {
        airportDAO.save(airport);
    }

    @Override
    @Transactional
    public List<Airport> findAll() {
        return airportDAO.findAll();
    }

    @Override
    @Transactional
    public Airport findById(long id) {
        return airportDAO.findById(id);
    }

    @Override
    @Transactional
    public Airport findByName(String name) {
        return airportDAO.findByName(name);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        airportDAO.deleteById(id);
    }

    @Override
    @Transactional
    public Airport update(long id, Airport airport) {
        return airportDAO.update(id,airport);
    }
}
