package service;

import java.util.List;

import org.hibernate.Session;

import db.Access;
import db.ContractAccess;
import model.Contract;

public class ContractService implements Service<Contract> {
	private Session session;
	private Access<Contract> con_access;
	
	public ContractService(Session session) {
		this.session = session;
		con_access = new ContractAccess(this.session);
	}

	@Override
	public void createEntity(Contract entity) throws Exception {
		con_access.create(entity);
		
	}

	@Override
	public void modifyEntity(Contract entity) throws Exception {
		con_access.update(entity);
	}

	@Override
	public Contract getEntity(int id) throws Exception {
		Contract contract = null;
		contract = con_access.retrieveById(id);
		return contract;
	}

	@Override
	public Contract getEntity(String name) throws Exception {
		Contract contract = null;
		List<Contract> contracts = con_access.retrieveByName(name);
		if(!contracts.isEmpty()) {
			contract = contracts.get(0);
		}
		return contract;
	}

	@Override
	public List<Contract> getEntities() throws Exception {
		List<Contract> contracts = null;
		contracts = con_access.retrieveAll();
		return contracts;
	}

	@Override
	public void deleteEntity(Contract entity) throws Exception {
		con_access.delete(entity);
	}

}
