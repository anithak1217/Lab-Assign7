package com.eventapp.service;

import java.util.List;

import com.eventapp.entities.Event;

public interface EventService {

	public List<Event> getAllEvents() ;
	public Event getEventById(int eventId) ;
	public Event addEvent(Event event);
	public Event updateEvent(int eventId, Event event);
	public Event deleteEvent(int eventId);
	public Event findByUserName(String username);
	public Event addTicket(Event event);
	public Event cancleTicket(int eventId, Event event);
	void eventRequest(int eventId, int noOfTickets);

}
