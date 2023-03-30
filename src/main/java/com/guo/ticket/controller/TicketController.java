package com.guo.ticket.controller;

import com.guo.ticket.common.entity.Response;
import com.guo.ticket.domain.entities.Ticket;
import com.guo.ticket.domain.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    
    @Autowired
    private TicketRepository ticketRepository;
    
    /**
     * GET /tickets 获取所有的Ticket
     */
    @GetMapping("")
    public Response<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketRepository.getAllTickets();
        return Response.success(tickets);
    }
    
    /**
     * GET /tickets/{id} 根据id获取Ticket信息
     */
    @GetMapping("/{id}")
    public Response<Ticket> getTicketById(@PathVariable("id") String code) {
        Ticket ticket = ticketRepository.getTicketByCode(code);
        if (ticket == null) {
            return Response.fail("Ticket not found with id " + code);
        }
        return Response.success(ticket);
    }
    
    /**
     * POST /tickets 创建一个Ticket
     */
    @PostMapping("")
    public Response<Ticket> createTicket(@RequestBody Ticket ticket) {
        if (ticket == null) {
            return Response.fail("Ticket cannot be null");
        }
        ticket.setCode(UUID.randomUUID().toString());
        ticket.save();
        return Response.success(ticket);
    }
    
    /**
     * PUT /tickets/{id} 根据id更新Ticket信息
     */
    @PutMapping("/{id}")
    public Response<Ticket> updateTicket(@RequestBody Ticket ticket) {
        if (ticket == null) {
            return Response.fail("Ticket cannot be null");
        }
        Ticket existingTicket = ticketRepository.getTicketByCode(ticket.getCode());
        if (existingTicket == null) {
            return Response.fail("Ticket not found with id " + ticket.getCode());
        }
        ticket.update();
        return Response.success(existingTicket);
    }
    
    /**
     * DELETE /tickets/{id} 根据id删除Ticket信息
     */
    @DeleteMapping("/{id}")
    public Response<Ticket> deleteTicket(@PathVariable("id") String code) {
        Ticket ticket = ticketRepository.getTicketByCode(code);
        if (ticket == null) {
            return Response.fail("Ticket not found with id " + code);
        }
        ticket.delete();
        return Response.success(ticket);
    }
}
