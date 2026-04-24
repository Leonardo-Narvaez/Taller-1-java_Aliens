package com.krakedev.maquinaAliens.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.maquinaAliens.Alien;

public class TestJUnit {
	@Test
	void testCrearAlienNormal() {
		Alien alien = new Alien(4, "verde");
		assertEquals(5, alien.getTamanio());
		assertEquals("verde", alien.getColor());
		assertEquals(0.5, alien.getPrecioExtremidad(), 0.01);
		assertEquals(0.25, alien.getPrecioOjo(), 0.01);
		assertEquals(1.0, alien.getPrecioCuerpo(), 0.01);

		Alien alien2 = new Alien(50, "negro");
		assertEquals(30, alien2.getTamanio());
		assertEquals("negro", alien2.getColor());
		assertEquals(3.0, alien2.getPrecioExtremidad(), 0.01);
		assertEquals(1.5, alien2.getPrecioOjo(), 0.01);
		assertEquals(6.0, alien2.getPrecioCuerpo(), 0.01);

		Alien alien3 = new Alien(21, "negro");
		assertEquals(21, alien3.getTamanio());
		assertEquals("negro", alien3.getColor());
		assertEquals(2.1, alien3.getPrecioExtremidad(), 0.01);
		assertEquals(1.05, alien3.getPrecioOjo(), 0.01);
		assertEquals(4.2, alien3.getPrecioCuerpo(), 0.01);

	}
	/*
	 * TEST PARA EL METODO AGREGAR BRAZOS REVISANDO CASOS VALIDOS, PARA CASOS LIMITE
	 * Y COMBINACION DE EXTREMIDADES
	 */

	@Test
	void testAgregarBrazos_Correctamente() {
		Alien alien1 = new Alien(4, "verde");
		alien1.agregarBrazos(3);
		assertEquals(3, alien1.getNumeroBrazos());
	}

	@Test
	void testAgregarBrazos_Hasta_El_Limite_Y_No_Suma_Si_Lo_Sobrepasa() {
		Alien alien1 = new Alien(4, "verde");
		alien1.agregarBrazos(3);
		assertEquals(3, alien1.getNumeroBrazos());
		alien1.agregarBrazos(5);
		assertEquals(8, alien1.getNumeroBrazos());
		alien1.agregarBrazos(2);
		assertEquals(10, alien1.getNumeroBrazos()); // LIMITE DE EXTREMIDADES ALCANZADA
		alien1.agregarBrazos(1);
		assertEquals(10, alien1.getNumeroBrazos()); // VERIFICA QUE NO SOBREPASE EL LIMITE
	}

	@Test
	void testAgregarBrazos_Y_Agregando_Pies() {
		Alien alien1 = new Alien(4, "verde");
		alien1.agregarBrazos(4);
		assertEquals(4, alien1.getNumeroBrazos());
		alien1.agregarPies(5);
		assertEquals(5, alien1.getNumeroPies());
		alien1.agregarBrazos(2);
		assertEquals(4, alien1.getNumeroBrazos()); // SOBREPASA EL LIMITE DE EXTREMIDADES Y NO AGREGA MAS
	}

	/*
	 * TEST PARA EL METODO AGREGARPIES REVISANDO CASOS VALIDOS, PARA CASOS LIMITE Y
	 * COMBINACION DE EXTREMIDADES
	 */

	@Test
	void testAgregarPies() {
		Alien alien1 = new Alien(4, "verde");
		alien1.agregarPies(3);
		assertEquals(3, alien1.getNumeroPies());
	}

	@Test
	void testAgregarPies_Hasta_El_Limite_Y_No_Suma_Si_Lo_Sobrepasa() {
		Alien alien1 = new Alien(4, "verde");
		alien1.agregarPies(3);
		assertEquals(3, alien1.getNumeroPies());
		alien1.agregarPies(5);
		assertEquals(8, alien1.getNumeroPies());
		alien1.agregarPies(2);
		assertEquals(10, alien1.getNumeroPies()); // LIMITE DE EXTREMIDADES ALCANZADA
		alien1.agregarPies(1);
		assertEquals(10, alien1.getNumeroPies()); // VERIFICA QUE NO SOBREPASE EL LIMITE
	}

	@Test
	void testAgregarPies_Y_Agregando_Brazos() {

		Alien alien1 = new Alien(4, "verde");
		alien1.agregarPies(4);
		assertEquals(4, alien1.getNumeroPies());
		alien1.agregarBrazos(5);
		assertEquals(5, alien1.getNumeroBrazos());
		alien1.agregarPies(2);
		assertEquals(4, alien1.getNumeroPies()); // SOBREPASA EL LIMITE DE EXTREMIDADES Y NO AGREGA MAS
	}

}
