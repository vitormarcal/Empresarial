package com.vitormarcal.empresarial.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.vitormarcal.empresarial.model.Pedido;
import com.vitormarcal.empresarial.model.StatusPedido;
import com.vitormarcal.empresarial.repository.Pedidos;
import com.vitormarcal.empresarial.util.jpa.Transactional;

public class EmissaoPedidoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroPedidoService cadastroPedidoService;
	
	@Inject
	private Pedidos pedidos;
	
	@Inject
	EstoqueService estoqueService;
	
	@Transactional
	public Pedido emitir(Pedido pedido) {
		pedido = this.cadastroPedidoService.salvar(pedido);
		 
		if(pedido.isNaoEmissivel()){
			throw new NegocioException("Pedido não pode ser emitido com status "
					+ pedido.getStatus().getDescricao() + ".");
		}
		
		this.estoqueService.baixarItensEstoque(pedido);
		
		pedido.setStatus(StatusPedido.EMITIDO);
		
		pedido = this.pedidos.guardar(pedido);
		
		return pedido;
	}

}
