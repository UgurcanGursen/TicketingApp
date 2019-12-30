package com.ugurcangursen.ticketingapp.dto;

import com.ugurcangursen.ticketingapp.entity.Flight;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;


public class TicketDto {

    @ApiModelProperty(required = true, value = "ID")
    private long id;
    @ApiModelProperty(required = true, value = "Ticket Code")
    private String ticketCode;

    private Flight flight;
    private long flightId;
    private float ticketPrice1;
    @ApiModelProperty(required = true, value = "Is Ticket Sold")
    private boolean isTicketSold;

    public TicketDto() {
    }

    public TicketDto(long id, String ticketCode, Flight flight, long flightId, float ticketPrice1, boolean isTicketSold) {
        this.id = id;
        this.ticketCode = ticketCode;
        this.flight = flight;
        this.flightId = flightId;
        this.ticketPrice1 = ticketPrice1;
        this.isTicketSold = isTicketSold;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public float getTicketPrice1() {
        return ticketPrice1;
    }

    public void setTicketPrice1(float ticketPrice1) {
        this.ticketPrice1 = ticketPrice1;
    }

    public boolean isTicketSold() {
        return isTicketSold;
    }

    public void setTicketSold(boolean ticketSold) {
        isTicketSold = ticketSold;
    }
}
