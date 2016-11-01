package service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import db.Access;
import db.LawnAreaAccess;
import model.Contract;
import model.LawnArea;

public class LawnAreaService implements Service<LawnArea> {
	private Session session;
	private Access<LawnArea> la_access;
	
	public LawnAreaService(Session session) {
		this.session = session;
		la_access = new LawnAreaAccess(this.session);
	}

	@Override
	public void createEntity(LawnArea entity) throws Exception {
		verifyParameters(entity);
		la_access.create(entity);
		
	}

	@Override
	public void modifyEntity(LawnArea entity) throws Exception {
		verifyParameters(entity);
		la_access.update(entity);
	}

	@Override
	public LawnArea getEntity(int id) {
		LawnArea la = null;
		la = la_access.retrieveById(id);
		return la;
	}

	@Override
	public LawnArea getEntity(String name) {
		LawnArea la = null;
		List<LawnArea> las = la_access.retrieveByName(name);
		if(!las.isEmpty()) {
			la = las.get(0);
		}
		return la;
	}

	@Override
	public List<LawnArea> getEntities() {
		List<LawnArea> las = null;
		las = la_access.retrieveAll();
		return las;
	}

	@Override
	public void deleteEntity(LawnArea entity) throws Exception {
		Set<Contract> contracts = new HashSet<>(entity.getContracts()); //Get any contracts that use this lawnarea
		la_access.delete(entity);
		Service<Contract> con_service = new ContractService(session);
		for(Contract contract: contracts) {
			session.flush(); //Clear the cache to make sure you're seeing any updates to the object
			contract = con_service.getEntity(contract.getId()); //Get the updated object from the db
			if(contract.getLawns().isEmpty()) {
				con_service.deleteEntity(contract);
			}
		}
	}
	
	/**
	 * These checks likely would be enforced by a GUI, but whatever.. it's an example
	 * @param la
	 * @throws Exception
	 */
	private void verifyParameters(LawnArea la) throws Exception {
		if(la.getPosition() != null) {
			if(la.getPosition().getLatitude() < 0.0 
					|| la.getPosition().getLatitude() > 90.0
					|| la.getPosition().getLongitude() < 0.0
					|| la.getPosition().getLongitude() > 180.0) {
				throw new Exception("Position parameters out of bounds");
			}
		}
	}

}
