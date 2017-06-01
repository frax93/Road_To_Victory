package com.company;

public class Citta {

	private String Nome;
	private int distanza;
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
	public void PosizionaGiocatore(int Mezzo) {
		// TODO - implement Citta.PosizionaGiocatore
		throw new UnsupportedOperationException();
	}

	public void CheckOccupata() {
		// TODO - implement Citta.CheckOccupata
		throw new UnsupportedOperationException();
	}

	public int getDistanza(){
		return this.distanza;
	}

}