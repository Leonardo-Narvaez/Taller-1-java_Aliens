package com.krakedev.maquinaAliens;

public class Alien {
	private int tamanio;
	private String color;
	private int numeroOjos;
	private int numeroBrazos;
	private int numeroPies;
	private double precioExtremidad;
	private double precioOjo;
	private double precioCuerpo;

	public int getTamanio() {
		return tamanio;
	}

	public String getColor() {
		return color;
	}

	public int getNumeroOjos() {
		return numeroOjos;
	}

	public int getNumeroBrazos() {
		return numeroBrazos;
	}

	public int getNumeroPies() {
		return numeroPies;
	}

	public double getPrecioExtremidad() {
		return precioExtremidad;
	}

	public double getPrecioOjo() {
		return precioOjo;
	}

	public double getPrecioCuerpo() {
		return precioCuerpo;
	}

	public Alien(int tamanio, String color) {
		if (tamanio < 5) {
			this.tamanio = 5;
		} else if (tamanio > 30) {
			this.tamanio = 30;
		} else {
			this.tamanio = tamanio;
		}
		this.color = color;
		this.precioCuerpo = 0.2 * this.tamanio;
		this.precioExtremidad = 0.1 * this.tamanio;
		this.precioOjo = 0.05 * tamanio;
	}

	public void imprimir() {
		System.out.println("Tamaño: " + tamanio);
		System.out.println("Color: " + color);
		System.out.println("Numero de ojos: " + numeroOjos);
		System.out.println("Numero de brazos: " + numeroBrazos);
		System.out.println("Numero pies: " + numeroPies);
		System.out.println("Precio de extremidad: " + precioExtremidad);
		System.out.println("Precio de ojo: " + precioOjo);
		System.out.println("Precio de cuerpo: " + precioCuerpo);

	}
}
