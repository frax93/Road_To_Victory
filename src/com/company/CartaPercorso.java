package com.company;

public class CartaPercorso extends Carta {

	private String CittaPartenza;
	private String CittaArrivo;

    public CartaPercorso(int id1, String CittaPartenza,String CittaArrivo) {
        super(id1);
        this.CittaPartenza=CittaPartenza;
        this.CittaArrivo=CittaArrivo;
    }
    public String getCittaPartenza(){return this.CittaPartenza;}
    public String getCittaArrivo(){return this.CittaArrivo;}


    public void CreaCarta() {
		// TODO - implement CartaPercorso.CreaCarta
		throw new UnsupportedOperationException();
	}

}