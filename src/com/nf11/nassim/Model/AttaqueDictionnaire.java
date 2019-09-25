package com.nf11.nassim.Model;

import java.util.List;

public class AttaqueDictionnaire extends AbstractAttaque implements IAttaque {


	private List<String> dictionnaire;
	

	public AttaqueDictionnaire(MotDePasse password, List<String> dictionnaire){
		super(password);
		this.dictionnaire=dictionnaire;
	}


	public String attaquer(){
		String res=null;
		String test = getPassword().getValeur() ;

		for(String s : this.dictionnaire){
			if(test.equals(s)){
				res=s;
				break;
			}
		}
		return res;
	}
}