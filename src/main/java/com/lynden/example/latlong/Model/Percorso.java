package com.lynden.example.latlong;

import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MVCArray;
import com.lynden.gmapsfx.shapes.Polyline;
import com.lynden.gmapsfx.shapes.PolylineOptions;
import netscape.javascript.JSObject;

import java.util.ArrayList;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.sun.org.apache.bcel.internal.generic.FLOAD;
import java.util.Calendar;
import java.util.Random;

public class Percorso {
	private int id;
	private Citta Cittapartenza=new Citta();
	private Citta CittaArrivo=new Citta();
	public static int identificativo=0;
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



	public boolean CheckSuiVicini(Casella c) {
		int pos=1;
		for(int i = 0; i<caselle.size(); i++){

			if(c.getId()==caselle.get(i).getId()){
				pos = i;

			}
		}
		if(caselle.get(1).CheckOccupata()&&(caselle.get(1).getId()-1==c.getId()||caselle.get(1).getId()+1==c.getId())){
			return true;
		}
		else if((caselle.get(pos-1).CheckOccupata()||caselle.get(pos+1).CheckOccupata())
				&&((caselle.get(pos-1).getId()+1==c.getId()||caselle.get(pos+1).getId()-1==c.getId())||
				(caselle.get(pos-1).getId()-1==c.getId()||caselle.get(pos+1).getId()+1==c.getId()))){
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

	/*******Funzione che permette di capire come è posizionato il percorso, e dove si trova la casella di partenza
	 * in questo modo possiamo distinguere i vicini di arrivo e partenza del percorso. Va fatta un check vicini partenza e un cech vicini coda.*****/

	public Casella CalcolaCaselleVicine(Casella casella){
		if(casella.getId()==this.caselle.get(0).getId()&&(!this.caselle.get(1).CheckOccupata())){
			return this.caselle.get(1);
		}
		else if (casella.getId()==this.caselle.get(this.caselle.size()-1).getId()&&(!this.caselle.get(this.caselle.size()-2).CheckOccupata())){

			return this.caselle.get(this.caselle.size()-2);
		}
		else{
			int pos=1;
			for(int i = 0; i<caselle.size(); i++){

				if(casella.getId()==caselle.get(i).getId()){
					pos = i;

				}
			}

			if(pos>0 && pos<caselle.size()-1){
				if (!this.caselle.get(pos + 1).CheckOccupata())
					return this.caselle.get(pos + 1);
				else if (!this.caselle.get(pos - 1).CheckOccupata())
					return this.caselle.get(pos - 1);
			}
			else if (pos==0){
				return this.caselle.get(0);

			}
			else{
				return this.caselle.get(this.caselle.size()-1);
			}
		}
		return null;

	}

	public Casella getCasellaPartenza(){
		double R = 6372.795477598;  //Con errore dello 0.3%

		double k= 2* 3.14/360;
		Casella casellaPartenza = new Casella(0);

		double distCasella0 = R* Math.acos(Math.sin(this.getCaselle().get(0).getInizio().getLatitude()*k) * Math.sin(53.3498053*k) +
				Math.cos(this.getCaselle().get(0).getInizio().getLatitude()*k) * Math.cos(53.3498053*k) * Math.cos(this.getCaselle().get(0).getInizio().getLongitude()*k-(-6.260309699999993*k)));

		double distCasellaN = R* Math.acos(Math.sin(this.getCaselle().get(this.getCaselle().size()-1).getInizio().getLatitude()*k) * Math.sin(53.3498053*k) +
				Math.cos(this.getCaselle().get(this.getCaselle().size()-1).getInizio().getLatitude()*k) * Math.cos(53.3498053*k) * Math.cos(this.getCaselle().get(this.getCaselle().size()-1).getInizio().getLongitude()*k-(-6.260309699999993*k)));

		double distCittaPartenza = R* Math.acos(Math.sin(this.getCittapartenza().getCoordinate().getLatitude()*k) * Math.sin(53.3498053*k) +
				Math.cos(this.getCittapartenza().getCoordinate().getLatitude()*k) * Math.cos(53.3498053*k) * Math.cos(this.getCittapartenza().getCoordinate().getLongitude()*k-(-6.260309699999993*k)));

		if(Math.abs(distCittaPartenza-distCasella0)<= Math.abs(distCittaPartenza-distCasellaN)){
			casellaPartenza= this.getCaselle().get(0);
		}
		else if(Math.abs(distCittaPartenza-distCasella0)> Math.abs(distCittaPartenza-distCasellaN)){
			casellaPartenza= this.getCaselle().get(this.getCaselle().size()-1);
		}
		//System.out.println(distCittaPartenza);
		//System.out.println(distCasella0);
		//System.out.println(distCasellaN);
		return casellaPartenza;
	}
	public Casella getCasellaPerVicino(Casella casella_iniziale){
		double R = 6372.795477598;  //Con errore dello 0.3%

		double k= 2* 3.14/360;
		Casella casella_vicina = new Casella(0);

		double distCasella0 = R* Math.acos(Math.sin(this.getCaselle().get(0).getInizio().getLatitude()*k) * Math.sin(53.3498053*k) +
				Math.cos(this.getCaselle().get(0).getInizio().getLatitude()*k) * Math.cos(53.3498053*k) * Math.cos(this.getCaselle().get(0).getInizio().getLongitude()*k-(-6.260309699999993*k)));

		double distCasellaN = R* Math.acos(Math.sin(this.getCaselle().get(this.getCaselle().size()-1).getInizio().getLatitude()*k) * Math.sin(53.3498053*k) +
				Math.cos(this.getCaselle().get(this.getCaselle().size()-1).getInizio().getLatitude()*k) * Math.cos(53.3498053*k) * Math.cos(this.getCaselle().get(this.getCaselle().size()-1).getInizio().getLongitude()*k-(-6.260309699999993*k)));

		double distCasella_iniziale = R* Math.acos(Math.sin(casella_iniziale.getInizio().getLatitude()*k) * Math.sin(53.3498053*k) +
				Math.cos(casella_iniziale.getInizio().getLatitude()*k) * Math.cos(53.3498053*k) * Math.cos(casella_iniziale.getInizio().getLongitude()*k-(-6.260309699999993*k)));

		if(Math.abs(distCasella_iniziale-distCasella0)<= Math.abs(distCasella_iniziale-distCasellaN)){
			casella_vicina= this.getCaselle().get(0);
		}
		else if(Math.abs(distCasella_iniziale-distCasella0)> Math.abs(distCasella_iniziale-distCasellaN)){
			casella_vicina= this.getCaselle().get(this.getCaselle().size()-1);
		}
		//System.out.println(distCittaPartenza);
		//System.out.println(distCasella0);
		//System.out.println(distCasellaN);
		return casella_vicina;
	}

	public Casella getCasellaArrivo(){
		double R = 6372.795477598;  //Con errore dello 0.3%

		double k= 2* 3.14/360;
		Casella casellaArrivo = new Casella(0);

		double distCasella0 = R* Math.acos(Math.sin(this.getCaselle().get(0).getInizio().getLatitude()*k) * Math.sin(53.3498053*k) +
				Math.cos(this.getCaselle().get(0).getInizio().getLatitude()*k) * Math.cos(53.3498053*k) * Math.cos(this.getCaselle().get(0).getInizio().getLongitude()*k-(-6.260309699999993*k)));

		double distCasellaN = R* Math.acos(Math.sin(this.getCaselle().get(this.getCaselle().size()-1).getInizio().getLatitude()*k) * Math.sin(53.3498053*k) +
				Math.cos(this.getCaselle().get(this.getCaselle().size()-1).getInizio().getLatitude()*k) * Math.cos(53.3498053*k) * Math.cos(this.getCaselle().get(this.getCaselle().size()-1).getInizio().getLongitude()*k-(-6.260309699999993*k)));

		double distCittaArrivo = R* Math.acos(Math.sin(this.getCittaArrivo().getCoordinate().getLatitude()*k) * Math.sin(53.3498053*k) +
				Math.cos(this.getCittaArrivo().getCoordinate().getLatitude()*k) * Math.cos(53.3498053*k) * Math.cos(this.getCittaArrivo().getCoordinate().getLongitude()*k-(-6.260309699999993*k)));

		if(Math.abs(distCittaArrivo-distCasella0)<= Math.abs(distCittaArrivo-distCasellaN)){
			casellaArrivo= this.getCaselle().get(0);
		}
		else if(Math.abs(distCittaArrivo-distCasella0)> Math.abs(distCittaArrivo-distCasellaN)){
			casellaArrivo= this.getCaselle().get(this.getCaselle().size()-1);
		}
		//System.out.println(distCittaPartenza);
		//System.out.println(distCasella0);
		//System.out.println(distCasellaN);
		return casellaArrivo;

	}






}