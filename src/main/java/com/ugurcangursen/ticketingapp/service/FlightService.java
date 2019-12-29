package com.ugurcangursen.ticketingapp.service;

import com.ugurcangursen.ticketingapp.dto.FlightDto;

import java.util.List;

public interface FlightService {

    FlightDto save(FlightDto flight);

    List<FlightDto> findAll();

    FlightDto findById(long id);

    List<FlightDto> findByName(String name);

    void deleteById(long id);

    FlightDto update(long id, FlightDto flight);
}
