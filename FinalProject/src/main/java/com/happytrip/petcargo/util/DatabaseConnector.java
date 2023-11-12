package com.happytrip.petcargo.util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class DatabaseConnector {

	private static SessionFactory sessionFactory = null;
	private DatabaseConnector() {
		// TODO Auto-generated constructor stub
	}
	
	public static SessionFactory getSessionFactory(){
		
		if(sessionFactory == null){
		AnnotationConfiguration configuration = new AnnotationConfiguration();
			configuration = configuration.configure();
			sessionFactory = configuration.buildSessionFactory();
		}
		return sessionFactory;
	}
	

	
	
}
