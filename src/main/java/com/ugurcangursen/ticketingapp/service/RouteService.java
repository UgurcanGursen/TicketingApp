package com.ugurcangursen.ticketingapp.service;

import com.ugurcangursen.ticketingapp.dto.RouteDto;

import java.util.List;

public interface RouteService {
    RouteDto save(RouteDto route);

    List<RouteDto> findAll();

    RouteDto findById(long id);

    List<RouteDto> findByName(String name);

    void deleteById(long id);

    RouteDto update(long id, RouteDto route);
}
