package com.happytrip.petcargo.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionObj;

	public static SessionFactory getSessionFactory() {

		if (sessionObj == null) {

			Configuration config = new AnnotationConfiguration();
			config = config.configure();
			sessionObj = config.buildSessionFactory();
		}
		return sessionObj;
	}
	
	public static void main(String...a){
		getSessionFactory();
	}
}
