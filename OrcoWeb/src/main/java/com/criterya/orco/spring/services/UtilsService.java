package com.criterya.orco.spring.services;

import java.util.Date;
import java.util.Map;

import com.criterya.orco.beans.PromedioYDesviacion;

public interface UtilsService {
	/**
	 * Retorna la cantidad de personas que pasaron en un periodo de tiempo
	 * @param inicio
	 * @param fin
	 * @return
	 */
	Map<Date, Long> getPersonasPeriodo(Date inicio, Date fin);
	
	Map<Integer, PromedioYDesviacion> getPersonasSemana(Date inicio, Date fin);

	/**
	 * Retorna el promedio de personas que pasaron por hora
	 * @param inicio
	 * @param fin
	 * @return
	 */
	Map<Integer, Long> getPersonasHora(Date inicio, Date fin);
}
