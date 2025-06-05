package src.ejercicio6;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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
        biblioteca.add(new Libro("Autor E", "9111ABB", 2021));
        biblioteca.add(new Libro("Autor E", "811ABB", 2020));

        System.out.println("Auto con más libros: " + autorConMasLibros(biblioteca));
    }

    public static String autorConMasLibros(TreeSet<Libro> libros) {
        Map<String, Integer> mapa = new HashMap<>();
        for (Libro libro : libros) {
            mapa.put(libro.autor, mapa.getOrDefault(libro.autor, 0) + 1);
        }
        return Collections.max(mapa.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
