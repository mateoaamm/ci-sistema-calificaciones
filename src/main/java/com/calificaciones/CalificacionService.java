package com.calificaciones;

public class CalificacionService {

    public double calcularPromedio(double[] notas) {

        if (notas == null || notas.length == 0) {
            throw new IllegalArgumentException("Debe ingresar al menos una nota");
        }

        double suma = 0;

        for (double nota : notas) {
            validarNota(nota);
            suma += nota;
        }

        return suma / notas.length;
    }

    public double obtenerNotaMaxima(double[] notas) {

        validarArreglo(notas);

        double maxima = notas[0];

        for (double nota : notas) {
            validarNota(nota);

            if (nota > maxima) {
                maxima = nota;
            }
        }

        return maxima;
    }

    public double obtenerNotaMinima(double[] notas) {

        validarArreglo(notas);

        double minima = notas[0];

        for (double nota : notas) {
            validarNota(nota);

            if (nota < minima) {
                minima = nota;
            }
        }

        return minima;
    }

    public String determinarEstado(double promedio) {

        validarNota(promedio);

        if (promedio >= 3.0) {
            return "APROBADO";
        }

        return "REPROBADO";
    }

    public void validarNota(double nota) {

        if (nota < 0.0 || nota > 5.0) {
            throw new IllegalArgumentException(
                "La nota debe estar entre 0.0 y 5.0"
            );
        }
    }

    private void validarArreglo(double[] notas) {

        if (notas == null || notas.length == 0) {
            throw new IllegalArgumentException(
                "Debe ingresar al menos una nota"
            );
        }
    }
}
