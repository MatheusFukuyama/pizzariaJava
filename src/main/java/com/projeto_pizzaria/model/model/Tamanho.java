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
public class Tamanho {
	private Integer idTamanho;
	private String tamanho;
	private Double precoTamanho;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TAMANHO_ID")
	public Integer getIdTamanho() {
		return idTamanho;
	}
	public void setIdTamanho(Integer idTamanho) {
		this.idTamanho = idTamanho;
	}
	
	@Column(name="TAMANHO_NOME", length = 80, nullable = false)
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	@Column(name="PIZZA_PRECO", nullable = false)
	public Double getPrecoTamanho() {
		return precoTamanho;
	}
	public void setPrecoTamanho(Double precoTamanho) {
		this.precoTamanho = precoTamanho;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idTamanho);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tamanho other = (Tamanho) obj;
		return Objects.equals(idTamanho, other.idTamanho);
	}
	
	
	@Override
	public String toString() {
		return "Tamanho [idTamanho=" + idTamanho + ", tamanho=" + tamanho + ", precoTamanho=" + precoTamanho + "]";
	}
		 
}
