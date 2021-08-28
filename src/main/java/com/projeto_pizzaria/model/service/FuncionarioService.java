package com.projeto_pizzaria.model.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.projeto_pizzaria.model.model.Funcionario;
import com.projeto_pizzaria.model.repository.FuncionarioDao;
import com.projeto_pizzaria.persistencia.ConexaoBancoDados;

public class FuncionarioService {
	private static final String UNIT_NAME="projeto_pizzaria";
	
	@PersistenceContext(unitName=UNIT_NAME)
	private final EntityManager entityManager;
	
	private FuncionarioDao funcionarioDao;
	
	public FuncionarioService() {
		this.entityManager = ConexaoBancoDados.getConexao().getEntityManager();
		funcionarioDao = new FuncionarioDao(this.entityManager);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	
	public Funcionario findFuncionarioById(Integer id) {
		return funcionarioDao.findById(id);
	}
	
	public void save(Funcionario funcionario) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			funcionarioDao.save(funcionario);
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
	
	public void update(Funcionario funcionario) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			funcionarioDao.update(funcionario);
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

	public void delete(Funcionario funcionario) {
		
		EntityTransaction trx = this.getEntityManager().getTransaction();
		try {
			trx.begin();
			funcionarioDao.delete(funcionario);
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
