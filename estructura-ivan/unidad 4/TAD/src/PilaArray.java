public class PilaArray <E>{
    private E[] array;
    private int contador;

    public PilaArray(){
        array = (E[]) new Object[10];
        contador = 0;
    }

    public void apilar(E dato) throws DesbordamientoSuperior {
        if(contador > array.length){
            throw new DesbordamientoSuperior("Desbordamiento superior de la pila");
        }
        array[contador++] = dato;//postincremento se usa el valor primero y después se incrementa la variable
    }

    public void desapilar() throws DesbordamientoInferior {
        if(contador == 0){
            throw new DesbordamientoInferior("Desbordamiento inferior de la pila");
        }
        contador--;
    }

    public E cima() throws DesbordamientoInferior {
        if(contador == 0){
            throw new DesbordamientoInferior("Desbordamiento inferior de la pila");
        }
        return array[contador - 1];
    }

    public E cimaYDespilar() throws DesbordamientoInferior {
        if(contador == 0){
            throw new DesbordamientoInferior("Desbordamiento inferior de la pila");
        }
        return array[--contador];
    }

    public boolean estaVacia(){
        return contador == 0;
    }

    public void vaciar(){
        contador = 0;
    }
}
