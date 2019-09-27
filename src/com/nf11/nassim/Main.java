package com.nf11.nassim;

import com.nf11.nassim.Controller.CLctrlCrypt;
import com.nf11.nassim.Controller.CLctrlGestionComptePersonne;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main{

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//
//        CLctrlGestionComptePersonne objGestion;
//        ResultSet rs;
//
//        objGestion = new CLctrlGestionComptePersonne();
//
//        rs = objGestion.m_get_single("Rafik");
//        afficher(rs);

         // rs = objGestion.m_listerLesCompte();
//        afficher(rs);
//
//        objGestion.m_CreeUnCompte ("X", "x");
//        rs = objGestion.m_listerLesCompte();
//        afficher(rs);



        CLctrlCrypt o1;
        String reponse, decrypted, decrypted1;

        o1 = new CLctrlCrypt();
        o1.ecrireFichierSimple("C:\\Users\\ordan\\Desktop\\a.txt", "Bonjour a tous. Comment Allez vous?");

        reponse = o1.lireFichierSimple("C:\\Users\\ordan\\Desktop\\a.txt");
        reponse = o1.crypter(reponse, "awqpnass");



        o1.ecrireFichierSimple("C:\\Users\\ordan\\Desktop\\b.txt", reponse);

        reponse = o1.lireFichierSimple("C:\\Users\\ordan\\Desktop\\b.txt");
        reponse = o1.crypter(reponse, "awqpnass");



        o1.ecrireFichierSimple("C:\\Users\\ordan\\Desktop\\c.txt", reponse);

        reponse = o1.lireFichierSimple("C:\\Users\\ordan\\Desktop\\b.txt").split("null")[1];;



    }
}
