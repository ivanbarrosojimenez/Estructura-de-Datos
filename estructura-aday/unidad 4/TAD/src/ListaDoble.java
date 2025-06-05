public class ListaDoble <E>{
    NodoDoble<E> cabecera;
    NodoDoble<E> cola;

    public ListaDoble(){
        cabecera = new NodoDoble<>(null);
        cola = new NodoDoble<>(null);
        cabecera.siguiente = cola;
        cola.anterior = cabecera;
    }


    public void insertarPrimero(E dato){
        NodoDoble<E> nuevo = new NodoDoble<>(dato);
        nuevo.siguiente = cabecera.siguiente;
        nuevo.anterior = cabecera;

        cabecera.siguiente = nuevo;
        nuevo.siguiente.anterior = nuevo;
    }
    public void insertarUltimo(E dato){
        NodoDoble<E> nuevo = new NodoDoble<>(dato);
        nuevo.siguiente = cola;
        nuevo.anterior = cola.anterior;

        cola.anterior = nuevo;
        nuevo.anterior.siguiente = nuevo;
    }

    public void insertarOrdenado(E dato){
        NodoDoble<E> nuevo = new NodoDoble<>(dato);
        NodoDoble<E> posicion = cabecera;

        while(posicion.siguiente != cola && ((Comparable)posicion.siguiente.dato).compareTo(nuevo.dato)<0){
            posicion = posicion.siguiente;
        }

        nuevo.siguiente = posicion.siguiente;
        nuevo.anterior = posicion;

        posicion.siguiente = nuevo;
        nuevo.siguiente.anterior = nuevo;


    }


    public int buscar(E dato){
        NodoDoble<E> posicion = cabecera.siguiente;

        int pos = 0;
        while(posicion != cola){
            if(posicion.dato.equals(dato)){
                return pos;//lo hemos encontrado devolvemos la posición
            }
            posicion = posicion.siguiente;
            pos++;
        }

        return -1;//no lo hemos encontrado, ha llegado al final de la lista y no ha devuelto nada
    }

    public boolean eliminar(E dato){
        NodoDoble<E> posicion = cabecera.siguiente;

        while(posicion != cola && !posicion.dato.equals(dato)){
            posicion = posicion.siguiente;
        }
        if(posicion != cola){
            posicion.anterior.siguiente = posicion.siguiente;
            posicion.siguiente.anterior = posicion.anterior;
            return true;
        }
        return false;
    }

    public void vaciar(){
        cabecera.siguiente = cola;
        cola.anterior = cabecera;
    }

}
