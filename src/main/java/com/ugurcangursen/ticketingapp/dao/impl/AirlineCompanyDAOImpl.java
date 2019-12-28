package com.ugurcangursen.ticketingapp.dao.impl;

import com.ugurcangursen.ticketingapp.dao.AirlineCompanyDAO;
import com.ugurcangursen.ticketingapp.entity.AirlineCompany;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AirlineCompanyDAOImpl implements AirlineCompanyDAO {

    private EntityManager entityManager;

    @Autowired
    public AirlineCompanyDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(AirlineCompany airlineCompany) {

        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session
        currentSession.saveOrUpdate(airlineCompany); // save Airline Company

    }

    @Override
    public List<AirlineCompany> findAll() {

        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session


        Query<AirlineCompany> theQuery =
                currentSession.createQuery("select a from AirlineCompany a", AirlineCompany.class); // create a query


        List<AirlineCompany> airlineCompanies = theQuery.getResultList(); // execute query and get result list


        return airlineCompanies; // return the results
    }

    @Override
    public AirlineCompany findById(long id) {

        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session

        AirlineCompany airlineCompany = currentSession.get(AirlineCompany.class,id); // get the company

        return airlineCompany;
    }

    @Override
    public AirlineCompany findByName(String name) {

        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session

        AirlineCompany airlineCompany = currentSession.get(AirlineCompany.class,name);

        return airlineCompany;
    }

    @Override
    public void deleteById(long id) {


        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from AirlineCompany where id=:id");
        theQuery.setParameter("id", id);

        theQuery.executeUpdate();

    }

    @Override
    public AirlineCompany update(long id, AirlineCompany airlineCompany) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("update AirlineCompany  set name =: name where id =:id");
        theQuery.setParameter("id", id);
        theQuery.setParameter("name", airlineCompany.getName());
        theQuery.executeUpdate();
        return airlineCompany;
    }
}
