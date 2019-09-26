package com.nf11.nassim.Model;

import java.io.*;

public class CLfichier {
    private String content;

    public CLfichier(){

    }

    public String getContent(){
        return this.content;
    }

    public void addContent(String line){
        this.content+= line;
    }
    public String lireFichier(String path) {

        String line = "";

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(path);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                addContent(line);
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            path + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + path + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }

        return getContent();
    }

    public void ecrireFichier(String path, String texte) {
        try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(path);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write(texte);

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                    "Error writing to file '"
                            + path + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}