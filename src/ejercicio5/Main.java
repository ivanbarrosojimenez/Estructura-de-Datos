package src.ejercicio5;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Libro> biblioteca = new TreeSet<>();

        biblioteca.add(new Libro("Autor A", "1234ABC", 2020));
        biblioteca.add(new Libro("Autor B", "5678XYZ", 2018));
        biblioteca.add(new Libro("Autor C", "0001AAA", 2020));
        biblioteca.add(new Libro("Autor D", "1111BBB", 2022));
        biblioteca.add(new Libro("Autor D", "1112BBB", 2022));
        biblioteca.add(new Libro("Autor D", "1111ABB", 2022));

        System.out.println("Libros ordenados:");
        for (Libro libro : biblioteca) {
            System.out.println(libro);
        }
    }
}
