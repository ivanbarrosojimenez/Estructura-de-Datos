public class NodoSimple <E>{
    public E dato;
    public NodoSimple<E> siguiente;

    public NodoSimple(E dato){
        this.dato = dato;
        this.siguiente = null;
    }
}
