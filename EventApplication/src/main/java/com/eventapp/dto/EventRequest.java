package com.eventapp.dto;

public class EventRequest {
	private int eventId;

	private int noOfTickets;

	public EventRequest(int eventId, int noOfTickets) {
		
		this.eventId = eventId;
		this.noOfTickets = noOfTickets;
	}

	public EventRequest() {}

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
