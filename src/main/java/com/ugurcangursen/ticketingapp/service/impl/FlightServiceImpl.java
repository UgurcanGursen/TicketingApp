package com.ugurcangursen.ticketingapp.service.impl;

import com.ugurcangursen.ticketingapp.dao.FlightDAO;
import com.ugurcangursen.ticketingapp.dto.FlightDto;
import com.ugurcangursen.ticketingapp.entity.Flight;
import com.ugurcangursen.ticketingapp.service.FlightService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightDAO flightDAO;
    private final ModelMapper modelMapper;

    @Autowired
    public FlightServiceImpl(FlightDAO flightDAO, ModelMapper modelMapper) {
        this.flightDAO = flightDAO;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public FlightDto save(FlightDto flight) {
        if (flight != null) {
            Flight flightDb = modelMapper.map(flight, Flight.class);
            Flight flightDbSaved= flightDAO.save(flightDb);
            if (flightDbSaved != null) {
                return modelMapper.map(flightDbSaved, FlightDto.class);
            }
        }
        return flight;
    }

    @Override
    @Transactional
    public List<FlightDto> findAll() {
        List<Flight> data = flightDAO.findAll();
        return Arrays.asList(modelMapper.map(data, FlightDto.class));
    }

    @Override
    @Transactional
    public FlightDto findById(long id) {
        Flight flightDb= flightDAO.findById(id);
        return modelMapper.map(flightDb,FlightDto.class);
    }

    @Override
    @Transactional
    public FlightDto findByName(String name) {
        Flight flightDb = flightDAO.findByName(name);
        return modelMapper.map(flightDb,FlightDto.class);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        flightDAO.deleteById(id);
    }

    @Override
    @Transactional
    public FlightDto update(long id, FlightDto flight) {
        if (flight != null) {
            Flight flightDb = modelMapper.map(flight, Flight.class);
            Flight flightDbSaved= flightDAO.update(id,flightDb);
            if (flightDbSaved != null) {
                return modelMapper.map(flightDbSaved, FlightDto.class);
            }
        }
        return flight;
    }
}
