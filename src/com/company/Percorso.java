package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Percorso {

	private int id;
	private Citta Cittapartenza=new Citta();
	private Citta CittaArrivo=new Citta();
        ArrayList<Casella> caselle=new ArrayList<Casella>();
        
        public Percorso(int id, Citta Cp, Citta Ca){
            this.id=id;
            this.CittaArrivo=Ca;
            this.Cittapartenza=Cp;
            this.setCaselle();
        }
        private void setCaselle(){
               int dist= (int) Math.sqrt(Math.abs(this.Cittapartenza.getDistanza()-this.CittaArrivo.getDistanza()));
               //Creare caselle in base a dist
				for(int i=0;i<dist/50;i++){
					Casella c=new Casella(i);
					this.caselle.add(c);
				}
               
            
        }

	public Percorso ChiediPercorso() {
		// TODO - implement Percorso.ChiediPercorso
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param CartaPercorso
	 * @param Mezzo
	 */
	public void TrovaPercorso(CartaPercorso c, FMezzo mez,Giocatore g) {
		//PER IL MOMENTO usiamo stringhe come identificativo citta!
		if(c.getCittaPartenza()==this.Cittapartenza.getNome()&&this.Cittapartenza.getMezzo()==null)
			this.Cittapartenza.PosizionaGiocatore(mez,g);
	}

	public void CheckSuiVicini() {
		// TODO - implement Percorso.CheckSuiVicini
		throw new UnsupportedOperationException();
	}

	public void checkPosizionaMezzo() {
		// TODO - implement Percorso.checkPosizionaMezzo
		throw new UnsupportedOperationException();
	}

	public void ControlloFinePartita() {
		// TODO - implement Percorso.ControlloFinePartita
		throw new UnsupportedOperationException();
	}

	public void CheckFinePartita() {
		// TODO - implement Percorso.CheckFinePartita
		throw new UnsupportedOperationException();
	}

	//ritorna citta partenza o arrivo
	public int getid(){
		return this.id;
	}
	public Citta getCittapartenza(){
		return this.Cittapartenza;
	}
	public Citta getCittaArrivo(){
		return this.CittaArrivo;
	}
	public ArrayList<Casella> getCaselle(){
		return this.caselle;
	}

}