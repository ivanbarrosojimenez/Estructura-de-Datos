package src.ejercicio8;

public class Main {
    public static void main(String[] args) {
        ArbolBusquedaJugador arbol = new ArbolBusquedaJugador();

        // Crear jugadores con nombre, equipo, posición, sueldo y primas
        Jugador j1 = new Jugador("Luis", "Real Madrid", "Delantero", 4000, 1000);   // total = 5000
        Jugador j2 = new Jugador("Ana", "Barcelona", "Portera", 3000, 0);           // total = 3000
        Jugador j3 = new Jugador("Carlos", "Real Madrid", "Defensa", 4500, 700);    // total = 5200
        Jugador j4 = new Jugador("Sofía", "Atletico", "Centrocampista", 2500, 0);   // total = 2500
        Jugador j5 = new Jugador("Pedro", "Barcelona", "Delantero", 5000, 600);     // total = 5600
        Jugador j6 = new Jugador("Marta", "Valencia", "Portera", 2000, 0);          // total = 2000
        Jugador j7 = new Jugador("David", "Valencia", "Defensa", 2500, 250);        // total = 2750

        // Insertarlos en el árbol
        arbol.insertar(j1);
        arbol.insertar(j2);
        arbol.insertar(j3);
        arbol.insertar(j4);
        arbol.insertar(j5);
        arbol.insertar(j6);
        arbol.insertar(j7);

        // Ejecutar búsqueda de sueldos altos
        System.out.println("Jugadores con sueldo total mayor que 4000:");
        arbol.imprimeSueldosAltos(4000);
        System.out.println("\nJugadores con sueldo total mayor que 5000:");
        arbol.imprimeSueldosAltos(5000);
        System.out.println("\nJugadores con sueldo total mayor que 6000:");
        arbol.imprimeSueldosAltos(6000);
    }
}



