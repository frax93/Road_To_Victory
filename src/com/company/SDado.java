
package com.company;
import java.util.Random;

public class SDado {

	private Random Numero;
        private int lati;
        
        public SDado(){
            this.Numero= new Random();
            this.lati=6;
        }
        
	public int Lancia() {
            int n=1+this.Numero.nextInt(this.lati);
            return n;
	}

}