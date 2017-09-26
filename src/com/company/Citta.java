package com.company;

public class Citta {

	private String Nome;
	private int distanza;
	private Vagone mezzo=null;
        public Citta() {
           this.Nome="";
           this.distanza=0;
        }
        public Citta(String Nome,int dist){
            this.Nome=Nome;
            this.distanza=dist*dist;
        }
        public String getNome(){
            return this.Nome;
        }
	public void DammiCittàPartenza() {
		// TODO - implement Citta.DammiCittàPartenza
		throw new UnsupportedOperationException();
	}

	public void DammiCittàArrivo() {
		// TODO - implement Citta.DammiCittàArrivo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Mezzo
	 */
	public void PosizionaGiocatore(FMezzo Mezzo, Giocatore g) {
		this.mezzo=Mezzo.CreaVagone(g);
	}
	public Vagone getMezzo(){
		return this.mezzo;
	}

	public void CheckOccupata() {
		// TODO - implement Citta.CheckOccupata
		throw new UnsupportedOperationException();
	}

	public int getDistanza(){
		return this.distanza;
	}

}