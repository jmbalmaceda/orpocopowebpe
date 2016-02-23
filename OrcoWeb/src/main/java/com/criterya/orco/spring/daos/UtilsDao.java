package com.criterya.orco.spring.daos;

import java.util.Date;
import java.util.Map;

import com.criterya.orco.beans.PromedioYDesviacion;

public interface UtilsDao {
	/**
	 * Retorna la cantidad de personas que pasaron en un periodo de tiempo.
	 * Retorna un mapa indicando la cantidad de personas en cada d�a del periodo
	 * @param inicio
	 * @param fin
	 * @return
	 */
	Map<Date, Long> getPersonasPeriodo(Date inicio, Date fin);

	/**
	 * Retorna el promedio de personas que pasaron en los distintos d�as de la semana en el periodo de tiempo.
	 * Retorno un mapa indicando el d�a de la semana y el promedio de cada d�a de la semana.
	 * @param inicio
	 * @param fin
	 * @return
	 */
	Map<Integer, PromedioYDesviacion> getPersonasSemana(Date inicio, Date fin);

	/**
	 * Retorna el promedio de personas que pasaron por hora
	 * @param inicio
	 * @param fin
	 * @return
	 */
	Map<Integer, Long> getPersonasHora(Date inicio, Date fin);
}
