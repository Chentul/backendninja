package com.udemy.backendninja.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	/**
	 *  get all the attributes from @ModelAttribute("person") Person p
	 * @Valid -> Validate the model with the annotations that already has the class
	 * BindingResult -> spring verify the fields
	 */
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, 
									BindingResult bind) {
		LOGGER.info("METHOD: 'addPerson' -- PARAMS: '" + person + "'");
		ModelAndView mav = new ModelAndView();
		
		System.out.println(bind.hasErrors());
		System.out.println(bind);
		
		if(bind.hasErrors())
			mav.setViewName(FORM_VIEW);
		else {
			mav.setViewName(RESULT_VIEW);
			mav.addObject("person", person);
		}
		
		LOGGER.info("TEMPLATE: '" + RESULT_VIEW + "' -- DATA: '" + person + "'");
		System.out.println(mav);
		
		return mav;
	}
	
}
