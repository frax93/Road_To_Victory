package com.company;
import java.util.ArrayList;

public class FMappa {

	private ArrayList<Percorso> p=new ArrayList<Percorso>();
        
        public FMappa(){
			//Istanzia i percorsi e li mette nell'arrayList
            Mazzo m;
            //m= new Mazzo(NumCitta);
        }
	/**
	 * 
	 * @param Giocatori
	 * @param Nome_Mappa
	 */
	//RITORNA ARRAY SIZE
	public void sizea(){
		System.out.println(p.size());
	}
	public void AddPercorso(Percorso p1){
		this.p.add(p1);
	}
	public void Mappa(int Giocatori, int Nome_Mappa) {
		// TODO - implement SingletonMappa.CreaMappa
		throw new UnsupportedOperationException();
	}

	public void DammiPercorsi() {
		// TODO - implement SingletonMappa.DammiPercorsi
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Giocatori
	 */
	public void PopolaMappa(int Giocatori) {
		// TODO - implement SingletonMappa.PopolaMappa
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Percorso
	 */
	public void MandamiVicini(int Percorso) {
		// TODO - implement SingletonMappa.MandamiVicini
		throw new UnsupportedOperationException();
	}

}