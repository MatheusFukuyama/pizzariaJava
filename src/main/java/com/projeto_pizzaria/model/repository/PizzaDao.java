package com.projeto_pizzaria.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.projeto_pizzaria.model.model.Pizza;

public class PizzaDao {
private EntityManager entityManager;
	
	public PizzaDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void save(Pizza pizza) {
		this.getEntityManager().persist(pizza);
	}
	
	public void update(Pizza pizza) {
		this.getEntityManager().merge(pizza);
	}
	
	public void delete(Pizza pizza) {
		this.getEntityManager().remove(pizza);
	}
	
	public Pizza findById(Integer id) {
		return this.getEntityManager().find(Pizza.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Pizza> findall(){
		Query query = this.getEntityManager().createQuery("SELECT pi FROM Ingrediente pi");
		
		List<Pizza> listaPizza = query.getResultList();
		return listaPizza;
	}
}
