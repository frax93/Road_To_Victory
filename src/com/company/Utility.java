package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Utility {
    private ArrayList<Citta> c=null;
    public Utility(){

    }
    public void inizializza() throws FileNotFoundException, IOException {
        /*Classe configurazione*/
        ArrayList<Citta> c1=new ArrayList<Citta>();
        try {

            FileReader fw = new FileReader("ciao.txt");
            BufferedReader b=new BufferedReader(fw);
            HashMap x= new HashMap();
            while(b.readLine()!=null){
                x.put(Integer.parseInt(b.readLine()),b.readLine() );

            }
            Map<Integer, String> tree = new TreeMap<Integer, String>(x);
            //Costruzione dei percorsi della mappa DA SPOSTARE IN FUTURO
            for (Map.Entry entry : tree.entrySet()){
                Citta p= new Citta((String)entry.getValue(),(int)entry.getKey());
                c1.add(p);
            }
            this.c=c1;
        }

        catch (FileNotFoundException exc) {
            this.c=c1;
        }

    }

    public ArrayList<Citta> getC() throws FileNotFoundException,IOException {
        this.inizializza();
        return this.c;
    }
}