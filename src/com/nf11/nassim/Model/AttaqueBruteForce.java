package com.nf11.nassim.Model;

public class AttaqueBruteForce extends AbstractAttaque implements IAttaque{


	private String caracteres;

	private int tailleMin;

	private int tailleMax;

	public AttaqueBruteForce(MotDePasse password, String caracteres, int tailleMin, int tailleMax){
		super(password);
		this.caracteres=caracteres;
		this.tailleMin=tailleMin;
		this.tailleMax=tailleMax;
	}


	public String attaquer(){
		String res = null;
		for(int t=tailleMin; t<=tailleMax; t++){
			String test = initialiserTest(t);
			if(getPassword().isPasswordEquals(test)){
				res=test;
			}
			else{
				while(test!=null){
					test=incrementer(test);
					if(getPassword().isPasswordEquals(test)){
						res=test;
						break;
					}
				}
			}
		}
		return res;
	}

	public String initialiserTest(int taille){
		StringBuilder sb = new StringBuilder();
		if(taille>0){
			char premierCaractere = caracteres.charAt(0);
			for(int k=0; k<taille; k++){
				sb.append(premierCaractere);
			}
		}
		return sb.toString();
	}

	public String incrementer(String s){
		String res=null;
		if(s!=null){
			if(s.length()==0){
				res=caracteres.charAt(caracteres.length()-1)+"";
			}
			else{
				boolean temp = true;
				for(int u=0; u<s.length(); u++){
					if(s.charAt(u)!=caracteres.charAt(caracteres.length()-1)){
						temp=false;
						break;
					}
				}
				if(!temp){
					char dernier = s.charAt(s.length()-1);
					if(dernier==caracteres.charAt(caracteres.length()-1)){
						res=incrementer(s.substring(0, s.length()-1))+caracteres.charAt(0);
					}
					else{
						res=s.substring(0, s.length()-1)+nextChar(dernier);
					}
				}
				else{
					res=null;
				}
			}
		}
		return res;
	}


	public char nextChar(char car){
		int i=0;
		for(int j=0; j<caracteres.length(); j++){
			i++;
			if(caracteres.charAt(j)==car){
				break;
			}
		}
		return caracteres.charAt(i);
	}

	public String getCaracteres() {
		return caracteres;
	}

	public int getTailleMin() {
		return tailleMin;
	}

	public int getTailleMax() {
		return tailleMax;
	}

}