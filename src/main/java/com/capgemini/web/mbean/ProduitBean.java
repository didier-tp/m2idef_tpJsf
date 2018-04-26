package com.capgemini.web.mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;

import com.capgemini.entity.Categorie;
import com.capgemini.entity.Produit;
import com.capgemini.service.ServiceProduit;

@ManagedBean
@RequestScoped //ou SessionScoped
public class ProduitBean {
	
	private Boolean avecDetails = Boolean.FALSE; //avec valeur par defaut et get/set
	
	private List<Produit> listeProduits; //à afficher dans tableau
	
	private List<Categorie> listeCategorie; //pour remplir valeurs selectionnables
	                                        //dans liste deroulante (+get/set)
	
	private Long categorie=1L;  //id de la categorie choisie/selectionnee 
	                        // via liste déroulante (+get/set) 
							//avec 1L comme valeur par defaut
	/*
	public String filtrerSelonCategorie() {
		String suite = null;
		System.out.println("avecDetails=" + avecDetails);
		System.out.println("categorie=" + categorie);//à visualiser dans console eclipse/tomcat
		//reactualisation de la liste des produits selon categorie choisie:
		this.listeProduits = 
				this.serviceProduit.rechercherProduitsParCategorie(this.categorie);
		return suite;
	}
	*/
	
	public void onDetailsChange(ValueChangeEvent event) {
		this.avecDetails = (Boolean) event.getNewValue();
		System.out.println("onDetailsChange() appele avecDetails=" + avecDetails);
	}
	
	public void onCategorieChange(ValueChangeEvent event) {
		this.categorie = (Long) event.getNewValue();
		System.out.println("onDetailsChange() categorie=" + categorie);
		//reactualisation de la liste des produits selon categorie choisie:
		this.listeProduits = 
			this.serviceProduit.rechercherProduitsParCategorie(this.categorie);
	}
	
	private ServiceProduit serviceProduit;
	
	public ProduitBean() {
		this.serviceProduit = ServiceProduit.getInstance();//singleton
		this.listeProduits = 
			this.serviceProduit.rechercherProduitsParCategorie(1L);
		//avec 1L : id de la categorie par defaut (1L = 1 de type Long)
		this.listeCategorie = this.serviceProduit.rechercherListeCategories();
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

	public List<Categorie> getListeCategorie() {
		return listeCategorie;
	}

	public void setListeCategorie(List<Categorie> listeCategorie) {
		this.listeCategorie = listeCategorie;
	}

	public Boolean getAvecDetails() {
		return avecDetails;
	}

	public void setAvecDetails(Boolean avecDetails) {
		this.avecDetails = avecDetails;
	}
	
	

}
