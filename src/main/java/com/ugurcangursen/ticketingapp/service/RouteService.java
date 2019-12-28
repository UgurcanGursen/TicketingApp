package com.ugurcangursen.ticketingapp.service;

import com.ugurcangursen.ticketingapp.entity.Route;

import java.util.List;

public interface RouteService {
    void save(Route route);
    List<Route> findAll();
    Route findById(long id);
    Route findByName(String name);
    void deleteById(long id);
    Route update(long id, Route route);
}
