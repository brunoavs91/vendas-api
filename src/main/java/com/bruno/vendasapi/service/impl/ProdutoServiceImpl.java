package com.bruno.vendasapi.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bruno.vendasapi.dto.ProdutoDTO;
import com.bruno.vendasapi.model.AvaliacaoProduto;
import com.bruno.vendasapi.model.Produto;
import com.bruno.vendasapi.repository.ProdutoRepository;
import com.bruno.vendasapi.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;

	@Override
	public Produto buscar(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException("erro"));
	}

	@Override
	
	public List<Produto> buscarTodos() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public Produto salvar(ProdutoDTO dto) {

		Produto produto = converterToEntity(dto);
		if (dto.getAvaliacao() != null) {
			AvaliacaoProduto avaliacao = new AvaliacaoProduto();
			avaliacao.setNota(dto.getAvaliacao());
			avaliacao.setProduto(produto);

			produto.setAvaliacoes(Arrays.asList(avaliacao));
		}

		return produto;

	}

	private Produto converterToEntity(ProdutoDTO dto) {
		Produto produto = new Produto();
		produto.setNome(dto.getNome());
		produto.setDescricao(dto.getDescricao());
		produto.setDataCriacao(Calendar.getInstance());

		return produto;

	}

	@Override
	@Transactional
	public Produto atualizar(Produto produto) {
		Objects.requireNonNull(produto.getId());
		return repository.save(produto);
	}

	@Override
	@Transactional
	public void deletar(Produto produto) {
		Objects.requireNonNull(produto.getId());
		repository.delete(produto);
		
	}
	
	
}
