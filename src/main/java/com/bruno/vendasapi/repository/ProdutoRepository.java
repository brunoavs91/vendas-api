package com.bruno.vendasapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bruno.vendasapi.dto.ProdutoBuscaDTO;
import com.bruno.vendasapi.dto.projection.ProdutoBuscaProjection;
import com.bruno.vendasapi.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query(value = "SELECT p.id, p.nome, p.descricao, p.data_Criacao, p.score FROM Produto p "
			+ " INNER JOIN CATEGORIA_PRODUTO cat on cat.id = p.categoria_id"
			+ " WHERE lower(p.nome)  like lower(concat( :produto,'%')) "
			+ " ORDER BY cat.nome, p.score DESC", nativeQuery = true)
	public List<ProdutoBuscaProjection> buscarProdutoPorScore(@Param("produto")String produto);
	
	
	@Query(value = "SELECT NEW com.bruno.vendasapi.dto.ProdutoBuscaDTO(p.id, p.nome, p.descricao, p.dataCriacao, p.score) FROM  Produto p "
			+ " INNER JOIN CategoriaProduto cat on cat.id = p.categoria.id "
			+ " WHERE lower(p.nome)  like lower(concat( :produto,'%')) "
			+ " ORDER BY cat.nome, p.score DESC")
	public List<ProdutoBuscaDTO> buscarScore(@Param("produto") String produto);
//
//	  @Query("SELECT new de.smarterco.example.dto.UserNameDTO(u.id, u.name) FROM User u WHERE u.name = :name")
//	    List<UserNameDTO> retrieveUsernameAsDTO(@Param("name") String name);

}
