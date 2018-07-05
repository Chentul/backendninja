package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/example5")
public class Example5Controller {
	
	public static final String SERVER_ERROR = "500";
	
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/example5/500");
	}
	
	@GetMapping("/500")
	public String get500() {
		return SERVER_ERROR;
	}
	
}
