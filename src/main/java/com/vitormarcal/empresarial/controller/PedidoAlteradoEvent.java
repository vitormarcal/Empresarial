package com.vitormarcal.empresarial.controller;

import com.vitormarcal.empresarial.model.Pedido;

public class PedidoAlteradoEvent {
	
	private Pedido pedido;

	public PedidoAlteradoEvent(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
}
