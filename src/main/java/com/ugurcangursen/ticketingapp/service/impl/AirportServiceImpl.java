package com.ugurcangursen.ticketingapp.service.impl;

import com.ugurcangursen.ticketingapp.dao.AirportDAO;
import com.ugurcangursen.ticketingapp.dto.AirportDto;
import com.ugurcangursen.ticketingapp.entity.Airport;
import com.ugurcangursen.ticketingapp.service.AirportService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {

    private final AirportDAO airportDAO;
    private final ModelMapper modelMapper;

    @Autowired
    public AirportServiceImpl(AirportDAO airportDAO, ModelMapper modelMapper) {
        this.airportDAO = airportDAO;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public AirportDto save(AirportDto airport) {
        if (airport != null) {
            Airport airportDb = modelMapper.map(airport, Airport.class);
            Airport airportDbSaved = airportDAO.save(airportDb);
            if (airportDbSaved != null) {
                return modelMapper.map(airportDbSaved, AirportDto.class);
            }
        }
        return airport;
    }

    @Override
    @Transactional
    public List<AirportDto> findAll() {
        List<Airport> data = airportDAO.findAll();
        return Arrays.asList(modelMapper.map(data, AirportDto[].class));
    }

    @Override
    @Transactional
    public AirportDto findById(long id) {
        Airport airportDb = airportDAO.findById(id);
        return modelMapper.map(airportDb, AirportDto.class);
    }

    @Override
    @Transactional
    public AirportDto findByName(String name) {
        Airport airportDb = airportDAO.findByName(name);
        return modelMapper.map(airportDb, AirportDto.class);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        airportDAO.deleteById(id);
    }

    @Override
    @Transactional
    public AirportDto update(long id, AirportDto airport) {
        if (airport != null) {
            Airport airportDb = modelMapper.map(airport, Airport.class);
            Airport airportDbSaved = airportDAO.update(id, airportDb);
            if (airportDbSaved != null) {
                return modelMapper.map(airportDbSaved, AirportDto.class);
            }
        }
        return airport;
    }
}
