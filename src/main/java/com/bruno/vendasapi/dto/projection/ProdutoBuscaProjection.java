package com.bruno.vendasapi.dto.projection;

import java.util.Date;


public interface ProdutoBuscaProjection {

	public Long getId();
	
	public String getNome();
	
	public String getDescricao();
	
	public Date getDataCriacao();
	
	public Double getScore();
	
}
