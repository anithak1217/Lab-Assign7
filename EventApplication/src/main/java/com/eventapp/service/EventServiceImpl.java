package com.eventapp.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventapp.dto.TicketBookingRequest;
import com.eventapp.dto.TicketBookingResponse;
import com.eventapp.dto.TicketCancleRequest;
import com.eventapp.dto.TicketCancleResponse;
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
	public Event findByEventId(int eventId) {
		return eventRepo.findById(eventId).orElseThrow(()->new EventNotFoundException("event info with id:"+eventId+"not found"));
	}

	
	
	@Override
	public Event addEvent(Event event) {
		eventRepo.save(event);
		return event;
	}

	@Override
	public Event updateEvent(int eventId, Event event) {
		Event eventToUpdate=findByEventId(eventId);
		eventToUpdate.setEventTicketPrice(event.getEventTicketPrice());
		eventToUpdate.setDiscount(event.getDiscount());
		eventToUpdate.setNoOfTicket(event.getNoOfTicket());
		eventRepo.save(eventToUpdate);
		return eventToUpdate;
	}

	@Override
	public Event deleteEvent(int eventId) {
		Event eventToDelete=findByEventId(eventId);
		eventRepo.delete(eventToDelete);
		return eventToDelete;
	}

	@Override
	public Event findByEventName(String eventName) {
		return eventRepo.findByEventName(eventName);
	}
	

	@Override
	public List<Event> findByEventDateBetween(LocalDate date1, LocalDate date2) {
		return eventRepo.findByEventDateBetween(date1, date2);
	}

	@Override
	public TicketBookingResponse bookTickets(TicketBookingRequest request) {
		TicketBookingResponse response=new TicketBookingResponse();
		Event eventToBook=findByEventId(request.getEventId());
		if(request.getNoOfTicket()>eventToBook.getNoOfTicket()) {
			response.setMessage("no of ticket requested is more than what we can book");
			response.setAmountPayable(0.0);
		}
		else {
			eventToBook.setNoOfTicket(eventToBook.getNoOfTicket()-request.getNoOfTicket());
			this.updateEvent(eventToBook.getId(), eventToBook);
			response.setMessage("ticket book successfully");
			double pricePayable=(eventToBook.getEventTicketPrice()*request.getNoOfTicket())*(100-eventToBook.getDiscount())/100;
			response.setAmountPayable(pricePayable);
			}
		return response;
	}
//cancle tickets
	@Override
	public TicketCancleResponse cancleTickets(TicketCancleRequest request) {
		TicketCancleRequest response=new TicketCancleRequest();
		Event eventToCancel=findByEventId(request.getEventId());
		if(eventToCancel==null) {
			throw new EventNotFoundException("event with id :" +request.getEventId()+  "is not found");
		}
		LocalDate eventDate=eventToCancel.getDate();
		if(eventDate.isBefore(LocalDate.now())) {
			
		}
		eventToCancel.setNoOfTicket(eventToCancel.getNoOfTicket()+request.getNoOfTicket());
		//return 50% of booking amnt
		double amountReturned=(eventToCancel.getEventTicketPrice()*eventToCancel.getNoOfTicket())*
				(100 - eventToCancel.getDiscount())/100;
		
		TicketCancleResponse cancelResponse=new TicketCancleResponse();
		cancelResponse.setAmountPayable(amountReturned);
		cancelResponse.setMessage("tickets are cancelled");
		return cancelResponse;
	}

	
	
	


	

	

	
	
	
}