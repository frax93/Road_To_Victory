package com.lynden.example.latlong;

public class CartaObiettivo extends Carta {

	private String CittaObiettivo;

        public CartaObiettivo(int id1, String CittaObiettivo) {
            super(id1);
            this.CittaObiettivo=CittaObiettivo;
            
        }
        public String getNome(){
            return this.CittaObiettivo;
        }

	public void CreaCarta() {
		// TODO - implement CartaObiettivo.CreaCarta
		throw new UnsupportedOperationException();
	}

}