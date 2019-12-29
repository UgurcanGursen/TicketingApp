package com.ugurcangursen.ticketingapp.entity;

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
    private int numberOfSeats;

    @Column(name = "full_seats")
    private int numOfFullSeats;

    @Column(name = "full_seats_per")
    private int fullSeatsPer;

    @JoinColumn(name = "flight_route_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Route route;

    @JoinColumn(name = "flight_airline_id")
    @ManyToOne(fetch = FetchType.LAZY)
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

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumOfFullSeats() {
        return numOfFullSeats;
    }

    public void setNumOfFullSeats(int numOfFullSeats) {
        this.numOfFullSeats = numOfFullSeats;
    }

    public int getFullSeatsPer() {
        return fullSeatsPer;
    }

    public void setFullSeatsPer(int fullSeatsPer) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return getDuration() == flight.getDuration() &&
                getNumberOfSeats() == flight.getNumberOfSeats() &&
                getNumOfFullSeats() == flight.getNumOfFullSeats() &&
                getFullSeatsPer() == flight.getFullSeatsPer() &&
                Objects.equals(getId(), flight.getId()) &&
                Objects.equals(getName(), flight.getName()) &&
                Objects.equals(getStartingDate(), flight.getStartingDate()) &&
                Objects.equals(getEndingDate(), flight.getEndingDate()) &&
                Objects.equals(getRoute(), flight.getRoute()) &&
                Objects.equals(getAirlineCompany(), flight.getAirlineCompany());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStartingDate(), getEndingDate(), getDuration(), getNumberOfSeats(), getNumOfFullSeats(), getFullSeatsPer(), getRoute(), getAirlineCompany());
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
                ", route=" + route +
                ", airlineCompany=" + airlineCompany +
                '}';
    }
}
