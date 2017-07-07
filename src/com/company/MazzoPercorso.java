package com.company;

import java.util.ArrayList;
import java.util.Random;

public class MazzoPercorso extends Mazzo {
        private ArrayList<CartaPercorso> Carte= new ArrayList<CartaPercorso>();
        public MazzoPercorso(ArrayList<Percorso> p) {
            for(int i=0;i<p.size();i++){
                Percorso percorso= p.get(i);
                Citta ca= percorso.getCittaArrivo();
                Citta cp= percorso.getCittapartenza();
                CartaPercorso c1=new CartaPercorso(1,cp.getNome(),ca.getNome());
                this.addCarta((Carta)c1);
            }
                
        }

        @Override 
        public void addCarta(Carta c){
            this.Carte.add((CartaPercorso) c);
        }
        
        @Override
	    public Carta PescaCarta() {
                int num1=this.MischiaMazzo();
		        Carta c=this.Carte.get(num1);
                this.Carte.remove(num1);
                return c;
        }
        
        @Override
	    public int MischiaMazzo() {
               Random r= new Random();
               int num= r.nextInt(this.Carte.size());
               return num;
        }


}