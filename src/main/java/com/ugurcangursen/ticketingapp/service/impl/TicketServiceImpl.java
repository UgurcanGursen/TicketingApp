package com.ugurcangursen.ticketingapp.service.impl;

import com.ugurcangursen.ticketingapp.dao.FlightDAO;
import com.ugurcangursen.ticketingapp.dao.TicketDAO;
import com.ugurcangursen.ticketingapp.dto.TicketDto;
import com.ugurcangursen.ticketingapp.entity.Flight;
import com.ugurcangursen.ticketingapp.entity.Ticket;
import com.ugurcangursen.ticketingapp.service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketDAO ticketDAO;
    private final FlightDAO flightDAO;
    private final ModelMapper modelMapper;


    @Autowired
    public TicketServiceImpl(TicketDAO ticketDAO, FlightDAO flightDAO, ModelMapper modelMapper) {
        this.ticketDAO = ticketDAO;
        this.flightDAO = flightDAO;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public TicketDto save(TicketDto ticket) {
        if (ticket != null) {
            Ticket ticketDb = modelMapper.map(ticket, Ticket.class);

            if (ticketDb.isTicketSold()) {
                // Get quota status of Flight
                Flight flight = flightDAO.findById(ticket.getFlightId());
                ticketDb.setFlight(flight);
                float quota = flight.getNumberOfSeats();
                float fullQuota = flight.getNumOfFullSeats();

                if (fullQuota < quota) {
                    // Increase quota if it is not full yet
                    flight.setNumOfFullSeats(fullQuota + 1);

                    float newPer = ((1+fullQuota)*100)/quota;
                    float currentPer = flight.getFullSeatsPer();
                    float diffPer = newPer - currentPer;
                    float newPrice;
                    if (diffPer > 9) {
                        flight.setFullSeatsPer(newPer);
                        newPrice = flight.getTicketPrice() + flight.getTicketPrice() * diffPer/100;
                        ticketDb.getFlight().setTicketPrice(newPrice);
                    }
                }
            }


            Ticket ticketDbSaved = ticketDAO.save(ticketDb);
            if (ticketDbSaved != null) {
                return modelMapper.map(ticketDbSaved, TicketDto.class);
            }
        }
        return ticket;
    }

    @Override
    @Transactional
    public List<TicketDto> findAll() {
        List<Ticket> data = ticketDAO.findAll();
        return Arrays.asList(modelMapper.map(data, TicketDto[].class));
    }

    @Override
    @Transactional
    public TicketDto findById(long id) {
        Ticket ticket = ticketDAO.findById(id);
        return modelMapper.map(ticket, TicketDto.class);
    }

    @Override
    @Transactional
    public TicketDto findByCode(String ticketCode) {
        Ticket ticket = ticketDAO.findByCode(ticketCode);
        return modelMapper.map(ticket, TicketDto.class);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        ticketDAO.deleteById(id);
    }

    @Override
    @Transactional
    public TicketDto update(long id, TicketDto ticket) {
        if (ticket != null) {
            Ticket ticketDb = modelMapper.map(ticket, Ticket.class);

            if (ticketDb.isTicketSold()) {
                // Get quota status of Flight
                Flight flight = flightDAO.findById(ticket.getFlightId());
                ticketDb.setFlight(flight);
                float quota = flight.getNumberOfSeats();
                float fullQuota = flight.getNumOfFullSeats();

                if (fullQuota < quota) {
                    // Increase quota if it is not full yet
                    flight.setNumOfFullSeats(fullQuota + 1);

                    float newPer = ((1+fullQuota)*100)/quota;
                    float currentPer = flight.getFullSeatsPer();
                    float diffPer = newPer - currentPer;
                    float newPrice;
                    if (diffPer > 9) {
                        flight.setFullSeatsPer(newPer);
                        newPrice = flight.getTicketPrice() + flight.getTicketPrice() * diffPer/100;
                        ticketDb.getFlight().setTicketPrice(newPrice);
                    }
                }
            }


            Ticket ticketDbSaved = ticketDAO.update(id,ticketDb);
            if (ticketDbSaved != null) {
                return modelMapper.map(ticketDbSaved, TicketDto.class);
            }
        }
        return ticket;
    }
}
