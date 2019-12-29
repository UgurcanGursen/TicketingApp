package com.ugurcangursen.ticketingapp.dao.impl;

import com.ugurcangursen.ticketingapp.dao.FlightDAO;
import com.ugurcangursen.ticketingapp.entity.Flight;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class FlightDAOImpl implements FlightDAO {

    private EntityManager entityManager;

    @Autowired
    public FlightDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Flight save(Flight flight) {

        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session
        currentSession.saveOrUpdate(flight); // save flight
        return flight;
    }

    @Override
    public List<Flight> findAll() {
        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session


        Query<Flight> theQuery =
                currentSession.createQuery("select a from Flight a", Flight.class); // create a query


        List<Flight> flights = theQuery.getResultList(); // execute query and get result list


        return flights; // return the results
    }

    @Override
    public Flight findById(long id) {
        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session

        Flight flight = currentSession.get(Flight.class,id); // get the flight

        return flight;
    }

    @Override
    public Flight findByName(String name) {
        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session

        Flight flight = currentSession.get(Flight.class,name);

        return flight;
    }

    @Override
    public void deleteById(long id) {

        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from Flight where id=:id");
        theQuery.setParameter("id", id);

        theQuery.executeUpdate();

    }

    @Override
    public Flight update(long id, Flight flight) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery = currentSession.createQuery(
                "update Flight  set name =: name,startingDate =:startingDate,endingDate =:endingDate,numberOfSeats =:numberOfSeats,numOfFullSeats =:numOfFullSeats,fullSeatsPer =: fullSeatsPer where id =:id");
        theQuery.setParameter("id", id);
        theQuery.setParameter("name", flight.getName());
        theQuery.setParameter("startingDate", flight.getStartingDate());
        theQuery.setParameter("endingDate", flight.getEndingDate());
        theQuery.setParameter("numberOfSeats", flight.getNumberOfSeats());
        theQuery.setParameter("numOfFullSeats", flight.getNumOfFullSeats());
        theQuery.setParameter("fullSeatsPer", flight.getFullSeatsPer());
        theQuery.executeUpdate();
        return flight;
    }
}
