package com.nf11.nassim;



public class XOREncryption  {

    private static String encryptDecrypt(String input) {
        char[] key = {'a', 'w', 'q','p','m','n','d','f'}; //Can be any chars, and any length array
        StringBuilder output = new StringBuilder();

        for(int i = 0; i < input.length(); i++) {
            output.append((char) (input.charAt(i) ^ key[i % key.length]));
        }

        return output.toString();
    }
    public static void main(String[] args) {

        String decrypted = XOREncryption.encryptDecrypt("\"\u0012Q\u001EJ\u000B\u0017\u0012G\u0004\u0004\u0019A\u001B\u0014P\u000F\u0001\n" +
                "F\u0001\u001D\u0006\u0002\b\u0012\u0003^M'\bF\u0001\u0015\u0010\u001EA\u0014\u0019\u0015\u001F\n" +
                "\f\u0003\u0015T\u0004\u0003\n" +
                "\u001B\u0014\u0005\u001F\u001DJ");
        System.out.println("Decrypted:" + decrypted);
    }

    }
