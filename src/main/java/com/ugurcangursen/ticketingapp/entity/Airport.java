package com.ugurcangursen.ticketingapp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "airports")
public class Airport implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @JoinColumn(name = "starting_airport_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Route> startingRoute;

    @JoinColumn(name = "ending_airport_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Route> endingRoute;

    public Airport() {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Route> getStartingRoute() {
        return startingRoute;
    }

    public void setStartingRoute(List<Route> startingRoute) {
        this.startingRoute = startingRoute;
    }

    public List<Route> getEndingRoute() {
        return endingRoute;
    }

    public void setEndingRoute(List<Route> endingRoute) {
        this.endingRoute = endingRoute;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", startingRoute=" + startingRoute +
                ", endingRoute=" + endingRoute +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;
        Airport airport = (Airport) o;
        return Objects.equals(getId(), airport.getId()) &&
                Objects.equals(getName(), airport.getName()) &&
                Objects.equals(getLocation(), airport.getLocation()) &&
                Objects.equals(getStartingRoute(), airport.getStartingRoute()) &&
                Objects.equals(getEndingRoute(), airport.getEndingRoute());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLocation(), getStartingRoute(), getEndingRoute());
    }
}
