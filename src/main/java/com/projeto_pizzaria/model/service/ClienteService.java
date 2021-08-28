package com.projeto_pizzaria.model.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.projeto_pizzaria.model.model.Cliente;
import com.projeto_pizzaria.model.repository.ClienteDao;
import com.projeto_pizzaria.persistencia.ConexaoBancoDados;

public class ClienteService {
	private static final String UNIT_NAME="projeto_pizzaria";
			
	@PersistenceContext(unitName=UNIT_NAME)
	private final EntityManager entityManager;
	
	private ClienteDao clienteDao;
	
	public ClienteService() {
		this.entityManager = ConexaoBancoDados.getConexao().getEntityManager();
		clienteDao = new ClienteDao(this.entityManager);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void testeDeExecucao() {
		System.out.println("chamada da tela cliente >>>>>>>>>>>>>>>>>");
	}
	
	public Cliente findClienteById(Integer id) {
		return clienteDao.findById(id);
	}
	
	public void save(Cliente cliente) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			clienteDao.save(cliente);
			trx.commit();
		} catch(Throwable t) {
			t.printStackTrace();
			if(trx.isActive())
				trx.rollback();
		} finally {
			if (this.getEntityManager().isOpen()) {
				this.getEntityManager().close();
			}
		}
	}
	
	public void update(Cliente cliente) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			clienteDao.update(cliente);
			trx.commit();
		} catch(Throwable t) {
			t.printStackTrace();
			if(trx.isActive())
				trx.rollback();
		} finally {
			if (this.getEntityManager().isOpen()) {
				this.getEntityManager().close();
			}
		}
	}

	public void delete(Cliente cliente) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			clienteDao.delete(cliente);
			trx.commit();
		} catch(Throwable t) {
			t.printStackTrace();
			if(trx.isActive())
				trx.rollback();
		} finally {
			if (this.getEntityManager().isOpen()) {
				this.getEntityManager().close();
			}
		}
	}
	
	
	
}
