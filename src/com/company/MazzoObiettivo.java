package com.company;
import Design.*;
import java.util.ArrayList;
import java.util.Random;

public class MazzoObiettivo extends Mazzo {

    /**
     *
     * @param Cit
     */
    public MazzoObiettivo(ArrayList<Citta> Cit) {
            super(Cit.size());
            for(int i=0;i<Cit.size();i++){
                Citta c= Cit.get(i);
                CartaObiettivo c1;
                c1=new CartaObiettivo(i, c.getNome());
                this.addCarta(c1);
            }
                
        }
        @Override 
        public void addCarta(CartaObiettivo c){
            super.Carte.add(c);
        }
        @Override
	public CartaObiettivo PescaCarta() {
                int num1=this.MischiaMazzo();
		CartaObiettivo c=super.Carte.get(num1);
                super.Carte.remove(num1);
                return c;
               
	}
        @Override
	public int MischiaMazzo() {
               Random r= new Random();
               int num= r.nextInt(super.Carte.size());
               return num;
	}

	/**
	 * 
	 * @param Mappa
	 *//*
	public MazzoObiettivo CreaMazzo(int Mappa) {
		// TODO - implement MazzoObiettivo.CreaMazzo
		throw new UnsupportedOperationException();
	}*/

}