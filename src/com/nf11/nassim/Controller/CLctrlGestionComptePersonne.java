package com.nf11.nassim.Controller;
import com.nf11.nassim.Model.CLcad;
import com.nf11.nassim.Model.CLmapTB_PERSONNE;

import java.sql.*;
public class CLctrlGestionComptePersonne {
    CLcad conn;
    CLmapTB_PERSONNE personne;
    public CLctrlGestionComptePersonne(){
        try {
            this.conn = new CLcad();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        this.personne = new CLmapTB_PERSONNE();
    }
    public ResultSet m_listerLesCompte() throws SQLException, ClassNotFoundException {


        return this.conn.m_getRows(personne.m_select());
    }

    public int m_CreeUnCompte(String name, String firstName) throws SQLException {

        return  this.conn.m_actionRows(this.personne.m_insert(name,firstName));
    }


}
