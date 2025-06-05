package Ejemplos;

import java.util.ArrayList;
import java.util.List;

public class MutableInmutable {

    public static void main(String[] args) {
        //Lista Mutable
        ArrayList<String> listaMutable = new ArrayList<String>();
        ArrayList<Integer> listaMutable4 = new ArrayList<Integer>();
        listaMutable.add("Manzana");
        listaMutable.add("Banana");
        System.out.println("Lista: " + listaMutable);


        listaMutable.remove("Manzana");
        System.out.println("Lista Mutable después de haber borrado la manzana: " + listaMutable);


        //Lista Inmutable
        List<String> listaInmutable2 = List.of("Manzana", "Banana");
        System.out.println("Lista Inmutable: " + listaInmutable2);
       // listaInmutable2.remove("Manzana");
        //System.out.println("Lista Inmutable: " + listaInmutable2);
        List<String> listaInmutable3 = List.of("Manzana", "Narajan");
        System.out.println("Lista Inmutable: " + listaInmutable3);


    }
}
