package com.criterya.orco.spring.daos.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.criterya.orco.beans.Histograma;
import com.criterya.orco.model.Pickup;
import com.criterya.orco.spring.daos.PickupPersonaDao;

@Transactional("transactionManager")
public class PickupPersonaDaoImpl extends AbstractDao implements
		PickupPersonaDao {

	@Override
	public Histograma getPickups(Date inicio, Date fin) {
		@SuppressWarnings("unchecked")
		List<Object[]> list = getSession().createCriteria(Pickup.class).add(Restrictions.between("currentTime", inicio, fin)).add(Restrictions.isNotNull("blobHandId"))
		.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("blobHandX"), "x")
				.add(Projections.groupProperty("blobHandY"), "y")
				.add(Projections.count("blobHandId"), "count")
		).list();
		Histograma salida = new Histograma();
		for (Object[] row : list) {
			salida.setValue((Integer)row[0], (Integer)row[1], Integer.parseInt(row[2].toString()));
		}
		return salida ;
	}

}
