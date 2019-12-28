package com.ugurcangursen.ticketingapp.service.impl;

import com.ugurcangursen.ticketingapp.dao.FlightDAO;
import com.ugurcangursen.ticketingapp.dao.TicketDAO;
import com.ugurcangursen.ticketingapp.entity.Flight;
import com.ugurcangursen.ticketingapp.entity.Ticket;
import com.ugurcangursen.ticketingapp.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketDAO ticketDAO;
    private FlightDAO flightDAO;


    @Autowired
    public TicketServiceImpl(TicketDAO ticketDAO, FlightDAO flightDAO) {
        this.ticketDAO = ticketDAO;
        this.flightDAO = flightDAO;
    }

    @Override
    @Transactional
    public void save(Ticket ticket) {
        ticketDAO.save(ticket);
    }

    @Override
    @Transactional
    public List<Ticket> findAll() {
        return ticketDAO.findAll();
    }

    @Override
    @Transactional
    public Ticket findById(long id) {
        return ticketDAO.findById(id);
    }

    @Override
    @Transactional
    public Ticket findByCode(String ticketCode) {
        return ticketDAO.findByCode(ticketCode);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        ticketDAO.deleteById(id);
    }

    @Override
    public Ticket update(long id, Ticket ticket) {

        if(ticket.isTicketSold()== true) {
            // Get quota status of Flight
            Flight flight = flightDAO.findById(ticket.getFlight().getId());
            int quota = flight.getNumberOfSeats();
            int fullQuota = flight.getNumOfFullSeats();

            if(fullQuota < quota) {
                // Increase quota if it is not full yet
                flight.setNumOfFullSeats(fullQuota + 1);


                int newPer = (fullQuota / quota) * 100;
                int currentPer = flight.getFullSeatsPer();
                int diffPer = (newPer % 10) - currentPer;
                if(diffPer > 0) {
                    flight.setFullSeatsPer(newPer % 10);
                    int newPrice = ticket.getTicketPrice() + ticket.getTicketPrice() * (diffPer / 100);
                    ticket.setTicketPrice(newPrice);
                }
            }

        }


        return ticketDAO.update(id,ticket);
    }
}
