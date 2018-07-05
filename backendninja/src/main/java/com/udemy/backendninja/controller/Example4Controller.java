package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/example4")
public class Example4Controller {
	
	public static final String CLIENT_ERROR_VIEW = "404";
	
	@GetMapping("")
	public RedirectView redirect() {
		return new RedirectView("/example4/404");
	}
	
	@GetMapping("/404")
	public String get404() {
		return CLIENT_ERROR_VIEW;
	}
	
}
