package com.projeto_pizzaria.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.projeto_pizzaria.model.model.Ingrediente;

public class IngredienteDao {
	
	private EntityManager entityManager;
	
	public IngredienteDao (EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void save(Ingrediente ingrediente) {
		this.getEntityManager().persist(ingrediente);
	}
	
	public void update(Ingrediente ingrediente) {
		this.getEntityManager().merge(ingrediente);
	}
	
	public void delete(Ingrediente ingrediente) {
		this.getEntityManager().remove(ingrediente);
	}
	
	public Ingrediente findById(Integer id) {
		return this.getEntityManager().find(Ingrediente.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Ingrediente> findall(){
		Query query = this.getEntityManager().createQuery("SELECT i FROM Ingrediente i");
		
		List<Ingrediente> listaIngrediente = query.getResultList();
		return listaIngrediente;
	}
}
