package br.com.crud.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
		Configuration cfg = new Configuration();
		try {
			cfg.configure("hibernate.cfg.xml");
		} catch (Exception e) {
		}
		return cfg.buildSessionFactory();
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
}
