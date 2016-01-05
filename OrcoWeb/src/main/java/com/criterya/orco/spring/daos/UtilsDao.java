package com.criterya.orco.spring.daos;

import java.util.Date;
import java.util.Map;

public interface UtilsDao {
	/**
	 * Retorna la cantidad de personas que pasaron en un periodo de tiempo
	 * @param inicio
	 * @param fin
	 * @return
	 */
	Map<Date, Long> getPersonasPeriodo(Date inicio, Date fin);
}
