package com.ugurcangursen.ticketingapp.dto;

import com.ugurcangursen.ticketingapp.entity.Flight;

import java.util.Objects;


public class TicketDto {

    private long id;

    private String ticketCode;

    private Flight flight;

    private int ticketPrice;

    private boolean isTicketSold;

    public TicketDto() {
    }

    public TicketDto(long id, String ticketCode, Flight flight, int ticketPrice, boolean isTicketSold) {
        this.id = id;
        this.ticketCode = ticketCode;
        this.flight = flight;
        this.ticketPrice = ticketPrice;
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

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public boolean isTicketSold() {
        return isTicketSold;
    }

    public void setTicketSold(boolean ticketSold) {
        isTicketSold = ticketSold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketDto ticketDto = (TicketDto) o;
        return id == ticketDto.id &&
                ticketPrice == ticketDto.ticketPrice &&
                isTicketSold == ticketDto.isTicketSold &&
                Objects.equals(ticketCode, ticketDto.ticketCode) &&
                Objects.equals(flight, ticketDto.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ticketCode, flight, ticketPrice, isTicketSold);
    }

    @Override
    public String toString() {
        return "TicketDto{" +
                "id=" + id +
                ", ticketCode='" + ticketCode + '\'' +
                ", flight=" + flight +
                ", ticketPrice=" + ticketPrice +
                ", isTicketSold=" + isTicketSold +
                '}';
    }
}
