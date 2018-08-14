package com.lynden.example.latlong;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Partita {

	private int ElencoGiocatori;
	private int NumGiocatori;

	/**
	 * 
	 * @param Giocatori
	 * @param Nome_mappa
	 */
	public void AvviaPartita(ArrayList<Giocatore> Giocatori, String Nome_mappa) throws FileNotFoundException,IOException {
		Iniziale i=new Iniziale();
		i.OrdinaGiocatori(Giocatori);
		i.InizioTurno(Giocatori,Nome_mappa);
		Generale g = new Generale();
		//g.InizioTurno();
	}

	/**
	 * 
	 * @param Giocatore
	 */
	public void LanciaDado(int Giocatore) {
		// TODO - implement Partita.LanciaDado
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Mezzo
	 * @param Giocatore
	 * @param Percorso
	 */
	public void PosizionaMezzo(int Mezzo, int Giocatore, int Percorso) {
		// TODO - implement Partita.PosizionaMezzo
		throw new UnsupportedOperationException();
	}

	public void CheckFinePartita() {
		// TODO - implement Partita.CheckFinePartita
		throw new UnsupportedOperationException();
	}

}