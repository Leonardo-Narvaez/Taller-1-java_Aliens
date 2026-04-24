package com.krakedev.maquinaAliens.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	 * !!!!!!----IMPORTANTE----!!!!!! TOMANDO EN CUENTA QUE ALGUNOS TEST PARA
	 * VERIFICAR PODRIAN SALIR EN ROJO (FALLOS) SE OPTO POR REALIZAR ALGO SIMILAR A
	 * LO QUE REALIZO LA IA EN EL CUAL TODOS LOS TEST SALIERAN EN VERDE
	 */

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

	@Test
	void testAgregarBrazos_Retorno_Del_Metodo() {
		Alien alien1 = new Alien(5, "verde");

		boolean retorno1 = alien1.agregarBrazos(5);
		assertTrue(retorno1);
		retorno1 = alien1.agregarBrazos(6);
		assertFalse(retorno1);
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

	@Test
	void testAgregarPies_Retorno_Del_Metodo() {
		Alien alien1 = new Alien(5, "verde");

		boolean retorno1 = alien1.agregarPies(3);
		assertTrue(retorno1);
		retorno1 = alien1.agregarPies(12);
		assertFalse(retorno1);
	}

	/*
	 * TEST PARA EL METODO AGREGAR OJOS REVISANDO CORRECTA ASIGNACION DE VALORES Y
	 * CUMPLIMIENTO DE RESTRICCIONES
	 */

	@Test
	void testAgregarOjos_Atributos_Tamanio_Y_NumeroOjos_Son_Correctos() {
		Alien alien1 = new Alien(4, "verde");
		Alien alien2 = new Alien(15, "verde");
		Alien alien3 = new Alien(30, "verde");

		alien1.agregarOjos(2);
		assertEquals(2, alien1.getNumeroOjos());
		alien2.agregarOjos(4);
		assertEquals(4, alien2.getNumeroOjos());
		alien3.agregarOjos(7);
		assertEquals(7, alien3.getNumeroOjos());
	}

	@Test
	void testAgregarOjos_Un_Atributo_Fuera_De_Rango() {
		Alien alien1 = new Alien(20, "verde");
		Alien alien2 = new Alien(15, "verde");
		Alien alien3 = new Alien(30, "verde");

		alien1.agregarOjos(2); // SE AGREGA EL NUMERO DE OJOS INCORRECTO PARA SU TAMAÑO (OJOS=2----TAMAÑO=20)
		assertEquals(0, alien1.getNumeroOjos());
		alien2.agregarOjos(7); // SE AGREGA EL NUMERO DE OJOS INCORRECTO PARA SU TAMAÑO (OJOS=7----TAMAÑO=15)
		assertEquals(0, alien2.getNumeroOjos());
		alien3.agregarOjos(7); // SE AGREGA CORRECTAMENTE
		assertEquals(7, alien3.getNumeroOjos());
	}

	@Test
	void testAgregarOjos_Retorno_Del_Metodo() {
		Alien alien1 = new Alien(5, "verde");
		Alien alien2 = new Alien(15, "verde");

		boolean retorno1 = alien1.agregarOjos(3);
		assertTrue(retorno1);
		boolean retorno2 = alien2.agregarOjos(7);
		assertFalse(retorno2);
	}

	/*
	 * TEST PARA EL METODO CALCULAR_PRECIO_TOTAL
	 */

	@Test
	void testCalcularPrecioTotal_Correctamente_Funcionando() {
		Alien alien1 = new Alien(28, "verde");

		alien1.agregarOjos(6);
		assertEquals(13, alien1.getPrecioTotal(), 0.001);
		alien1.agregarBrazos(5);
		assertEquals(27, alien1.getPrecioTotal(), 0.001);
		alien1.agregarPies(5);
		assertEquals(41, alien1.getPrecioTotal(), 0.001);
	}
}
