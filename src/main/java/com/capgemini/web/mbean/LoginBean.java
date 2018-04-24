package com.capgemini.web.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
//@SessionScoped
public class LoginBean {
	
	private String username;
	private String password;
	
	public String connexion() {
		String suite = null;
		if(password.equals("pwd"+username)) {
			suite="user";
		}
		return suite;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
