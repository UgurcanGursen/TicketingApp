package com.ugurcangursen.ticketingapp.rest;


import com.ugurcangursen.ticketingapp.dto.PlaneDto;
import com.ugurcangursen.ticketingapp.service.PlaneService;
import com.ugurcangursen.ticketingapp.util.RestPaths;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestPaths.PlaneRest.REST)
public class PlaneRest {

    private final PlaneService planeService;

    public PlaneRest(PlaneService planeService) {
        this.planeService = planeService;
    }


    // expose "/rest/planes" and return list of planes
    @GetMapping
    @ApiOperation(value = "Find All Operation", response = PlaneDto.class)
    public List<PlaneDto> findAll() {
        List<PlaneDto> data = planeService.findAll();
        return data;
    }

    // add mapping for GET /rest/planes/{id}
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    @ApiOperation(value = "Find By Id Operation", response = PlaneDto.class)
    public PlaneDto findById(@PathVariable long id) {

        PlaneDto plane = planeService.findById(id);

        if (plane == null) {
            throw new RuntimeException("Plane  id not found - " + id);
        }

        return plane;
    }

    // add mapping for POST /rest/planes - add new plane
    @PostMapping
    @ApiOperation(value = "Add Plane Operation", response = PlaneDto.class)
    public PlaneDto addPlane(@RequestBody PlaneDto plane) {

        return planeService.save(plane);
    }

    // add mapping for GET /rest/planes/name/{name}
    @GetMapping("/name/{name}")
    @ApiOperation(value = "Find By Name Operation", response = PlaneDto.class)
    public PlaneDto findByName(@PathVariable String name) {

        PlaneDto plane = planeService.findByName(name);

        if (plane == null) {
            throw new RuntimeException("Plane is not found - " + name);
        }

        return plane;
    }

    // add mapping for DELETE /rest/planes/{id} - delete plane
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = PlaneDto.class)
    public String deletePlane(@PathVariable long id) {

        PlaneDto plane = planeService.findById(id);

        // throw exception if null

        if (plane == null) {
            throw new RuntimeException("Plane id not found - " + id);
        }

        planeService.deleteById(id);

        return "Deleted plane id - " + id;
    }

    // add mapping for PUT /rest/planes/id - update existing plane
    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = PlaneDto.class)
    public PlaneDto planeUpdate(@PathVariable long id, @RequestBody PlaneDto plane) {

        planeService.update(id, plane);
        return plane;
    }
}
