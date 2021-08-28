package com.projeto_pizzaria.model.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.projeto_pizzaria.model.model.Pizza;
import com.projeto_pizzaria.model.repository.PizzaDao;
import com.projeto_pizzaria.persistencia.ConexaoBancoDados;

public class PizzaService {
	private static final String UNIT_NAME="projeto_pizzaria";
	
	@PersistenceContext(unitName=UNIT_NAME)
	private final EntityManager entityManager;
	
	private PizzaDao pizzaDao;
	
	public PizzaService() {
		this.entityManager = ConexaoBancoDados.getConexao().getEntityManager();
		pizzaDao = new PizzaDao(this.entityManager);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public Pizza findPizzaById(Integer id) {
		return pizzaDao.findById(id); 
	}
	
	public void save(Pizza pizza) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			pizzaDao.save(pizza);
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
	
	public void update(Pizza pizza) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			pizzaDao.update(pizza);
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

	public void delete(Pizza pizza) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			pizzaDao.delete(pizza);
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
