package com.bruno.vendasapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bruno.vendasapi.service.config.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	@Value("${quantidadeProduto}")
	private Integer quantidadeProdutos;
	
	@Autowired
	private DBService dbService;

	
	@Bean
	public Boolean instantiateDataBase() throws Exception {
		dbService.instantiateTestDataBase(quantidadeProdutos);
		return true;
	}
}
