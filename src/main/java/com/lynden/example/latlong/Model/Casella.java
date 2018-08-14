package com.lynden.example.latlong;
import com.lynden.example.latlong.FMezzo;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.sun.tools.javac.tree.JCTree;

public class Casella {
    
        private boolean libera;
        private int id;
        private Mezzo m=null;
        private LatLong inizio;
        private LatLong fine;
	
        public Casella(int id){
            this.id=id;
            this.libera=true;
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
            System.out.println(this.m);
            this.libera=false;
        }
    public void ImpostaCoordinate(LatLong i,LatLong f){
	    this.inizio=i;
	    this.fine=f;
    }

    public int getId() {
        return id;
    }

    public boolean CheckOccupata(){
            return this.libera;
        }

}

