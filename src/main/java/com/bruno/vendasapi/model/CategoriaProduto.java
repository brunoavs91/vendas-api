package com.bruno.vendasapi.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "CATEGORIA_PRODUTO")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriaProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column
	String nome;
	
	@OneToMany( mappedBy = "categoria", 
			cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	Set<Produto> produtos;
	
	
}
