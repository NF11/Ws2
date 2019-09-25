package com.nf11.nassim.Model;

public class MotDePasse{


	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	private String valeur;
	

	public MotDePasse(String valeur){
		if(valeur!=null){
			this.valeur=valeur;
		}
		else{
			this.valeur="";
		}
	}
	

	public boolean isPasswordEquals(String essai){
		return valeur.equals(essai);
	}
	
}