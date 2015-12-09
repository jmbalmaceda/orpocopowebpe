package com.criterya.orco.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBCommons {
	private static SessionFactory factory;
	private static Connection con;
	
	
	@SuppressWarnings("deprecation")
	public static SessionFactory getSessionFactory(){
		if (factory == null){
			factory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
		}
		return factory;
	}
	
	
	public static Connection getConnection() throws SQLException {
		if (con == null)
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/orcodb", "root", "");
		return con;
	}
}
