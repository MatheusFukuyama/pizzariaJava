package com.projeto_pizzaria.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.projeto_pizzaria.model.model.Tamanho;

public class TamanhoDao {
private EntityManager entityManager;
	
	public TamanhoDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void save(Tamanho tamanho) {
		this.getEntityManager().persist(tamanho);
	}
	
	public void update(Tamanho tamanho) {
		this.getEntityManager().merge(tamanho);
	}
	
	public void delete(Tamanho tamanho) {
		this.getEntityManager().remove(tamanho);
	}
	
	public Tamanho findById(Integer id) {
		return this.getEntityManager().find(Tamanho.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Tamanho> findall(){
		Query query = this.getEntityManager().createQuery("SELECT p FROM Ingrediente p");
		
		List<Tamanho> listaTamanho = query.getResultList();
		return listaTamanho;
	}
}
