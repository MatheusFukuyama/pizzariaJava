package com.projeto_pizzaria.model.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PedidoBebida {
	private Integer quantidade;
	private Integer idPedidoBebida;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PEDIDO_BEBIDA_ID")
	public Integer getIdPedidoBebida() {
		return idPedidoBebida;
	}

	public void setIdPedidoBebida(Integer idPedidoBebida) {
		this.idPedidoBebida = idPedidoBebida;
	}
	
	@Column(name="PEDIDOBEBIDA_QUANTIDADE", nullable = false)
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
