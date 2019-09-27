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

    public String decrypter(String input, String keys) {
        char[] key = keys.toCharArray(); //Can be any chars, and any length array
        StringBuilder output = new StringBuilder();

        for(int i = 0; i < input.length(); i++) {
            output.append((char) (input.charAt(i) ^ key[i % key.length]));
        }

        return output.toString();
    }
}