package com.criterya.orco.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criterya.orco.daos.TimesDao;
import com.criterya.orco.model.Times;
import com.criterya.orco.services.TimesService;

@Service("timesService")
public class TimesServiceImpl implements TimesService {
	@Autowired
	TimesDao timesDao;
	
	/* (non-Javadoc)
	 * @see com.criterya.orco.services.impl.TimesServices#getAllTimes()
	 */
	@Override
	public List<Times> getAllTimes(){
		return timesDao.getAlltimes();
	}

	public TimesDao getTimesDao() {
		return timesDao;
	}

	public void setTimesDao(TimesDao timesDao) {
		this.timesDao = timesDao;
	}

}
