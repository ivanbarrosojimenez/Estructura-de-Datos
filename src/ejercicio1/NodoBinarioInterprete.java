package ejercicio1;

/**
 * The type Nodo binario interprete.
 */
public class NodoBinarioInterprete {
    private Interprete interprete;
    private NodoBinarioInterprete izquierdo;
    private NodoBinarioInterprete derecho;


    /**
     * Instantiates a new Nodo binario interprete.
     *
     * @param interprete the interprete
     */
    public NodoBinarioInterprete(Interprete interprete) {
        this.interprete = interprete;
        izquierdo = null;
        derecho = null;
    }

    /**
     * Gets interprete.
     *
     * @return the interprete
     */
    public Interprete getInterprete() {
        return interprete;
    }

    /**
     * Gets izquierdo.
     *
     * @return the izquierdo
     */
    public NodoBinarioInterprete getIzquierdo() {
        return izquierdo;
    }

    /**
     * Sets izquierdo.
     *
     * @param izquierdo the izquierdo
     */
    public void setIzquierdo(NodoBinarioInterprete izquierdo) {
        this.izquierdo = izquierdo;
    }

    /**
     * Gets derecho.
     *
     * @return the derecho
     */
    public NodoBinarioInterprete getDerecho() {
        return derecho;
    }

    /**
     * Sets derecho.
     *
     * @param derecho the derecho
     */
    public void setDerecho(NodoBinarioInterprete derecho) {
        this.derecho = derecho;
    }

    @Override
    public String toString() {
        return interprete.toString();
    }
}
