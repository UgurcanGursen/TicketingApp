package com.ugurcangursen.ticketingapp.entity;

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
    @ManyToOne(fetch = FetchType.LAZY)
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
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return getTicketPrice() == ticket.getTicketPrice() &&
                isTicketSold() == ticket.isTicketSold() &&
                Objects.equals(getId(), ticket.getId()) &&
                Objects.equals(getTicketCode(), ticket.getTicketCode()) &&
                Objects.equals(getFlight(), ticket.getFlight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTicketCode(), getFlight(), getTicketPrice(), isTicketSold());
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
