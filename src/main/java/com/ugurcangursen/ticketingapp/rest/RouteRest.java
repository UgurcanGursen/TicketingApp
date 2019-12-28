package com.ugurcangursen.ticketingapp.rest;


import com.ugurcangursen.ticketingapp.entity.Route;
import com.ugurcangursen.ticketingapp.service.RouteService;
import com.ugurcangursen.ticketingapp.util.RestPaths;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestPaths.RouteRest.REST)
public class RouteRest {

    private final RouteService routeService;

    public RouteRest(RouteService routeService) {
        this.routeService = routeService;
    }

    // expose "/rest/routes" and return list of routes
    @GetMapping
    public List<Route> findAll() {
        return routeService.findAll();
    }

    // add mapping for GET /rest/routes/{id}
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Route findById(@PathVariable long id) {

        Route route = routeService.findById(id);

        if (route == null) {
            throw new RuntimeException("Route  id not found - " + id);
        }

        return route;
    }

    // add mapping for POST /rest/routes - add new route
    @PostMapping
    public Route addRoute(@RequestBody Route route) {


        routeService.save(route);

        return route;
    }

    // add mapping for GET /rest/routes/name/{name}
    @GetMapping("/name/{name}")
    public Route findByName(@PathVariable String name) {

        Route route = routeService.findByName(name);

        if (route == null) {
            throw new RuntimeException("Route is not found - " + name);
        }

        return route;
    }

    // add mapping for DELETE /rest/routes/{id} - delete route
    @DeleteMapping("/{id}")
    public String deleteRoute(@PathVariable long id) {

        Route route = routeService.findById(id);

        // throw exception if null

        if (route == null) {
            throw new RuntimeException("Route id not found - " + id);
        }

        routeService.deleteById(id);

        return "Deleted route id - " + id;
    }

    // add mapping for PUT /rest/routes/id - update existing route
    @PutMapping("/{id}")
    public Route routeUpdate(@PathVariable long id, @RequestBody Route route) {

        routeService.update(id,route);
        return route;
    }

}
