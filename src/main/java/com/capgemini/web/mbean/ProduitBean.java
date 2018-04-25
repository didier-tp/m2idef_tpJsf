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
	
	private Long categorie=1L;  //id de la categorie choisie/selectionnee 
	                        // via liste déroulante (+get/set) 
							//avec 1L comme valeur par defaut
	public String filtrerSelonCategorie() {
		String suite = null;
		System.out.println("categorie=" + categorie);//à visualiser dans console eclipse/tomcat
		//reactualisation de la liste des produits selon categorie choisie:
		this.listeProduits = 
				this.serviceProduit.rechercherProduitsParCategorie(this.categorie);
		return suite;
	}
	
	
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

	public Long getCategorie() {
		return categorie;
	}

	public void setCategorie(Long categorie) {
		this.categorie = categorie;
	}
	
	

}
