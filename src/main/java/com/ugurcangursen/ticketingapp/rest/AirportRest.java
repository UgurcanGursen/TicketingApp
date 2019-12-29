package com.ugurcangursen.ticketingapp.rest;


import com.ugurcangursen.ticketingapp.dto.AirportDto;
import com.ugurcangursen.ticketingapp.service.AirportService;
import com.ugurcangursen.ticketingapp.util.RestPaths;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestPaths.AirportRest.REST)
public class AirportRest {

    private final AirportService airportService;

    public AirportRest(AirportService airportService) {
        this.airportService = airportService;
    }

    // expose "/rest/airports" and return list of airports
    @GetMapping
    public List<AirportDto> findAll() {
        return airportService.findAll();
    }

    // add mapping for GET /rest/airports/{id}
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public AirportDto findById(@PathVariable long id) {

        AirportDto airport = airportService.findById(id);

        if (airport == null) {
            throw new RuntimeException("Airport  id not found - " + id);
        }

        return airport;
    }

    // add mapping for POST /rest/airports - add new airport
    @PostMapping
    public AirportDto addAirport(@RequestBody AirportDto airport) {

        return airportService.save(airport);
    }

    // add mapping for GET /rest/airports/name/{name}
    @GetMapping("/name/{name}")
    public AirportDto findByName(@PathVariable String name) {

        AirportDto airport = airportService.findByName(name);

        if (airport == null) {
            throw new RuntimeException("Airport is not found - " + name);
        }

        return airport;
    }

    // add mapping for DELETE /rest/airports/{id} - delete airport
    @DeleteMapping("/{id}")
    public String deleteAirport(@PathVariable long id) {

        AirportDto airport = airportService.findById(id);

        // throw exception if null

        if (airport == null) {
            throw new RuntimeException("Airport id not found - " + id);
        }

        airportService.deleteById(id);

        return "Deleted airport id - " + id;
    }

    // add mapping for PUT /rest/airports/id - update existing airport
    @PutMapping("/{id}")
    public AirportDto airportUpdate(@PathVariable long id, @RequestBody AirportDto airport) {


        return airportService.update(id,airport);
    }


}
