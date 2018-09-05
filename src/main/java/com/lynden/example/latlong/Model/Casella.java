package com.lynden.example.latlong;
import com.lynden.example.latlong.Percorso;
import com.lynden.gmapsfx.javascript.object.LatLong;

import java.util.ArrayList;

public class Casella {
    
        private boolean occupata;
        private int id;
        private Mezzo m=null;
        private LatLong inizio;
        private LatLong fine;
	
        public Casella(int id){
            this.id=id;
            this.occupata=false;
            this.inizio=null;
            this.fine=null;
        }


    public LatLong getInizio() {
        return inizio;
    }

    public LatLong getFine() {
        return fine;
    }

    public void PosizionaGiocatore(Giocatore g){
            this.m=(Mezzo)g.getMezzo().get(g.getMezzo().size()-1);

            this.occupata=true;
        }
    public void ImpostaCoordinate(LatLong i,LatLong f){
	    this.inizio=i;
	    this.fine=f;
    }

    public int getId() {
        return id;
    }

    public boolean CheckOccupata(){
            return this.occupata;
        }
    }

   /* public void getIdPadre(FMappa f){
        int id=0;
        ArrayList<Percorso> per = null;
        per = f.DammiPercorsi();

        for(int i =0; i<per.size(); i++){
            Percorso p= per.get(i);
            ArrayList<Casella> cas = p.getCaselle();
            for (int j = 0; j < cas.size(); j++) {

            }
        }






    }*/




