package src.ejercicio8;

public class NodoJugador {
    Jugador jugador;
    NodoJugador izq;
    NodoJugador der;


    public NodoJugador(Jugador jugador, NodoJugador izq, NodoJugador der) {
        this.jugador = jugador;
        this.izq = izq;
        this.der = der;
    }

    public NodoJugador(Jugador jugador) {
        this.jugador = jugador;
        this.izq = null;
        this.der = null;
    }
}
