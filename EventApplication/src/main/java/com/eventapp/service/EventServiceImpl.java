package com.eventapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventapp.entities.Event;
import com.eventapp.exceptions.EventNotFoundException;
import com.eventapp.repo.EventRepo;


@Service
@Transactional
public class EventServiceImpl implements EventService{

	private EventRepo eventRepo;
	
	@Autowired
	public EventServiceImpl(EventRepo eventRepo) {
		this.eventRepo=eventRepo;
		
	}

	@Override
	public List<Event> getAllEvents() {
		return eventRepo.findAll();
	}

	@Override
	public Event getEventById(int eventId) {
		return eventRepo.findById(eventId).orElseThrow(()->new EventNotFoundException("product with id:"+eventId+"not found"));
	}

	@Override
	public Event addEvent(Event event) {
		eventRepo.save(event);
		return event;
	}

	@Override
	public Event updateEvent(int eventId, Event event) {
		Event eventToUpdate=getEventById(eventId);
		eventToUpdate.setPrice(event.getPrice());
		eventToUpdate.setDiscount(event.getDiscount());
		eventRepo.save(eventToUpdate);
		return eventToUpdate;
	}

	@Override
	public Event deleteEvent(int eventId) {
		Event eventToDelete=getEventById(eventId);
		eventRepo.delete(eventToDelete);
		return eventToDelete;
	}

	@Override
	public Event findByUserName(String username) {
		return null;
	}
	private Event getTicketById(int ticketId) {
		return eventRepo.findById(ticketId).orElseThrow(()->new EventNotFoundException("product with id:"+ticketId+"not found"));
	}
	@Override
	public Event addTicket(Event ticket) {
		eventRepo.save(ticket);
		return ticket;
	}

	@Override
	public Event cancleTicket(int eventId, Event event) {
		Event ticketToDelete=getTicketById(eventId);
		eventRepo.delete(ticketToDelete);
		return ticketToDelete;
	}


	@Override
	public void eventRequest(int eventId, int noOfTickets) {
		// TODO Auto-generated method stub
		Event tickets=getEventById(eventId);
		tickets.setNoOfTicket(tickets.getNoOfTicket()+noOfTickets);
		eventRepo.save(tickets);
		
	}
	
	
}