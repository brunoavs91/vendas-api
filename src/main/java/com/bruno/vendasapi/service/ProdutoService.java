package com.bruno.vendasapi.service;

import java.util.List;

import com.bruno.vendasapi.dto.ProdutoDTO;
import com.bruno.vendasapi.model.Produto;

public interface ProdutoService {

	/**
	 * Buscar produtos por id
	 * @return
	 */
	Produto buscar(Long id);
	
	/**
	 * Buscar todos Produtos
	 * @return
	 */
	List<Produto> buscarTodos();
	
	
	/**
	 * Salvar produto
	 * @param dto
	 */
	Produto salvar(ProdutoDTO dto);
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
			
	Produto atualizar(Produto produto);
	
	/**
	 * deletar produto por id
	 */
	void deletar(Produto produto);
}
