package org.isd.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProduitReposetory extends JpaRepository<Produit, Long>{

	@Query("select p from Produit p where p.designation like :x")
	public Page<Produit> produitparmc(@Param("x") String mc,Pageable p);
	public List<Produit>  findByDesignation( String des);
	public Page <Produit> findByDesignation(String des , Pageable p);
	public Page <Produit> findByCategory(Category c,Pageable p);
	
	
}
