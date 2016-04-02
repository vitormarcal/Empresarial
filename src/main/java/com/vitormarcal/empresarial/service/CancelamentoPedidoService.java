package com.vitormarcal.empresarial.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.vitormarcal.empresarial.model.Pedido;
import com.vitormarcal.empresarial.model.StatusPedido;
import com.vitormarcal.empresarial.repository.Pedidos;
import com.vitormarcal.empresarial.util.jpa.Transactional;

public class CancelamentoPedidoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pedidos pedidos;
	
	@Inject
	private EstoqueService estoqueService; 
	
	@Transactional
	public Pedido cancelar(Pedido pedido) {
		pedido = this.pedidos.porId(pedido.getId());
		
		
		if(pedido.isNaoCancelavel()){
			throw new NegocioException("pedido não pode ser cancelado no status "
					+ pedido.getStatus().getDescricao() + ".");
		}
		
		if(pedido.isEmitido()){
			this.estoqueService.retornarItensEstoque(pedido);
		}
		
		pedido.setStatus(StatusPedido.CANCELADO);
		pedido = this.pedidos.guardar(pedido);
		return pedido;
	}
	
}
