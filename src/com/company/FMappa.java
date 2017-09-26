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

	public ArrayList<Percorso> DammiPercorsi() {
		return this.p;
	}

	/**
	 * 
	 * @param Giocatori
	 */
	public void PopolaMappa(ArrayList<Giocatore> giocatores) {
		//DA TESTARE
		for(int i=0; i<giocatores.size();i++){
			Giocatore g=giocatores.get(i);
			FMezzo factory= new FMezzo();
			Vagone v=factory.CreaVagone(g);
			CartaPercorso c1=g.ChiediCartaPercorso();
			for(int j=0;j<this.p.size();j++){
				Percorso p1=p.get(j);
				p1.TrovaPercorso(c1,factory,g);
			}
		}
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