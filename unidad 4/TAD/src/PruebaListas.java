public class PruebaListas {
    public static void main(String[] args) throws DesbordamientoInferior, DesbordamientoSuperior {
        /*ListaSimple<Integer> cabecera = new ListaSimple<>();
        cabecera.insertarOrdenado( Integer.valueOf(1));
        cabecera.insertarOrdenado( Integer.valueOf(3));
        cabecera.insertarOrdenado( Integer.valueOf(4));
        cabecera.insertarOrdenado( Integer.valueOf(11));
        cabecera.insertarOrdenado( Integer.valueOf(2));
        cabecera.insertarOrdenado( Integer.valueOf(9));


        System.out.println(cabecera);
        */

        ColaArray<String> cola = new ColaArray<>();
        cola.insertar("H");
        cola.insertar("O");
        cola.insertar("L");
        cola.insertar("A");
        cola.insertar(" ");
        cola.insertar("M");
        cola.insertar("U");
        cola.insertar("N");
        cola.insertar("D");
        cola.insertar("O");
        System.out.println(cola.primero() + " es el valor de la cabecera");
        cola.quitarPrimero();
        System.out.println(cola.primero() + " es el nuevo valor de la cabecera");
        cola.insertar("A1");
        cola.quitarPrimero();
        System.out.println(cola.primero() + " es el nuevo valor de la cabecera");
        cola.insertar("A2");
        cola.quitarPrimero();
        System.out.println(cola.primero() + " es el nuevo valor de la cabecera");
        cola.insertar("A3");
        cola.quitarPrimero();
        System.out.println(cola.primero() + " es el nuevo valor de la cabecera");
        cola.insertar("A4");

    }

}
