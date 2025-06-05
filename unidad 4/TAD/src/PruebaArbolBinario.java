public class PruebaArbolBinario {

    public static void main(String[] args) throws Exception {
        // Crear los nodos del árbol
        NodoBinario<String> nodoA = new NodoBinario<>("A");
        NodoBinario<String> nodoB = new NodoBinario<>("B");
        NodoBinario<String> nodoC = new NodoBinario<>("C");
        NodoBinario<String> nodoD = new NodoBinario<>("D");
        NodoBinario<String> nodoE = new NodoBinario<>("E");
        NodoBinario<String> nodoF = new NodoBinario<>("F");
        NodoBinario<String> nodoG = new NodoBinario<>("G");

        nodoA.izquierdo = nodoB;
        nodoA.derecho = nodoC;
        nodoB.izquierdo = nodoD;
        nodoC.izquierdo = nodoE;
        nodoC.derecho = nodoF;
        nodoF.derecho = nodoG;

        // Crear el árbol binario con el nodo raíz
        ArbolBinario<String> arbol = new ArbolBinario<>(nodoA);
        System.out.println("Recorrido Preorden:");
        ArbolBinario.preorden(arbol.raiz());

        System.out.println("Recorrido Inorden:");
        ArbolBinario.inorder(arbol.raiz());

        System.out.println("Recorrido Postorden:");
        ArbolBinario.postorder(arbol.raiz());
    }
}
