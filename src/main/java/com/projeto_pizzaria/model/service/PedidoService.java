package com.projeto_pizzaria.model.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.projeto_pizzaria.model.model.Pedido;
import com.projeto_pizzaria.model.repository.PedidoDao;
import com.projeto_pizzaria.persistencia.ConexaoBancoDados;

public class PedidoService {
	private static final String UNIT_NAME="projeto_pizzaria";
	
	@PersistenceContext(unitName=UNIT_NAME)
	private final EntityManager entityManager;
	
	private PedidoDao pedidoDao;
	
	public PedidoService() {
		this.entityManager = ConexaoBancoDados.getConexao().getEntityManager();
		pedidoDao = new PedidoDao(this.entityManager);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public Pedido findPedidoById(Integer id) {
		return pedidoDao.findById(id);
	}
	
	public void save(Pedido pedido) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			pedidoDao.save(pedido);
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
	
	public void update(Pedido pedido) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			pedidoDao.update(pedido);
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

	public void delete(Pedido pedido) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			pedidoDao.delete(pedido);
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
