package com.eventapp.beans;

public class TicketBooking {
	private int eventId;

	private int noOfTickets;

	public TicketBooking(int eventId, int noOfTickets) {
		
		this.eventId = eventId;
		this.noOfTickets = noOfTickets;
	}

	public TicketBooking() {}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

}
