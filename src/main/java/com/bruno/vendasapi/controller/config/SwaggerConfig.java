package com.bruno.vendasapi.controller.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.bruno.vendasapi"))
				.paths(PathSelectors.any()).build().apiInfo(metaInfo());
	}
	
	private ApiInfo metaInfo() {
		return new ApiInfo("API VENDAS DE PRODUTOS", "api de vendas de produtos", "1.0", "Termos de servico", 
				new Contact("ApiVendas", "", ""), "", "", new ArrayList<VendorExtension>());
	}
}
