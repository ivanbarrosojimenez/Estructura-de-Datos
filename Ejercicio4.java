import recursos.ej4ej5.*;

public class Ejercicio4 {
    /*
    Ejercicio 4: (3.5 puntos).
    Suponga que se tienen dos pilas, cada una de ellas implementadas con una lista simple
    enlazada usando las clases vistas:
    • recursos.ej4ej5.Pila
    • recursos.ej4ej5.NodoSimple
    • ListaSimple
    Tenga en cuenta que la pila está declarada como que contiene elementos de tipo <E>
    pero asuma que contiene elementos enteros. Para convertir un elemento de la pila a
    entero, haga un cast explícito a Integer:
    (Integer)elementoDeLaPila
    Se pide crear un método que dadas dos pilas p1 y p2 conteniendo números enteros,
    multiplique un elemento de la primera pila con el correspondiente elemento de la
    segunda pila, seleccione sólo los resultados pares y los coloque en un arbol binario de
    búsqueda albergando en cada nodo números enteros (clase recursos.ej4ej5.ArbolBusqueda con nodos de
    tipo recursos.ej4ej5.NodoBinario) que retornará el método.
    Para crear el recursos.ej4ej5.ArbolBusqueda y recursos.ej4ej5.NodoBinario use los constructores y métodos de las clases
    correspondientes. Si las dos pilas no tienen el mismo número de elementos, se debe
    retornar una excepción de tipo Exception.
    El método se tendrá la siguiente definición:
    public static recursos.ej4ej5.ArbolBusqueda multiplicacionDeElementos(recursos.ej4ej5.Pila p1,
    recursos.ej4ej5.Pila p2)
    Por ejemplo, las siguientes pilas (izquierda), darían lugar al árbol de la derecha en el
    primer caso y en el segundo lanzarían una excepción
     }


     */

    public static void main(String[] args) throws DesbordamientoSuperior, ErrorDiferenteTamanio, DesbordamientoInferior, Exception {
        Pila<Integer> pila1 = new Pila<>();
        pila1.apilar(1);
        pila1.apilar(2);
        pila1.apilar(3);

        Pila<Integer> pila2 = new Pila<>();
        pila2.apilar(4);
        pila2.apilar(5);
        pila2.apilar(6);

        var arbol1 = multiplicacionDeElementos(pila1, pila2);
        System.out.println(arbol1);
        //Resultado del ejemplo anterior:
        //    Raiz (4)
        //   /     \
        //         10
        //        /  \
        //            18

        Pila<Integer> pila3 = new Pila<>();
        pila3.apilar(1);
        pila3.apilar(2);

        Pila<Integer> pila4 = new Pila<>();
        pila4.apilar(4);
        pila4.apilar(5);
        pila4.apilar(6);

        try {
            var arbol2 = multiplicacionDeElementos(pila3, pila4);

        } catch (ErrorDiferenteTamanio e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static ArbolBusqueda multiplicacionDeElementos(Pila p1,
                                                          Pila p2) throws DesbordamientoInferior, DesbordamientoSuperior, ErrorDiferenteTamanio, Exception {
        if (p1.estaVacia() || p2.estaVacia()) {
            return new ArbolBusqueda();
        }
        int tamanioP1 = 0;
        Pila<Integer> auxP1 = new Pila<>();
        while (!p1.estaVacia()) {
            tamanioP1++;
            auxP1.apilar((Integer) p1.cimaYDesapilar());
        }

        int tamanioP2 = 0;
        Pila<Integer> auxP2 = new Pila<>();
        while (!p2.estaVacia()) {
            tamanioP2++;
            auxP2.apilar((Integer) p2.cimaYDesapilar());
        }
        if (tamanioP1 != tamanioP2) {
            throw new ErrorDiferenteTamanio("Las pilas no tienen el mismo número de elementos");
        }
        ArbolBusqueda arbol = new ArbolBusqueda();
        for (int i = 0; i < tamanioP2; i++) {
            int resultado = auxP1.cimaYDesapilar() * auxP2.cimaYDesapilar();
            arbol.insertar(resultado);
        }

        return arbol;

    }


}
