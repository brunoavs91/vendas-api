package com.bruno.vendasapi.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "PRODUTO")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
	@Temporal(TemporalType.DATE)
	Calendar dataCriacao;
	
	@Column
	Double score;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="categoria_id")
	CategoriaProduto categoria;
	
	@OneToMany( mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<AvaliacaoProduto> avaliacoes;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	public Date getDataFormatada() {
		return dataCriacao.getTime();
	}
}
