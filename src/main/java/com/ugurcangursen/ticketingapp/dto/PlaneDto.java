package com.ugurcangursen.ticketingapp.dto;

import io.swagger.annotations.ApiModelProperty;


public class PlaneDto {

    @ApiModelProperty(required = true, value = "ID")
    private long id;
    @ApiModelProperty(required = true, value = "Name Of Plane")
    private String name;
    @ApiModelProperty(required = true, value = "Number Of Seats")
    private int numberOfSeats;

    private AirlineCompanyDto airlineCompany;
    private Long airlineCompanyId;

    public PlaneDto() {
    }

    public PlaneDto(long id, String name, int numberOfSeats, AirlineCompanyDto airlineCompany, Long airlineCompanyId) {
        this.id = id;
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.airlineCompany = airlineCompany;
        this.airlineCompanyId = airlineCompanyId;
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

    public AirlineCompanyDto getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(AirlineCompanyDto airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public Long getAirlineCompanyId() {
        return airlineCompanyId;
    }

    public void setAirlineCompanyId(Long airlineCompanyId) {
        this.airlineCompanyId = airlineCompanyId;
    }
}
