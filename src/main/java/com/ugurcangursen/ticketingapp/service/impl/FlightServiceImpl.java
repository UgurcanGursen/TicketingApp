package com.ugurcangursen.ticketingapp.service.impl;

import com.ugurcangursen.ticketingapp.dao.FlightDAO;
import com.ugurcangursen.ticketingapp.entity.Flight;
import com.ugurcangursen.ticketingapp.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private FlightDAO flightDAO;

    @Autowired
    public FlightServiceImpl(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    @Override
    @Transactional
    public void save(Flight flight) {
        flightDAO.save(flight);
    }

    @Override
    @Transactional
    public List<Flight> findAll() {
        return flightDAO.findAll();
    }

    @Override
    @Transactional
    public Flight findById(long id) {
        return flightDAO.findById(id);
    }

    @Override
    @Transactional
    public Flight findByName(String name) {
        return flightDAO.findByName(name);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        flightDAO.deleteById(id);
    }

    @Override
    @Transactional
    public Flight update(long id, Flight flight) {
        return flightDAO.update(id,flight);
    }
}
