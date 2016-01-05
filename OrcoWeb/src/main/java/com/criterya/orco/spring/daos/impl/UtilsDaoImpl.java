package com.criterya.orco.spring.daos.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.transaction.annotation.Transactional;

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

}
