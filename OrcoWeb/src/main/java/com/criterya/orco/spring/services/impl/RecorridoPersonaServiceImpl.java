package com.criterya.orco.spring.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criterya.orco.beans.GetRecorridosResponse;
import com.criterya.orco.beans.Histograma;
import com.criterya.orco.spring.daos.RecorridoPersonaDao;
import com.criterya.orco.spring.services.RecorridoPersonaService;
@Service("recorridoPersonaService")
public class RecorridoPersonaServiceImpl implements RecorridoPersonaService {
	@Autowired
	RecorridoPersonaDao recorridoPersonaDao;

	@Override
	public GetRecorridosResponse getRecorridos(Date inicio, Date fin) {
		return recorridoPersonaDao.getRecorridos(inicio, fin);
	}

	@Override
	public Histograma getHistograma(Date inicio, Date fin) {
		return recorridoPersonaDao.getHistograma(inicio, fin);
	}

}
