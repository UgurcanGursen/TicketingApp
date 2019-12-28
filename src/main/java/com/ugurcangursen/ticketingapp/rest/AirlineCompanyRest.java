package com.ugurcangursen.ticketingapp.rest;

import com.ugurcangursen.ticketingapp.entity.AirlineCompany;
import com.ugurcangursen.ticketingapp.service.AirlineCompanyService;
import com.ugurcangursen.ticketingapp.util.RestPaths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestPaths.AirlineCompanyRest.REST)
public class AirlineCompanyRest {

    private final AirlineCompanyService airlineCompanyService;


    @Autowired
    public AirlineCompanyRest(AirlineCompanyService airlineCompanyService) {
        this.airlineCompanyService = airlineCompanyService;
    }

    // expose "/rest/airlines" and return list of airlines
    @GetMapping
    public List<AirlineCompany> findAll() {
        return airlineCompanyService.findAll();
    }

    // add mapping for GET /rest/airlines/{id}
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public AirlineCompany findById(@PathVariable long id) {

        AirlineCompany airlineCompany = airlineCompanyService.findById(id);

        if (airlineCompany == null) {
            throw new RuntimeException("Airline  id not found - " + id);
        }

        return airlineCompany;
    }

    // add mapping for POST /rest/airlines - add new airline
    @PostMapping
    public AirlineCompany addAirlineCompany(@RequestBody AirlineCompany airlineCompany) {


        airlineCompanyService.save(airlineCompany);

        return airlineCompany;
    }

    // add mapping for GET /rest/airlines/name/{name}
    @GetMapping("/name/{name}")
    public AirlineCompany findByName(@PathVariable String name) {

        AirlineCompany airlineCompany = airlineCompanyService.findByName(name);

        if (airlineCompany == null) {
            throw new RuntimeException("Airline is not found - " + name);
        }

        return airlineCompany;
    }

    // add mapping for DELETE /rest/airlines/{id} - delete airline
    @DeleteMapping("/{id}")
    public String deleteAirline(@PathVariable long id) {

        AirlineCompany airlineCompany = airlineCompanyService.findById(id);

        // throw exception if null

        if (airlineCompany == null) {
            throw new RuntimeException("Airline id not found - " + id);
        }

        airlineCompanyService.deleteById(id);

        return "Deleted airline id - " + id;
    }

    // add mapping for PUT /rest/airlines/id - update existing airline
    @PutMapping("/{id}")
    public AirlineCompany airlineCompanyUpdate(@PathVariable long id, @RequestBody AirlineCompany airlineCompany) {

        airlineCompanyService.update(id,airlineCompany);
        return airlineCompany;
    }


}
