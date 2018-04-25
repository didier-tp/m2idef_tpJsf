package com.capgemini.service;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.entity.Produit;

/*
 Business Service (plus tard pris en charge par Spring)
 gérant des produits classés par categorie
 Dans la version temporaire sans spring : design pattern Singleton 
  + jeu de données en dur (simulation sans base de données)
 */
public class ServiceProduit {
	
	private List<Produit> produits; //+get/set 
	
	public ServiceProduit(){
		produits=new ArrayList<Produit>();
		produits.add(new Produit(1L,"cahier" , 2.5 ,"grands carreaux"));
		//...add , add , add
	}

}
