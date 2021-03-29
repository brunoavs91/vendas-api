package com.bruno.vendasapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.bruno.vendasapi.exception.ObjectNotFoundException;
import com.bruno.vendasapi.model.CategoriaProduto;
import com.bruno.vendasapi.repository.CategoriaProdutoRepository;
import com.bruno.vendasapi.service.CategoriaProdutoService;

public class CategoriaProdutoImpl implements CategoriaProdutoService {
	
	@Autowired
	private CategoriaProdutoRepository repository;

	@Override
	public CategoriaProduto buscarPorNome(String nome) {
		
		return repository.findByNome(nome)
				.orElseThrow(() -> new ObjectNotFoundException("Categoria nao encontrada"));
	}


}
