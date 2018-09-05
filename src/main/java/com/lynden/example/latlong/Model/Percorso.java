package com.lynden.example.latlong;

import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MVCArray;
import com.lynden.gmapsfx.shapes.Polyline;
import com.lynden.gmapsfx.shapes.PolylineOptions;
import netscape.javascript.JSObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Percorso {
	private int id;
	private Citta Cittapartenza=new Citta();
	private Citta CittaArrivo=new Citta();
        ArrayList<Casella> caselle=new ArrayList<Casella>();
        
        public Percorso(int num, Citta Cp, Citta Ca){
            this.id=num;
            this.CittaArrivo=Ca;
            this.Cittapartenza=Cp;
            this.setCaselle();
        }
        private void setCaselle(){
			   //Valori utilizzati per coordinate casella
			   double err=0.1;
			   double spezzata =0.2;
               double dist= Math.abs(this.Cittapartenza.getDistanza()-this.CittaArrivo.getDistanza());
               LatLong partenza=this.Cittapartenza.getCoordinate();
               LatLong arrivo=this.CittaArrivo.getCoordinate();
			if(arrivo.getLatitude()>partenza.getLatitude()&&arrivo.getLongitude()<partenza.getLongitude()){
				double x=partenza.getLatitude();
				double y=partenza.getLongitude();
				int n= (int) dist/100;
				LatLong resultold=partenza;
				double passo=arrivo.getLatitude()-partenza.getLatitude();
				passo/=n;
				double passo1=partenza.getLongitude()-arrivo.getLongitude();
				passo1/=n;
				int identificativo=0;

				for(double i=x,j=y;i<=arrivo.getLatitude()+err&&j>=arrivo.getLongitude()-err;){
					// System.out.println(l+" "+l1+" "+passo);
					//    System.out.println(i+" "+j);

					LatLong l1= new LatLong(i+spezzata,j+spezzata);
					LatLong[] result={resultold,l1};
					resultold=new LatLong(i,j);
					i=i+passo;
					j=j-passo1;
					Casella c=new Casella(identificativo);
					c.ImpostaCoordinate(resultold,l1);
					this.caselle.add(c);
					identificativo++;

				}
			}
			if(arrivo.getLatitude()>partenza.getLatitude()&&arrivo.getLongitude()>partenza.getLongitude()){
				double x=arrivo.getLatitude();
				double y=arrivo.getLongitude();
				int n= (int) dist/100;
				LatLong resultold=arrivo;
				double passo=partenza.getLatitude()-arrivo.getLatitude();
				passo/=n;
				double passo1=arrivo.getLongitude()-partenza.getLongitude();
				passo1/=n;
				int identificativo=0;

				for(double i=x,j=y;i>=partenza.getLatitude()+err&&j>=partenza.getLongitude()-err;){
					// System.out.println(l+" "+l1+" "+passo);
					//    System.out.println(i+" "+j);

					LatLong l1= new LatLong(i+spezzata,j+spezzata);
					LatLong[] result={resultold,l1};
					resultold=new LatLong(i,j);
					i=i+passo;
					j=j-passo1;
					Casella c=new Casella(identificativo);
					c.ImpostaCoordinate(resultold,l1);
					this.caselle.add(c);
					identificativo++;

				}
			}

			if(arrivo.getLatitude()<partenza.getLatitude()&&arrivo.getLongitude()<partenza.getLongitude()){
				double x=arrivo.getLatitude();
				double y=arrivo.getLongitude();
				int n= (int) dist/100;
				LatLong resultold=arrivo;
				double passo=partenza.getLatitude()-arrivo.getLatitude();
				passo/=n;
				double passo1=arrivo.getLongitude()-partenza.getLongitude();
				passo1/=n;
				int identificativo=0;

				for(double i=x,j=y;i<=partenza.getLatitude()+err&&j<=partenza.getLongitude()-err;){
					// System.out.println(l+" "+l1+" "+passo);
					//    System.out.println(i+" "+j);

					LatLong l1= new LatLong(i+spezzata,j+spezzata);
					LatLong[] result={resultold,l1};
					resultold=new LatLong(i,j);
					i=i+passo;
					j=j-passo1;
					Casella c=new Casella(identificativo);
					c.ImpostaCoordinate(resultold,l1);
					this.caselle.add(c);
					identificativo++;

				}
			}

			if(partenza.getLatitude()>arrivo.getLatitude()&&partenza.getLongitude()<arrivo.getLongitude()){
				double x=arrivo.getLatitude();
				double y=arrivo.getLongitude();
				int n= (int) dist/100;
				LatLong resultold=arrivo;
				double passo=partenza.getLatitude()-arrivo.getLatitude();
				passo/=n;
				double passo1=arrivo.getLongitude()-partenza.getLongitude();
				passo1/=n;
				int identificativo=0;

				for(double i=x,j=y;i<=partenza.getLatitude()+err&&j>=partenza.getLongitude()-err;){
					// System.out.println(l+" "+l1+" "+passo);
					//    System.out.println(i+" "+j);

					LatLong l1= new LatLong(i+spezzata,j+spezzata);
					LatLong[] result={resultold,l1};
					resultold=new LatLong(i,j);
					i=i+passo;
					j=j-passo1;
					Casella c=new Casella(identificativo);
					c.ImpostaCoordinate(resultold,l1);
					this.caselle.add(c);
					identificativo++;

				}
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

		if(c.getCittaPartenza()==this.Cittapartenza&&this.Cittapartenza.getMezzo()==null)
			this.Cittapartenza.PosizionaGiocatore(mez,g);
	}


	//Da vedere se è giusta
	public boolean CheckSuiVicini(Casella c) {
		int pos=1;
		LatLong l= c.getInizio();
		for(int i = 1; i<caselle.size(); i++){
			if((l.getLongitude()==caselle.get(i).getInizio().getLongitude())&&(l.getLatitude()==caselle.get(i).getInizio().getLatitude())){
				pos = i;
			}
		}
		if(caselle.get(pos-1).CheckOccupata() ){
			return  true;
		}
		else return false;
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


	//FUNZIONE CHE DEVE RESTITUIRE 2 CASELLE, UNA INIZIALE E UNA FINALE DEL PERCORSO IN QUESTIONE
	public ArrayList<Casella> getCaselleAntipodi(){
		ArrayList<Casella> c= new ArrayList<>();

		c.add(0,this.getCaselle().get(0));
		c.add(1,this.getCaselle().get(this.getCaselle().size()-1));

		return c;

	}

//Funzione che restituisce le due citta del percorso
	public ArrayList<Citta> getCittas(){
		ArrayList<Citta> cit= new ArrayList<>();
		cit.add(0,getCittapartenza());
		cit.add(1,getCittaArrivo());

		return cit;
	}

}