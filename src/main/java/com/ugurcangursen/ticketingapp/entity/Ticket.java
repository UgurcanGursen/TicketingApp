package com.ugurcangursen.ticketingapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tickets")

public class Ticket implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ticket_code")
    private String ticketCode;

    @JoinColumn(name = "flight_ticket_id")
    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Flight flight;

    @Column(name = "ticket_price")
    private int ticketPrice;

    @Column(name = "is_ticket_sold")
    private boolean isTicketSold;

    public Ticket() {
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
        Ticket ticket1 = (Ticket) o;
        return id == ticket1.id &&
                ticketPrice == ticket1.ticketPrice &&
                isTicketSold == ticket1.isTicketSold &&
                Objects.equals(ticketCode, ticket1.ticketCode) &&
                Objects.equals(flight, ticket1.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ticketCode, flight, ticketPrice, isTicketSold);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", ticketCode='" + ticketCode + '\'' +
                ", flight=" + flight +
                ", ticketPrice=" + ticketPrice +
                ", isTicketSold=" + isTicketSold +
                '}';
    }
}
