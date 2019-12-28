package com.ugurcangursen.ticketingapp.dao;


import com.ugurcangursen.ticketingapp.entity.Flight;

import java.util.List;

public interface FlightDAO {

    void save(Flight flight);
    List<Flight> findAll();
    Flight findById(long id);
    Flight findByName(String name);
    void deleteById(long id);
    Flight update(long id, Flight flight);
}
