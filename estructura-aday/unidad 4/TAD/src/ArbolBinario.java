public class ArbolBinario <E>{

    NodoBinario<E> raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public ArbolBinario(NodoBinario<E> nodo) {
        this.raiz = nodo;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public void vaciar(){
        raiz = null;
    }


    public NodoBinario<E> raiz() throws Exception {
        if(estaVacio()){
            throw new Exception("Raiz: árbol vacío.");
        }
        return raiz;
    }


    public ArbolBinario<E> hijoIzquierdo() throws Exception {
        if(estaVacio()){
            throw new Exception("Error Hijo Izquierdo: árbol vacío.");
        }
        return new ArbolBinario<>(raiz.izquierdo);
    }

    public ArbolBinario<E> hijoDerecho() throws Exception {
        if(estaVacio()){
            throw new Exception("Error Hijo derecho: árbol vacío.");
        }
        return new ArbolBinario<>(raiz.derecho);
    }


    public void ponHijoIzquierdo(ArbolBinario<E> hijoIzquierdo) throws Exception {
        if(hijoIzquierdo == null){
            throw new Exception("Error Hijo Izquierdo: el hijo es árbol vacío.");
        }
        if(hijoIzquierdo.estaVacio()){
            throw new Exception("Error Hijo Izquierdo:  árbol vacío.");
        }
        raiz.izquierdo = hijoIzquierdo.raiz();
    }


    public void ponHijoDerecho(ArbolBinario<E> hijoDerecho) throws Exception {
        if(hijoDerecho == null){
            throw new Exception("Error Hijo Derecho: el hijo es árbol vacío.");
        }
        if(hijoDerecho.estaVacio()){
            throw new Exception("Error Hijo Derecho:  árbol vacío.");
        }
        raiz.derecho = hijoDerecho.raiz();
    }

    public void eliminar(ArbolBinario<E> subarbol) throws Exception {
        if(subarbol == null){
            throw new Exception("Error en eliminar:  subárbol vacío.");
        }
        if(subarbol.raiz == raiz)
            raiz = null;
        else{

            ArbolBinario<E> auxiliarPadre = padre(subarbol);
            if(auxiliarPadre.estaVacio())
                throw new Exception("Error en eliminar: no existe el subarbol a eliminar.");
            else
                if(auxiliarPadre.raiz.izquierdo == subarbol.raiz)
                    auxiliarPadre.raiz.izquierdo = null;
                else
                    auxiliarPadre.raiz.derecho = null;

        }
    }

    private ArbolBinario<E> padre(ArbolBinario<E> subarbol) throws Exception {
        if(subarbol == null){
            throw new Exception("Error en eliminar:  subárbol vacío.");
        }

        if(estaVacio() || subarbol.estaVacio() || subarbol.raiz == raiz){
            return new ArbolBinario<>();
        }else{
            if(raiz.izquierdo == subarbol.raiz || raiz.derecho == subarbol.raiz){
                return this;
            }else{
                ArbolBinario<E> auxiliar = (new ArbolBinario<>(raiz.izquierdo)).padre(subarbol);
                if(auxiliar.estaVacio()){
                    return (new ArbolBinario<>(raiz.derecho)).padre(subarbol);
                }else
                    return auxiliar;
            }
        }

    }


    //Recorrido del árbol en preorden
    public static void preorden(NodoBinario nodo){
        if(nodo != null){
            System.out.println(nodo.dato);
            preorden(nodo.izquierdo);
            preorden(nodo.derecho);
        }
    }

    //Recorrido del árbol en inorder
    public static void inorder(NodoBinario nodo){
        if(nodo != null){
            inorder(nodo.izquierdo);
            System.out.println(nodo.dato);
            inorder(nodo.derecho);
        }
    }
    //Recorrido del árbol en postorder
    public static void postorder(NodoBinario nodo){
        if(nodo != null){
            postorder(nodo.izquierdo);
            postorder(nodo.derecho);
            System.out.println(nodo.dato);
        }
    }

}
