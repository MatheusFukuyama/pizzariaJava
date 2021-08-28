package com.projeto_pizzaria.model.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.projeto_pizzaria.model.model.Tamanho;
import com.projeto_pizzaria.model.repository.TamanhoDao;
import com.projeto_pizzaria.persistencia.ConexaoBancoDados;

public class TamanhoService {
	private static final String UNIT_NAME="projeto_pizzaria";
	
	@PersistenceContext(unitName=UNIT_NAME)
	private final EntityManager entityManager;
	
	private TamanhoDao tamanhoDao;
	
	public TamanhoService() {
		this.entityManager = ConexaoBancoDados.getConexao().getEntityManager();
		tamanhoDao = new TamanhoDao(this.entityManager);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public Tamanho findTamanhoById(Integer id) {
		return tamanhoDao.findById(id);
	}
	
	public void save(Tamanho tamanho) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			tamanhoDao.save(tamanho);
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
	
	public void update(Tamanho tamanho) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			tamanhoDao.update(tamanho);
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

	public void delete(Tamanho tamanho) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			tamanhoDao.delete(tamanho);
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
