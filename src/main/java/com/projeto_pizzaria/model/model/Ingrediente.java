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
public class Ingrediente {
	private Integer idIngrediente;
	private String nome;
	private Double precoIngrediente;
	private Boolean addIngrediente;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="INGREDIENTE_ID")
	public Integer getIdIngrediente() {
		return idIngrediente;
	}
	public void setIdIngrediente(Integer idIngrediente) {
		this.idIngrediente = idIngrediente;
	}
	
	@Column(name="INGREDIENTE_NOME", length = 80, nullable = false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name="INGREDIENTE_PRECO", nullable = false)
	public Double getPrecoIngrediente() {
		return precoIngrediente;
	}
	public void setPrecoIngrediente(Double precoIngrediente) {
		this.precoIngrediente = precoIngrediente;
	}
	
	@Column(name="INGREDIENTE_ADICIONAR", nullable = false)
	public Boolean getAddIngrediente() {
		return addIngrediente;
	}
	public void setAddIngrediente(Boolean addIngrediente) {
		this.addIngrediente = addIngrediente;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idIngrediente);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		return Objects.equals(idIngrediente, other.idIngrediente);
	}
	
	
	@Override
	public String toString() {
		return "Ingrediente [idIngrediente=" + idIngrediente + ", nome=" + nome + ", precoIngrediente="
				+ precoIngrediente + ", addIngrediente=" + addIngrediente + "]";
	}
	
}
