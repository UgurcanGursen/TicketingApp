package com.ugurcangursen.ticketingapp.dao.impl;

import com.ugurcangursen.ticketingapp.dao.PlaneDAO;
import com.ugurcangursen.ticketingapp.entity.Plane;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PlaneDAOImpl implements PlaneDAO {

    private EntityManager entityManager;

    @Autowired
    public PlaneDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Plane save(Plane plane) {
        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session
        currentSession.saveOrUpdate(plane); // save plane
        return plane;
    }

    @Override
    public List<Plane> findAll() {
        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session


        Query<Plane> theQuery =
                currentSession.createQuery("select a from Plane a", Plane.class); // create a query


        List<Plane> planes = theQuery.getResultList(); // execute query and get result list


        return planes; // return the results
    }

    @Override
    public Plane findById(long id) {
        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session

        Plane plane = currentSession.get(Plane.class, id); // get the plane

        return plane;
    }

    @Override
    public Plane findByName(String name) {
        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session

        // create a query
        Query theQuery =
                currentSession.createQuery("select a from Plane a where a.name =:name ", Plane.class);
        theQuery.setParameter("name", name);

        // execute query and get result list
        Plane plane = (Plane) theQuery.list().get(0);

        return plane;
    }

    @Override
    public void deleteById(long id) {

        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from Plane where id=:id");
        theQuery.setParameter("id", id);

        theQuery.executeUpdate();

    }

    @Override
    public Plane update(long id, Plane plane) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("update Plane  set name =: name,numberOfSeats =:numberOfSeats where id =:id");
        theQuery.setParameter("id", id);
        theQuery.setParameter("name", plane.getName());
        theQuery.setParameter("numberOfSeats", plane.getNumberOfSeats());
        theQuery.executeUpdate();
        return plane;
    }
}
