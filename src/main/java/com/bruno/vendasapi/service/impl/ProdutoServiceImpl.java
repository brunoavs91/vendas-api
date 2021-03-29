package com.bruno.vendasapi.service.impl;

import java.util.Arrays;
import java.util.Calendar;
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
import com.bruno.vendasapi.dto.projection.ProdutoBuscaProjection;
import com.bruno.vendasapi.exception.BusinessException;
import com.bruno.vendasapi.exception.ObjectNotFoundException;
import com.bruno.vendasapi.model.AvaliacaoProduto;
import com.bruno.vendasapi.model.Produto;
import com.bruno.vendasapi.repository.ProdutoRepository;
import com.bruno.vendasapi.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	private static final Logger LOG = LoggerFactory.getLogger(ProdutoServiceImpl.class);
	
	@Autowired
	private ProdutoRepository repository;

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

		Produto produto = converterToEntity(dto);
		if (dto.getAvaliacao() != null) {
			AvaliacaoProduto avaliacao = new AvaliacaoProduto();
			avaliacao.setNota(dto.getAvaliacao());
			avaliacao.setProduto(produto);

			produto.setAvaliacoes(Arrays.asList(avaliacao));
		}
		
		return repository.save(produto);

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
	public Produto atualizar(ProdutoDTO dto) {
		if(Objects.isNull(dto)) {
			throw new BusinessException("Nao contem produto para atualizacao");
		}
		return salvar(dto);
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
