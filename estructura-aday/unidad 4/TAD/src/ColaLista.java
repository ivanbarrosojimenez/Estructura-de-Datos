public class ColaLista <E>{
    private ListaSimple<E> lista;

    public ColaLista(){
        lista = new ListaSimple<>();
    }


    public void insertar(E elemento){
        lista.insertarUltimo(elemento);
    }

    public E primero() throws DesbordamientoInferior {
        if(lista.estaVacia()){
            throw new DesbordamientoInferior("Desbordamiento inferior de la cola");
        }
        return lista.cabecera.siguiente.dato;

    }

    public void quitarPrimero() throws DesbordamientoInferior {
        if(lista.estaVacia()){
            throw new DesbordamientoInferior("Desbordamiento inferior de la cola");
        }
        lista.eliminar(primero());

    }

    public E primeroUYQuitar() throws DesbordamientoInferior {
        if(lista.estaVacia()){
            throw new DesbordamientoInferior("Desbordamiento inferior de la cola");
        }
        E elemento = primero();
        quitarPrimero();
        return elemento;

    }
}
