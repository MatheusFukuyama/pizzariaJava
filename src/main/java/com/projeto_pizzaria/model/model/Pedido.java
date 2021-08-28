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
public class Pedido {
	private Integer idPedido;
	private Double precoTotal;
	private String formaPagamanto;
	private Integer numPedido;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PEDIDO_ID")
	public Integer getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	
	@Column(name="PEDIDO_PRECO_TOTAL", nullable = false)
	public Double getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}
	
	@Column(name="FORMA_PAGAMENTO_PEDIDO", length = 40, nullable = false)
	public String getFormaPagamanto() {
		return formaPagamanto;
	}
	public void setFormaPagamanto(String formaPagamanto) {
		this.formaPagamanto = formaPagamanto;
	}
	
	@Column(name="NUMERO_PEDIDO", length = 40, nullable = false)
	public Integer getNumPedido() {
		return numPedido;
	}
	public void setNumPedido(Integer numPedido) {
		this.numPedido = numPedido;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idPedido);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(idPedido, other.idPedido);
	}
	
	
	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", precoTotal=" + precoTotal + ", formaPagamanto=" + formaPagamanto
				+ ", numPedido=" + numPedido + "]";
	}
	
}
