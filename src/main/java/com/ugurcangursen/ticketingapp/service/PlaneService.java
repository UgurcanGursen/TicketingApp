package com.ugurcangursen.ticketingapp.service;

import com.ugurcangursen.ticketingapp.dto.PlaneDto;

import java.util.List;

public interface PlaneService {
    PlaneDto save(PlaneDto plane);

    List<PlaneDto> findAll();

    PlaneDto findById(long id);

    PlaneDto findByName(String name);

    void deleteById(long id);

    PlaneDto update(long id, PlaneDto plane);
}
