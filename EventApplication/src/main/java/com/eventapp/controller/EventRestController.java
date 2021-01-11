package com.eventapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventapp.dto.TicketBookingRequest;
import com.eventapp.dto.TicketBookingResponse;
import com.eventapp.dto.TicketCancleRequest;
import com.eventapp.dto.TicketCancleResponse;
import com.eventapp.entities.Event;
import com.eventapp.service.EventService;


@RestController
@RequestMapping("admin")

public class EventRestController {
	@Autowired
private EventService eventService;
	
	
	
	
	public EventRestController(EventService eventService) {
		
		this.eventService = eventService;
	}

	@GetMapping("events")
	public ResponseEntity<List<Event>> getEvent(){
		List<Event> allEvents=eventService.getAllEvents();
		return new ResponseEntity<List<Event>>(allEvents,HttpStatus.OK);
	}
	
	@GetMapping("events/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable("id")int eventId){
		Event eventsById=eventService.findByEventId(eventId);
		return new ResponseEntity<Event>(eventsById,HttpStatus.OK);
	}
	
	@PostMapping(path="events",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Event> getEventAdded(@RequestBody Event event){
		eventService.addEvent(event);
		return new ResponseEntity<Event>(HttpStatus.CREATED);
	}

	
	  @PutMapping(path="events/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<Event> getEventUpdated(@PathVariable("id")int eventId,@RequestBody Event event)
	  { 
	   Event eventsUpdated=eventService.updateEvent(eventId, event); 
	   return new ResponseEntity<Event>(eventsUpdated,HttpStatus.CREATED); 
	  }
	 
	@DeleteMapping(path="events/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> getEventDeleted(@PathVariable("id")int eventId){
		Event eventsDeleted=eventService.deleteEvent(eventId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	  @GetMapping("events/{name}")
	  public ResponseEntity<Event> getEventByName(@PathVariable("name")String eventName)
	  { 
		  Event eventsByName=eventService.findByEventName(eventName); 
		  return new ResponseEntity<Event>(eventsByName,HttpStatus.OK); 
		  }
	 
	  @PostMapping(path="booking", 
				produces = MediaType.APPLICATION_JSON_VALUE, 
				consumes =MediaType.APPLICATION_JSON_VALUE )
		public TicketBookingResponse booking( @RequestBody TicketBookingRequest request) {
			
			return eventService.bookTickets(request);
		}
		
		@PostMapping(path="cancel", 
				produces = MediaType.APPLICATION_JSON_VALUE, 
				consumes =MediaType.APPLICATION_JSON_VALUE )
		public TicketCancleResponse cancel( @RequestBody TicketCancleRequest cancelrequest) {
			
			return eventService.cancleTickets(cancelrequest);
		}
}