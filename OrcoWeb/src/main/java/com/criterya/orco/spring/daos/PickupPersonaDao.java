package com.criterya.orco.spring.daos;

import java.util.Date;

import com.criterya.orco.beans.Histograma;

public interface PickupPersonaDao {
	public Histograma getPickups(Date inicio, Date fin);
}
