package db;

import java.util.List;

import org.hibernate.Session;

import model.LawnArea;

public class LawnAreaAccess implements Access<LawnArea> {
	private Session session;
	
	public LawnAreaAccess(Session session) {
		this.session = session;
	}
	
	public void create(LawnArea la) {
		session.save(la);
	}
	
	public LawnArea retrieveById(int id) {
		LawnArea la = (LawnArea) session.get(LawnArea.class, id);
		return la;
	}
	
	public List<LawnArea> retrieveByName(String name) {
		@SuppressWarnings("unchecked")
		List<LawnArea> las = session.createQuery("from LawnArea la where la.name='"+name+"'").list();
		return las;
	}
	
	public List<LawnArea> retrieveAll() {
		@SuppressWarnings("unchecked")
		List<LawnArea> las = session.createQuery("from LawnArea").list();
		return las;
	}
	
	public void update(LawnArea la) {
		session.merge(la);
	}
	
	public void delete(LawnArea la) {
		session.delete(la);
	}

}
