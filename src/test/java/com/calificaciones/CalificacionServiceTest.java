package com.calificaciones;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalificacionServiceTest {

    private final CalificacionService service =
        new CalificacionService();

    @Test
    void calculaPromedioCorrectamente() {

        double[] notas = {4.0, 3.0, 5.0};

        double resultado =
            service.calcularPromedio(notas);

        assertEquals(4.0, resultado);
    }

    @Test
    void obtieneNotaMaximaCorrectamente() {

        double[] notas = {3.2, 4.8, 2.5};

        assertEquals(
            4.8,
            service.obtenerNotaMaxima(notas)
        );
    }

    @Test
    void obtieneNotaMinimaCorrectamente() {

        double[] notas = {3.2, 4.8, 2.5};

        assertEquals(
            2.5,
            service.obtenerNotaMinima(notas)
        );
    }

    @Test
    void estudianteApruebaConPromedioMayorA3() {

        assertEquals(
            "APROBADO",
            service.determinarEstado(4.0)
        );
    }

    @Test
    void estudianteRepruebaConPromedioMenorA3() {

        assertEquals(
            "REPROBADO",
            service.determinarEstado(2.5)
        );
    }

    @Test
    void rechazaNotaMayorA5() {

        assertThrows(
            IllegalArgumentException.class,
            () -> service.validarNota(6.0)
        );
    }

    @Test
    void rechazaNotaNegativa() {

        assertThrows(
            IllegalArgumentException.class,
            () -> service.validarNota(-1.0)
        );
    }
}
