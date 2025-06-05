package recursos.ej4ej5;

public class ArbolMoto {

    NodoMoto raiz;

    public ArbolMoto() {
        this.raiz = null;
    }

    public ArbolMoto(NodoMoto nodo) {
        this.raiz = nodo;
    }

    //Recorrido del árbol en preorden
    public static void preorden(NodoMoto moto) {
        if (moto != null) {
            System.out.println(moto.moto);
            preorden(moto.izquierdo);
            preorden(moto.derecho);
        }
    }

    //Recorrido del árbol en inorder
    public static void inorder(NodoMoto nodo) {
        if (nodo != null) {
            inorder(nodo.izquierdo);
            System.out.println(nodo.moto);
            inorder(nodo.derecho);
        }
    }


    public static void inorderMarcarInspeccionFavorable(NodoMoto nodo) {
        if (nodo != null) {
            nodo.moto.setInspecciónFavorable(true); // Marcar inspección técnica como aprobada
            inorderMarcarInspeccionFavorable(nodo.izquierdo);
            inorderMarcarInspeccionFavorable(nodo.derecho);
        }
    }


    //Recorrido del árbol en postorder
    public static void postorder(NodoMoto nodo) {
        if (nodo != null) {
            postorder(nodo.izquierdo);
            postorder(nodo.derecho);
            System.out.println(nodo.moto);
        }
    }


    public boolean estaVacio() {
        return raiz == null;
    }

    public void vaciar() {
        raiz = null;
    }

    public NodoMoto raiz() throws Exception {
        if (estaVacio()) {
            throw new Exception("Raiz: árbol vacío.");
        }
        return raiz;
    }

    public ArbolMoto hijoIzquierdo() throws Exception {
        if (estaVacio()) {
            throw new Exception("Error Hijo Izquierdo: árbol vacío.");
        }
        return new ArbolMoto(raiz.izquierdo);
    }

    public ArbolMoto hijoDerecho() throws Exception {
        if (estaVacio()) {
            throw new Exception("Error Hijo derecho: árbol vacío.");
        }
        return new ArbolMoto(raiz.derecho);
    }

    public void ponHijoIzquierdo(ArbolMoto hijoIzquierdo) throws Exception {
        if (hijoIzquierdo == null) {
            throw new Exception("Error Hijo Izquierdo: el hijo es árbol vacío.");
        }
        if (hijoIzquierdo.estaVacio()) {
            throw new Exception("Error Hijo Izquierdo:  árbol vacío.");
        }
        raiz.izquierdo = hijoIzquierdo.raiz();
    }

    public void ponHijoDerecho(ArbolMoto hijoDerecho) throws Exception {
        if (hijoDerecho == null) {
            throw new Exception("Error Hijo Derecho: el hijo es árbol vacío.");
        }
        if (hijoDerecho.estaVacio()) {
            throw new Exception("Error Hijo Derecho:  árbol vacío.");
        }
        raiz.derecho = hijoDerecho.raiz();
    }

    public void eliminar(ArbolMoto subarbol) throws Exception {
        if (subarbol == null) {
            throw new Exception("Error en eliminar:  subárbol vacío.");
        }
        if (subarbol.raiz == raiz)
            raiz = null;
        else {

            ArbolMoto auxiliarPadre = padre(subarbol);
            if (auxiliarPadre.estaVacio())
                throw new Exception("Error en eliminar: no existe el subarbol a eliminar.");
            else if (auxiliarPadre.raiz.izquierdo == subarbol.raiz)
                auxiliarPadre.raiz.izquierdo = null;
            else
                auxiliarPadre.raiz.derecho = null;

        }
    }

    private ArbolMoto padre(ArbolMoto subarbol) throws Exception {
        if (subarbol == null) {
            throw new Exception("Error en eliminar:  subárbol vacío.");
        }

        if (estaVacio() || subarbol.estaVacio() || subarbol.raiz == raiz) {
            return new ArbolMoto();
        } else {
            if (raiz.izquierdo == subarbol.raiz || raiz.derecho == subarbol.raiz) {
                return this;
            } else {
                ArbolMoto auxiliar = (new ArbolMoto(raiz.izquierdo)).padre(subarbol);
                if (auxiliar.estaVacio()) {
                    return (new ArbolMoto(raiz.derecho)).padre(subarbol);
                } else
                    return auxiliar;
            }
        }

    }

    //Escriba un método en la clase ArbolMoto que ponga inspecciónFavorable a true a todas las
    //motos almacenadas en el árbol.
    public void inspecciónTecnicaAprobada() {
        marcarInspeccionTecnicaAprobadaInorder(this.raiz);
    }

    //Recorrido del árbol en inorder
    public void marcarInspeccionTecnicaAprobadaInorder(NodoMoto nodo) {
        if (nodo != null) {
            nodo.moto.setInspecciónFavorable(true);
            inorderMarcarInspeccionFavorable(nodo.izquierdo);
            inorderMarcarInspeccionFavorable(nodo.derecho);
        }
    }

}
