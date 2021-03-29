package com.bruno.vendasapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.vendasapi.dto.ProdutoDTO;
import com.bruno.vendasapi.service.ProdutoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/produtos/")
public class ProdutoController {
	
	@Autowired
	ProdutoService service;
	
	@GetMapping("buscar-por-score")
	public ResponseEntity buscarPorScore(@RequestParam String produto) {
		return ResponseEntity.ok( service.buscarProdutoPorScore(produto));
		
	}
	
	
	
	@GetMapping
	@ApiOperation(value = "Retorna todos os produtos", notes = "")
	 @ApiResponses(value = {
				@ApiResponse(code = 200, message = "Busca concluida."),
				@ApiResponse(code = 417, message = "Erro na busca.")
		  })
	public ResponseEntity buscarTodos() {
		return ResponseEntity.ok( service.buscarTodos());
		
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna produto por id", notes = "")
	 @ApiResponses(value = {
				@ApiResponse(code = 200, message = "Busca concluida"),
				@ApiResponse(code = 417, message = "Erro na busca.")
		  })
	public ResponseEntity buscar(@PathVariable Long id) {
		return ResponseEntity.ok( service.buscar(id));
		
	}

	@PostMapping
	@ApiOperation(value = "Salva produto ", notes = "")
	 @ApiResponses(value = {
				@ApiResponse(code = 200, message = "Produto Salvo com sucesso."),
				@ApiResponse(code = 417, message = "Erro na busca.")
		  })
	public ResponseEntity salvar(@RequestBody ProdutoDTO dto) {

		return ResponseEntity.ok(service.salvar(dto));
	}
	
	@PutMapping
	@ApiOperation(value = "Atualiza produto", notes = "")
	 @ApiResponses(value = {
				@ApiResponse(code = 200, message = "Produto Atualizado com sucesso."),
				@ApiResponse(code = 417, message = "Erro na busca.")
		  })
	public ResponseEntity atualizar(@RequestBody ProdutoDTO dto) {
		return ResponseEntity.ok(service.atualizar(dto));
	}
	
	@DeleteMapping("{id}")
	@ApiOperation(value = "Deleta produto", notes = "")
	  @ApiResponses(value = {
			@ApiResponse(code = 200, message = "Produto deletado com sucesso."),
			@ApiResponse(code = 417, message = "Erro na busca.")
	  })
	public ResponseEntity deletar(@PathVariable Long id) {
		
		service.deletar(id);
		 return ResponseEntity.noContent().build();
	}
	
	

}
