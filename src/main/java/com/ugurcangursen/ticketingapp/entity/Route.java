package com.ugurcangursen.ticketingapp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "routes")
public class Route implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @JoinColumn(name = "starting_airport_id")
    @ManyToOne
    private Airport startingAirport;

    @JoinColumn(name = "ending_airport_id")
    @ManyToOne
    private Airport endingAirport;

    @JoinColumn(name = "flight_route_id")
    @OneToMany
    private List<Flight> flights;

    public Route() {
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

    public Airport getStartingAirport() {
        return startingAirport;
    }

    public void setStartingAirport(Airport startingAirport) {
        this.startingAirport = startingAirport;
    }

    public Airport getEndingAirport() {
        return endingAirport;
    }

    public void setEndingAirport(Airport endingAirport) {
        this.endingAirport = endingAirport;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Route)) return false;
        Route route = (Route) o;
        return Objects.equals(getId(), route.getId()) &&
                Objects.equals(getName(), route.getName()) &&
                Objects.equals(getStartingAirport(), route.getStartingAirport()) &&
                Objects.equals(getEndingAirport(), route.getEndingAirport()) &&
                Objects.equals(getFlights(), route.getFlights());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStartingAirport(), getEndingAirport(), getFlights());
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startingAirport=" + startingAirport +
                ", endingAirport=" + endingAirport +
                ", flights=" + flights +
                '}';
    }
}
