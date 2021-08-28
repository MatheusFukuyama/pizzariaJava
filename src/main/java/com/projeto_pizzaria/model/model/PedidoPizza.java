package com.projeto_pizzaria.model.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PedidoPizza {
	private Integer quantidade;
	private Integer idPedidoPizza;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PEDIDO_PIZZA_ID")
	public Integer getIdPedidoPizza() {
		return idPedidoPizza;
	}

	public void setIdPedidoPizza(Integer idPedidoPizza) {
		this.idPedidoPizza = idPedidoPizza;
	}
	
	@Column(name="PEDIDOPIZZA_QUANTIDADE", nullable = false)
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
