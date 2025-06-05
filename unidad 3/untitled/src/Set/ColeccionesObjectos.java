package Set;

import java.util.TreeSet;

public class ColeccionesObjectos {

    public static void main(String[] args) {
        TreeSet<Coche> conjuntoCoches = new TreeSet<Coche>();
        conjuntoCoches.add(new Coche("8787-BBB", "Seat", "Ibiza", 95));// 0
        conjuntoCoches.add(new Coche("8374-BLP", "Seat", "León", 95));

        conjuntoCoches.add(new Coche("7857-CQC", "Seat", "León", 105));// 2
        conjuntoCoches.add(new Coche("7646-FYN", "Seat", "Ateca", 115)); // 3
        conjuntoCoches.add(new Coche("7646-FYN", "Audi", "A4", 115)); // 3
        conjuntoCoches.add(new Coche("7645-DRS", "Seat", "Ibiza", 135));// 4


        System.out.println("Lista de coches");
        for (Coche coche : conjuntoCoches) {
            System.out.println(coche);
        }


    }
}
