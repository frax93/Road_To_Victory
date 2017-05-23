package com.company;
public class Casella {
    
        private boolean libera;
        private int id;
        private FMezzo m=null;
	
        public Casella(int id){
            this.id=id;
            this.libera=true;
        }
	public void PosizionaGiocatore(FMezzo Mezzo){
            this.libera=false;
            this.m=Mezzo;
        }

	public boolean CheckOccupata(){
            return this.libera;
        }

}