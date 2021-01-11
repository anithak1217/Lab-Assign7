package com.eventapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
	
	
	@GetMapping("admin")
	public String admin()
	{
		return "hello admin";
	}
	@GetMapping("clerk")
	public String clerk()
	{
		return "hello clerk";
	}
	
	

}
