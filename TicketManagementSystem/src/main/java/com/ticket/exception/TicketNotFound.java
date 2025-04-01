package com.ticket.exception;

public class TicketNotFound extends RuntimeException{

	public TicketNotFound(String msg) {
		super(msg);
	}
}
