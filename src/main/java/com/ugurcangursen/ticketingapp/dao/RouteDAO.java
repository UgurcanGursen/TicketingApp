package com.ugurcangursen.ticketingapp.dao;


import com.ugurcangursen.ticketingapp.entity.Route;

import java.util.List;

public interface RouteDAO {

    Route save(Route route);
    List<Route> findAll();
    Route findById(long id);
    Route findByName(String name);
    void deleteById(long id);
    Route update(long id, Route route);
}
