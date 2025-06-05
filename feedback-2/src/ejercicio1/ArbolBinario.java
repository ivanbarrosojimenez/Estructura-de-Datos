package ejercicio1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The type Arbol binario.
 */
public class ArbolBinario {

    private NodoBinarioInterprete raiz;

    /**
     * Instantiates a new Arbol binario.
     */
    public ArbolBinario() {
        this.raiz = raiz;
    }

    /**
     * Gets raiz.
     *
     * @return the raiz
     */
    public NodoBinarioInterprete getRaiz() {
        return raiz;
    }

    /**
     * Raiz nodo binario interprete.
     *
     * @return the nodo binario interprete
     * @throws Exception the exception
     */
    public NodoBinarioInterprete raiz() throws Exception {
        if (estaVacio()) {
            throw new Exception("Raiz: árbol vacío.");
        }
        return raiz;
    }

    /**
     * Buscar nodo binario interprete.
     *
     * @param interprete the interprete
     * @return the nodo binario interprete
     * @throws Exception the exception
     */
    NodoBinarioInterprete buscar(Interprete interprete) throws Exception {
        return buscar(interprete, raiz);
    }

    /**
     * Buscar nodo binario interprete.
     *
     * @param interprete the interprete
     * @param raiz       the raiz
     * @return the nodo binario interprete
     * @throws Exception the exception
     */
    NodoBinarioInterprete buscar(Interprete interprete, NodoBinarioInterprete raiz) throws Exception {
        while (raiz != null) {
            if (interprete.compareTo(raiz.getInterprete()) < 0)
                raiz = raiz.getIzquierdo();
            else if (interprete.compareTo(raiz.getInterprete()) > 0)
                raiz = raiz.getDerecho();
            else
                return raiz;
        }
        throw new Exception("Error en buscar: interprete no encontrado");
    }


    /**
     * Insertar.
     *
     * @param dato the dato
     * @throws Exception the exception
     */
    void insertar(Interprete dato) throws Exception {

        raiz = insertar(dato, raiz);
    }

    /**
     * Insertar nodo binario interprete.
     *
     * @param interprete the interprete
     * @param raiz       the raiz
     * @return the nodo binario interprete
     * @throws Exception the exception
     */
    NodoBinarioInterprete insertar(Interprete interprete, NodoBinarioInterprete raiz) throws Exception {

        if (raiz == null) {
            raiz = new NodoBinarioInterprete(interprete);
        } else if (interprete.compareTo(raiz.getInterprete()) < 0) {
            raiz.setIzquierdo(insertar(interprete, raiz.getIzquierdo()));
        } else if (interprete.compareTo(raiz.getInterprete()) > 0) {
            raiz.setDerecho(insertar(interprete, raiz.getDerecho()));
        } else {
            throw new Exception("Error en Insertar: ejercicio1.Interprete  duplicado (comparamos ignorando mayúsculas y minúsculas)");
        }
        return raiz;
    }

    /**
     * Esta vacio boolean.
     *
     * @return the boolean
     */
    public boolean estaVacio() {
        return raiz == null;
    }

    /**
     * Listar interpretes.
     */
    public void listarInterpretes() {
        listarInterpretes(raiz);
    }

    private void listarInterpretes(NodoBinarioInterprete nodo) {
        if (nodo != null) {
            listarInterpretes(nodo.getIzquierdo());
            System.out.println(nodo.toString());
            listarInterpretes(nodo.getDerecho());
        }
    }


    /**
     * Listar discos por anio.
     * al igual que en el listado de discos se ordena primero por año y en este caso como es el mismo
     * se ordenada por nombre del disco.
     *
     * @param anio the anio
     */
    public void listarDiscosPorAnio(int anio) {
        List<Disco> discosFiltrados = new ArrayList<>();

        // Recorre todos los intérpretes del árbol binario
        listarDiscosPorAnio(this.getRaiz(), anio, discosFiltrados);

        // Ordena los discos por año y nombre
        discosFiltrados.sort(Comparator.comparingInt(Disco::getAnio).thenComparing(Disco::getTituloDisco));

        // Muestra los discos filtrados
        discosFiltrados.forEach(System.out::println);

        if (discosFiltrados.isEmpty()) {
            System.out.println("No se encontraron discos del año " + anio + ".");
        } else {
            System.out.println("Discos del año " + anio + ".");
        }
    }

    private void listarDiscosPorAnio(NodoBinarioInterprete nodo, int anio, List<Disco> discosFiltrados) {
        if (nodo != null) {
            listarDiscosPorAnio(nodo.getIzquierdo(), anio, discosFiltrados);

            // Filtra los discos del intérprete actual
            nodo.getInterprete().getListaDiscos().stream()
                    .filter(disco -> disco.getAnio() == anio)
                    .forEach(discosFiltrados::add);

            listarDiscosPorAnio(nodo.getDerecho(), anio, discosFiltrados);
        }
    }
}
