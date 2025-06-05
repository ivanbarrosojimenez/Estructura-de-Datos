package recursos.ej4ej5;

public class NodoBinario<E> {
    E dato;
    NodoBinario<E> izquierdo;
    NodoBinario<E> derecho;

    public NodoBinario(E dato) {
        this.dato = dato;
        izquierdo = null;
        derecho = null;
    }

    public NodoBinario(E dato, NodoBinario<E> hijoIzquierdo, NodoBinario<E> hijoDerecho) {
        this.dato = dato;
        this.izquierdo = hijoIzquierdo;
        this.derecho = hijoDerecho;
    }
}
