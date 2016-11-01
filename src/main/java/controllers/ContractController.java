package controllers;

import java.util.List;

import org.hibernate.Session;

import db.SessionManager;
import model.Contract;
import service.ContractService;
import service.Service;

public class ContractController {
	
	public ContractController() {
		
	}
	
	public void createContract(Contract contract) {
		Session session = SessionManager.getInstance().getSession();
		try {
			session.beginTransaction();
			Service<Contract> con_service = new ContractService(session);
			con_service.createEntity(contract);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void modifyContract(Contract contract) {
		Session session = SessionManager.getInstance().getSession();
		try {
			session.beginTransaction();
			Service<Contract> con_service = new ContractService(session);
			con_service.modifyEntity(contract);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public Contract getContractById(int id) {
		Contract contract = null;
		Session session = SessionManager.getInstance().getSession();
		try {
			session.beginTransaction();
			Service<Contract> con_service = new ContractService(session);
			contract = con_service.getEntity(id);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return contract;
	}
	
	public Contract getContractByName(String name) {
		Contract contract = null;
		Session session = SessionManager.getInstance().getSession();
		try {
			session.beginTransaction();
			Service<Contract> con_service = new ContractService(session);
			contract = con_service.getEntity(name);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return contract;
	}
	
	public List<Contract> getContracts() {
		List<Contract> contracts = null;
		Session session = SessionManager.getInstance().getSession();
		try {
			session.beginTransaction();
			Service<Contract> con_service = new ContractService(session);
			contracts = con_service.getEntities();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return contracts;
	}
	
	public void deleteContract(Contract contract) {
		Session session = SessionManager.getInstance().getSession();
		try {
			session.beginTransaction();
			Service<Contract> con_service = new ContractService(session);
			con_service.deleteEntity(contract);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
