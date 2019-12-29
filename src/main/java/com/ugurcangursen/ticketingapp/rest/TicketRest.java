package com.ugurcangursen.ticketingapp.rest;


import com.ugurcangursen.ticketingapp.dto.TicketDto;
import com.ugurcangursen.ticketingapp.service.TicketService;
import com.ugurcangursen.ticketingapp.util.RestPaths;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestPaths.TicketRest.REST)
public class TicketRest {

    private final TicketService ticketService;

    public TicketRest(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // expose "/rest/tickets" and return list of tickets
    @GetMapping
    @ApiOperation(value = "Find All Operation", response = TicketDto.class)
    public List<TicketDto> findAll() {
        List<TicketDto> data = ticketService.findAll();
        return data;
    }

    // add mapping for GET /rest/tickets/{id}
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    @ApiOperation(value = "Find By Id Operation", response = TicketDto.class)
    public TicketDto findById(@PathVariable long id) {

        TicketDto ticket = ticketService.findById(id);

        if (ticket == null) {
            throw new RuntimeException("Ticket  id not found - " + id);
        }

        return ticket;
    }

    // add mapping for POST /rest/tickets - add new ticket
    @PostMapping
    @ApiOperation(value = "Add Ticket Operation", response = TicketDto.class)
    public TicketDto addTicket(@RequestBody TicketDto ticket) {

        return ticketService.save(ticket);
    }

    // add mapping for GET /rest/tickets/code/{ticketCode}
    @GetMapping("/code/{ticketCode}")
    @ApiOperation(value = "Find By Code Operation", response = TicketDto.class)
    public TicketDto findByCode(@PathVariable String ticketCode) {

        TicketDto ticket = ticketService.findByCode(ticketCode);

        if (ticket == null) {
            throw new RuntimeException("Ticket is not found - " + ticketCode);
        }

        return ticket;
    }

    // add mapping for DELETE /rest/tickets/{id} - delete ticket
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = TicketDto.class)
    public String deleteTicket(@PathVariable long id) {

        TicketDto ticket = ticketService.findById(id);

        // throw exception if null

        if (ticket == null) {
            throw new RuntimeException("Ticket id not found - " + id);
        }

        ticketService.deleteById(id);

        return "Deleted ticket id - " + id;
    }

    // add mapping for PUT /rest/tickets/id - update existing ticket
    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = TicketDto.class)
    public TicketDto ticketUpdate(@PathVariable long id, @RequestBody TicketDto ticket) {

        return ticketService.update(id, ticket);
    }
}
