package com.criterya.orco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.criterya.orco.model.Times;
import com.criterya.orco.services.TimesService;

@Controller
public class TimesController {

	@Autowired
	@Qualifier("timesService")
	TimesService timesService;
	
	public TimesController() {
	}
	
	@RequestMapping(value="/times", method = RequestMethod.GET)
	public ModelAndView listing() {
		return new ModelAndView("times/list");
	}
	
	@RequestMapping(value = "/times/{id}", method = RequestMethod.GET)
	public ModelAndView showTime(@PathVariable("id") String id) {
		List<Times> list = timesService.getAllTimes();
		ModelAndView salida = new ModelAndView("times/list");
		salida.addObject("times", list);
		return salida;
	}

	public TimesService getTimesService() {
		return timesService;
	}

	public void setTimesService(TimesService timesService) {
		this.timesService = timesService;
	}
}
