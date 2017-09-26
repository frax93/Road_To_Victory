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
            this.m=Mezzo;
            this.libera=false;
        }

	public boolean CheckOccupata(){
            return this.libera;
        }

}