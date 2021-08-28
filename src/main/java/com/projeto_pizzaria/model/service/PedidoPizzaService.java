package com.projeto_pizzaria.model.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.projeto_pizzaria.model.model.PedidoPizza;
import com.projeto_pizzaria.model.repository.PedidoPizzaDao;
import com.projeto_pizzaria.persistencia.ConexaoBancoDados;

public class PedidoPizzaService {
	private static final String UNIT_NAME="projeto_pizzaria";
	
	@PersistenceContext(unitName=UNIT_NAME)
	private final EntityManager entityManager;
	
	private PedidoPizzaDao pedidoPizzaDao;
	
	public PedidoPizzaService() {
		this.entityManager = ConexaoBancoDados.getConexao().getEntityManager();
		pedidoPizzaDao = new PedidoPizzaDao(this.entityManager);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	
	public PedidoPizza findPedidoPizzaById(Integer id) {
		return pedidoPizzaDao.findById(id);
	}
	
	
	public void save(PedidoPizza pedidoPizza) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			pedidoPizzaDao.save(pedidoPizza);
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
	
	public void update(PedidoPizza pedidoPizza) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			pedidoPizzaDao.update(pedidoPizza);
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

	public void delete(PedidoPizza pedidoPizza) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			pedidoPizzaDao.delete(pedidoPizza);
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
