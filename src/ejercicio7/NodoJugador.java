package src.ejercicio7;

public class NodoJugador<T> {
    public T jugador;
    public NodoJugador<T> siguiente;

    public NodoJugador(T jugador) {
        this.jugador = jugador;
        this.siguiente = null;
    }

    public boolean estaVacia() {
        return this.siguiente == null;
    }

    public void insertarPrimero(T dato) {
        NodoJugador<T> nuevo = new NodoJugador<>(dato);
        nuevo.siguiente = this.siguiente;
        this.siguiente = nuevo;
    }

    public void insertarUltimo(T dato) {
        NodoJugador<T> nuevo = new NodoJugador<>(dato);
        NodoJugador<T> ultimo = this;
        while (ultimo.siguiente != null) {
            ultimo = ultimo.siguiente;
        }
        ultimo.siguiente = nuevo;
    }

    public void insertarOrdenado(T dato) {
        NodoJugador<T> nuevo = new NodoJugador<>(dato);
        NodoJugador<T> anterior = this;

        while (anterior.siguiente != null && ((Comparable) anterior.siguiente.jugador).compareTo(nuevo.jugador) < 0) {
            anterior = anterior.siguiente;
        }

        nuevo.siguiente = anterior.siguiente;
        anterior.siguiente = nuevo;
    }

    public int buscar(T dato) {
        NodoJugador<T> auxiliar = this.siguiente;
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
        NodoJugador<T> auxiliar = this;

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
        this.siguiente = null;
    }
}