package com.nf11.nassim;

import com.nf11.nassim.Controller.CLctrlGestionComptePersonne;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main{

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("salut");

        CLctrlGestionComptePersonne objGestion;
        ResultSet rs;

        objGestion = new CLctrlGestionComptePersonne();

        rs = objGestion.m_listerLesCompte();
        afficher(rs);

        objGestion.m_CreeUnCompte(11, "X", "x");
        rs = objGestion.m_listerLesCompte();
        afficher(rs);
    }

    public static void afficher(ResultSet rs)
    {
        try {
            while (rs.next()) {
                System.out.println(rs.getString("nom") + " " + rs.getString("prenom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
