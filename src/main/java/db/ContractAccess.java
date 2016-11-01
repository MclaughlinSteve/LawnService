package db;

import java.util.List;

import org.hibernate.Session;

import model.Contract;

public class ContractAccess implements Access<Contract> {
	private Session session;
	
	public ContractAccess(Session session) {
		this.session = session;
	}

	@Override
	public void create(Contract contract) {
		session.save(contract);
		
	}

	@Override
	public Contract retrieveById(int id) {
		Contract contract = (Contract) session.get(Contract.class, id);
		return contract;
	}

	@Override
	public List<Contract> retrieveByName(String name) {
		@SuppressWarnings("unchecked")
		List<Contract> contracts = session.createQuery("from Contract contract where contract.name='"+name+"'").list();
		return contracts;
	}

	@Override
	public List<Contract> retrieveAll() {
		@SuppressWarnings("unchecked")
		List<Contract> contracts = session.createQuery("from Contract").list();
		return contracts;
	}

	@Override
	public void update(Contract contract) {
		session.merge(contract);
	}

	@Override
	public void delete(Contract contract) {
		session.delete(contract);
	}

}
