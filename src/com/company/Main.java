package com.company;

import java.util.*;
import java.io.*;
import java.net.URL;
import javax.ws.rs.core.Response;
//import com.fasterxml.jackson.*;
import com.jayway.jsonpath.*;
import javafx.beans.binding.Bindings;

public class Main {

    public static String[] main(String[] args) throws FileNotFoundException, IOException {
       //MAZZI Sono stati già messi Singleton e pure il Dado E FUNZIONANO
        Giocatore g1=new com.company.Giocatore(12,"Scandalo1");
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


        String address="";
        String county="";
        address = address.replace(",", "+");
        address = address.replace(" ", "+");
        county = county.replace(" ", "");

        String fullAddress = address+"+"+county;
        System.out.println(fullAddress);

        URL url = new URL("http://maps.google.com/maps/api/geocode/json?address="+fullAddress+"&sensor=false");


        Response res = given().when().get(url);
        JsonPath jp = new JsonPath(res.asString());

        String lat = jp.get("results.geometry.location.lat").toString();
        String lng = jp.get("results.geometry.location.lng").toString();

        String[] location = new String[2];
        location[0] = lat;
        location[1] = lng;

        return location;


        }




}


