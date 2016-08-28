package com.criterya.orco.spring.services;

import java.util.Date;

import com.criterya.orco.beans.Histograma;

public interface PickupPersonaService {
	public Histograma getPickups(Date inicio, Date fin);
}
