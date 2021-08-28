package com.projeto_pizzaria.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.projeto_pizzaria.model.model.Pedido;

public class PedidoDao {
	
	private EntityManager entityManager;
	
	public PedidoDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void save(Pedido pedido) {
		this.getEntityManager().persist(pedido);
	}
	
	public void update(Pedido pedido) {
		this.getEntityManager().merge(pedido);
	}
	
	public void delete(Pedido pedido) {
		this.getEntityManager().remove(pedido);
	}
	
	public Pedido findById(Integer id) {
		return this.getEntityManager().find(Pedido.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> findall(){
		Query query = this.getEntityManager().createQuery("SELECT p FROM Ingrediente p");
		
		List<Pedido> listaPedido = query.getResultList();
		return listaPedido;
	}
}

