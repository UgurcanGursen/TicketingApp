package com.ugurcangursen.ticketingapp.rest;

import com.ugurcangursen.ticketingapp.dto.AirlineCompanyDto;
import com.ugurcangursen.ticketingapp.service.AirlineCompanyService;
import com.ugurcangursen.ticketingapp.util.RestPaths;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "Find All Operation", response = AirlineCompanyDto.class)
    public List<AirlineCompanyDto> findAll() {
        List<AirlineCompanyDto> data = airlineCompanyService.findAll();
        return data;
    }

    // add mapping for GET /rest/airlines/{id}
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    @ApiOperation(value = "Find By Id Operation", response = AirlineCompanyDto.class)
    public AirlineCompanyDto findById(@PathVariable long id) {

        AirlineCompanyDto airlineCompany = airlineCompanyService.findById(id);

        if (airlineCompany == null) {
            throw new RuntimeException("Airline  id not found - " + id);
        }

        return airlineCompany;
    }

    // add mapping for POST /rest/airlines - add new airline
    @PostMapping
    @ApiOperation(value = "Add Airline Operation", response = AirlineCompanyDto.class)
    public AirlineCompanyDto addAirlineCompany(@RequestBody AirlineCompanyDto airlineCompany) {

        return airlineCompanyService.save(airlineCompany);
    }

    // add mapping for GET /rest/airlines/name/{name}
    @GetMapping("/name/{name}")
    @ApiOperation(value = "Find By Name Operation", response = AirlineCompanyDto.class)
    public AirlineCompanyDto findByName(@PathVariable String name) {

        AirlineCompanyDto airlineCompany = airlineCompanyService.findByName(name);

        if (airlineCompany == null) {
            throw new RuntimeException("Airline is not found - " + name);
        }

        return airlineCompany;
    }

    // add mapping for DELETE /rest/airlines/{id} - delete airline
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = AirlineCompanyDto.class)
    public String deleteAirline(@PathVariable long id) {

        AirlineCompanyDto airlineCompany = airlineCompanyService.findById(id);

        // throw exception if null

        if (airlineCompany == null) {
            throw new RuntimeException("Airline id not found - " + id);
        }

        airlineCompanyService.deleteById(id);

        return "Deleted airline id - " + id;
    }

    // add mapping for PUT /rest/airlines/id - update existing airline
    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = AirlineCompanyDto.class)
    public AirlineCompanyDto airlineCompanyUpdate(@PathVariable long id, @RequestBody AirlineCompanyDto airlineCompany) {

        return airlineCompanyService.update(id, airlineCompany);
    }


}
