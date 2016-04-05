package com.vitormarcal.empresarial.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.vitormarcal.empresarial.model.Cliente;
import com.vitormarcal.empresarial.model.TipoPessoa;
import com.vitormarcal.empresarial.service.CadastroClienteService;
import com.vitormarcal.empresarial.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroClienteService cadastroClienteService;
	


	private Cliente cliente;

	public CadastroClienteBean() {
		limpar();

	}

	private void limpar() {
		cliente = new Cliente();
	}

	public void salvar() {
		this.cliente = cadastroClienteService.salvar(this.cliente);
		limpar();

		FacesUtil.addInfoMessage("Cliente salvo com sucesso!");
	}

	public boolean isEditando() {
		return cliente.getId() != null;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoPessoa[] getTipoPessoa() {
		return TipoPessoa.values();
	}

	public Cliente getCliente() {
		return cliente;
	}

}
