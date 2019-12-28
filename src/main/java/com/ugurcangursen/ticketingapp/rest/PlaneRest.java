package com.ugurcangursen.ticketingapp.rest;


import com.ugurcangursen.ticketingapp.entity.Plane;
import com.ugurcangursen.ticketingapp.service.PlaneService;
import com.ugurcangursen.ticketingapp.util.RestPaths;
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
    public List<Plane> findAll() {
        return planeService.findAll();
    }

    // add mapping for GET /rest/planes/{id}
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Plane findById(@PathVariable long id) {

        Plane plane = planeService.findById(id);

        if (plane == null) {
            throw new RuntimeException("Plane  id not found - " + id);
        }

        return plane;
    }

    // add mapping for POST /rest/planes - add new plane
    @PostMapping
    public Plane addPlane(@RequestBody Plane plane) {


        planeService.save(plane);

        return plane;
    }

    // add mapping for GET /rest/planes/name/{name}
    @GetMapping("/name/{name}")
    public Plane findByName(@PathVariable String name) {

        Plane plane = planeService.findByName(name);

        if (plane == null) {
            throw new RuntimeException("Plane is not found - " + name);
        }

        return plane;
    }

    // add mapping for DELETE /rest/planes/{id} - delete plane
    @DeleteMapping("/{id}")
    public String deletePlane(@PathVariable long id) {

        Plane plane = planeService.findById(id);

        // throw exception if null

        if (plane == null) {
            throw new RuntimeException("Plane id not found - " + id);
        }

        planeService.deleteById(id);

        return "Deleted plane id - " + id;
    }

    // add mapping for PUT /rest/planes/id - update existing plane
    @PutMapping("/{id}")
    public Plane planeUpdate(@PathVariable long id, @RequestBody Plane plane) {

        planeService.update(id,plane);
        return plane;
    }
}
