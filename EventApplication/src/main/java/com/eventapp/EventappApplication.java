package com.eventapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eventapp.entities.Event;
import com.eventapp.service.EventService;

@SpringBootApplication
public class EventappApplication implements CommandLineRunner{
	@Autowired
	private EventService eventService;
	public static void main(String[] args) 
	{
		SpringApplication.run(EventappApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception
	{
//		Event e1=new Event("kathak", "bangalore", 50000.00, "2020-05-12", 20, 500);
//		Event e2=new Event("kuchipoodi", "Chennai", 150000.00, "2020-05-12", 10, 300);
//		Event e3=new Event("singing event", "Delhi", 570000.00, "2020-05-12", 15, 700);
//		Event e4=new Event("classical dance", "Kochi", 130000.00, "2020-05-12", 27, 100);
//		
//		eventService.addEvent(e1);
//		eventService.addEvent(e2);
//		eventService.addEvent(e3);
//		eventService.addEvent(e4);
		
		
	}
	
	//List<Event> events=eventService.getAllEventUsers();
			//events.forEach(event-> System.out.println(event));
}
