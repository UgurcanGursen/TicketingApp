package com.ugurcangursen.ticketingapp.service.impl;

import com.ugurcangursen.ticketingapp.dao.AirportDAO;
import com.ugurcangursen.ticketingapp.dao.RouteDAO;
import com.ugurcangursen.ticketingapp.dto.RouteDto;
import com.ugurcangursen.ticketingapp.entity.Airport;
import com.ugurcangursen.ticketingapp.entity.Route;
import com.ugurcangursen.ticketingapp.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteDAO routeDAO;
    private final ModelMapper modelMapper;
    private final AirportDAO airportDAO;

    @Autowired
    public RouteServiceImpl(RouteDAO routeDAO, ModelMapper modelMapper, AirportDAO airportDAO) {
        this.routeDAO = routeDAO;
        this.modelMapper = modelMapper;
        this.airportDAO = airportDAO;
    }

    @Override
    @Transactional
    public RouteDto save(RouteDto route) {
        if (route != null) {
            Route routeDb = modelMapper.map(route, Route.class);
            Airport startingAirport = airportDAO.findById(route.getStartingAirportId());
            Airport endingAirport = airportDAO.findById(route.getEndingAirportId());
            routeDb.setStartingAirport(startingAirport);
            routeDb.setEndingAirport(endingAirport);
            Route routeDbSaved = routeDAO.save(routeDb);
            if (routeDbSaved != null) {
                return modelMapper.map(routeDbSaved, RouteDto.class);
            }
        }
        return route;
    }

    @Override
    @Transactional
    public List<RouteDto> findAll() {
        List<Route> data = routeDAO.findAll();
        return Arrays.asList(modelMapper.map(data, RouteDto[].class));
    }

    @Override
    @Transactional
    public RouteDto findById(long id) {
        Route routeDb = routeDAO.findById(id);
        return modelMapper.map(routeDb, RouteDto.class);
    }

    @Override
    @Transactional
    public List<RouteDto> findByName(String name) {
        List<Route> routeDb = routeDAO.findByName(name);
        return Arrays.asList(modelMapper.map(routeDb, RouteDto[].class));
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        routeDAO.deleteById(id);
    }

    @Override
    @Transactional
    public RouteDto update(long id, RouteDto route) {
        if (route != null) {
            Route routeDb = modelMapper.map(route, Route.class);
            Route routeDbSaved = routeDAO.update(id, routeDb);
            if (routeDbSaved != null) {
                return modelMapper.map(routeDbSaved, RouteDto.class);
            }
        }
        return route;
    }
}
