package com.nf11.nassim.Model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Key {
        private static final Random rand = new Random();
        private static final   String Xsi ="abcdefghijklmnopqrstuvwxyz";
        private static final String Gamm ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private static final String Iot = "1234567890";
        private static final String Zeta="&~#|`-_)('/?,;:.";
        private static String demo ="";
        private static double i =0;

        public static void main(String[] args) {
            FileWriter writer;
            try {
                writer = new FileWriter("C:\\Users\\nassi\\Desktop\\javatest\\dico01.txt");
                {
                    for (i=0;i<314159260L;i++){
                        demo="awqp";
                        //randomisation des caractères selon leur nombre par type définis ,entre six et dix caratères
                        while ((demo.length() != 12)&& (demo.length() != 12)) {
                            //selection aleatoire du type de caractère puis selection parmis les differents modèles de caractères
                            int rPick=rand.nextInt(4);
                            if (rPick ==0) {
                                int erzat=rand.nextInt(25);
                                demo+=Xsi.charAt(erzat);
                            } else if (rPick == 1) {
                                int erzat=rand.nextInt(9);
                                demo+=Xsi.charAt(erzat);
                            } else if (rPick==2) {
                                int erzat=rand.nextInt(25);
                                demo+=Xsi.charAt(erzat);
                            }else if (rPick==3) {
                                int erzat=rand.nextInt(15);
                                demo+=Xsi.charAt(erzat);
                            }
                        }
                        writer.write(demo+"\n");
                    }
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
