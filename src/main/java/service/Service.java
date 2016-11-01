package service;

import java.util.List;

public interface Service<E> {
	
	void createEntity(E entity) throws Exception;
	
	void modifyEntity(E entity) throws Exception;
	
	E getEntity(int id) throws Exception;
	
	E getEntity(String name) throws Exception;
	
	List<E> getEntities() throws Exception;
	
	void deleteEntity(E entity) throws Exception;
	
	//void copyEntity(E entity) throws Exception; //TODO Maybe implement this functionality?

}
