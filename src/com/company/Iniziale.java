package com.company;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Iniziale implements iTurno {
	@Override
	public void InizioTurno(ArrayList<Giocatore> g, String nomeMappa)throws FileNotFoundException,IOException{
		FMappa m= new FMappa(g,nomeMappa);
		MazzoPercorso m1=new MazzoPercorso();
		m1=m1.getIstance(m.DammiPercorsi());
		MazzoObiettivo m2 = new MazzoObiettivo();
		m2=m2.getIstance(m.getCitta());
		for(int i=0;i<g.size();i++)
			g.get(i).PescaDueCarte();
		m.PopolaMappa(g);

	}
	@Override
	public void Termina_Turno() {
		// TODO - implement Iniziale.Termina_Turno
		throw new UnsupportedOperationException();
	}
	@Override
	public ArrayList<Giocatore> OrdinaGiocatori(ArrayList<Giocatore> g) {
		Collections.sort(g);
		return g;

	}

}