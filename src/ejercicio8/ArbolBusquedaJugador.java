package src.ejercicio8;

public class ArbolBusquedaJugador {
    NodoJugador raiz;

    public ArbolBusquedaJugador(NodoJugador raiz) {
        this.raiz = raiz;
    }

    public ArbolBusquedaJugador() {
        this.raiz = null;
    }

    public boolean estaVacio() {
        return raiz == null;
    }


    public NodoJugador raiz() throws Exception {
        if (estaVacio()) {
            throw new Exception("Raiz: árbol vacío.");
        }
        return raiz;
    }


    public ArbolBusquedaJugador hijoIzquierdo() throws Exception {
        if (estaVacio()) {
            throw new Exception("Error Hijo Izquierdo: árbol vacío.");
        }
        return new ArbolBusquedaJugador(raiz.izq);
    }

    public ArbolBusquedaJugador hijoDerecho() throws Exception {
        if (estaVacio()) {
            throw new Exception("Error Hijo derecho: árbol vacío.");
        }
        return new ArbolBusquedaJugador(raiz.der);
    }


    NodoJugador buscar(Jugador dato) throws Exception {
        return buscar(dato, raiz);
    }


    NodoJugador buscar(Jugador jugador, NodoJugador raiz) throws Exception {
        while (raiz != null) {
            int cmp = jugador.compareTo(raiz.jugador);
            if (cmp < 0)
                raiz = raiz.izq;
            else if (cmp > 0)
                raiz = raiz.der;
            else
                return raiz;
        }
        throw new Exception("Error en buscar: dato no encontrado");
    }

    public void insertar(Jugador jugador) {
        raiz = insertarRec(raiz, jugador);
    }

    private NodoJugador insertarRec(NodoJugador nodo, Jugador jugador) {
        if (nodo == null) {
            NodoJugador nuevo = new NodoJugador(jugador);
            nuevo.jugador = jugador;
            return nuevo;
        }

        String claveActual = nodo.jugador.getEquipo() + nodo.jugador.getNombre();
        String claveNueva = jugador.getEquipo() + jugador.getNombre();

        if (claveNueva.compareTo(claveActual) < 0) {
            nodo.izq = insertarRec(nodo.izq, jugador);
        } else {
            nodo.der = insertarRec(nodo.der, jugador);
        }

        return nodo;
    }


    NodoJugador insertar(Jugador jugador, NodoJugador raiz) throws Exception {
        if (raiz == null) {
            raiz = new NodoJugador(jugador);
        } else {
            int cmp = jugador.compareTo(raiz.jugador);
            if (cmp < 0)
                raiz.izq = insertar(jugador, raiz.izq);
            else if (cmp > 0)
                raiz.der = insertar(jugador, raiz.der);
            else {
                throw new Exception("Error en Insertar: dato  duplicado");
            }
        }
        return raiz;
    }


    //Ejercicio 8
    public void imprimeSueldosAltos(int limite) {
        imprimeSueldosAltosRec(raiz, limite);
    }

    private void imprimeSueldosAltosRec(NodoJugador nodo, int limite) {
        if (nodo == null) return;

        // Recorrer subárbol izquierdo
        imprimeSueldosAltosRec(nodo.izq, limite);

        // Evaluar condición
        if (nodo.jugador.getSueldoTotal() > limite) {
            System.out.println("Jugador: " + nodo.jugador.getNombre() +
                    ", Equipo: " + nodo.jugador.getEquipo() +
                    ", Sueldo total: " + nodo.jugador.getSueldoTotal());
        }

        // Recorrer subárbol derecho
        imprimeSueldosAltosRec(nodo.der, limite);
    }


}
