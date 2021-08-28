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
public class Funcionario {
	private Integer idFuncionario;
	private String nome;
	private String rua;
	private Integer numCasa;
	private String bairro;
	private String telefone;
	private String cargo;
	private Double salario;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="FUNCIONARIO_ID")
	public Integer getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
	@Column(name="FUNCIONARIO_NOME", length = 80, nullable = false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name="FUNCIONARIO_RUA", length = 80, nullable = false)
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	@Column(name="FUNCIONARIO_NUM_CASA", nullable = false)
	public Integer getNumCasaFuncionario() {
		return numCasa;
	}
	public void setNumCasaFuncionario(Integer numCasaFuncionario) {
		this.numCasa = numCasaFuncionario;
	}
	
	@Column(name="FUNCIONARIO_BAIRRO", length = 40, nullable = false)
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
	@Column(name="FUNCIONARIO_TELEFONE_CELULAR", length = 20, nullable = false)
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Column(name="FUNCIONARIO_CARGO", length = 80, nullable = false)
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	@Column(name="FUNCIONARIO_SALARIO", nullable = false)
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idFuncionario);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(idFuncionario, other.idFuncionario);
	}

	
	@Override
	public String toString() {
		return "Funcionario [idFuncionario=" + idFuncionario + ", nome=" + nome + ", rua=" + rua
				+ ", numCasa=" + numCasa + ", bairro=" + bairro + ", telefone=" + telefone
				+ ", cargo=" + cargo + ", salario=" + salario + "]";
	}
	
}
