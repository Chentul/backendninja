package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/say")
public class HelloWorldController {
	
	private int contador;
	
	
	
	public HelloWorldController() {
		super();
		this.contador = 0;
	}



	@GetMapping("/helloworld")
	public String helloWorld() {
		System.out.printf("Requesting #%d of helloworld ...\n", ++this.contador);
		return "helloworld";
	}
	
}