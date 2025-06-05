package Map;

import Set.Coche;

import java.util.HashMap;

public class ColeccionesObjetos
{
    public static void main(String[] args) {
        HashMap<String, Coche> hashMapCoches = new HashMap<String, Coche>();
        hashMapCoches.put("8787-BBB", new Coche("8787-BBB", "Seat", "Ibiza", 95));
        hashMapCoches.put("8374-BLP",new Coche("8374-BLP", "Seat", "León",95));
        hashMapCoches.put("7857-CQC",new Coche("7857-CQC","Seat","León",105));
        hashMapCoches.put("7646-FYN", new Coche("7646-FYN", "Audi", "A4", 115));
        hashMapCoches.put("7645-DRS", new Coche("7645-DRS", "Seat", "Ibiza", 135));

        System.out.println("Lista de coches.");
        for (String key : hashMapCoches.keySet()) {
            System.out.println("Clave de coches: " + key + " = " + hashMapCoches.get(key));
        }

        Coche miCoche = hashMapCoches.remove("8787-BBB");
        System.out.println("El coche eliminado:"+miCoche);
        Coche miAntiguoCoche = hashMapCoches.put("7645-DRS", new Coche("ESTOESLOMODFICADO", "Seat", "Ibiza", 135));
        System.out.println("El coche sobreescrito:"+miAntiguoCoche);
        System.out.println("Lista de coches.");
        for (String key : hashMapCoches.keySet()) {
            System.out.println("Clave de coches: " + key + " = " + hashMapCoches.get(key));
        }
        System.out.println("Esta el coche:8374-BLP:" + hashMapCoches.containsKey("8374-BLP"));
        System.out.println("Tamaña del diccionario: " + hashMapCoches.size());
        hashMapCoches.clear();
        System.out.println("Tamaña del diccionario: " + hashMapCoches.size());
    }
}
