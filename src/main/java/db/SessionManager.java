package db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionManager {
	
	private static volatile SessionManager sessionManager;
	private final SessionFactory sf;
	
	public static SessionManager getInstance() {
		if(sessionManager == null) {
			synchronized(SessionManager.class) {
				if(sessionManager == null) {
					sessionManager = new SessionManager();		
				}
			}
		}
		return sessionManager;
	}
	
	public Session getSession() {
		Session session = sf.openSession();
		return session;
	}

	private SessionFactory createSessionFactory() {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
	    return sf;
	}
	
	private SessionManager() {
		sf = createSessionFactory();
	}

}
