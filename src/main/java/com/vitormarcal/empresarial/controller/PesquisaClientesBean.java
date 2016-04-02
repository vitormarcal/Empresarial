package com.vitormarcal.empresarial.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.vitormarcal.empresarial.model.Cliente;
import com.vitormarcal.empresarial.repository.Clientes;
import com.vitormarcal.empresarial.repository.filter.ClienteFilter;
import com.vitormarcal.empresarial.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaClientesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Clientes clientes;
	
	private ClienteFilter filtro;
	private List<Cliente> clientesFiltrados;
	private Cliente clienteSelecionado;
	
	public PesquisaClientesBean() {
		filtro = new ClienteFilter();
	}
	public void excluir(){
		clientes.remover(clienteSelecionado);
		clientesFiltrados.remove(clienteSelecionado);
		
		FacesUtil.addInfoMessage("Cliente " + clienteSelecionado.getId() + " excluído com sucesso.");
	}
	public void pesquisar(){
		clientesFiltrados = clientes.filtrados(filtro);
	}
	
	public List<Cliente> getClientesFiltrados() {
		return clientesFiltrados;
	}
	
	public ClienteFilter getFiltro() {
		return filtro;
	}
	
	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}
	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}
}
