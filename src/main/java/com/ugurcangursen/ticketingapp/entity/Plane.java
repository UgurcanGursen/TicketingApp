package com.ugurcangursen.ticketingapp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "planes")
public class Plane implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "number_seat")
    private int numberOfSeats;

    @JoinColumn(name = "plane_airline_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private AirlineCompany airlineCompany;

    public Plane() {
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

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
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
        if (!(o instanceof Plane)) return false;
        Plane plane = (Plane) o;
        return getNumberOfSeats() == plane.getNumberOfSeats() &&
                Objects.equals(getId(), plane.getId()) &&
                Objects.equals(getName(), plane.getName()) &&
                Objects.equals(getAirlineCompany(), plane.getAirlineCompany());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getNumberOfSeats(), getAirlineCompany());
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", airlineCompany=" + airlineCompany +
                '}';
    }
}
