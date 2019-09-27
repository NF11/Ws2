package com.nf11.nassim.Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BrutForce {

    private static final  String mot ="abcdefghijklmnopqrstuvwxyz";
    private static final Random rand = new Random();
    public static String getMot() {
        return mot;
    }

    public static String getDemo() {
        return demo;
    }

    public static void setDemo(String demo) {
        BrutForce.demo = demo;
    }

    public static double getI() {
        return i;
    }

    public static void setI(double i) {
        BrutForce.i = i;
    }

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }

    private static String demo ="";
    private static double i =0;
    private List<String> keys = new ArrayList<String>();

    public void genKeys () throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\Users\\nassi\\Desktop\\exia_test\\myKeys.txt");

        // Always wrap FileWriter in BufferedWriter.
        BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

        for (i=0;i<314159260L;i++){
            demo="awqpmndf";
            //randomisation des caractères selon leur nombre par type définis ,entre six et dix caratères
            while ((demo.length() != 12)&& (demo.length() != 12)) {
                //selection aleatoire du type de caractère puis selection parmis les differents modèles de caractères
                int rPick=rand.nextInt(4);
                if (rPick ==0) {
                    int erzat=rand.nextInt(25);
                    demo+=mot.charAt(erzat);
                } else if (rPick == 1) {
                    int erzat=rand.nextInt(9);
                    demo+=mot.charAt(erzat);
                } else if (rPick==2) {
                    int erzat=rand.nextInt(25);
                    demo+=mot.charAt(erzat);
                }else if (rPick==3) {
                    int erzat=rand.nextInt(15);
                    demo+=mot.charAt(erzat);
                }
            }
            bufferedWriter.write(demo);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

}
