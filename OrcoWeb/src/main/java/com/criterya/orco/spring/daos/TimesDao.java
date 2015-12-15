package com.criterya.orco.spring.daos;

import java.util.List;

import com.criterya.orco.model.Times;

public interface TimesDao {

	public List<Times> getAlltimes();

	public Times getTime(Integer id);

	public Integer saveOrUpdate(Times time);

	public void delete(Times time);

}