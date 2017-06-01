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
            //this.setCaselle();
        }
        private void setCaselle(){
               Random r= new Random();
               int num= r.nextInt(8-14);
               
            
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
	public void TrovaPercorso(int CartaPercorso, int Mezzo) {
		// TODO - implement Percorso.TrovaPercorso
		throw new UnsupportedOperationException();
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
	public Citta getCittapartenza(){
		return this.Cittapartenza;
	}
	public Citta getCittaArrivo(){
		return this.CittaArrivo;
	}

}