package com.criterya.orco.spring.daos;

// Generated 07-sep-2015 0:05:09 by Hibernate Tools 3.4.0.CR1

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.criterya.orco.commons.DBCommons;
import com.criterya.orco.model.Pickup;

/**
 * Home object for domain model class Pickup.
 * @see com.com.criterya.orco.model.Pickup
 * @author jmbalamceda
 */
public class PickupDAO {

	private static final Log log = LogFactory.getLog(PickupDAO.class);

	private final SessionFactory sessionFactory = DBCommons.getSessionFactory();
	
	public void persist(Pickup transientInstance) {
		log.debug("persisting Pickup instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction t = session.beginTransaction();
			session.persist(transientInstance);
			t.commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Pickup instance) {
		log.debug("attaching dirty Pickup instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction t = session.beginTransaction();
			session.saveOrUpdate(instance);
			t.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Pickup persistentInstance) {
		log.debug("deleting Pickup instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction t = session.beginTransaction();
			session.delete(persistentInstance);
			t.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Pickup merge(Pickup detachedInstance) {
		log.debug("merging Pickup instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction t = session.beginTransaction();
			Pickup result = (Pickup) session.merge(
					detachedInstance);
			t.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Pickup findById(java.lang.Integer id) {
		log.debug("getting Pickup instance with id: " + id);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction t = session.beginTransaction();
			Pickup instance = (Pickup) session.get(Pickup.class, id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			t.commit();
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
