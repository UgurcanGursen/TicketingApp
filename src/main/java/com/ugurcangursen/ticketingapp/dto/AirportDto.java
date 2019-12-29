package com.ugurcangursen.ticketingapp.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

public class AirportDto {

    @ApiModelProperty(required = true, value = "ID")
    private long id;
    @ApiModelProperty(required = true, value = "Name of Airport")
    private String name;
    @ApiModelProperty(required = true, value = "Location Of Airport")
    private String location;


    public AirportDto() {
    }

    public AirportDto(long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirportDto that = (AirportDto) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location);
    }

    @Override
    public String toString() {
        return "AirportDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
