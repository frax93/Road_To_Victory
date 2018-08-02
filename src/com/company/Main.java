package com.company;
import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
       //MAZZI Sono stati già messi Singleton e pure il Dado E FUNZIONANO PORCA PUTTANA
        Giocatore g1=new Giocatore(12,"Scandalo1");
        Giocatore g2=new Giocatore(13,"Ghista1");
        Giocatore g3=new Giocatore(2,"Scandalo");
        Giocatore g4=new Giocatore(1,"Ghista");
        FMezzo factory= new FMezzo();
        factory.CreaVagone(g1);
        factory.CreaVagone(g2);
        ArrayList<Giocatore> giocatore = new ArrayList<Giocatore>();
        giocatore.add(g1);
        giocatore.add(g2);
        FMezzo factory1= new FMezzo();
        factory1.CreaVagone(g3);
        factory1.CreaVagone(g4);
        giocatore.add(g3);
        giocatore.add(g4);
        Partita partita = new Partita();
        partita.AvviaPartita(giocatore,"Europa");


        }





    }


