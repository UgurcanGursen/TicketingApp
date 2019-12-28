package com.ugurcangursen.ticketingapp.rest;


import com.ugurcangursen.ticketingapp.entity.Flight;
import com.ugurcangursen.ticketingapp.service.FlightService;
import com.ugurcangursen.ticketingapp.util.RestPaths;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestPaths.FlightRest.REST)
public class FlightRest {

    private final FlightService flightService;

    public FlightRest(FlightService flightService) {
        this.flightService = flightService;
    }


    // expose "/rest/flights" and return list of flights
    @GetMapping
    public List<Flight> findAll() {
        return flightService.findAll();
    }

    // add mapping for GET /rest/flights/{id}
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Flight findById(@PathVariable long id) {

        Flight flight = flightService.findById(id);

        if (flight == null) {
            throw new RuntimeException("Flight  id not found - " + id);
        }

        return flight;
    }

    // add mapping for POST /rest/flights - add new flight
    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {


        flightService.save(flight);

        return flight;
    }

    // add mapping for GET /rest/flights/name/{name}
    @GetMapping("/name/{name}")
    public Flight findByName(@PathVariable String name) {

        Flight flight = flightService.findByName(name);

        if (flight == null) {
            throw new RuntimeException("Flight is not found - " + name);
        }

        return flight;
    }

    // add mapping for DELETE /rest/flights/{id} - delete flight
    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable long id) {

        Flight flight = flightService.findById(id);

        // throw exception if null

        if (flight == null) {
            throw new RuntimeException("Flight id not found - " + id);
        }

        flightService.deleteById(id);

        return "Deleted flight id - " + id;
    }

    // add mapping for PUT /rest/flights/id - update existing flight
    @PutMapping("/{id}")
    public Flight flightUpdate(@PathVariable long id, @RequestBody Flight flight) {

        flightService.update(id,flight);
        return flight;
    }


}
