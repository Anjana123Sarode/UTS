package com.ticket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.entity.Ticket;
import com.ticket.exception.TicketNotFound;
import com.ticket.repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	
	public TicketRepository trepo;
	
	public Ticket addTicket(Ticket t1) {
		return trepo.save(t1);
		
	}
	 
	public List<Ticket>getAllTickets(){
		return trepo.findAll();
	}
	
	public Ticket getTickeyById(int id){
		
		Optional<Ticket>ticket=trepo.findById(id);
		if(!ticket.isPresent()) {
			throw new TicketNotFound("Searching ticket id not avaialable");
		}
		else {
			
			
		return ticket.get();
	}
	}
	public List<Ticket> getTicketByUser(int userId) {
        return trepo.findByUserId(userId);
    }
	
public Ticket update(Ticket t) {
		
		Optional<Ticket>newTicket=trepo.findById(t.getId());
		if(!newTicket.isPresent()) {
			throw new TicketNotFound("Searching ticket id not avaialable");
		}
		else {
			Ticket tt=newTicket.get();
			tt.setSource(t.getSource());
			tt.setDestination(t.getDestination());
			tt.setDistance(t.getDistance());
			tt.setCost(t.getCost());
			tt.setDate(t.getDate());
			trepo.save(tt);
			return tt;
		}
	
	}
public String deleteTicket(int id) {

	Optional<Ticket>ticket=trepo.findById(id);
	if(ticket.isPresent()) {
		 trepo.delete(ticket.get());
	}
	else {
		throw new TicketNotFound("Searching ticket id not avaialable");
	};
	return "ticket id deleted";
}
}
