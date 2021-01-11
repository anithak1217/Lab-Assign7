package com.eventapp.service;

import java.time.LocalDate;
import java.util.List;

import com.eventapp.dto.TicketBookingRequest;
import com.eventapp.dto.TicketBookingResponse;
import com.eventapp.dto.TicketCancleRequest;
import com.eventapp.dto.TicketCancleResponse;
import com.eventapp.entities.Event;

public interface EventService {

	public List<Event> getAllEvents() ;
	public Event findByEventId(int eventId) ;
	public Event findByEventName(String eventName);
	public Event addEvent(Event event);
	Event updateEvent(int eventId, Event event);
	public TicketBookingResponse bookTickets(TicketBookingRequest request);
	public Event deleteEvent(int eventId);
	
	public TicketCancleResponse cancleTickets(TicketCancleRequest request);
	//public TicketCancleResponse cancleTickets(TicketCancleResponse response);
	  
	
	public List<Event> findByEventDateBetween(LocalDate date1,LocalDate date2);
	


}
