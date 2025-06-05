package src.ejercicio7;

public class Main {
    public static void main(String[] args) {
        ListaJugadores<Jugador> lista = new ListaJugadores<>();

        // Crear jugadores y añadirlos
        Jugador j1 = new Jugador("Juan", "FCX", "Delantero", 4000, 500);
        Jugador j2 = new Jugador("Pedro", "FCY", "Defensa", 2000, 400);
        Jugador j3 = new Jugador("Luis", "FCZ", "Portero", 2000, 300);
        Jugador j4 = new Jugador("Pepe", "FCZ", "Delantero", 2000, 300);
        Jugador j5 = new Jugador("Iván", "FCZ", "Delantero", 10000, 300);
        Jugador j6 = new Jugador("Aday", "FCZ", "Delantero", 180000, 300);

        lista.insertarUltimo(j1);
        lista.insertarUltimo(j2);
        lista.insertarUltimo(j3);
        lista.insertarUltimo(j4);
        lista.insertarUltimo(j5);
        lista.insertarUltimo(j6);

        // Imprimir resultado
        System.out.println("Total de sueldos: " + lista.totalSueldos());
    }
}
