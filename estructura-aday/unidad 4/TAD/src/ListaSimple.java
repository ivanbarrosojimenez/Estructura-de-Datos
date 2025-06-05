public class ListaSimple <E>{
    NodoSimple<E> cabecera;

    public ListaSimple(){
        cabecera = new NodoSimple<>(null);
    }

    public boolean estaVacia(){
        return cabecera.siguiente == null;
    }

    public void insertarPrimero(E dato){
        NodoSimple<E> nuevo = new NodoSimple<>(dato);
        nuevo.siguiente = cabecera.siguiente;
        cabecera.siguiente = nuevo;
    }


    public void insertarUltimo(E dato){
        NodoSimple<E> nuevo = new NodoSimple<>(dato);

        NodoSimple<E> ultimo = cabecera;
        while(ultimo.siguiente != null){
            ultimo = ultimo.siguiente;
        }
        ultimo.siguiente = nuevo;
    }

    public void insertarOrdenado(E dato){
        NodoSimple<E> nuevo = new NodoSimple<>(dato);
        NodoSimple<E> anterior = cabecera;

        while(anterior.siguiente != null && ((Comparable)anterior.siguiente.dato).compareTo(nuevo.dato)<0){
            anterior = anterior.siguiente;
        }

        nuevo.siguiente = anterior.siguiente;
        anterior.siguiente = nuevo;
        System.out.println("Inserto " + dato);
        System.out.println("Detras de " + anterior.dato);
    }

    public int buscar(E dato){
        NodoSimple<E> auxiliar = cabecera.siguiente;
        int posicion = 0;
        while(auxiliar != null){
            if(auxiliar.dato.equals(dato)){
                return posicion;
            }else{
                auxiliar = auxiliar.siguiente;
            }
            posicion++;
        }
        return -1;

    }

    public boolean eliminar(E dato){
        NodoSimple<E> auxiliar = cabecera;

        while(auxiliar.siguiente != null && !auxiliar.siguiente.dato.equals(dato)){
            auxiliar = auxiliar.siguiente;
        }
        if(auxiliar.siguiente != null){
            auxiliar.siguiente = auxiliar.siguiente.siguiente;
            return true;
        }
        return false;
    }

    public void vaciar(){
        cabecera.siguiente = null;
    }


}


