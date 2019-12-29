package com.ugurcangursen.ticketingapp.dto;

import com.ugurcangursen.ticketingapp.entity.Route;


import java.util.List;
import java.util.Objects;

public class AirportDto {

    private long id;

    private String name;

    private String location;

    private List<Route> startingRoute;

    private List<Route> endingRoute;

    public AirportDto() {
    }

    public AirportDto(long id, String name, String location, List<Route> startingRoute, List<Route> endingRoute) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.startingRoute = startingRoute;
        this.endingRoute = endingRoute;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Route> getStartingRoute() {
        return startingRoute;
    }

    public void setStartingRoute(List<Route> startingRoute) {
        this.startingRoute = startingRoute;
    }

    public List<Route> getEndingRoute() {
        return endingRoute;
    }

    public void setEndingRoute(List<Route> endingRoute) {
        this.endingRoute = endingRoute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirportDto that = (AirportDto) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(location, that.location) &&
                Objects.equals(startingRoute, that.startingRoute) &&
                Objects.equals(endingRoute, that.endingRoute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, startingRoute, endingRoute);
    }

    @Override
    public String toString() {
        return "AirportDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", startingRoute=" + startingRoute +
                ", endingRoute=" + endingRoute +
                '}';
    }
}
