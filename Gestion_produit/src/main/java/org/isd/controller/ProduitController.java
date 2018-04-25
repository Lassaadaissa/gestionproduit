package org.isd.controller;

import java.util.List;

import org.isd.dao.CategoryReposetory;
import org.isd.dao.Produit;
import org.isd.dao.Category;
import org.isd.dao.ProduitReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduitController {
	
	@Autowired
	private  ProduitReposetory produitreposetory ;
	
	@Autowired
	private CategoryReposetory categoryreposetory ;
	
	 @RequestMapping(value = "/produitsparcat")
	 public Page <Produit> produitparcat(Category c , int page)
	 {
		 return produitreposetory.findByCategory(c, new PageRequest(page, 4));
	 }
	
	
	
	
	
	
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	public Produit saveproduit(@RequestBody Produit p)
	{
		produitreposetory.save(p);
		return p ;
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	@RequestMapping("/all")
	public List<Produit> getproduits(){
		
		return produitreposetory.findAll();
	}
	
	
	@RequestMapping("/allcat")
	public List<Category> getcategories(){
		
		return categoryreposetory.findAll();
	}
	
	
	@RequestMapping("/pageproduits")
	public Page<Produit> getproduits(int page){
		
		return produitreposetory.findAll(new PageRequest(page, 4));
	}
	
	@RequestMapping("/produitsdes")
  public List <Produit> getproduits(String desin ) {
	return produitreposetory.findByDesignation(desin);
	}
	
	@RequestMapping("/produitref")
	public Produit getProduit(Long ref) {
		return produitreposetory.findOne(ref);
	}
	
	@RequestMapping("/produitmc")
	public Page <Produit> getproduitparmc(String mc ,int page) {
		
		return produitreposetory.produitparmc("%"+mc+"%",new PageRequest(page, 5));
	}
	
	
	
	@RequestMapping(value="/delete/{id}" ,method=RequestMethod.DELETE )
	public Boolean deleteproduit(@PathVariable("id") Long ref)
	{
		produitreposetory.delete(ref);
		return true ;
	}
	
	
	
	
	

}
