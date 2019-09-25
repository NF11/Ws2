package com.nf11.nassim.Controller;

import com.nf11.nassim.Model.AttaqueDictionnaire;
import com.nf11.nassim.Model.CLfichier;
import com.nf11.nassim.Model.LectureFichier;
import com.nf11.nassim.Model.MotDePasse;

public class SelectGoodFile {

    private String[] path = new String[10];
    private String key;

    public String[] getPath() {
        return this.path;
    }

    public void setPath(String[] path) {
        for(int i = 0; i < path.length; i++)
            this.path[i] = path[i];
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public SelectGoodFile(String[] path,String key){
        setPath(path);
        this.key = key;
    }

    public String GetGood(){
        boolean isGood = false;
        int i =0 ;
        String text = "";
        String decrepted = "";
        CLctrlCrypt cLctrlCrypt = new CLctrlCrypt();
        MotDePasse mdp = new MotDePasse("");
        AttaqueDictionnaire attaqueDictionnaire = new AttaqueDictionnaire(mdp, LectureFichier.getInstance().lireFichier("C:\\java\\Ws2\\src\\com\\nf11\\nassim\\dictionnaire.txt",360000));;
        String goodfile = "";
        for (String file : getPath()){
            System.out.println(file);
        }
        while (isGood == false &&  i < getPath().length){
            text = cLctrlCrypt.lireFichierSimple(getPath()[i]).replaceAll("null","");
            decrepted = cLctrlCrypt.decrypter(text,getKey());
            mdp.setValeur(decrepted.split(" ")[0].toLowerCase());

            attaqueDictionnaire.setPassword(mdp);

            // System.out.println(attaqueDictionnaire.attaquer());
            if ( attaqueDictionnaire.attaquer() != null){
                isGood = true;
                goodfile = getPath()[i];
                return goodfile;
            }else {
                i++;
            }
        }
        return null;
    }

}
