package com.projeto_pizzaria.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.projeto_pizzaria.model.model.PedidoBebida;

public class PedidoBebidaDao {
private EntityManager entityManager;
	
	public PedidoBebidaDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void save(PedidoBebida pedidoBebida) {
		this.getEntityManager().persist(pedidoBebida);
	}
	
	public void update(PedidoBebida pedidoBebida) {
		this.getEntityManager().merge(pedidoBebida);
	}
	
	public void delete(PedidoBebida pedidoBebida) {
		this.getEntityManager().remove(pedidoBebida);
	}
	
	public PedidoBebida findById(Integer id) {
		return this.getEntityManager().find(PedidoBebida.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<PedidoBebida> findall(){
		Query query = this.getEntityManager().createQuery("SELECT pb FROM Ingrediente pb");
		
		List<PedidoBebida> listaPedidoBebida = query.getResultList();
		return listaPedidoBebida;
	}

}
