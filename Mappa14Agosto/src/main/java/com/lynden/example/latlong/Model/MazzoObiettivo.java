package com.lynden.example.latlong;

import java.util.ArrayList;
import java.util.Random;

public class MazzoObiettivo extends Mazzo {
    private static MazzoObiettivo istance = null;
    private ArrayList<CartaObiettivo> Carte= new ArrayList<CartaObiettivo>();
    /**
     *
     * @param Cit
     */
    public static MazzoObiettivo getIstance(ArrayList<Citta> Cit){
        if(istance==null){
            istance = new MazzoObiettivo();
            for(int i=0;i<Cit.size();i++){
                Citta c= Cit.get(i);
                CartaObiettivo c1;
                c1=new CartaObiettivo(i, c.getNome());
                istance.addCarta(c1);
            }
        }
        return istance;
    }
    public static MazzoObiettivo getIstance1(){
        return istance;
    }
    protected MazzoObiettivo(){

    }
        @Override
        public void addCarta(Carta c){
            this.Carte.add((CartaObiettivo) c);
        }
        @Override
        public Carta PescaCarta() {
                int num1=this.MischiaMazzo();
		        CartaObiettivo c=this.Carte.get(num1);
                this.Carte.remove(num1);
                return c;
               
	    }
        @Override
	    public int MischiaMazzo() {
               Random r= new Random();
               int num= r.nextInt(this.Carte.size());
               return num;
	    }
	    public int getCarte(){return this.Carte.size();}

	  /* CANCELLARE IN FUTURO
	   public void stampacarte(){
            for(int i=0;i<this.Carte.size();i++){
                String c=this.Carte.get(i).getNome();
                System.out.println(c);
            }
        }*/

}