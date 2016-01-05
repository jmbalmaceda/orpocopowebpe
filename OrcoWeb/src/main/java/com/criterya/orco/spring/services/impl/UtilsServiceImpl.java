package com.criterya.orco.spring.services.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criterya.orco.spring.daos.UtilsDao;
import com.criterya.orco.spring.services.UtilsService;

@Service("utilsService")
public class UtilsServiceImpl implements UtilsService {
	@Autowired
	private UtilsDao utilsDao;
	
	/*
	 * (non-Javadoc)
	 * @see com.criterya.orco.spring.services.UtilsService#getPersonasPeriodo(java.util.Date, java.util.Date)
	 */
	@Override
	public Map<Date, Long> getPersonasPeriodo(Date inicio, Date fin) {
		return utilsDao.getPersonasPeriodo(inicio, fin);
	}

	public UtilsDao getUtilsDao() {
		return utilsDao;
	}

	public void setUtilsDao(UtilsDao utilsDao) {
		this.utilsDao = utilsDao;
	}

}
