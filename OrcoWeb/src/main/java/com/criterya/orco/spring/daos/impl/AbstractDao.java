package com.criterya.orco.spring.daos.impl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {
    //~ Instance fields ----------------------------------------------------------------------------

    @Autowired
	protected SessionFactory sessionFactory;

    //~ Methods ------------------------------------------------------------------------------------

    /**
     * @param entity
     */
    public void delete(Object entity) {
        getSession().delete(entity);
    }

    /**
     * @return the reportCenterSessionFactory
     */
    public SessionFactory getReportCenterSessionFactory() {
        return sessionFactory;
    }
    /**
     * @param entity
     */
    public void persist(Object entity) {
        getSession().persist(entity);
    }

    /**
     * @param reportCenterSessionFactory the reportCenterSessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    /**
     * @return
     */
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}