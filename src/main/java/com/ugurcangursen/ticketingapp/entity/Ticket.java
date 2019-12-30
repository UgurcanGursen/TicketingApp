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


    public boolean isTicketSold() {
        return isTicketSold;
    }

    public void setTicketSold(boolean ticketSold) {
        isTicketSold = ticketSold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return getId() == ticket.getId() &&
                isTicketSold() == ticket.isTicketSold() &&
                Objects.equals(getTicketCode(), ticket.getTicketCode()) &&
                Objects.equals(getFlight(), ticket.getFlight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTicketCode(), getFlight(), isTicketSold());
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", ticketCode='" + ticketCode + '\'' +
                ", flight=" + flight +
                ", isTicketSold=" + isTicketSold +
                '}';
    }
}
