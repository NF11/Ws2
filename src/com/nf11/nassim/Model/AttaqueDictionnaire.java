package com.nf11.nassim.Model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AttaqueDictionnaire extends AbstractAttaque implements IAttaque {


	private List<String> dictionnaire;
	

	public AttaqueDictionnaire(MotDePasse password, List<String> dictionnaire){
		super(password);
		this.dictionnaire=dictionnaire;
	}


	public String attaquer(){
		//String res=null;
		String test = getPassword().getValeur() ;
		Set<String> mySet = new HashSet<String>(this.dictionnaire);
        if(mySet.contains(test)) {
            return test;
        }
        return null;
//		for(String s : this.dictionnaire){
//			if(test.equals(s)){
//				res=s;
//				break;
//			}
//		}
		//return res;
	}
}