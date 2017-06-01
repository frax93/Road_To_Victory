package com.company;
import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
	
        Citta ca=new Citta("Roma");
        Citta cb=new Citta("Milano");
        Citta cc=new Citta("Parigi");
        Citta cd=new Citta("Madrid");
        Citta ce=new Citta("Londra");
        Citta cf=new Citta("Berlino");
        Citta cg=new Citta("Monaco");
        ArrayList<Citta> c1=new ArrayList<Citta>();
        c1.add(ca);
        c1.add(cb);
        c1.add(cc);
        c1.add(cd);
        c1.add(ce);
        c1.add(cf);
        c1.add(cg);
        MazzoObiettivo m=new MazzoObiettivo(c1);
        FileReader fw = new FileReader("ciao.txt");
        BufferedReader b=new BufferedReader(fw);
        HashMap x= new HashMap();
        while(b.readLine()!=null){
            x.put(b.readLine(),b.readLine() );
            System.out.println(x);
        }


    }
    }

