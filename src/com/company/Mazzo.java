package com.company;
import java.util.ArrayList;


public abstract class Mazzo {

	private int NumCarte;
	ArrayList<CartaObiettivo> Carte= new ArrayList<CartaObiettivo>();
	public Mazzo(int NumCarte){
            this.NumCarte=NumCarte;
        }
	public abstract void addCarta(CartaObiettivo c);
	public  abstract int MischiaMazzo();

	public abstract CartaObiettivo PescaCarta();
	/**
	 * 
	 * @param Mappa
	 */
	/*public Mazzo CreaMazzo(int Mappa) {
		// TODO - implement Mazzo.CreaMazzo
		throw new UnsupportedOperationException();
	}

	public void PopolaMazzo() {
		// TODO - implement Mazzo.PopolaMazzo
		throw new UnsupportedOperationException();
	}*/

}