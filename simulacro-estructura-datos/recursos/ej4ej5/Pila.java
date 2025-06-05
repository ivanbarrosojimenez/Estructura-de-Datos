package recursos.ej4ej5;

public class Pila<E> {
    private ListaSimple<E> lista;

    public Pila() {
        lista = new ListaSimple<>();
    }

    public void apilar(E dato) throws DesbordamientoSuperior {
        lista.insertarPrimero(dato);
    }

    public void desapilar() throws DesbordamientoInferior {
        if (lista.estaVacia()) {
            throw new DesbordamientoInferior("Desbordamiento Inferior de la pila");
        }
        lista.eliminar(cima());
    }

    public E cima() throws DesbordamientoInferior {
        if (lista.estaVacia()) {
            throw new DesbordamientoInferior("Desbordamiento Inferior de la pila");
        }
        return lista.cabecera.siguiente.dato;
    }

    public E cimaYDesapilar() throws DesbordamientoInferior {
        if (lista.estaVacia()) {
            throw new DesbordamientoInferior("Desbordamiento Inferior de la pila");
        }
        E aux = cima();
        lista.eliminar(aux);
        return aux;

    }

    public boolean estaVacia() {
        return lista.estaVacia();
    }


    public void vaciar() {
        lista.vaciar();
    }


}
