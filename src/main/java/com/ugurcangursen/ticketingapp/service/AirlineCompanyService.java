package com.ugurcangursen.ticketingapp.service;

import com.ugurcangursen.ticketingapp.entity.AirlineCompany;

import java.util.List;

public interface AirlineCompanyService {

    void save(AirlineCompany airlineCompany);
    List<AirlineCompany> findAll();
    AirlineCompany findById(long id);
    AirlineCompany findByName(String name);
    void deleteById(long id);
    AirlineCompany update(long id, AirlineCompany airlineCompany);
}
