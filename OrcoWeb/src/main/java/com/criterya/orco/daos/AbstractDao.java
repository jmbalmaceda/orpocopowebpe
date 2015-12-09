package com.criterya.orco.daos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public abstract class AbstractDao {
    //~ Instance fields ----------------------------------------------------------------------------

    @Autowired
    @Qualifier("orcoSessionFactory")
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
    public void setReportCenterSessionFactory(SessionFactory reportCenterSessionFactory) {
        this.sessionFactory = reportCenterSessionFactory;
    }
    /**
     * @return
     */
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}