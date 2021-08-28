package com.projeto_pizzaria.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.projeto_pizzaria.model.model.Cliente;

public class ClienteDao {

	private EntityManager entityManager;
	
	public ClienteDao (EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void save(Cliente cliente) {
		this.getEntityManager().persist(cliente);
	}
	
	public void update(Cliente cliente) {
		this.getEntityManager().merge(cliente);
	}
	
	public void delete(Cliente cliente) {
		this.getEntityManager().remove(cliente);
	}
	
	public Cliente findById(Integer id) {
		return this.getEntityManager().find(Cliente.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> findall() {
		Query query = this.getEntityManager().createQuery("SELECT c FROM Cliente c");
		
		List<Cliente> listaCliente = query.getResultList();
		return listaCliente;
	}
}
