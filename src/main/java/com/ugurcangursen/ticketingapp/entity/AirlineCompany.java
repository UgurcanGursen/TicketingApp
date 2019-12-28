package com.ugurcangursen.ticketingapp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "airlines")
public class AirlineCompany implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

//    @JoinColumn(name = "plane_airline_id")
//    @OneToMany(fetch = FetchType.LAZY)
//    private List<Plane> plane;
//
//    @JoinColumn(name = "flight_airline_id")
//    @OneToMany(fetch = FetchType.LAZY)
//    private List<Flight> flight;

    public AirlineCompany() {
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

//    public List<Plane> getPlane() {
//        return plane;
//    }
//
//    public void setPlane(List<Plane> plane) {
//        this.plane = plane;
//    }
//
//    public List<Flight> getFlight() {
//        return flight;
//    }
//
//    public void setFlight(List<Flight> flight) {
//        this.flight = flight;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirlineCompany)) return false;
        AirlineCompany that = (AirlineCompany) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName());
//                Objects.equals(getPlane(), that.getPlane()) &&
//                Objects.equals(getFlight(), that.getFlight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "AirlineCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", plane=" + plane +
//                ", flight=" + flight +
                '}';
    }
}
