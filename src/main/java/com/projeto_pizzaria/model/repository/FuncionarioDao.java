package com.projeto_pizzaria.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.projeto_pizzaria.model.model.Funcionario;

public class FuncionarioDao {
	
	private EntityManager entityManager;
	
	public FuncionarioDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void save(Funcionario funcionario) {
		this.getEntityManager().persist(funcionario);
	}
	
	public void update(Funcionario funcionario) {
		this.getEntityManager().merge(funcionario);
	}
	
	public void delete(Funcionario funcionario) {
		this.getEntityManager().remove(funcionario);
	}
	
	public Funcionario findById(Integer id) {
		return this.getEntityManager().find(Funcionario.class, id);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> findall() {
		Query query = this.getEntityManager().createQuery("SELECT f FROM Funcionario f");
		
		List<Funcionario> listaFuncionario = query.getResultList();
		return listaFuncionario;
	}
}
