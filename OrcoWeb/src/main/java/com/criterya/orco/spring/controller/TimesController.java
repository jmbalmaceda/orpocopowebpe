package com.criterya.orco.spring.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	
	@InitBinder
  	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(
	            dateFormat, false));
  		//binder.setValidator(elementFormValidator);
  	}
	
	@RequestMapping(value="/times", method = RequestMethod.GET)
	public ModelAndView listing() {
		List<Times> list = timesService.getAllTimes();
		ModelAndView salida = new ModelAndView("times/list");
		salida.addObject("times", list);
		List<String> days = new ArrayList<>();
		days.add("Domingo");
		days.add("Lunes");
		days.add("Martes");
		days.add("Mi&eacute;rcoles");
		days.add("Jueves");
		days.add("Viernes");
		days.add("S&aacute;bado");
		salida.addObject("days", days);
		return salida;
	}
	
	@RequestMapping(value = "/times/{id}/show", method = RequestMethod.GET)
	public String showTime(@PathVariable("id") Integer id, Model model) {
		Times time = timesService.getTime(id);
		model.addAttribute("time", time);
		return "/times/form";
	}
	
	@RequestMapping(value = "/times/add", method = RequestMethod.GET)
	public String addTime(Model model) {
		Times time = new Times();
		time.setStart(Calendar.getInstance().getTime());
		time.setFinish(Calendar.getInstance().getTime());
		model.addAttribute("time", time);
		return "/times/form";
	}
	
	@RequestMapping(value = "/times/update", method = RequestMethod.POST)
	public String updateTime(@Validated @ModelAttribute("time") Times time, BindingResult result, Model model) {
		timesService.saveOrUpdate(time);
		return "redirect:/times.htm";
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
