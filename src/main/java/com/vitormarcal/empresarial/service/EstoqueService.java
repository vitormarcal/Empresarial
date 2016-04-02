package com.vitormarcal.empresarial.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.Transient;

import com.vitormarcal.empresarial.model.ItemPedido;
import com.vitormarcal.empresarial.model.Pedido;
import com.vitormarcal.empresarial.repository.Pedidos;
import com.vitormarcal.empresarial.util.jpa.Transactional;

public class EstoqueService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pedidos pedidos;
	
	@Transactional
	public void baixarItensEstoque(Pedido pedido) {
			pedido = this.pedidos.porId(pedido.getId());
			
			for(ItemPedido item : pedido.getItens()){
				item.getProduto().baixarEstoque(item.getQuantidade());
			}
	}

	@Transient
	public void retornarItensEstoque(Pedido pedido) {
		pedido = this.pedidos.porId(pedido.getId());
		
		for( ItemPedido item : pedido.getItens()){
			item.getProduto().adicionarEstoque(item.getQuantidade());
		}
	}

}
