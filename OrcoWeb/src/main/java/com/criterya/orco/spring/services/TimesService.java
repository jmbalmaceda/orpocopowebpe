package com.criterya.orco.spring.services;

import java.util.List;

import com.criterya.orco.model.Times;

public interface TimesService {

	public List<Times> getAllTimes();
	public Times getTime(Integer id);
	public Integer saveOrUpdate(Times time);
	public void delete(Times time);
}