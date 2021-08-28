package com.projeto_pizzaria.model.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.projeto_pizzaria.persistencia.ConexaoBancoDados;
import com.projeto_pizzaria.model.model.Bebida;
import com.projeto_pizzaria.model.repository.BebidaDao;

public class BebidaService {
	private static final String UNIT_NAME = "projeto_pizzaria";
	
	@PersistenceContext(unitName=UNIT_NAME)
	private final EntityManager entityManager;

	private BebidaDao bebidaDao;
	
	public BebidaService() {
		this.entityManager = ConexaoBancoDados.getConexao().getEntityManager();
		bebidaDao = new BebidaDao(this.entityManager);
	}
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public Bebida findBebidaById(Integer id) {
		return bebidaDao.findById(id);
	}
	
	public void save(Bebida bebida) {
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			bebidaDao.save(bebida);
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
	
	public void update(Bebida bebida) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			bebidaDao.update(bebida);
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
	
	public void delete(Bebida bebida) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			bebidaDao.delete(bebida);
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
