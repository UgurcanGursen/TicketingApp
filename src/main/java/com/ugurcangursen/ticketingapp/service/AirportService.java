package com.ugurcangursen.ticketingapp.service;

import com.ugurcangursen.ticketingapp.entity.Airport;

import java.util.List;

public interface AirportService {

    void save(Airport airport);
    List<Airport> findAll();
    Airport findById(long id);
    Airport findByName(String name);
    void deleteById(long id);
    Airport update(long id, Airport airport);
}
