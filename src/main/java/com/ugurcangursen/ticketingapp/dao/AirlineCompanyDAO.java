package com.ugurcangursen.ticketingapp.dao;

import com.ugurcangursen.ticketingapp.entity.AirlineCompany;

import java.util.List;


public interface AirlineCompanyDAO {

    AirlineCompany save(AirlineCompany airlineCompany);
    List<AirlineCompany> findAll();
    AirlineCompany findById(long id);
    AirlineCompany findByName(String name);
    void deleteById(long id);
    AirlineCompany update(long id, AirlineCompany airlineCompany);

}
