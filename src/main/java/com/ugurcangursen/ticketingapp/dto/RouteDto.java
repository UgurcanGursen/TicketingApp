package com.ugurcangursen.ticketingapp.dto;

import com.ugurcangursen.ticketingapp.entity.Airport;
import com.ugurcangursen.ticketingapp.entity.Flight;

import java.util.List;
import java.util.Objects;

public class RouteDto {

    private long id;

    private String name;

    private Airport startingAirport;

    private Airport endingAirport;

    private List<Flight> flights;


    public RouteDto() {
    }

    public RouteDto(long id, String name, Airport startingAirport, Airport endingAirport, List<Flight> flights) {
        this.id = id;
        this.name = name;
        this.startingAirport = startingAirport;
        this.endingAirport = endingAirport;
        this.flights = flights;
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

    public Airport getEndingAirport() {
        return endingAirport;
    }

    public void setEndingAirport(Airport endingAirport) {
        this.endingAirport = endingAirport;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteDto routeDto = (RouteDto) o;
        return id == routeDto.id &&
                Objects.equals(name, routeDto.name) &&
                Objects.equals(startingAirport, routeDto.startingAirport) &&
                Objects.equals(endingAirport, routeDto.endingAirport) &&
                Objects.equals(flights, routeDto.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startingAirport, endingAirport, flights);
    }

    @Override
    public String toString() {
        return "RouteDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startingAirport=" + startingAirport +
                ", endingAirport=" + endingAirport +
                ", flights=" + flights +
                '}';
    }
}
