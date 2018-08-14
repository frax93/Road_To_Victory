package com.company;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Generale implements iTurno {
	@Override
	public void InizioTurno(ArrayList<Giocatore> g, String nomeMappa) throws FileNotFoundException,IOException {
		// TODO - implement Generale.InizioTurno
		throw new UnsupportedOperationException();
	}
	@Override
	public void Fineturno() {
		// TODO - implement Generale.Termina_Turno
		throw new UnsupportedOperationException();
	}
	@Override
	public  ArrayList<Giocatore> OrdinaGiocatori(ArrayList<Giocatore> g){
		// TO Implement
		return g;
	}

}