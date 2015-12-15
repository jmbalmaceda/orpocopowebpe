package com.criterya.orco.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.criterya.orco.model.Times;
import com.criterya.orco.spring.services.TimesService;

@Controller
public class TimesController {

	@Autowired
	@Qualifier("timesService")
	TimesService timesService;
	
	public TimesController() {
	}
	
	@RequestMapping(value="/times", method = RequestMethod.GET)
	public ModelAndView listing() {
		List<Times> list = timesService.getAllTimes();
		ModelAndView salida = new ModelAndView("times/list");
		salida.addObject("times", list);
		return salida;
	}
	
	@RequestMapping(value = "/times/update", method = RequestMethod.POST)
	public ModelAndView showTime(@ModelAttribute("time") Times time) {
		timesService.saveOrUpdate(time);
		return listing();
	}
	
	@RequestMapping(value = "/times/{id}/delete", method = RequestMethod.GET)
	public String deleteTime(@PathVariable("id") Integer id) {
		Times time = timesService.getTime(id);
		timesService.delete(time);
		return "redirect:/times.htm";
	}

	public TimesService getTimesService() {
		return timesService;
	}

	public void setTimesService(TimesService timesService) {
		this.timesService = timesService;
	}
}
