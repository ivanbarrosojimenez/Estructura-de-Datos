package recursos.ej4ej5;

public class NodoMoto {
    public Moto moto;
    public NodoMoto izquierdo;
    public NodoMoto derecho;

    public NodoMoto(Moto moto) {
        this.moto = moto;
        izquierdo = null;
        derecho = null;
    }

    public NodoMoto(Moto moto, NodoMoto hijoIzquierdo, NodoMoto hijoDerecho) {
        this.moto = moto;
        this.izquierdo = hijoIzquierdo;
        this.derecho = hijoDerecho;
    }
}
