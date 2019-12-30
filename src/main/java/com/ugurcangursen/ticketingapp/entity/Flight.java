package com.ugurcangursen.ticketingapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "flights")
public class Flight implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "starting_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startingDate;

    @Column(name = "ending_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endingDate;

    @Column(name = "duration")
    private int duration;

    @Column(name = "number_of_seats")
    private float numberOfSeats;

    @Column(name = "full_seats")
    private float numOfFullSeats;

    @Column(name = "full_seats_per")
    private float fullSeatsPer;

    @Column(name = "ticket_price")
    private float ticketPrice;

    @JoinColumn(name = "flight_route_id")
    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Route route;

    @JoinColumn(name = "flight_airline_id")
    @ManyToOne
    private AirlineCompany airlineCompany;


    public Flight() {
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

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return getId() == flight.getId() &&
                getDuration() == flight.getDuration() &&
                Float.compare(flight.getNumberOfSeats(), getNumberOfSeats()) == 0 &&
                Float.compare(flight.getNumOfFullSeats(), getNumOfFullSeats()) == 0 &&
                Float.compare(flight.getFullSeatsPer(), getFullSeatsPer()) == 0 &&
                Float.compare(flight.getTicketPrice(), getTicketPrice()) == 0 &&
                Objects.equals(getName(), flight.getName()) &&
                Objects.equals(getStartingDate(), flight.getStartingDate()) &&
                Objects.equals(getEndingDate(), flight.getEndingDate()) &&
                Objects.equals(getRoute(), flight.getRoute()) &&
                Objects.equals(getAirlineCompany(), flight.getAirlineCompany());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStartingDate(), getEndingDate(), getDuration(), getNumberOfSeats(), getNumOfFullSeats(), getFullSeatsPer(), getTicketPrice(), getRoute(), getAirlineCompany());
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                ", duration=" + duration +
                ", numberOfSeats=" + numberOfSeats +
                ", numOfFullSeats=" + numOfFullSeats +
                ", fullSeatsPer=" + fullSeatsPer +
                ", ticketPrice=" + ticketPrice +
                ", route=" + route +
                ", airlineCompany=" + airlineCompany +
                '}';
    }
}
