package com.bruno.vendasapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Venda {
  
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vendedor_id", referencedColumnName = "id")
	Vendedor vendedor;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoria_id", referencedColumnName = "id")
	CategoriaProduto categoria;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "produto_id", referencedColumnName = "id")
	Produto produto;
	
	
}
