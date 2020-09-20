package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Semaphore;

public class ThreadFormula1 extends Thread{
	
	private int idCarro;
	Semaphore semaforo, semaforoPodio;
	Carro carro;
	private static int contador;
	
	static ArrayList <Carro> podio = new ArrayList<Carro>();

	public ThreadFormula1(int idCarro,Semaphore semaforo, Carro carro, Semaphore semaforoPodio) {
		this.idCarro=idCarro;
		this.semaforo=semaforo;
		this.carro=carro;
		this.semaforoPodio=semaforoPodio;
	}
	
	@Override
	public void run() {
		defineEscuderia();
		try {
			semaforo.acquire();
			correrVolta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		
		try {
			semaforoPodio.acquire();
			podio();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforoPodio.release();
		}
		
	}



	private void defineEscuderia() {
		if (idCarro == 0 || idCarro == 1) {
			carro.setNumero(idCarro);
			carro.setEscuderia("Ferrari");
		}else if(idCarro==2 || idCarro==3) {
			carro.setNumero(idCarro);
			carro.setEscuderia("Mercedes");
		}else if(idCarro==4 || idCarro==5) {
			carro.setNumero(idCarro);
			carro.setEscuderia("McLaren");
		}else if(idCarro==6 || idCarro==7) {
			carro.setNumero(idCarro);
			carro.setEscuderia("Willians");
		}else if(idCarro==8 || idCarro==9) {
			carro.setNumero(idCarro);
			carro.setEscuderia("Renault");
		}else if(idCarro==10 || idCarro==11) {
			carro.setNumero(idCarro);
			carro.setEscuderia("Red Bull");
		}else if(idCarro==12 || idCarro==13) {
			carro.setNumero(idCarro);
			carro.setEscuderia("Alfa Romeo");
		}
	
	
	}

	private void correrVolta() {

		double tempoFinal= 40;
		for (int i=0; i<3; i++) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			double tempo= ((Math.random()*10.01)+20);
			System.out.println("Carro "+idCarro+", tempo da volta: " + tempo);
			if (tempo < tempoFinal) {
				tempoFinal=tempo;
			}
		}
		carro.setTempoRapido(tempoFinal);
	}
	
	private void podio() {
		if (contador < 13) {
			podio.add(carro);
			contador++;
		}else {
			podio.add(carro);
			Collections.sort(podio);
			System.err.println("------------------------PODIO--------------------------");
			for (Object resolucao: podio) {
				try {
					sleep(500);
					System.out.println(resolucao);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				   
				}
		}
		
	}
}
