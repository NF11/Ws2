package com.nf11.nassim.Model;


abstract class AbstractAttaque {

	private MotDePasse password;
	

	public AbstractAttaque(MotDePasse password){
		this.password=password;
	}
	

	public MotDePasse getPassword(){
		return this.password;
	}

	public void setPassword(MotDePasse mdp){
		this.password = mdp ;

	}

}

