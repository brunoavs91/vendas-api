package com.bruno.vendasapi.service;

import java.util.List;

import com.bruno.vendasapi.dto.ProdutoBuscaDTO;
import com.bruno.vendasapi.dto.ProdutoDTO;
import com.bruno.vendasapi.model.Produto;

public interface ProdutoService {
	
	
	List<ProdutoBuscaDTO> buscarProdutoPorScore(String produto);

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
			
	Produto atualizar(ProdutoDTO dto);
	
	/**
	 * deletar produto por id
	 */
	void deletar(Long id);
	
	
}
