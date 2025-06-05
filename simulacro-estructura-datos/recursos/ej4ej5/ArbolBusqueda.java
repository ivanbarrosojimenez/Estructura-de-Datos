package recursos.ej4ej5;

public class ArbolBusqueda {

    private NodoBinarioInt raiz;


    public ArbolBusqueda(NodoBinarioInt raiz) {
        this.raiz = raiz;
    }

    public ArbolBusqueda() {
        this.raiz = null;
    }

    public boolean estaVacio() {
        return raiz == null;
    }


    public NodoBinarioInt raiz() throws Exception {
        if (estaVacio()) {
            throw new Exception("Raiz: árbol vacío.");
        }
        return raiz;
    }


    public ArbolBusqueda hijoIzquierdo() throws Exception {
        if (estaVacio()) {
            throw new Exception("Error Hijo Izquierdo: árbol vacío.");
        }
        return new ArbolBusqueda(raiz.izquierdo);
    }

    public ArbolBusqueda hijoDerecho() throws Exception {
        if (estaVacio()) {
            throw new Exception("Error Hijo derecho: árbol vacío.");
        }
        return new ArbolBusqueda(raiz.derecho);
    }


    NodoBinarioInt buscar(int dato) throws Exception {
        return buscar(dato, raiz);
    }

    NodoBinarioInt buscar(int dato, NodoBinarioInt raiz) throws Exception {
        while (raiz != null) {
            if (dato < raiz.dato)
                raiz = raiz.izquierdo;
            else if (dato > raiz.dato)
                raiz = raiz.derecho;
            else
                return raiz;
        }
        throw new Exception("Error en buscar: dato no encontrado");
    }


    public void insertar(int dato) throws Exception {

        raiz = insertar(dato, raiz);
    }

    NodoBinarioInt insertar(int dato, NodoBinarioInt raiz) throws Exception {

        if (raiz == null)
            raiz = new NodoBinarioInt(dato, null, null);
        else if (dato < raiz.dato)
            raiz.izquierdo = insertar(dato, raiz.izquierdo);
        else if (dato > raiz.dato)
            raiz.derecho = insertar(dato, raiz.derecho);
        else
            throw new Exception("Error en Insertar: dato  duplicado");


        return raiz;
    }
}
