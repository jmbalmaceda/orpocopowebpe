package com.criterya.orcoWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorld {

	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {

		String message = "Pero qu� cito!!!";
		return new ModelAndView("welcome", "message", message);
	}
}
