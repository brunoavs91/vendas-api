package com.bruno.vendasapi.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoBuscaDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nome;
	
	private String descricao;
	
	private Date dataAvaliacao;
	
	private Double score;
}
