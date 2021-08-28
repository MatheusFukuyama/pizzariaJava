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
public class Bebida {
	private Integer idBebida;
	private String nome;
	private Double precoBebida;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BEBIDA_ID")
	public Integer getIdBebida() {
		return idBebida;
	}
	public void setIdBebida(Integer idBebida) {
		this.idBebida = idBebida;
	}
	
	@Column(name="BEBIDA_NOME", length = 80, nullable = false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	@Column(name="BEBIDA_PRECO", nullable = false)
	public Double getPrecoBebida() {
		return precoBebida;
	}
	public void setPrecoBebida(Double precoBebida) {
		this.precoBebida = precoBebida;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idBebida);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bebida other = (Bebida) obj;
		return Objects.equals(idBebida, other.idBebida);
	}
	
	
	@Override
	public String toString() {
		return "Bebida [idBebida=" + idBebida + ", nome=" + nome + ", precoBebida=" + precoBebida + "]";
	}
	
}
