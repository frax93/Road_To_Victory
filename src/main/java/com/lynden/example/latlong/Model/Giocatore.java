package com.lynden.example.latlong;

import com.lynden.example.latlong.FMezzo;
import com.lynden.example.latlong.Mezzo;

import java.util.ArrayList;

public class Giocatore implements Comparable<Giocatore>,Runnable {
	private int id;
	private String username;
	private CartaPercorso c=null;
	private CartaObiettivo c1=null;
	private ArrayList<Mezzo> mezzo=null;
	@Override
	public int compareTo(Giocatore g){
		int compare=((Giocatore) g).getId();
		return this.id-compare;
	}
	@Override
	public void run(){
		//this.Posizionamezzo();
	}
	public Giocatore(int id, String u){
		this.id=id;
		this.username=u;

	}

	public int getId(){
		return this.id;
	}

	public String getUsername(){
		return this.username;
	}

	public int LanciaDado() {
		SDado dado=new SDado();
		dado=dado.getIstance();
		return dado.Lancia();

	}
	public void setMezzo(int taglia){
		this.mezzo=new ArrayList<Mezzo>();
		FMezzo factorymezzo=new FMezzo();
		for(int i=0;i<taglia;i++){
			this.mezzo.add(factorymezzo.CreaVagone(this));
		}


	}

	public ArrayList<Mezzo> getMezzo() {
		return mezzo;
	}

	public void PescaDueCarte() {
		MazzoObiettivo m= new MazzoObiettivo();
		m=m.getIstance1();
		this.c1=(CartaObiettivo)m.PescaCarta();
		MazzoPercorso m1= new MazzoPercorso();
		m1=m1.getIstance1();
		this.c=(CartaPercorso)m1.PescaCarta();

	}


	public CartaPercorso ChiediCartaPercorso() {
		return this.c;
	}

	public CartaObiettivo ChiediCartaObiettivo() {
		return this.c1;
	}

	public void ChiediMezzo() {
		// TODO - implement Giocatore.ChiediMezzo
		throw new UnsupportedOperationException();
	}

	public void ChiediCarte() {
		// TODO - implement Giocatore.ChiediCarte
		throw new UnsupportedOperationException();
	}

	public void PosizionaMezzo(Casella c) {

		int pos=this.mezzo.size()-1;
		c.PosizionaGiocatore(this);
		if(pos==0) this.mezzo=null;
		else this.mezzo.remove(pos);


	}
}