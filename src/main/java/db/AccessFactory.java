package db;

public class AccessFactory {
	
	private static volatile AccessFactory instance;
	
	public static AccessFactory getInstance() {
		if(instance == null) {
			synchronized(AccessFactory.class) {
				if(instance == null) {
					instance = new AccessFactory();
				}
			}
		}
		return instance;
	}
	
	private AccessFactory() {
		
	}
	
	

}
