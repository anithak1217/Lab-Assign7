package com.eventapp.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
@Entity
@Table(name="event_table")
public class Event {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="event_name",nullable=false,length=50)	
	private String eventName;
	
	@Column(name="event_location",nullable=false,length=50)	
	private String eventLocation;
	
	@Column(name="event_price",nullable=false,length=50)	
	private Double eventTicketPrice;	
	
	@Column(name="event_discount",nullable=false,length=50)
	private double discount;
	
	@Column(name="event_noOfTicket",nullable=false,length=50)
	private Integer noOfTicket;

	@Column(name="event_date",nullable=false,length=50)
	private LocalDate eventDate;	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public Double getEventTicketPrice() {
		return eventTicketPrice;
	}

	public void setEventTicketPrice(Double eventTicketPrice) {
		this.eventTicketPrice = eventTicketPrice;
	}

	public LocalDate getDate() {
		return eventDate;
	}

	public void setDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getNoOfTicket() {
		return noOfTicket;
	}

	public void setNoOfTicket(Integer noOfTicket) {
		this.noOfTicket = noOfTicket;
	}

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(String eventName, String eventLocation, Double eventTicketPrice, double discount, Integer noOfTicket,
			LocalDate eventDate) {
		super();
		this.eventName = eventName;
		this.eventLocation = eventLocation;
		this.eventTicketPrice = eventTicketPrice;
		this.discount = discount;
		this.noOfTicket = noOfTicket;
		this.eventDate = eventDate;
	}

	

	
}