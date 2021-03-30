package com.bruno.vendasapi.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.bruno.vendasapi.dto.ProdutoBuscaDTO;
import com.bruno.vendasapi.dto.ProdutoDTO;
import com.bruno.vendasapi.exception.BusinessException;
import com.bruno.vendasapi.exception.ObjectNotFoundException;
import com.bruno.vendasapi.model.AvaliacaoProduto;
import com.bruno.vendasapi.model.CategoriaProduto;
import com.bruno.vendasapi.model.Produto;
import com.bruno.vendasapi.repository.CategoriaProdutoRepository;
import com.bruno.vendasapi.repository.ProdutoRepository;
import com.bruno.vendasapi.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	private static final Logger LOG = LoggerFactory.getLogger(ProdutoServiceImpl.class);
	
	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private CategoriaProdutoRepository categoriaProdutoRepository;

	@Override
	@Transactional(readOnly = true)
	public Produto buscar(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new BusinessException("Produto nao encontrado"));
	}

	@Override
	@Transactional(readOnly = true)
	public List<Produto> buscarTodos() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public Produto salvar(ProdutoDTO dto) {
		
		Produto produto =  converterToEntity(dto);
		

		CategoriaProduto categoria = categoriaProdutoRepository.findById(dto.getCategoria())
				.orElseThrow(() -> new ObjectNotFoundException("categoria nao encontrada"));

		produto.setCategoria(categoria);
		

		return repository.save(produto);

	}

	private Produto converterToEntity( ProdutoDTO dto) {
		Produto produto = new Produto();
		
		produto.setNome(dto.getNome());
		produto.setDescricao(dto.getDescricao());
		produto.setDataCriacao(Calendar.getInstance());
		
		if(CollectionUtils.isEmpty(produto.getAvaliacoes())) {
			produto.setAvaliacoes(new ArrayList<>());
		}
		
		if (dto.getAvaliacao() != null) {
			AvaliacaoProduto avaliacao = new AvaliacaoProduto();
			avaliacao.setNota(dto.getAvaliacao());
			avaliacao.setProduto(produto);

			produto.getAvaliacoes().add(avaliacao);

		}
		
		
		return produto;

	}

	@Override
	@Transactional
	public Produto atualizar(ProdutoDTO dto) {
		
		Produto produto = repository.findById(dto.getId())
				.orElseThrow(()-> new BusinessException("Nenhum produto encontrado"));
		
		atualizarProduto(produto, dto);
		return repository.save(produto);
	}
	
	private void atualizarProduto(Produto produto, ProdutoDTO dto) {
		produto.setNome(dto.getNome());
		produto.setDescricao(dto.getDescricao());
	}

	@Override
	@Transactional
	public void deletar(Long id) {
		
		if(id == null) {
			throw new BusinessException("Id para exclusao invalido");
		}
			
		
		repository.deleteById(id);
		
	}

	@Override
	public List<ProdutoBuscaDTO> buscarScore(String produto) {
		List<ProdutoBuscaDTO> listaBusca = repository.buscarScore(produto);
		
		
		if(CollectionUtils.isEmpty(listaBusca)) {
			throw new ObjectNotFoundException("Produto nao encontrado");
		}
		return listaBusca;
	}
	
	
}
