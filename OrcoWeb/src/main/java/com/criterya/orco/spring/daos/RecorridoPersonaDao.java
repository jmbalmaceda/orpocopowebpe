package com.criterya.orco.spring.daos;

import java.util.Date;

import com.criterya.orco.beans.Histograma;
import com.criterya.orco.beans.GetRecorridosResponse;

public interface RecorridoPersonaDao {

	public GetRecorridosResponse getRecorridos(Date inicio, Date fin);
	public Histograma getHistograma(Date inicio, Date fin);
}