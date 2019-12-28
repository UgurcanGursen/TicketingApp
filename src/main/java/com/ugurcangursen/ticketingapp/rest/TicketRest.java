package com.ugurcangursen.ticketingapp.rest;


import com.ugurcangursen.ticketingapp.entity.Ticket;
import com.ugurcangursen.ticketingapp.service.TicketService;
import com.ugurcangursen.ticketingapp.util.RestPaths;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestPaths.TicketRest.REST)
public class TicketRest {

    private  final TicketService ticketService;

    public TicketRest(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // expose "/rest/tickets" and return list of tickets
    @GetMapping
    public List<Ticket> findAll() {
        return ticketService.findAll();
    }

    // add mapping for GET /rest/tickets/{id}
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Ticket findById(@PathVariable long id) {

        Ticket ticket = ticketService.findById(id);

        if (ticket == null) {
            throw new RuntimeException("Ticket  id not found - " + id);
        }

        return ticket;
    }

    // add mapping for POST /rest/tickets - add new ticket
    @PostMapping
    public Ticket addTicket(@RequestBody Ticket ticket) {


        ticketService.save(ticket);

        return ticket;
    }

    // add mapping for GET /rest/tickets/code/{ticketCode}
    @GetMapping("/code/{ticketCode}")
    public Ticket findByCode(@PathVariable String ticketCode) {

        Ticket ticket = ticketService.findByCode(ticketCode);

        if (ticket == null) {
            throw new RuntimeException("Ticket is not found - " + ticketCode);
        }

        return ticket;
    }

    // add mapping for DELETE /rest/tickets/{id} - delete ticket
    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable long id) {

        Ticket ticket = ticketService.findById(id);

        // throw exception if null

        if (ticket == null) {
            throw new RuntimeException("Ticket id not found - " + id);
        }

        ticketService.deleteById(id);

        return "Deleted ticket id - " + id;
    }

    // add mapping for PUT /rest/tickets/id - update existing ticket
    @PutMapping("/{id}")
    public Ticket ticketUpdate(@PathVariable long id, @RequestBody Ticket ticket) {

        ticketService.update(id,ticket);
        return ticket;
    }
}
