package src.ejercicio7;

public class ListaJugadores<T extends Jugador> {
    NodoJugador<T> cabecera;

    public ListaJugadores() {
        cabecera = new NodoJugador<>(null);
    }

    public boolean estaVacia() {
        return cabecera.siguiente == null;
    }

    public void insertarPrimero(T dato) {
        NodoJugador<T> nuevo = new NodoJugador<>(dato);
        nuevo.siguiente = cabecera.siguiente;
        cabecera.siguiente = nuevo;
    }

    public void insertarUltimo(T dato) {
        NodoJugador<T> nuevo = new NodoJugador<>(dato);
        NodoJugador<T> ultimo = cabecera;
        while (ultimo.siguiente != null) {
            ultimo = ultimo.siguiente;
        }
        ultimo.siguiente = nuevo;
    }

    public void insertarOrdenado(T dato) {
        NodoJugador<T> nuevo = new NodoJugador<>(dato);
        NodoJugador<T> anterior = cabecera;

        while (anterior.siguiente != null && ((Comparable) anterior.siguiente.jugador).compareTo(nuevo.jugador) < 0) {
            anterior = anterior.siguiente;
        }

        nuevo.siguiente = anterior.siguiente;
        anterior.siguiente = nuevo;
    }

    public int buscar(T dato) {
        NodoJugador<T> auxiliar = cabecera.siguiente;
        int posicion = 0;
        while (auxiliar != null) {
            if (auxiliar.jugador.equals(dato)) {
                return posicion;
            }
            auxiliar = auxiliar.siguiente;
            posicion++;
        }
        return -1;
    }

    public boolean eliminar(T dato) {
        NodoJugador<T> auxiliar = cabecera;

        while (auxiliar.siguiente != null && !auxiliar.siguiente.jugador.equals(dato)) {
            auxiliar = auxiliar.siguiente;
        }
        if (auxiliar.siguiente != null) {
            auxiliar.siguiente = auxiliar.siguiente.siguiente;
            return true;
        }
        return false;
    }

    public void vaciar() {
        cabecera.siguiente = null;
    }

    public int totalSueldos() {
        int total = 0;
        NodoJugador<T> actual = cabecera.siguiente;

        while (actual != null) {
            total += actual.jugador.getSueldo();
            actual = actual.siguiente;
        }

        return total;
    }
}