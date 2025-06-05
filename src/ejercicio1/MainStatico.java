package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class MainStatico {
    public static void main(String[] args) throws Exception {
        Gestor gestor = new Gestor();

        Interprete interprete1 = new Interprete("Iván", true, new ArrayList<>(List.of(new Disco("Disco1", 2020, 120))), TipoInterprete.SOLISTA);
        Interprete interprete2 = new Interprete("Aday", false, new ArrayList<>(List.of(new Disco("Disco1", 2021, 90))), TipoInterprete.SOLISTA);
        Interprete interprete3 = new Interprete("Pepe", false, new ArrayList<>(List.of(new Disco("Disco1", 2022, 55))), TipoInterprete.GRUPO);
        Interprete interprete4 = new Interprete("Pepa", true, new ArrayList<>(List.of(new Disco("Disco1", 2020, 54))), TipoInterprete.SOLISTA);
        gestor.getArbolBinario().insertar(interprete1);
        gestor.getArbolBinario().insertar(interprete2);
        gestor.getArbolBinario().insertar(interprete3);
        gestor.getArbolBinario().insertar(interprete4);

        gestor.getArbolBinario().listarInterpretes();

        gestor.getArbolBinario().listarDiscosPorAnio(2020);


        gestor.getArbolBinario().listarDiscosPorAnio(2021);

        var ivan = gestor.getArbolBinario().buscar(new Interprete("Iván"));
        System.out.println(ivan.toString());

        try {
            gestor.getArbolBinario().insertar(new Interprete("Iván"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            gestor.getArbolBinario().buscar(new Interprete("No existo"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        interprete1.agregarDisco(new Disco("Disco2", 2023, 60));

        interprete1.imprimirDiscos();
    }

}
