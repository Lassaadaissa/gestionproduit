package org.isd.dao;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idcategory ;
	private String nomcategory ;
	
	@OneToMany(mappedBy="category" , fetch=FetchType.LAZY)
	private Collection<Produit> produits ;

	public Category() {
		super();
	}

	public Category(String nomcategory) {
		super();
		this.nomcategory = nomcategory;
	}

	public long getIdcategory() {
		return idcategory;
	}

	public void setIdcategory(long idcategory) {
		this.idcategory = idcategory;
	}

	public String getNomcategory() {
		return nomcategory;
	}

	public void setNomcategory(String nomcategory) {
		this.nomcategory = nomcategory;
	}

	
	public Collection<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	}
	
	
	
	
	
	
}
