package com.eventapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eventapp.beans.TicketBooking;
import com.eventapp.entities.Event;
import com.eventapp.service.EventService;
@RestController

public class EventController {
	private EventService eventService;
	@Autowired
	public EventController(EventService eventService) 
	{
		this.eventService = eventService;
	}
	//get All Events
	@GetMapping(path="event" ,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Event>> getEvent(){
		List<Event> events=eventService.getAllEvents();
		return ResponseEntity.ok(events);
		
	}
	//get Event
	@GetMapping(path="event/{id}" ,produces=MediaType.APPLICATION_JSON_VALUE)
	public Event getAnEvent(@PathVariable(name = "id")int eventId){
		Event event=eventService.getEventById(eventId);
		return event;
		
	}
	//adding
	@PostMapping(path="event" ,
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public Event addEvent(@RequestBody Event event) {
		Event addedEvent=eventService.addEvent(event);
		return addedEvent;
	}
	
	//updating
	@PutMapping(path="event/{id}" ,
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public Event updateEvent(@PathVariable(name = "id")int eventId,@RequestBody Event event ) {
		Event updateEvent=eventService.updateEvent(eventId,event);
		return updateEvent;
	}
	@DeleteMapping(path="event/{id}" ,
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public Event deleteEvent(@PathVariable(name = "id")int eventId) {
		return eventService.deleteEvent(eventId);
	}
	
	//adding ticket
		@PostMapping(path="ticket" ,
				produces=MediaType.APPLICATION_JSON_VALUE,
				consumes=MediaType.APPLICATION_JSON_VALUE)
		public Event addTicket(@RequestBody Event ticket) {
			Event addedTicket=eventService.addTicket(ticket);
			return addedTicket;
		}
	//deleting ticket
		@DeleteMapping(path="ticket/{id}" ,
				produces=MediaType.APPLICATION_JSON_VALUE,
				consumes=MediaType.APPLICATION_JSON_VALUE)
		public Event cancleTicket(@PathVariable(name = "id")int ticketId) {
			return eventService.cancleTicket(ticketId, cancleTicket(1));
		}
		//ticket booking
		@PostMapping(path="bookTicket", 
				produces = MediaType.APPLICATION_JSON_VALUE, 
				consumes =MediaType.APPLICATION_JSON_VALUE )
		public String deposit( @RequestBody TicketBooking tBbean) {
			eventService.eventRequest(tBbean.getEventId(),tBbean.getNoOfTickets());
			return "tickets booked successfully";
		}
}
