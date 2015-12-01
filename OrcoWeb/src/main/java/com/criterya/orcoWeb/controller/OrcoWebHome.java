package com.criterya.orcoWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrcoWebHome {

	@RequestMapping("/orcoWeb")
	public ModelAndView helloWorld() {
		return new ModelAndView("OrcoWebHome");
	}
}
