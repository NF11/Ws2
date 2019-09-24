package com.nf11.nassim.Model;

public class CLmapTB_PERSONNE {

    private String name;
    private String firstName;
    private String query;

    public String m_select(){
        return "SELECT * from tb_personne;";
    }

    public String m_insert(String name, String firstName){
        return "INSERT INTO tb_personne (name,firstName) VALUES ('"+ name +
                "','" +firstName+ "')";
    }


    // Getters & Setters
    //------------------------------------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
