package com.projeto_pizzaria.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.projeto_pizzaria.model.model.PedidoPizza;

public class PedidoPizzaDao {
	private EntityManager entityManager;
	
	public PedidoPizzaDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void save(PedidoPizza pedidoPizza) {
		this.getEntityManager().persist(pedidoPizza);
	}
	
	public void update(PedidoPizza pedidoPizza) {
		this.getEntityManager().merge(pedidoPizza);
	}
	
	public void delete(PedidoPizza pedidoPizza) {
		this.getEntityManager().remove(pedidoPizza);
	}
	
	public PedidoPizza findById(Integer id) {
		return this.getEntityManager().find(PedidoPizza.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<PedidoPizza> findall(){
		Query query = this.getEntityManager().createQuery("SELECT p FROM Ingrediente p");
		
		List<PedidoPizza> listaPedidoPizza = query.getResultList();
		return listaPedidoPizza;
	}
}
