public class ColaArray <E>{
    private final int TAMANIO = 10;
    private E[] datos;
    private int primero;
    private int numElementos;

    //constructor que crea la cola vacia
    public ColaArray() {
        datos = (E[]) new Object[TAMANIO];
        primero = 0;
        numElementos = 0;
    }

    //insertar un elemento en la cola
    public void insertar(E elemento) throws DesbordamientoSuperior {
        if (numElementos > TAMANIO) {
            throw new DesbordamientoSuperior("Desbordamiento superior de la cola");
        }

        datos[(primero + numElementos) % TAMANIO] = elemento;
        numElementos++;
    }

    public E primero() throws DesbordamientoInferior {
        if(numElementos <= 0){
            throw new DesbordamientoInferior("Desbordamiento inferior de la cola");
        }
        return datos[primero];

    }

    public E quitarPrimero() throws DesbordamientoInferior {
        if(numElementos <= 0){
            throw new DesbordamientoInferior("Desbordamiento inferior de la cola");
        }
        E elementoTemporal = datos[primero];
        primero = (primero + 1) % TAMANIO; //si supero el valor del tamaño vuelvo al principio del array
        numElementos--;
        return elementoTemporal;
    }

    public boolean estaVacia() {
        return numElementos == 0;
    }

    public void vaciar(){
        primero = 0;
        numElementos = 0;
    }
}
