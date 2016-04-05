package com.vitormarcal.empresarial.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.vitormarcal.empresarial.model.Cliente;
import com.vitormarcal.empresarial.repository.Clientes;
import com.vitormarcal.empresarial.util.jpa.Transactional;

public class CadastroClienteService  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Clientes clientes;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		Cliente clienteExistente = clientes.porDocumentoReceitaFederal(cliente.getDocumentoReceitaFederal()); 
		
		if(clienteExistente != null && !clienteExistente.equals(cliente)){
			throw new NegocioException("Já existe um cliente com o Documento da Receita informado. ");
		}
		return clientes.guardar(cliente);
	}

}
