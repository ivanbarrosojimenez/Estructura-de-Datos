package recursos.ej4ej5;

public class NodoBinarioInt {
    public int dato;
    NodoBinarioInt izquierdo;
    NodoBinarioInt derecho;

    public NodoBinarioInt(int dato) {
        this.dato = dato;
        izquierdo = null;
        derecho = null;
    }

    public NodoBinarioInt(int dato, NodoBinarioInt hijoIzquierdo, NodoBinarioInt hijoDerecho) {
        this.dato = dato;
        this.izquierdo = hijoIzquierdo;
        this.derecho = hijoDerecho;
    }
}
