package com.ugurcangursen.ticketingapp.dto;

import com.ugurcangursen.ticketingapp.entity.AirlineCompany;
import com.ugurcangursen.ticketingapp.entity.Route;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.Objects;

public class FlightDto {

    @ApiModelProperty(required = true, value = "ID")
    private long id;
    @ApiModelProperty(required = true, value = "Mame of Flight")
    private String name;
    @ApiModelProperty(required = true, value = "Starting Date and Time of Flight")
    private Date startingDate;
    @ApiModelProperty(required = true, value = "Ending Date and Time of Flight")
    private Date endingDate;
    @ApiModelProperty(required = true, value = "Flight Duration")
    private int duration;
    @ApiModelProperty(required = true, value = "Number Of Seats")
    private float numberOfSeats;
    @ApiModelProperty(required = true, value = "Number Of Seats Sold")
    private float numOfFullSeats;
    @ApiModelProperty(required = true, value = "Seats Sold Percentage")
    private float fullSeatsPer;
    @ApiModelProperty(required = true, value = "Ticket Price")
    private float ticketPrice;

    private Route route;
    private long routeId;

    private AirlineCompany airlineCompany;
    private long airlineCompanyId;


    public FlightDto() {
    }

    public FlightDto(long id, String name, Date startingDate, Date endingDate, int duration, float numberOfSeats, float numOfFullSeats, float fullSeatsPer, float ticketPrice, Route route, long routeId, AirlineCompany airlineCompany, long airlineCompanyId) {
        this.id = id;
        this.name = name;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.duration = duration;
        this.numberOfSeats = numberOfSeats;
        this.numOfFullSeats = numOfFullSeats;
        this.fullSeatsPer = fullSeatsPer;
        this.ticketPrice = ticketPrice;
        this.route = route;
        this.routeId = routeId;
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

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public float getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(float numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public float getNumOfFullSeats() {
        return numOfFullSeats;
    }

    public void setNumOfFullSeats(float numOfFullSeats) {
        this.numOfFullSeats = numOfFullSeats;
    }

    public float getFullSeatsPer() {
        return fullSeatsPer;
    }

    public void setFullSeatsPer(float fullSeatsPer) {
        this.fullSeatsPer = fullSeatsPer;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public AirlineCompany getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(AirlineCompany airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public long getAirlineCompanyId() {
        return airlineCompanyId;
    }

    public void setAirlineCompanyId(long airlineCompanyId) {
        this.airlineCompanyId = airlineCompanyId;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightDto flightDto = (FlightDto) o;
        return id == flightDto.id &&
                duration == flightDto.duration &&
                numberOfSeats == flightDto.numberOfSeats &&
                numOfFullSeats == flightDto.numOfFullSeats &&
                fullSeatsPer == flightDto.fullSeatsPer &&
                Objects.equals(name, flightDto.name) &&
                Objects.equals(startingDate, flightDto.startingDate) &&
                Objects.equals(endingDate, flightDto.endingDate) &&
                Objects.equals(route, flightDto.route) &&
                Objects.equals(airlineCompany, flightDto.airlineCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startingDate, endingDate, duration, numberOfSeats, numOfFullSeats, fullSeatsPer, route, airlineCompany);
    }

    @Override
    public String toString() {
        return "FlightDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                ", duration=" + duration +
                ", numberOfSeats=" + numberOfSeats +
                ", numOfFullSeats=" + numOfFullSeats +
                ", fullSeatsPer=" + fullSeatsPer +
                ", route=" + route +
                ", airlineCompany=" + airlineCompany +
                '}';
    }
}
