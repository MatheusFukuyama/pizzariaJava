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
public class Pizza {
	private Integer idPizza;
	private String sabor;
	private Double precoSabor;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PIZZA_ID")
	public Integer getIdPizza() {
		return idPizza;
	}
	public void setIdPizza(Integer idPizza) {
		this.idPizza = idPizza;
	}
	
	@Column(name="PIZZA_SABOR_NOME", length = 80, nullable = false)
	public String getSabor() {
		return sabor;
	}
	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	
	@Column(name="PIZZA_SABOR_PRECO", nullable = false)
	public Double getPrecoSabor() {
		return precoSabor;
	}
	public void setPrecoSabor(Double precoSabor) {
		this.precoSabor = precoSabor;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idPizza);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		return Objects.equals(idPizza, other.idPizza);
	}
	
	
	@Override
	public String toString() {
		return "Pizza [idPizza=" + idPizza + ", sabor=" + sabor + ", precoSabor=" + precoSabor + "]";
	}
	
}
