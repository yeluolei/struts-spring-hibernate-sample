package com.yerurui.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static String CONFIG_FILE = "/hibernate.cfg.xml";
	private static final ThreadLocal<Session>THREADLO_LOCAL = new ThreadLocal<Session>();
	private static Configuration configuration = new Configuration();
	private static SessionFactory sessionFactory ;
	
	static{
		try {
			configuration.configure(CONFIG_FILE);
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Session getSession (){
		Session session = THREADLO_LOCAL.get();
		if (session == null || !session.isOpen()){
			if (sessionFactory == null){
				rebuildSessionFactory();
			}
			session = (sessionFactory != null) ? sessionFactory.openSession():null;
			THREADLO_LOCAL.set(session);
		}
		return session;
		
	}
	
	public static void rebuildSessionFactory(){
		try {
			configuration.configure(CONFIG_FILE);
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeSession(){
		Session session = THREADLO_LOCAL.get();
		THREADLO_LOCAL.set(null);
		if (session != null){
			session.close();
		}
	}
}
