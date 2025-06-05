package List;

import java.util.Vector;
// metodos de collection
// void clear()
// boolean add(E e)
// boolean remove (Object o)
// boolean contains (Object o)
// iterator iterator()


public class Listas {

    public static void main(String[] args) {

       // ArrayList<Coche> listaCoches = new ArrayList<>();
     //   LinkedList<Coche> listaCoches = new LinkedList<Coche>();
        Vector<Coche> listaCoches = new Vector<Coche>();
    // public E get(int i);
    // public E set(int i, E e);
    // public void add(int i, E e);
    // public E remove(int i);
    // public int indexOf(Object o);
    // public int lastIndexOf(Object o);
    // public List<E> subList(int i1, int i2);
    // public default void sort(Comparator cmp);


        //add sin posición añade al final de la lista
        listaCoches.add(new Coche("8787-BBB", "Seat", "Ibiza", 95));// 0
        listaCoches.add(new Coche("8374-BLP", "Seat", "León", 95)); // 1
        listaCoches.add(new Coche("7857-CQC", "Seat", "León", 105));// 2
        listaCoches.add(new Coche("7646-FYN", "Audi", "A4", 115)); // 3
        listaCoches.add(new Coche("7645-DRS", "Seat", "Ibiza", 135));// 4


        System.out.println("Lista coches");
        for (Coche c:listaCoches) { //  foreach
            System.out.println(c);
        }


        //get
        System.out.println("El coche de la posición 2 es: "+ listaCoches.get(2));
        //set
        Coche coche1 = new Coche("6263-HFG","Seat","Altea",90);
        listaCoches.set(2, coche1);

        System.out.println("El coche de la posición 2 es: "+ listaCoches.get(2));
        System.out.println("Lista coches");
        for (Coche c:listaCoches) {
            System.out.println(c);
        }

        listaCoches.add(coche1);
        for (Coche c:listaCoches) {
            System.out.println(c);
        }
        //indexof
        System.out.println("En que posición esta el coche1:" + listaCoches.indexOf(coche1));
        //last index of
        System.out.println("Cual es la última posición dond esta el coche1:" + listaCoches.lastIndexOf(coche1));

        System.out.println("Añadamis el leon de nuevo");

        //add en posición
        listaCoches.add(2, new Coche("7857-CQC", "Seat", "León", 105));
        for (Coche c:listaCoches) {
            System.out.println(c);
        }

        Coche coche = listaCoches.remove(2);
        System.out.println("Borramos el leon de nuevo");
        System.out.println(coche);
        System.out.println("Y se queda así");
        for (Coche c:listaCoches) {
            System.out.println(c);
        }


    }
}
