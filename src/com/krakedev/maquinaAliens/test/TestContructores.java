package com.krakedev.maquinaAliens.test;

import com.krakedev.maquinaAliens.Alien;

public class TestContructores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alien alien1 = new Alien(4, "verde");
		Alien alien2 = new Alien(50, "negro");

		alien1.imprimir();
		alien2.imprimir();	
	}

}
