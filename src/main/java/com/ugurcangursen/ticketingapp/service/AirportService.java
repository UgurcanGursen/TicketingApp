package com.ugurcangursen.ticketingapp.service;

import com.ugurcangursen.ticketingapp.dto.AirportDto;

import java.util.List;

public interface AirportService {

    AirportDto save(AirportDto airport);

    List<AirportDto> findAll();

    AirportDto findById(long id);

    AirportDto findByName(String name);

    void deleteById(long id);

    AirportDto update(long id, AirportDto airport);
}
