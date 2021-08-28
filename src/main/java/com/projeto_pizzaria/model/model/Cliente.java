package com.projeto_pizzaria.model.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Cliente {
	private Integer idCliente;
	private String nome;
	private String rua;
	private Integer numCasa;
	private String bairro;
	private String telefone;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CLIENTE_ID")
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	@Column(name="CLIENTE_NOME", length = 80, nullable = false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name="CLIENTE_NUM_CASA", nullable = false)
	public Integer getNumCasaCliente() {
		return numCasa;
	}
	public void setNumCasaCliente(Integer numCasaCliente) {
		this.numCasa = numCasaCliente;
	}
	
	@Column(name="CLIENTE_BAIRRO", length = 40, nullable = false)
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	@Column(name="CLIENTE_TELEFONE_CELULAR", length = 20, nullable = false)
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Column(name="CLIENTE_RUA", length = 80, nullable = false)
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idCliente);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(idCliente, other.idCliente);
	}
	
	
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", rua=" + rua + ", numCasa="
				+ numCasa + ", bairro=" + bairro + ", telefone=" + telefone + "]";
	}
	
}
