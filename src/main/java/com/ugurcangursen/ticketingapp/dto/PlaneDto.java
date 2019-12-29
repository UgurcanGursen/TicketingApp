package com.ugurcangursen.ticketingapp.dto;

import com.ugurcangursen.ticketingapp.entity.AirlineCompany;

import java.util.Objects;

public class PlaneDto {

    private long id;

    private String name;

    private int numberOfSeats;

    private AirlineCompany airlineCompany;

    public PlaneDto() {
    }

    public PlaneDto(long id, String name, int numberOfSeats, AirlineCompany airlineCompany) {
        this.id = id;
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.airlineCompany = airlineCompany;
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

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public AirlineCompany getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(AirlineCompany airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaneDto planeDto = (PlaneDto) o;
        return id == planeDto.id &&
                numberOfSeats == planeDto.numberOfSeats &&
                Objects.equals(name, planeDto.name) &&
                Objects.equals(airlineCompany, planeDto.airlineCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, numberOfSeats, airlineCompany);
    }

    @Override
    public String toString() {
        return "PlaneDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", airlineCompany=" + airlineCompany +
                '}';
    }
}
