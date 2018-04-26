package com.capgemini.web.mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import com.capgemini.entity.Categorie;
import com.capgemini.service.ServiceProduit;

@ManagedBean
@SessionScoped
public class CategorieBean {
	
	private List<Categorie> listeCategorie; //pour remplir valeurs selectionnables
    //dans liste  (+get/set)

    private Categorie categorie;
    private Long idCategorie;
    
    private ServiceProduit serviceProduit;
    
    public CategorieBean() {
    	this.serviceProduit = ServiceProduit.getInstance();//singleton
    	this.listeCategorie = this.serviceProduit.rechercherListeCategories();
    	if(this.listeCategorie!=null && !this.listeCategorie.isEmpty()) {
    	    this.categorie = this.listeCategorie.get(0);
    	    this.idCategorie = this.categorie.getIdCat();
    	}
    }
    
    private void selectCategorieFromIdCategorie() {
    	for(Categorie c : this.listeCategorie) {
    		if(c.getIdCat() == this.idCategorie) {
    			this.categorie = c;
    			break;
    		}
    	}
    }
    
    public void onCategorieChange(ValueChangeEvent event) {
		this.idCategorie = (Long) event.getNewValue();
		System.out.println("onCategorieChange() idCategorie=" + idCategorie);
		selectCategorieFromIdCategorie();
	}

	public List<Categorie> getListeCategorie() {
		return listeCategorie;
	}

	public void setListeCategorie(List<Categorie> listeCategorie) {
		this.listeCategorie = listeCategorie;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}

    
}
