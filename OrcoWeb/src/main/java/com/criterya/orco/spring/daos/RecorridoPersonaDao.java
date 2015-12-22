package com.criterya.orco.spring.daos;

import java.util.Date;

import com.criterya.orco.beans.GetRecorridosResponse;

public interface RecorridoPersonaDao {

	public abstract GetRecorridosResponse getRecorridos(Date inicio, Date fin);

}