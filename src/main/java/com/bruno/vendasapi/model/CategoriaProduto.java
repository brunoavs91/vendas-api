package com.bruno.vendasapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "CATEGORIA_PRODUTO")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column
	String nome;
	
	@ManyToOne
	@JoinColumn(name="venda_id", nullable=false)
	Venda venda;
}
