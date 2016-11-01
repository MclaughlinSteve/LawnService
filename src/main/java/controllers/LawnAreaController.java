package controllers;

import java.util.List;

import org.hibernate.Session;

import db.SessionManager;
import model.LawnArea;
import service.LawnAreaService;
import service.Service;

public class LawnAreaController {
	
	public LawnAreaController() {
		
	}
	
	public void createLawnArea(LawnArea la) {
		Session session = SessionManager.getInstance().getSession();
		try {
			session.beginTransaction();
			Service<LawnArea> la_service = new LawnAreaService(session);
			la_service.createEntity(la);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void modifyLawnArea(LawnArea la) {
		Session session = SessionManager.getInstance().getSession();
		try {
			session.beginTransaction();
			Service<LawnArea> la_service = new LawnAreaService(session);
			la_service.modifyEntity(la);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public LawnArea getLawnAreaById(int id) {
		LawnArea la = null;
		Session session = SessionManager.getInstance().getSession();
		try {
			session.beginTransaction();
			Service<LawnArea> la_service = new LawnAreaService(session);
			la = la_service.getEntity(id);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return la;
	}
	
	public List<LawnArea> getLawnAreas() {
		List<LawnArea> las = null;
		Session session = SessionManager.getInstance().getSession();
		try {
			session.beginTransaction();
			Service<LawnArea> la_service = new LawnAreaService(session);
			las = la_service.getEntities();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return las;
	}
	
	public LawnArea getLawnAreaByName(String name) {
		LawnArea la = null;
		Session session = SessionManager.getInstance().getSession();
		try {
			session.beginTransaction();
			Service<LawnArea> la_service = new LawnAreaService(session);
			la = la_service.getEntity(name);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return la;
	}
	
	public void deleteLawnArea(LawnArea la) {
		Session session = SessionManager.getInstance().getSession();
		try {
			session.beginTransaction();
			Service<LawnArea> la_service = new LawnAreaService(session);
			la_service.deleteEntity(la);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
