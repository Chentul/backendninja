package com.udemy.backendninja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.component.ExampleComponent;
import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;

@Controller
@RequestMapping("/example")
public class ExampleController {
	
	public static final String EXAMPLE_VIEW = "example";
	
	// inject services
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	// inject componenets
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent; // we don't need the keyword new
	
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
		exampleComponent.sayHello();
		model.addAttribute("people", this.exampleService.getListPeople());
		return EXAMPLE_VIEW;
	}

	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people", this.exampleService.getListPeople());
		return mav;
	}
	
}
