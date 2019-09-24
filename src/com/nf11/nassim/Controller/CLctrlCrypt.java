package com.nf11.nassim.Controller;

import com.nf11.nassim.Model.*;

public class CLctrlCrypt {

    public void ecrireFichierSimple(String path, String texte) {
        CLfichier fichier = new CLfichier();
        fichier.ecrireFichier(path, texte);
    }

    public String lireFichierSimple(String path) {
        CLfichier fichier = new CLfichier();
        return fichier.lireFichier(path);
    }

    public String crypter(String texte, String key) {
        CLcrypt cLcrypt = new CLcrypt();
        return cLcrypt.m_crypt(texte, key);
    }

    public String decrypter(String f, String key) {
        String hexiToDeci = "";
        String decrypText = "";


        for (int i = 0; i < f.length() - 1; i += 2) {

            String output = f.substring(i, i + 2);

            int decimal = Integer.parseInt(output, 16);

            hexiToDeci += (char) decimal;

        }
        // Decrypt with XOR
        int keyItr = 0;
        for (int i = 0; i < hexiToDeci.length(); i++) {
            // XOR
            int temp = hexiToDeci.charAt(i) ^ key.charAt(keyItr);
            decrypText += (char) temp;
            keyItr++;
            if (keyItr == key.length()) {
                keyItr = 0;
            }
        }

        return decrypText;
    }
}