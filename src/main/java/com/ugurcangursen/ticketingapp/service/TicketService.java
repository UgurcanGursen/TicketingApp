package com.ugurcangursen.ticketingapp.service;

import com.ugurcangursen.ticketingapp.dto.TicketDto;

import java.util.List;

public interface TicketService {
    TicketDto save(TicketDto ticket);
    List<TicketDto> findAll();
    TicketDto findById(long id);
    TicketDto findByCode(String ticketCode);
    void deleteById(long id);
    TicketDto update(long id, TicketDto ticket);
}
