package com.ugurcangursen.ticketingapp.dao.impl;

import com.ugurcangursen.ticketingapp.dao.TicketDAO;
import com.ugurcangursen.ticketingapp.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TicketDAOImpl implements TicketDAO {

    private EntityManager entityManager;

    @Autowired
    public TicketDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Ticket save(Ticket ticket) {

        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session
        currentSession.saveOrUpdate(ticket); // save ticket
        return ticket;
    }

    @Override
    public List<Ticket> findAll() {
        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session


        Query<Ticket> theQuery =
                currentSession.createQuery("select a from Ticket a", Ticket.class); // create a query


        List<Ticket> tickets = theQuery.getResultList(); // execute query and get result list


        return tickets; // return the results
    }

    @Override
    public Ticket findById(long id) {
        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session

        Ticket ticket = currentSession.get(Ticket.class, id); // get the ticket

        return ticket;
    }

    @Override
    public Ticket findByCode(String ticketCode) {
        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session

        // create a query
        Query theQuery =
                currentSession.createQuery("select a from Ticket a where a.ticketCode =:ticketCode ", Ticket.class);
        theQuery.setParameter("ticketCode", ticketCode);

        // execute query and get result list
        Ticket ticket = (Ticket) theQuery.list().get(0);

        return ticket;
    }

    @Override
    public void deleteById(long id) {
        Session currentSession = entityManager.unwrap(Session.class); // get the current hibernate session

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from Ticket where id=:id");
        theQuery.setParameter("id", id);

        theQuery.executeUpdate();

    }

    @Override
    public Ticket update(long id, Ticket ticket) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("update Ticket  set ticketCode =: ticketCode,ticketPrice =: ticketPrice,isTicketSold =: isTicketSold where id =:id");
        theQuery.setParameter("id", id);
        theQuery.setParameter("ticketCode", ticket.getTicketCode());
        theQuery.setParameter("ticketPrice", ticket.getTicketPrice());
        theQuery.setParameter("isTicketSold", ticket.isTicketSold());
        theQuery.executeUpdate();
        return ticket;
    }
}
