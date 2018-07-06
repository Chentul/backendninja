package com.udemy.backendninja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backendninja.service.ExerciseService;

@Controller
@RequestMapping("/exercise")
public class EjercicioController {
	
	private static final String EXERCISE_VIEW = "exercise";
	
	// inject dependencies
	@Autowired
	@Qualifier("exerciseService")
	private ExerciseService exerciseService;
	
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/exercise/myExercise");
	}
	
	@GetMapping("/myExercise")
	public ModelAndView showExercise(@RequestParam(name="name", required=false, defaultValue="Undefined") String name) {
		ModelAndView mav = new ModelAndView(EXERCISE_VIEW);
		mav.addObject("name", name); // share the value from the browser param with the view
		exerciseService.getMessage();
		return mav;
	}
	
}
