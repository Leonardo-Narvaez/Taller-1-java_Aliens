package com.krakedev.maquinaAliens.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.maquinaAliens.Alien;

class testJUnit {
	@Test
	void testCrearAlienNormal() {
		Alien alien = new Alien(4, "verde");
		assertEquals(5, alien.getTamanio());
		assertEquals("verde", alien.getColor());
		assertEquals(0.5, alien.getPrecioExtremidad(), 0.01);
		assertEquals(0.2, alien.getPrecioOjo(), 0.01);
		assertEquals(1.0, alien.getPrecioCuerpo(), 0.01);
	}
}
