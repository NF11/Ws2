package com.nf11.nassim.Controller;

import com.nf11.nassim.Model.*;

import java.util.List;

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
        BrutForce brutForce = new BrutForce();
        brutForce.genKeys();
        List<String> keys = brutForce.getKeys();

        while (isGood == false &&  i < getPath().length){
            text = cLctrlCrypt.lireFichierSimple(getPath()[i]).replaceAll("null","");

            decrepted = cLctrlCrypt.decrypter(text,"awqpnass");
            mdp.setValeur(decrepted.split(" ")[0].toLowerCase());

            attaqueDictionnaire.setPassword(mdp);

            // System.out.println(attaqueDictionnaire.attaquer());
            if ( attaqueDictionnaire.attaquer() != null){
                isGood = true;
                goodfile = getPath()[i];
            }else {
                i++;
            }
        }
        System.out.println(goodfile);
        if(goodfile != null){

        String mot1,mot2,mot3 = "";

        MotDePasse mdp1= new MotDePasse("");
        MotDePasse mdp2= new MotDePasse("");
        MotDePasse mdp3= new MotDePasse("");
        AttaqueDictionnaire att1= new AttaqueDictionnaire(mdp1, LectureFichier.getInstance().lireFichier("C:\\java\\Ws2\\src\\com\\nf11\\nassim\\dictionnaire.txt",360000));;
        AttaqueDictionnaire att2= new AttaqueDictionnaire(mdp2, LectureFichier.getInstance().lireFichier("C:\\java\\Ws2\\src\\com\\nf11\\nassim\\dictionnaire.txt",360000));;
        AttaqueDictionnaire att3= new AttaqueDictionnaire(mdp3, LectureFichier.getInstance().lireFichier("C:\\java\\Ws2\\src\\com\\nf11\\nassim\\dictionnaire.txt",360000));;

        for(String thekey : keys) {
            decrepted = cLctrlCrypt.decrypter(text, key);
            mot1 = decrepted.split(" ")[0].toLowerCase();
            mot2 = decrepted.split(" ")[1].toLowerCase();
            mot3 = decrepted.split(" ")[2].toLowerCase();
            System.out.println("rani hna bezaf");
            mdp1.setValeur(mot1);
            mdp2.setValeur(mot2);
            mdp3.setValeur(mot3);

            att1.setPassword(mdp1);
            att2.setPassword(mdp2);
            att3.setPassword(mdp3);
            System.out.println("ya zah");
            if (att1.attaquer() != null && att2.attaquer() != null && att3.attaquer() != null) {
                System.out.println(decrepted);
                return "Successfully decrypted file";
            }
        }
        }
        return null;
    }

}
