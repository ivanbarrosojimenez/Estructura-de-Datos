package ejercicio2;

public class Main {
    public static void main(String[] args) {
        // Crear una pila de enteros con tamaño 5
        Pila<Integer> pilaEnteros = new Pila<>(5);
        System.out.println("Tamaño de la pila: " + pilaEnteros.tamanio());

        // Insertar elementos en la pila de enteros
        System.out.println("Pila de Enteros:");
        System.out.println("Agregando elementos a la pila de enteros:");
        pilaEnteros.insertarElemento(10);
        System.out.println("Agregando elementos a la pila de enteros:");
        pilaEnteros.insertarElemento(20);
        System.out.println("Agregando elementos a la pila de enteros:");
        pilaEnteros.insertarElemento(30);
        System.out.println("Agregando elementos a la pila de enteros:");
        pilaEnteros.insertarElemento(40);
        System.out.println("Agregando elementos a la pila de enteros:");
        pilaEnteros.insertarElemento(50);

        System.out.println("Intentando insertar un elemento cuando la pila está llena");
        //Intentar agregar otro elemento (ya llena)
        try {
            pilaEnteros.insertarElemento(50);
        } catch (IllegalStateException e) {
            System.out.println(e);
        }


        // Mostrar la pila de enteros
        System.out.println("Contenido de la pila de enteros después de insertar 5 elementos:");
        pilaEnteros.mostrarPila();

        var ultimoElemento = pilaEnteros.cima();
        System.out.println("El elemento en la cima de la pila es: " + ultimoElemento);
        System.out.println("Eliminar elemento de la cima de la pila (50)");
        pilaEnteros.eliminarElemento();

        ultimoElemento = pilaEnteros.cima();
        System.out.println("El elemento en la cima de la pila es: " + ultimoElemento);

        System.out.println("Eliminar elemento de la cima de la pila (40)"); //Eliminar elemento de la cima de la pila
        pilaEnteros.eliminarElemento();

        ultimoElemento = pilaEnteros.cima();
        System.out.println("El elemento en la cima de la pila es: " + ultimoElemento);
        System.out.println("Eliminar elemento de la cima de la pila (30)"); //Eliminar elemento de la cima de la pila
        pilaEnteros.eliminarElemento();

        ultimoElemento = pilaEnteros.cima();
        System.out.println("El elemento en la cima de la pila es: " + ultimoElemento);
        System.out.println("Eliminar elemento de la cima de la pila (20)"); //Eliminar elemento de la cima de la pila
        pilaEnteros.eliminarElemento();

        ultimoElemento = pilaEnteros.cima();
        System.out.println("El elemento en la cima de la pila es: " + ultimoElemento);
        System.out.println("Eliminar elemento de la cima de la pila (10)"); //Eliminar elemento de la cima de la pila
        pilaEnteros.eliminarElemento();

        System.out.println("Intentar eliminar con Pila vacía debería lanzar una excepción");
        try {
            pilaEnteros.eliminarElemento();
        } catch (IllegalStateException e) {

            System.out.println(e);
        }
        // Crear una pila de cadenas (String)
        Pila<String> pilaStrings = new Pila<>(3);

        // Insertar elementos en la pila de cadenas
        System.out.println("Pila de Strings:");
        pilaStrings.insertarElemento("Iván");
        pilaStrings.insertarElemento("Barroso");
        pilaStrings.insertarElemento("Jiménez");

        // Mostrar la pila de Strings
        System.out.println("Contenido de la pila de strings:");
        pilaStrings.mostrarPila();

        pilaStrings.eliminarElemento();
        System.out.println("Contenido de la pila de strings eliminando la cima:");
        pilaStrings.mostrarPila();

        pilaStrings.eliminarElemento();
        System.out.println("Contenido de la pila de strings eliminando la cima:");
        pilaStrings.mostrarPila();

        // Crear una pila de Doubles
        Pila<Double> pilaDoubles = new Pila<>(4);

        // Insertar elementos en la pila de Doubles
        System.out.println("Pila de Doubles:");
        pilaDoubles.insertarElemento(10.5);
        pilaDoubles.insertarElemento(20.75);
        pilaDoubles.insertarElemento(30.25);

        // Mostrar la pila de Doubles
        System.out.println("Contenido de la pila de Doubles:");
        pilaDoubles.mostrarPila();

        // Crear una pila de caracteres (Character)
        Pila<Character> pilaCaracteres = new Pila<>(4);

        // Insertar elementos en la pila de caracteres
        System.out.println("Pila de Caracteres:");
        pilaCaracteres.insertarElemento('A');
        pilaCaracteres.insertarElemento('B');
        pilaCaracteres.insertarElemento('C');

        // Mostrar la pila de caracteres
        System.out.println("Contenido de la pila de caracteres:");
        pilaCaracteres.mostrarPila();

        // Verificar si la pila de caracteres está vacía
        System.out.println("¿Está la pila de caracteres vacía? " + pilaCaracteres.estaVacia());

        // Agregar un salto de línea final
        System.out.println("");
    }
}
