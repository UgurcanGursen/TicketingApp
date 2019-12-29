package com.ugurcangursen.ticketingapp.rest;


import com.ugurcangursen.ticketingapp.dto.FlightDto;
import com.ugurcangursen.ticketingapp.service.FlightService;
import com.ugurcangursen.ticketingapp.util.RestPaths;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "Find All Operation", response = FlightDto.class)
    public List<FlightDto> findAll() {
        List<FlightDto> data = flightService.findAll();
        return data;
    }

    // add mapping for GET /rest/flights/{id}
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    @ApiOperation(value = "Find By Id Operation", response = FlightDto.class)
    public FlightDto findById(@PathVariable long id) {

        FlightDto flight = flightService.findById(id);

        if (flight == null) {
            throw new RuntimeException("Flight  id not found - " + id);
        }

        return flight;
    }

    // add mapping for POST /rest/flights - add new flight
    @PostMapping
    @ApiOperation(value = "Add Flight Operation", response = FlightDto.class)
    public FlightDto addFlight(@RequestBody FlightDto flight) {

        return flightService.save(flight);
    }

    // add mapping for GET /rest/flights/name/{name}
    @GetMapping("/name/{name}")
    @ApiOperation(value = "Find By Name Operation", response = FlightDto.class)
    public FlightDto findByName(@PathVariable String name) {

        FlightDto flight = flightService.findByName(name);

        if (flight == null) {
            throw new RuntimeException("Flight is not found - " + name);
        }

        return flight;
    }

    // add mapping for DELETE /rest/flights/{id} - delete flight
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = FlightDto.class)
    public String deleteFlight(@PathVariable long id) {

        FlightDto flight = flightService.findById(id);

        // throw exception if null

        if (flight == null) {
            throw new RuntimeException("Flight id not found - " + id);
        }

        flightService.deleteById(id);

        return "Deleted flight id - " + id;
    }

    // add mapping for PUT /rest/flights/id - update existing flight
    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = FlightDto.class)
    public FlightDto flightUpdate(@PathVariable long id, @RequestBody FlightDto flight) {

        flightService.update(id, flight);
        return flight;
    }


}
