package com.krakedev.maquinaAliens.testJUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.krakedev.maquinaAliens.Alien;

/**
 * Clase de pruebas unitarias para la clase Alien (JUnit 5).
 * Se prueban exclusivamente los métodos: agregarBrazos, agregarPies, agregarOjos y calcularPrecioTotal.
 * No se incluyen pruebas del constructor ni valores negativos.
 * 
 * @author Asistente IA
 */
class Test_JUnit_IA {

    private static final double DELTA = 1e-6; // Tolerancia para comparación de doubles

    private Alien alien;

    // Configuración común: se crea un Alien con tamaño y color por defecto.
    @BeforeEach
    void setUp() {
        alien = new Alien(15, "Verde"); // tamaño 15 (dentro del rango, sin extremidades ni ojos)
    }

    // --------------------------------------------------------------
    // PRUEBAS PARA EL MÉTODO agregarBrazos
    // --------------------------------------------------------------

    @Test
    @DisplayName("agregarBrazos: dentro del límite -> true y actualiza numeroBrazos")
    void testAgregarBrazos_DentroDelLimite_TrueYActualiza() {
        // Se agregan 3 brazos; total extremidades = 3 <= 10
        assertTrue(alien.agregarBrazos(3));
        assertEquals(3, alien.getNumeroBrazos());
        // Verifica que no se modificaron los pies
        assertEquals(0, alien.getNumeroPies());
    }

    @Test
    @DisplayName("agregarBrazos: justo en el límite máximo (suma total 10) -> true")
    void testAgregarBrazos_JustoLimite_True() {
        alien.agregarBrazos(5);
        alien.agregarPies(5); // total 10 extremidades
        // Intentar agregar 0 brazos debe ser true (no cambia total)
        assertTrue(alien.agregarBrazos(0));
        assertEquals(5, alien.getNumeroBrazos());
    }

    @Test
    @DisplayName("agregarBrazos: excede el límite -> false y no modifica numeroBrazos")
    void testAgregarBrazos_ExcedeLimite_FalseSinCambios() {
        alien.agregarBrazos(9);
        alien.agregarPies(1); // total = 10
        assertFalse(alien.agregarBrazos(1));
        assertEquals(9, alien.getNumeroBrazos()); // no se incrementa
    }

    @Test
    @DisplayName("agregarBrazos: agregar cero brazos -> true y no cambia")
    void testAgregarBrazos_Cero_True() {
        assertTrue(alien.agregarBrazos(0));
        assertEquals(0, alien.getNumeroBrazos());
    }

    // --------------------------------------------------------------
    // PRUEBAS PARA EL MÉTODO agregarPies
    // --------------------------------------------------------------

    @Test
    @DisplayName("agregarPies: dentro del límite -> true y actualiza numeroPies")
    void testAgregarPies_DentroDelLimite_TrueYActualiza() {
        assertTrue(alien.agregarPies(4));
        assertEquals(4, alien.getNumeroPies());
        assertEquals(0, alien.getNumeroBrazos());
    }

    @Test
    @DisplayName("agregarPies: excede el límite -> false sin cambios")
    void testAgregarPies_ExcedeLimite_False() {
        alien.agregarBrazos(6);
        alien.agregarPies(4); // total 10
        assertFalse(alien.agregarPies(1));
        assertEquals(4, alien.getNumeroPies());
    }

    @Test
    @DisplayName("agregarPies: agregar cero -> true")
    void testAgregarPies_Cero_True() {
        assertTrue(alien.agregarPies(0));
        assertEquals(0, alien.getNumeroPies());
    }

    // --------------------------------------------------------------
    // PRUEBAS PARA EL MÉTODO agregarOjos
    // --------------------------------------------------------------

    // --- Rango tamaño [5,10] : cantidad ojos hasta 3 ---
    @Test
    @DisplayName("agregarOjos: tamaño 5-10, cantidad válida (≤3) -> true y asigna ojos")
    void testAgregarOjos_RangoPequeno_CantidadValida_True() {
        Alien alienPeq = new Alien(7, "Rojo"); // tamaño 7
        assertTrue(alienPeq.agregarOjos(2));
        assertEquals(2, alienPeq.getNumeroOjos());
    }

    @Test
    @DisplayName("agregarOjos: tamaño 5-10, cantidad inválida (4) -> false")
    void testAgregarOjos_RangoPequeno_CantidadInvalida_False() {
        Alien alienPeq = new Alien(9, "Azul");
        assertFalse(alienPeq.agregarOjos(4));
        assertEquals(0, alienPeq.getNumeroOjos());
    }

    // --- Rango tamaño (10,20] : cantidad ojos 4 o 5 ---
    @Test
    @DisplayName("agregarOjos: tamaño 11-20, cantidad válida (4 o 5) -> true")
    void testAgregarOjos_RangoMedio_CantidadValida_True() {
        Alien alienMed = new Alien(14, "Amarillo");
        assertTrue(alienMed.agregarOjos(5));
        assertEquals(5, alienMed.getNumeroOjos());
    }

    @Test
    @DisplayName("agregarOjos: tamaño 11-20, cantidad 3 (inválida) -> false")
    void testAgregarOjos_RangoMedio_CantidadInvalidaBaja_False() {
        Alien alienMed = new Alien(18, "Verde");
        assertFalse(alienMed.agregarOjos(3));
        assertEquals(0, alienMed.getNumeroOjos());
    }

