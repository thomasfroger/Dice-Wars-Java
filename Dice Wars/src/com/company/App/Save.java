// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021



package com.company.App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Save {

    // c'est ici que nous nous occupons de tout ce qui touche la sauvegarde


    //TODO implementer backup.
    private File file ;

    private String filename ;


    public Save(String filename) throws IOException {
        this.filename = filename;
        getFile() ;
    }

    public void write(ArrayList<String> lines) throws IOException {
        String buffer = String.join("\n", lines);
        FileWriter writer = new FileWriter(file) ;
        writer.write(buffer);
        writer.close();
    }

    private File getFile() throws IOException {
        String fileSeparator = System.getProperty("file.separator");
        File directory = new File(System.getProperty("user.home")+fileSeparator+"dicewars");
        if (!directory.exists()) {
            directory.mkdir();
        }
        directory = new File(System.getProperty("user.home")+fileSeparator+"dicewars"+fileSeparator+"sauvegardes");
        if (!directory.exists()) {
            directory.mkdir();
        }
        String filePath = directory + fileSeparator + this.filename + ".txt";
        this.file = new File(filePath) ;
        file.createNewFile();
        return file;
    }

    public ArrayList<String> read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        ArrayList<String> lines = new ArrayList<String>();
        String save;
        do {
            save = reader.readLine();
            if (save != null) {
                lines.add(save);
            }
        }
        while (save != null);
        reader.close();
        return lines;
    }

    public void print() throws IOException {
        System.out.println("***********************************************************************");
        System.out.println("\n"+getFilename()+"\n");
        read().forEach(elt -> System.out.println(elt));
        System.out.println("***********************************************************************");
    }


    public String getFilename() {
        return filename;
    }
}