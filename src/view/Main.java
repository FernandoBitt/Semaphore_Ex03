package view;

import java.util.concurrent.Semaphore;

import controller.Carro;
import controller.ThreadFormula1;

public class Main {

	public static void main(String[] args) {
		
		int permissoes = 5;
		Semaphore semaforo = new Semaphore(permissoes);
		Semaphore semaforoPodio = new Semaphore(1);
		
		for(int idCarro=0; idCarro<14; idCarro++) {
			Carro carro = new Carro();
			Thread tFormula = new ThreadFormula1(idCarro, semaforo, carro, semaforoPodio);
			tFormula.start();
		}
		
		
	}

}
