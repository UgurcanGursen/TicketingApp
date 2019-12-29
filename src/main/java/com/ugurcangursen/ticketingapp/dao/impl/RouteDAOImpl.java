package com.ugurcangursen.ticketingapp.dao.impl;

import com.ugurcangursen.ticketingapp.dao.RouteDAO;
import com.ugurcangursen.ticketingapp.entity.Route;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RouteDAOImpl implements RouteDAO {

    private EntityManager entityManager;

    @Autowired
    public RouteDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Route save(Route route) {
        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session
        currentSession.saveOrUpdate(route); // save route
        return route;
    }

    @Override
    public List<Route> findAll() {
        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session


        Query<Route> theQuery =
                currentSession.createQuery("select a from Route a", Route.class); // create a query


        List<Route> routes = theQuery.getResultList(); // execute query and get result list


        return routes; // return the results
    }

    @Override
    public Route findById(long id) {
        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session

        Route route = currentSession.get(Route.class,id); // get the route

        return route;
    }

    @Override
    public Route findByName(String name) {
        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session

        Route route = currentSession.get(Route.class,name);

        return route;
    }

    @Override
    public void deleteById(long id) {

        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from Route where id=:id");
        theQuery.setParameter("id", id);

        theQuery.executeUpdate();

    }

    @Override
    public Route update(long id, Route route) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("update Route  set name =: name where id =:id");
        theQuery.setParameter("id", id);
        theQuery.setParameter("name", route.getName());
        theQuery.executeUpdate();
        return route;
    }
}
