package com.ugurcangursen.ticketingapp.dao;

import com.ugurcangursen.ticketingapp.entity.Ticket;

import java.util.List;

public interface TicketDAO {
    Ticket save(Ticket ticket);
    List<Ticket> findAll();
    Ticket findById(long id);
    Ticket findByCode(String ticketCode);
    void deleteById(long id);
    Ticket update(long id, Ticket ticket);

}
