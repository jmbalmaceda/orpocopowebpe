package com.criterya.orco.spring.daos.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.transaction.annotation.Transactional;

import com.criterya.orco.beans.PromedioYDesviacion;
import com.criterya.orco.model.Pickup;
import com.criterya.orco.spring.daos.UtilsDao;

@Transactional("transactionManager")
public class UtilsDaoImpl extends AbstractDao implements UtilsDao {

	/*
	 * (non-Javadoc)
	 * @see com.criterya.orco.spring.daos.UtilsDao#getPersonasPeriodo(java.util.Date, java.util.Date)
	 */
	@Override
	public Map<Date, Long> getPersonasPeriodo(Date inicio, Date fin) {
		Map<Date, Long> salida = new HashMap<Date, Long>();
		Criteria criteria = getSession().createCriteria(Pickup.class);
		ProjectionList pl = Projections.projectionList();
		pl.add(Projections.countDistinct("blobId"), "cantPersonas");
		pl.add(Projections.sqlGroupProjection("date({alias}.CURRENT_TIME) as periodo", "periodo", new String[] { "periodo" }, new Type[] { StandardBasicTypes.DATE }));
		criteria.setProjection(pl);
		criteria.add(Restrictions.between("currentTime", inicio, fin));
		List<Object[]> list = criteria.list();
		for (Object[] row : list) {
			Long cantPersonas = (Long) row[0];
			Date periodo = (Date) row[1];
			salida.put(periodo, cantPersonas);
		}
		return salida;
	}

	@Override
	public Map<Integer, PromedioYDesviacion> getPersonasSemana(Date inicio, Date fin) {
		Map<Integer, PromedioYDesviacion> salida = new HashMap<Integer, PromedioYDesviacion>();
		SQLQuery query = getSession().createSQLQuery("select weekday(p2.periodo) dia, avg(p2.cantPersonas) promedio, std(p2.cantPersonas) desviacion "+
				"from " + 
				"( "+
				"    SELECT date(p.current_time) periodo, count(distinct p.blob_id) cantPersonas "+
				"	from {h-schema}pickup p "+
				"	where p.current_time between ? and ? "+
				"	group by periodo "+
				") p2 "+
				"group by dia "+
				"order by dia asc");
		query.setDate(0, inicio);
		query.setDate(1, fin);
		List<Object[]> list = query.list();

		for (Object[] row : list) {
			BigDecimal cantPersonas = (BigDecimal) row[1];
			Integer periodo = Integer.parseInt(row[0].toString());
			Number std = (Number) row[2];
			PromedioYDesviacion aux = new PromedioYDesviacion(cantPersonas, std);
			salida.put(periodo, aux);
		}
		
		return salida;
	}

	@Override
	public Map<Integer, Long> getPersonasHora(Date inicio, Date fin) {
		Map<Integer, Long> salida = new HashMap<Integer, Long>();
		SQLQuery query = getSession().createSQLQuery("select p2.hora hora, avg(p2.cantPersonas) promedio "+
				"from " + 
				"( "+
				"    SELECT date(p.current_time) dia, HOUR(p.current_time) hora, count(distinct p.blob_id) cantPersonas "+
				"	from {h-schema}pickup p "+
				"	where p.current_time between ? and ? "+
				"	group by dia, hora "+
				") p2 "+
				"group by hora "+
				"order by hora asc");
		query.setDate(0, inicio);
		query.setDate(1, fin);
		List<Object[]> list = query.list();

		for (Object[] row : list) {
			BigDecimal cantPersonas = (BigDecimal) row[1];
			Integer hora = Integer.parseInt(row[0].toString());
			salida.put(hora, cantPersonas.longValue());
		}
		
		return salida;
	}

}
