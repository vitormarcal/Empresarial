package com.vitormarcal.empresarial.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.vitormarcal.empresarial.model.Produto;
import com.vitormarcal.empresarial.repository.Produtos;
import com.vitormarcal.empresarial.util.jpa.Transactional;

public class CadastroProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Produtos produtos;
	
	@Transactional
	public Produto salvar(Produto produto) {
		Produto produtoExistente = produtos.porSku(produto.getSku());
		
		if (produtoExistente != null && !produtoExistente.equals(produto)) {
			throw new NegocioException("Já existe um produto com o SKU informado.");
		}
		
		return produtos.guardar(produto);
	}
	
}
