package com.ugurcangursen.ticketingapp.dao.impl;

import com.ugurcangursen.ticketingapp.dao.AirportDAO;
import com.ugurcangursen.ticketingapp.entity.Airport;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AirportDAOImpl implements AirportDAO {

    private EntityManager entityManager;

    @Autowired
    public AirportDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Airport save(Airport airport) {

        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session
        currentSession.saveOrUpdate(airport); // save airport
        return airport;

    }

    @Override
    public List<Airport> findAll() {
        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session


        Query<Airport> theQuery =
                currentSession.createQuery("select a from Airport a", Airport.class); // create a query


        List<Airport> airports = theQuery.getResultList(); // execute query and get result list


        return airports; // return the results
    }

    @Override
    public Airport findById(long id) {
        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session

        Airport airport = currentSession.get(Airport.class, id); // get the airport

        return airport;
    }

    @Override
    public Airport findByName(String name) {
        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session

        // create a query
        Query theQuery =
                currentSession.createQuery("select a from Airport a where a.name =:name ", Airport.class);
        theQuery.setParameter("name", name);

        // execute query and get result list
        Airport airport = (Airport) theQuery.list().get(0);

        return airport;
    }

    @Override
    public void deleteById(long id) {

        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from Airport where id=:id");
        theQuery.setParameter("id", id);

        theQuery.executeUpdate();
    }

    @Override
    public Airport update(long id, Airport airport) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("update Airport  set name =: name,location =:location where id =:id");
        theQuery.setParameter("id", id);
        theQuery.setParameter("name", airport.getName());
        theQuery.setParameter("location", airport.getLocation());
        theQuery.executeUpdate();
        return airport;
    }
}
