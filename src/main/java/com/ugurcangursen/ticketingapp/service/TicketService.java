package com.ugurcangursen.ticketingapp.service;

import com.ugurcangursen.ticketingapp.entity.Ticket;

import java.util.List;

public interface TicketService {
    void save(Ticket ticket);
    List<Ticket> findAll();
    Ticket findById(long id);
    Ticket findByCode(String ticketCode);
    void deleteById(long id);
    Ticket update(long id, Ticket ticket);
}
