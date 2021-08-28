package com.projeto_pizzaria.model.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.projeto_pizzaria.model.model.PedidoBebida;
import com.projeto_pizzaria.model.repository.PedidoBebidaDao;
import com.projeto_pizzaria.persistencia.ConexaoBancoDados;

public class PedidoBebidaService {
	private static final String UNIT_NAME="projeto_pizzaria";
	
	@PersistenceContext(unitName=UNIT_NAME)
	private final EntityManager entityManager;
	
	private PedidoBebidaDao pedidoBebidaDao;
	
	public PedidoBebidaService() {
		this.entityManager = ConexaoBancoDados.getConexao().getEntityManager();
		pedidoBebidaDao = new PedidoBebidaDao(this.entityManager);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public PedidoBebida findPedidoBebidaById(Integer id) {
		return pedidoBebidaDao.findById(id);
	}
	
	public void save(PedidoBebida pedidoBebida) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			pedidoBebidaDao.save(pedidoBebida);
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
	
	public void update(PedidoBebida pedidoBebida) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			pedidoBebidaDao.update(pedidoBebida);
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

	public void delete(PedidoBebida pedidoBebida) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			pedidoBebidaDao.delete(pedidoBebida);
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
