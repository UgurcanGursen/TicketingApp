package com.ugurcangursen.ticketingapp.dto;

import com.ugurcangursen.ticketingapp.entity.Airport;
import io.swagger.annotations.ApiModelProperty;


public class RouteDto {

    @ApiModelProperty(required = true, value = "ID")
    private long id;
    @ApiModelProperty(required = true, value = "Name Of Route")
    private String name;

    private Airport startingAirport;
    private long startingAirportId;

    private Airport endingAirport;
    private long endingAirportId;


    public RouteDto() {
    }

    public RouteDto(long id, String name, Airport startingAirport, long startingAirportId, Airport endingAirport, long endingAirportId) {
        this.id = id;
        this.name = name;
        this.startingAirport = startingAirport;
        this.startingAirportId = startingAirportId;
        this.endingAirport = endingAirport;
        this.endingAirportId = endingAirportId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airport getStartingAirport() {
        return startingAirport;
    }

    public void setStartingAirport(Airport startingAirport) {
        this.startingAirport = startingAirport;
    }

    public long getStartingAirportId() {
        return startingAirportId;
    }

    public void setStartingAirportId(long startingAirportId) {
        this.startingAirportId = startingAirportId;
    }

    public Airport getEndingAirport() {
        return endingAirport;
    }

    public void setEndingAirport(Airport endingAirport) {
        this.endingAirport = endingAirport;
    }

    public long getEndingAirportId() {
        return endingAirportId;
    }

    public void setEndingAirportId(long endingAirportId) {
        this.endingAirportId = endingAirportId;
    }
}
