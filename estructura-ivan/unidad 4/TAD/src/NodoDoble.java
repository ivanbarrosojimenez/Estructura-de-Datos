public class NodoDoble <E>{
    public E dato;
    public NodoDoble<E> siguiente;
    public NodoDoble<E> anterior;

    public NodoDoble(E dato){
        this.dato = dato;
        siguiente = null;
        anterior = null;
    }

}