    @Test
    @DisplayName("agregarOjos: tamaño 11-20, cantidad 6 (inválida) -> false")
    void testAgregarOjos_RangoMedio_CantidadInvalidaAlta_False() {
        Alien alienMed = new Alien(20, "Naranja");
        assertFalse(alienMed.agregarOjos(6));
        assertEquals(0, alienMed.getNumeroOjos());
    }

    // --- Rango tamaño (20,30] : cantidad ojos 6 o 7 ---
    @Test
    @DisplayName("agregarOjos: tamaño 21-30, cantidad válida (6 o 7) -> true")
    void testAgregarOjos_RangoGrande_CantidadValida_True() {
        Alien alienGrande = new Alien(25, "Morado");
        assertTrue(alienGrande.agregarOjos(7));
        assertEquals(7, alienGrande.getNumeroOjos());
    }

    @Test
    @DisplayName("agregarOjos: tamaño 21-30, cantidad 5 (inválida) -> false")
    void testAgregarOjos_RangoGrande_CantidadInvalida_False() {
        Alien alienGrande = new Alien(30, "Gris");
        assertFalse(alienGrande.agregarOjos(5));
        assertEquals(0, alienGrande.getNumeroOjos());
    }

    // --- Casos límite de tamaño ---
    @Test
    @DisplayName("agregarOjos: tamaño exacto 10 (rango pequeño) permite hasta 3")
    void testAgregarOjos_Tamanio10_Valido3() {
        Alien alienLimite = new Alien(10, "Cian");
        assertTrue(alienLimite.agregarOjos(3));
        assertEquals(3, alienLimite.getNumeroOjos());
    }

    @Test
    @DisplayName("agregarOjos: tamaño exacto 11 (rango medio) permite 4 o 5")
    void testAgregarOjos_Tamanio11_Valido4() {
        Alien alienLimite = new Alien(11, "Magenta");
        assertTrue(alienLimite.agregarOjos(4));
        assertEquals(4, alienLimite.getNumeroOjos());
    }

    @Test
    @DisplayName("agregarOjos: tamaño exacto 21 (rango grande) permite 6 o 7")
    void testAgregarOjos_Tamanio21_Valido6() {
        Alien alienLimite = new Alien(21, "Plateado");
        assertTrue(alienLimite.agregarOjos(6));
        assertEquals(6, alienLimite.getNumeroOjos());
    }

    // --------------------------------------------------------------
    // PRUEBAS PARA EL MÉTODO calcularPrecioTotal
    // Nota: No se prueba su invocación desde otros métodos (aislamiento).
    // Se verifica el cálculo directo según la fórmula.
    // --------------------------------------------------------------

    @Test
    @DisplayName("calcularPrecioTotal: valor inicial correcto (sin extremidades, sin ojos)")
    void testCalcularPrecioTotal_Inicial_SinExtremidadesSinOjos() {
        // Alien con tamaño 15 (creado en setUp)
        double expected = (0 * alien.getPrecioExtremidad()) +
                          (0 + alien.getPrecioOjo()) +
                          alien.getPrecioCuerpo();
        assertEquals(expected, alien.getPrecioTotal(), DELTA);
    }

    @Test
    @DisplayName("calcularPrecioTotal: después de agregar brazos y pies")
    void testCalcularPrecioTotal_ConExtremidades() {
        alien.agregarBrazos(2);
        alien.agregarPies(3); // total extremidades = 5
        double expected = (5 * alien.getPrecioExtremidad()) +
                          (0 + alien.getPrecioOjo()) +
                          alien.getPrecioCuerpo();
        assertEquals(expected, alien.getPrecioTotal(), DELTA);
    }

    @Test
    @DisplayName("calcularPrecioTotal: después de agregar ojos")
    void testCalcularPrecioTotal_ConOjos() {
        alien.agregarOjos(4); // tamaño 15 permite 4 ojos
        double expected = (0 * alien.getPrecioExtremidad()) +
                          (4 + alien.getPrecioOjo()) +
                          alien.getPrecioCuerpo();
        assertEquals(expected, alien.getPrecioTotal(), DELTA);
    }

    @Test
    @DisplayName("calcularPrecioTotal: con extremidades y ojos combinados")
    void testCalcularPrecioTotal_ExtremidadesYOjos() {
        alien.agregarBrazos(1);
        alien.agregarPies(2);
        alien.agregarOjos(5); // tamaño 15 permite 5 ojos
        double expected = (3 * alien.getPrecioExtremidad()) +
                          (5 + alien.getPrecioOjo()) +
                          alien.getPrecioCuerpo();
        assertEquals(expected, alien.getPrecioTotal(), DELTA);
    }

    @Test
    @DisplayName("calcularPrecioTotal: no se altera por operaciones fallidas")
    void testCalcularPrecioTotal_NoSeAlteraPorOperacionesFallidas() {
        double precioAntes = alien.getPrecioTotal();
        alien.agregarBrazos(11); // falla por exceder límite
        assertEquals(precioAntes, alien.getPrecioTotal(), DELTA);
        alien.agregarOjos(10);   // falla porque no se ajusta al rango
        assertEquals(precioAntes, alien.getPrecioTotal(), DELTA);
    }
}
