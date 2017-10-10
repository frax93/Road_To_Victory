package com.company;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//import java.Time;


public interface iTurno {

	public abstract void InizioTurno(ArrayList<Giocatore> g,String nomeMappa) throws FileNotFoundException,IOException;
	public abstract void Termina_Turno();
	public abstract ArrayList<Giocatore> OrdinaGiocatori(ArrayList<Giocatore> g);
	//Coda dei giocatori
	/*private final BlockingQueue<Runnable> turno =
			new ArrayBlockingQueue<Runnable>(2, true);
	private int Numero_Turno;
	//Thread contemporanei solo 1 perchè è solo un giocatore per turno
	private final ExecutorService sportello =
			Executors.newFixedThreadPool(1);

	public void InizioTurno(Giocatore g) {
		/*new Thread(new Runnable() {
			public void run() {
				for (;;) {
					try {
						// prendo e rimuovo il primo elemento
						// della coda e lo mando allo sportello
						g.LanciaDado();
						sportello.execute(turno.take());
					} catch (InterruptedException e) {
						// ..continuo
					}
				}
			}
		}).start();
	}*/

}