package db;

import java.util.List;

public interface Access<E> {
	
	void create(E entity);
	
	E retrieveById(int id);
	
	List<E> retrieveByName(String name);
	
	List<E> retrieveAll();
	
	void update(E entity);
	
	void delete(E entity);

}
