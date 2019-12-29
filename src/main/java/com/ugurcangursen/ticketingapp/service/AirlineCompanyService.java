package com.ugurcangursen.ticketingapp.service;


import com.ugurcangursen.ticketingapp.dto.AirlineCompanyDto;

import java.util.List;

public interface AirlineCompanyService {

    AirlineCompanyDto save(AirlineCompanyDto airlineCompany);

    List<AirlineCompanyDto> findAll();

    AirlineCompanyDto findById(long id);

    AirlineCompanyDto findByName(String name);

    void deleteById(long id);

    AirlineCompanyDto update(long id, AirlineCompanyDto airlineCompany);
}
