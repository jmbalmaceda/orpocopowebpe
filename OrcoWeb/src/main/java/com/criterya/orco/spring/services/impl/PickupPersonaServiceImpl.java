package com.criterya.orco.spring.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criterya.orco.beans.Histograma;
import com.criterya.orco.spring.daos.PickupPersonaDao;
import com.criterya.orco.spring.services.PickupPersonaService;

@Service("pickupPersonaService")
public class PickupPersonaServiceImpl implements PickupPersonaService {

	@Autowired
	PickupPersonaDao pickupPersonaDao;
	
	@Override
	public Histograma getPickups(Date inicio, Date fin) {
		return pickupPersonaDao.getPickups(inicio, fin);
	}

}
