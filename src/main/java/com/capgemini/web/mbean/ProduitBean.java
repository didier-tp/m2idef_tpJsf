package com.capgemini.web.mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.capgemini.entity.Produit;
import com.capgemini.service.ServiceProduit;

@ManagedBean
@RequestScoped //ou SessionScoped
public class ProduitBean {
	
	private List<Produit> listeProduits; //à afficher dans tableau
	
	private ServiceProduit serviceProduit;
	
	public ProduitBean() {
		this.serviceProduit = ServiceProduit.getInstance();//singleton
		this.listeProduits = 
			this.serviceProduit.rechercherProduitsParCategorie(1L);
		//avec 1L : id de la categorie par defaut (1L = 1 de type Long)
	}

	public List<Produit> getListeProduits() {
		return listeProduits;
	}
	
	

}
