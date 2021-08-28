package com.projeto_pizzaria.model.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.projeto_pizzaria.model.model.Ingrediente;
import com.projeto_pizzaria.model.repository.IngredienteDao;
import com.projeto_pizzaria.persistencia.ConexaoBancoDados;

public class IngredienteService {
	private static final String UNIT_NAME="projeto_pizzaria";
	
	@PersistenceContext(unitName=UNIT_NAME)
	private final EntityManager entityManager;
	
	private IngredienteDao ingredienteDao;
	
	public IngredienteService() {
		this.entityManager = ConexaoBancoDados.getConexao().getEntityManager();
		ingredienteDao = new IngredienteDao(this.entityManager);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public Ingrediente findIngredienteById(Integer id) {
		return ingredienteDao.findById(id);
	}
	
	public void save(Ingrediente ingrediente) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			ingredienteDao.save(ingrediente);
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
	
	public void update(Ingrediente ingrediente) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			ingredienteDao.update(ingrediente);
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

	public void delete(Ingrediente ingrediente) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			ingredienteDao.delete(ingrediente);
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
 