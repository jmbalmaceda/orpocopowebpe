package com.criterya.orco.spring.daos.impl;

// Generated 07-sep-2015 0:05:09 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.springframework.transaction.annotation.Transactional;

import com.criterya.orco.model.Times;
import com.criterya.orco.spring.daos.TimesDao;

@Transactional("transactionManager")
public class TimesDaoImpl extends AbstractDao implements TimesDao{

	private static final Log log = LogFactory.getLog(TimesDaoImpl.class);


	/* (non-Javadoc)
	 * @see com.criterya.orco.daos.impl.TimesDao#getAlltimes()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Times> getAlltimes(){
		return sessionFactory.getCurrentSession().createCriteria(Times.class).addOrder(Order.asc("weekDay")).addOrder(Order.asc("start")).list();
	}

	public void persist(Times transientInstance) {
		log.debug("persisting Times instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Times instance) {
		log.debug("attaching dirty Times instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Times instance) {
		log.debug("attaching clean Times instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Times persistentInstance) {
		log.debug("deleting Times instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Times merge(Times detachedInstance) {
		log.debug("merging Times instance");
		try {
			Times result = (Times) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Times findById(java.lang.Integer id) {
		log.debug("getting Times instance with id: " + id);
		try {
			Times instance = (Times) sessionFactory.getCurrentSession().get(
					"com.criterya.orco.Times", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Times instance) {
		log.debug("finding Times instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.criterya.orco.Times")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@Override
	public Times getTime(Integer id) {
		return (Times) getSession().get(Times.class, id);
	}

	@Override
	public Integer save(Times time) {
		return (Integer) getSession().save(time);
	}

	@Override
	public void update(Times time) {
		Times t = (Times) getSession().get(Times.class, time.getId());
		t.setFinish(time.getFinish());
		t.setStart(time.getStart());
		t.setWeekDay(time.getWeekDay());
		getSession().update(t);
	}
}
