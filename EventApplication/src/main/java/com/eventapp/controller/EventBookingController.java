package com.eventapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventapp.dto.TicketBookingRequest;
import com.eventapp.dto.TicketBookingResponse;
import com.eventapp.dto.TicketCancleRequest;
import com.eventapp.dto.TicketCancleResponse;
import com.eventapp.service.EventService;
@RestController
@RequestMapping("clerk")
public class EventBookingController {
private EventService eventService;
	
	@Autowired
	public EventBookingController(EventService eventService) 
	{
		this.eventService = eventService;
	}
	//ticket booking
	@PostMapping(path="booking" ,
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public TicketBookingResponse bookEvent(@RequestBody TicketBookingRequest eventRequest) {
		//Event addedEvent=eventService.addEvent(event);
		return eventService.bookTickets(eventRequest);
	}
	
	//ticket cancle
		@PostMapping(path="cancle" ,
				produces=MediaType.APPLICATION_JSON_VALUE,
				consumes=MediaType.APPLICATION_JSON_VALUE)
		public TicketCancleResponse cancleEventEventTicketBooking(@RequestBody TicketCancleRequest  cancleRequest) {
			return eventService.cancleTickets(cancleRequest);
		}
}
