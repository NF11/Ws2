package com.nf11.nassim.Model;

public class CLcrypt {

    public CLcrypt() {

    }

    public String m_crypt(String inputString, String key)
    {
        String encrypted = "";
        int keyit = 0;
        for (int i=0 ; i<inputString.length() ;i++ ){
            int temp = inputString.charAt(i) ^ key.charAt(keyit);
            encrypted+= String.format("%02x" , (byte)temp);
            keyit++;
            if (keyit >= key.length()){
                keyit = 0 ;
            }
        }

        return encrypted;
    }
}