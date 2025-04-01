package com.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ticket.entity.Ticket;
import com.ticket.repository.TicketRepository;
import com.ticket.service.TicketService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/tickets")
public class TicketController {
	@Autowired
	TicketService service;
	@Autowired
    private TicketRepository ticketRepository;
	@PostMapping
	public Ticket addTicketDetails(@RequestBody Ticket t) {
		
		return service.addTicket(t);
	}

	@PutMapping("/{id}")
		
		public Ticket updateTicketDetails(@PathVariable("id") int id,@RequestBody Ticket t) {
		t.setId(id);
			return service.update(t);
			
		}
		@GetMapping("/all")
		
		public List<Ticket>getAllTicketInfo(){
			return service.getAllTickets();
			
		}
		@GetMapping("{id}")
		public Ticket getTicketbyId(@PathVariable("id")int id) {
			return service.getTickeyById(id);
		}
		@GetMapping("/id/{id}")
		public Ticket getTicketByUserId(@PathVariable int id) {
			return ticketRepository.findById(id).get();
		}
		@DeleteMapping("/delete/{id}")
		public String deleteticketDetails(@PathVariable("id")int id) {
			return service.deleteTicket(id);
		}
	
	
}
