package com.company;
import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        ArrayList<Citta> c1=new ArrayList<Citta>();

        MazzoObiettivo m=new MazzoObiettivo(c1);
        FileReader fw = new FileReader("ciao.txt");
        BufferedReader b=new BufferedReader(fw);
        HashMap x= new HashMap();
        while(b.readLine()!=null){
            x.put(Integer.parseInt(b.readLine()),b.readLine() );

        }
        Map<Integer, String> tree = new TreeMap<Integer, String>(x);
        //Costruzione dei percorsi della mappa
        for (Map.Entry entry : tree.entrySet()){
            Citta p= new Citta((String)entry.getValue());
            c1.add(p);
        }
        FMappa m1=new FMappa();
        for (int i=0;i<c1.size()-4;i++)
            for(int j=i+1;j<=i+4 ;j++){
                Percorso p;
                p=new Percorso(i,c1.get(i),c1.get(j));
                System.out.println(p.getCittapartenza().getNome());
                System.out.println(p.getCittaArrivo().getNome());
                m1.AddPercorso(p);
        }

        }





    }


