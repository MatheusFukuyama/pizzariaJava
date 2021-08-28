package com.projeto_pizzaria.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.projeto_pizzaria.model.model.Bebida;

public class BebidaDao {
	
	private EntityManager entityManager;
	
	public BebidaDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void save(Bebida bebida) {
		this.getEntityManager().persist(bebida);
	}
	
	public void update(Bebida bebida) {
		this.getEntityManager().merge(bebida);
	}
	
	public void delete(Bebida bebida) {
		this.getEntityManager().remove(bebida);
	}
	
	public Bebida findById(Integer id) {
		return this.getEntityManager().find(Bebida.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Bebida> findall() {
		Query query = this.getEntityManager().createQuery("SELECT b FROM Bebida b");
		
		List<Bebida> listaBebida = query.getResultList();
		return listaBebida;
		
	}
}
