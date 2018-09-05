package com.lynden.example.latlong;

import java.util.Random;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.lynden.example.latlong.Casella;
import com.lynden.gmapsfx.javascript.object.LatLong;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.lang.String;

public class FMappa {
	private String Nome;
	private ArrayList<Percorso> p=new ArrayList<Percorso>();

	public FMappa(ArrayList<Giocatore> g, String NomeMappa) throws FileNotFoundException,IOException {
		this.Nome = NomeMappa;

		ArrayList<Citta> c = this.CreaMappa();



		for (int i=0;i<c.size();i++)
			for(int j=i+1;j<=i+2&&j<c.size() ;j++){
				Percorso p;
				p=new Percorso(i*i+j*j,c.get(i),c.get(j));

				this.AddPercorso(p);
			}





	}

	/**
	 * 
	 * @param Giocatori
	 * @param Nome_Mappa
	 */
	//RITORNA ARRAY SIZE
	public void sizea(){
		System.out.println(p.size());
	}
	public void AddPercorso(Percorso p1){
		this.p.add(p1);
	}
	public ArrayList<Citta> CreaMappa()throws FileNotFoundException,IOException{
		ArrayList<Citta> c1=new ArrayList<Citta>();
		try {

			FileReader fw = new FileReader("citta.json");
			ObjectMapper objectMapper = new ObjectMapper();
			HashMap<String, LatLong> maplat = new HashMap<>();


			com.google.gson.JsonParser jsonParser = new com.google.gson.JsonParser();
			JsonArray object = (JsonArray) jsonParser.parse(fw);
			for (int i = 0; i < object.size(); i++) {
				LatLong l = new LatLong(object.get(i).getAsJsonObject().get("latitude").getAsDouble(),
						object.get(i).getAsJsonObject().get("longitude").getAsDouble());

				maplat.put(object.get(i).getAsJsonObject().get("variableName").toString(), l);
			}

			//Costruzione dei percorsi della mappa DA SPOSTARE IN FUTURO
			for (Map.Entry entry : maplat.entrySet()){
				String nome=(String) entry.getKey();
				String[] nome1 = nome.split(",");
				Citta p= new Citta((String) nome1[0].replace("\"",""),0);
				p.ImpostaCoordinate((LatLong) entry.getValue());
				c1.add(p);
			}
			return c1;
		}

		catch (FileNotFoundException exc) {
			return c1;
		}

	}

	public ArrayList<Percorso> DammiPercorsi() {

	return this.p;

	}

	/**
	 * 
	 * @param Giocatori
	 */
	public void PopolaMappa(ArrayList<Giocatore> giocatores) {
		//DA TESTARE
		for(int i=0; i<giocatores.size();i++){
			Giocatore g=giocatores.get(i);
			FMezzo factory= new FMezzo();
			Vagone v=factory.CreaVagone(g);
			CartaPercorso c1=g.ChiediCartaPercorso();
			for(int j=0;j<this.p.size();j++){
				Percorso p1=p.get(j);
				p1.TrovaPercorso(c1,factory,g);
			}
		}
	}

	/**
	 * 
	 * @param Percorso
	 */
	public void MandamiVicini(int Percorso) {
		// TODO - implement SingletonMappa.MandamiVicini
		throw new UnsupportedOperationException();
	}


	public ArrayList<Citta> getCitta(){
		ArrayList<Citta> c=new ArrayList<Citta>();
		for(int i=0; i<this.p.size();i++) {
			Percorso percorso = p.get(i);
			Citta citta1=percorso.getCittapartenza();
			Citta citta2=percorso.getCittaArrivo();
			c.add(citta1);
			c.add(citta2);
		}
		java.util.Set setta_citta=new HashSet(c);
		ArrayList<Citta> c1=new ArrayList<Citta>(setta_citta);
		return c1;

	}



	}

