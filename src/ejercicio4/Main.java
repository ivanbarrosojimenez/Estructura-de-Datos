package src.ejercicio4;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro("Autor A", "1234ABC", 2020);
        Libro libro2 = new Libro("Autor B", "5678DEF", 2019);
        Libro libro3 = new Libro("Autor C", "789ABC", 2020);
        Libro libro4 = new Libro("Autor D", "2468XYZ", 2021);
        Libro libro5 = new Libro("Autor D", "0XYZ", 2021);
        var libros = new ArrayList<Libro>(Arrays.asList(libro1, libro2, libro3, libro4, libro5));
        System.out.println(libros);
        var librosPares = librosPares(libros);
        System.out.println(librosPares);
    }

    public static ArrayList<Libro> librosPares(ArrayList<Libro> libros) {
        ArrayList<Libro> resultado = new ArrayList<>();

        for (Libro libro : libros) {
            String numRegistro = libro.numRegistro;

            // Extraemos los dígitos del principio (antes de las letras)
            String parteNumerica = "";
            for (int i = 0; i < numRegistro.length(); i++) {
                char c = numRegistro.charAt(i);
                if (Character.isDigit(c)) {
                    parteNumerica += c;
                } else {
                    break; // dejamos de leer cuando aparecen letras
                }
            }

            // Convertimos y comprobamos si es par
            if (!parteNumerica.isEmpty()) {
                int numero = Integer.parseInt(parteNumerica);
                if (numero % 2 == 0) {
                    resultado.add(libro);
                }
            }
        }

        return resultado;
    }
}
