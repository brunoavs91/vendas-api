package com.bruno.vendasapi.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Produto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column
	String nome;
	
	@Column
	String descricao;
	
	@Column
	Calendar dataCriacao;
	
	@Column
	Double score;
	
	@OneToMany( mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<AvaliacaoProduto> avaliacoes;
	
	@ManyToOne
	@JoinColumn(name="venda_id", nullable=false)
	Venda venda;
	
	
}
