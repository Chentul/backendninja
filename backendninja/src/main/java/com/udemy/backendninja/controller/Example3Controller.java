package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
	 
	private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);
	
	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEW = "result";
	
//	first way to redirect
//	@GetMapping("/")
//	public String redirect() {
//		return "redirect:/example3/showform";
//	}
	
	// second way to redirect
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/example3/showform");
	}
	
	@GetMapping("/showform")
	public String showForm(Model mav) {
//		LOGGER.info("INFO TRACE");
//		LOGGER.warn("WARNING TRACE");
//		LOGGER.error("ERROR TRACE");
		LOGGER.debug("DEBUG"); // only show de log if is in debug mode
		mav.addAttribute("person", new Person());
		return FORM_VIEW; // return the view
	}
	
	// get all the attributes from @ModelAttribute("person") Person p
	@PostMapping("/addperson")
	public ModelAndView addPerson(@ModelAttribute("persona") Person person) {
		LOGGER.info("METHOD: 'addPerson' -- PARAMS: '" + person + "'");
		ModelAndView mav = new ModelAndView(RESULT_VIEW);
		mav.addObject("person", person);
		LOGGER.info("TEMPLATE: '" + RESULT_VIEW + "' -- DATA: '" + person + "'");
		return mav;
	}
	
}
