package com.company;

public class Giocatore implements Comparable<Giocatore> {
	private int id;
	private String username;
	private CartaPercorso c;
	@Override
	public int compareTo(Giocatore g){
		int compare=((Giocatore) g).getId();
		return this.id-compare;
	}
	public Giocatore(int id, String u, Carta c){
		this.id=id;
		this.username=u;
		this.c=(CartaPercorso) c;
	}

	public int getId(){
		return this.id;
	}

	public String getUsername(){
		return this.username;
	}

	public void LanciaDado() {
		// TODO - implement Giocatore.LanciaDado
		throw new UnsupportedOperationException();
	}

	public void Posizionamezzo() {
		// TODO - implement Giocatore.Posizionamezzo
		throw new UnsupportedOperationException();
	}

	public void PescaDueCarte() {
		// TODO - implement Giocatore.PescaDueCarte
		throw new UnsupportedOperationException();
	}

	public CartaPercorso ChiediCartaPercorso() {
		return this.c;
	}

	public void ChiediCartaObiettivo() {
		// TODO - implement Giocatore.ChiediCartaObiettivo
		throw new UnsupportedOperationException();
	}

	public void ChiediMezzo() {
		// TODO - implement Giocatore.ChiediMezzo
		throw new UnsupportedOperationException();
	}

	public void ChiediCarte() {
		// TODO - implement Giocatore.ChiediCarte
		throw new UnsupportedOperationException();
	}

}