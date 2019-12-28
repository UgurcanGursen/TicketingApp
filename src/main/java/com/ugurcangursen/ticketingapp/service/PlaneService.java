package com.ugurcangursen.ticketingapp.service;

import com.ugurcangursen.ticketingapp.entity.Plane;

import java.util.List;

public interface PlaneService {
    void save(Plane plane);
    List<Plane> findAll();
    Plane findById(long id);
    Plane findByName(String name);
    void deleteById(long id);
    Plane update(long id, Plane plane);
}
