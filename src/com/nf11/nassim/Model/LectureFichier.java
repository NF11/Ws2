package com.nf11.nassim.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
  * <b>LectureFichier represente la lecture d'un fichier texte.</b>
  * 
  * <p>
  * Une LectureFichier permet d'acceder de lire un fichier texte.
  * Cette classe est un singleton
  * </p>
  *
  * @author Julien
  * @version 1.0
  */
public class LectureFichier {

	/**
	  * L'unique instance du singleton LectureFichier
	  */
	private static final LectureFichier instance = new LectureFichier();
	
	/**
	  * Constructeur
	  */
	private LectureFichier(){
		super();
	}

	/**
	  * Fonction qui lit le contenu d'un fichier
	  * @param nomFichier 
	  * 	nom du fichier en entree
	  * @param nbLignes
	  *		estimation du nombre de lignes du fichier pour construire la liste
	  * @return liste des lignes du fichier
	  */
	public List<String> lireFichier(String nomFichier, int nbLignes){
		BufferedReader fluxEntree=null;
		String ligneLue;
		List<String> lignes = new ArrayList<String>(nbLignes);
		try{
			fluxEntree = new BufferedReader(new FileReader(nomFichier));
			ligneLue = fluxEntree.readLine();
			while(ligneLue!=null){
				lignes.add(ligneLue);
				ligneLue = fluxEntree.readLine();
			}
		}
		catch(IOException exc){
			exc.printStackTrace();
		}
		try{
			fluxEntree.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return lignes;
	} 
	
	/**
	  * Accesseur a l'instance du singleton
	  * @return l'instance de la classe LectureFichier
	  */
	public static LectureFichier getInstance(){
		return instance;
	}

}