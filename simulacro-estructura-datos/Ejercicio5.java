import recursos.ej4ej5.*;

public class Ejercicio5 {


    public static void main(String[] args) throws DesbordamientoSuperior, ErrorDiferenteTamanio, DesbordamientoInferior, Exception {

        // Crear los nodos del árbol, por defecto todos con la inspeccion tecnica a false (en constructor)
        NodoMoto nodoA = new NodoMoto(new Moto(500, "Yamaha", "MT-07"));
        NodoMoto nodoB = new NodoMoto(new Moto(400, "Kawasaki", "Ninja 400"));
        NodoMoto nodoC = new NodoMoto(new Moto(600, "Ducati", "Panigale V2"));
        NodoMoto nodoD = new NodoMoto(new Moto(250, "Kawasaki", "Ninja 250"));
        NodoMoto nodoE = new NodoMoto(new Moto(400, "Suzuki", "GSX-R400"));
        NodoMoto nodoF = new NodoMoto(new Moto(300, "Honda", "CBR300R"));
        NodoMoto nodoG = new NodoMoto(new Moto(600, "KTM", "RC 390"));

        nodoA.izquierdo = nodoB;
        nodoA.derecho = nodoC;
        nodoB.izquierdo = nodoD;
        nodoC.izquierdo = nodoE;
        nodoC.derecho = nodoF;
        nodoF.derecho = nodoG;

        ArbolMoto arbol = new ArbolMoto(nodoA);
        System.out.println("Recorrido antes de modificar en Inorden (1):");
        ArbolMoto.inorder(arbol.raiz());

        System.out.println("\nEjecutamos (1)  inspecciónTecnicaAprobada():");
        arbol.inspecciónTecnicaAprobada();
        ArbolMoto.inorder(arbol.raiz());

        System.out.println("\n  -    -   -   -   -   -  \n");

        ArbolMoto arbol2 = new ArbolMoto(new NodoMoto(new Moto(300, "Yamaha", "R3")));
        System.out.println("Recorrido antes de modificar en Inorden (2):");
        ArbolMoto.inorder(arbol2.raiz());
        System.out.println("\nEjecutamos (2) inspecciónTecnicaAprobada():");
        arbol2.inspecciónTecnicaAprobada();
        ArbolMoto.inorder(arbol2.raiz());

    }
}