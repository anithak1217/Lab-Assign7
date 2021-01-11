package com.eventapp;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

import com.eventapp.entities.Event;
import com.eventapp.entities.User;
import com.eventapp.service.EventService;
import com.eventapp.service.UserService;

@SpringBootApplication
public class EventappApplication implements CommandLineRunner{
	@Autowired
	private UserService userService;
	@Autowired
	private EventService eventService;
	
	public static void main(String[] args) 
	{
		SpringApplication.run(EventappApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception
	{
		Event e1=new Event("bharathnatyam", "chennai",500.00, 10, 50, LocalDate.of(2021,Month.APRIL,21));
		//Event e2=new Event("kuchipudi", "chennai",400.00, 15, 50, LocalDate.of(2021,Month.MARCH,12));
		//Event e3=new Event("kathak", "chennai",900.00, 5, 50, LocalDate.of(2021,Month.JULY,11));
		//Event e4=new Event("singing event", "chennai",100.00, 7, 50, LocalDate.of(2021,Month.JANUARY,16));
		
		User user =new User("Anitha","ani","ROLE_ADMIN");
		//User user2 =new User("Ram","r123","ROLE_CLERK");
		
		
		eventService.addEvent(e1);
		//eventService.addEvent(e2);
		//eventService.addEvent(e3);
		//eventService.addEvent(e4);
		
		
		userService.addUser(user);
		//userService.addUser(user2);
	}
	
}
