package com.company;
import Design.*;
import java.util.ArrayList;
import java.util.Random;

public class MazzoObiettivo extends Mazzo {
    private ArrayList<CartaObiettivo> Carte= new ArrayList<CartaObiettivo>();
    /**
     *
     * @param Cit
     */
        public MazzoObiettivo(ArrayList<Citta> Cit) {
            for(int i=0;i<Cit.size();i++){
                Citta c= Cit.get(i);
                CartaObiettivo c1;
                c1=new CartaObiettivo(i, c.getNome());
                this.addCarta(c1);
            }
                
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

	  /* CANCELLARE IN FUTURO
	   public void stampacarte(){
            for(int i=0;i<this.Carte.size();i++){
                String c=this.Carte.get(i).getNome();
                System.out.println(c);
            }
        }*/

}