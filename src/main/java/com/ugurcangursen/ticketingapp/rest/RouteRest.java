package com.ugurcangursen.ticketingapp.rest;


import com.ugurcangursen.ticketingapp.dto.RouteDto;
import com.ugurcangursen.ticketingapp.service.RouteService;
import com.ugurcangursen.ticketingapp.util.RestPaths;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "Find All Operation", response = RouteDto.class)
    public List<RouteDto> findAll() {
        List<RouteDto> data = routeService.findAll();
        return data;
    }

    // add mapping for GET /rest/routes/{id}
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    @ApiOperation(value = "Find By Id Operation", response = RouteDto.class)
    public RouteDto findById(@PathVariable long id) {

        RouteDto route = routeService.findById(id);

        if (route == null) {
            throw new RuntimeException("Route  id not found - " + id);
        }

        return route;
    }

    // add mapping for POST /rest/routes - add new route
    @PostMapping
    @ApiOperation(value = "Add Route Operation", response = RouteDto.class)
    public RouteDto addRoute(@RequestBody RouteDto route) {

        return routeService.save(route);
    }

    // add mapping for GET /rest/routes/name/{name}
    @GetMapping("/name/{name}")
    @ApiOperation(value = "Find By Name Operation", response = RouteDto.class)
    public List<RouteDto> findByName(@PathVariable String name) {

        List<RouteDto> route = routeService.findByName(name);

        if (route == null) {
            throw new RuntimeException("Route is not found - " + name);
        }

        return route;
    }

    // add mapping for DELETE /rest/routes/{id} - delete route
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = RouteDto.class)
    public String deleteRoute(@PathVariable long id) {

        RouteDto route = routeService.findById(id);

        // throw exception if null

        if (route == null) {
            throw new RuntimeException("Route id not found - " + id);
        }

        routeService.deleteById(id);

        return "Deleted route id - " + id;
    }

    // add mapping for PUT /rest/routes/id - update existing route
    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = RouteDto.class)
    public RouteDto routeUpdate(@PathVariable long id, @RequestBody RouteDto route) {

        routeService.update(id, route);
        return route;
    }

}
