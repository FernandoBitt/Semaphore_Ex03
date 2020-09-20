package controller;

public class Carro implements Comparable<Object>{
	private int numero;
	private String escuderia;
	private double tempoRapido;
	


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getEscuderia() {
		return escuderia;
	}


	public void setEscuderia(String escuderia) {
		this.escuderia = escuderia;
	}


	public double getTempoRapido() {
		return tempoRapido;
	}


	public void setTempoRapido(double tempoFinal) {
		this.tempoRapido = tempoFinal;
	}


	@Override
	public String toString() {
		return "Carro Nº=" + numero + ", Escuderia= " + escuderia + ", tempoRapido= " + tempoRapido;
	}


	@Override
	public int compareTo(Object o) {
		Carro f = (Carro) o;
		return (int) ((this.getTempoRapido()*100) - (f.getTempoRapido()*100));
	}
	
}
