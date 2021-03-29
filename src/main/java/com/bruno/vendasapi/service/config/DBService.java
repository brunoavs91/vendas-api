package com.bruno.vendasapi.service.config;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.vendasapi.model.AvaliacaoProduto;
import com.bruno.vendasapi.model.CategoriaProduto;
import com.bruno.vendasapi.model.Produto;
import com.bruno.vendasapi.repository.ProdutoRepository;

@Service
public class DBService {

	@Autowired
	private ProdutoRepository repository;
	
	
	public void instantiateTestDataBase(Integer quantidadeProdutos) {
		
		for(int i =1 ; i < quantidadeProdutos; i++) {
			
			Produto produto = Produto.builder().nome("Produto"+i).descricao("Descricao"+i).dataCriacao(Calendar.getInstance()).build();
			
			produto	= repository.save(produto);
			
			CategoriaProduto categoria = CategoriaProduto.builder().nome("CATEGORIA"+i).build();
			produto.setCategoria(categoria);
			produto.setAvaliacoes(listaAvalicacoes(produto));
			
			repository.save(produto);
					
		}
		

	}
	
	private List<AvaliacaoProduto> listaAvalicacoes(Produto produto) {
		Random random = new Random();
		
		return Arrays.asList(AvaliacaoProduto.builder().nota(random.nextDouble() * 5).produto(produto).build());
	}
	
	
}
