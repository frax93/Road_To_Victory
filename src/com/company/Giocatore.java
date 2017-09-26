package com.company;

public class Giocatore {
	private int id;
	private String username;
	private CartaPercorso c;

	public Giocatore(int id, String u, CartaPercorso c){
		this.id=id;
		this.username=u;
		this.c=c;
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