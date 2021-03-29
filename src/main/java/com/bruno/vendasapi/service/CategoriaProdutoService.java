package com.bruno.vendasapi.service;

import com.bruno.vendasapi.model.CategoriaProduto;

public interface CategoriaProdutoService {

	/**
	 * Buscar categoria por nome
	 * @param nome
	 * @return
	 */
	CategoriaProduto buscarPorNome(String nome);
}
