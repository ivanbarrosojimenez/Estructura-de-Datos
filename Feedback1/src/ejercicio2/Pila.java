package ejercicio2;

/**
 * La clase {@code Pila} representa una pila genérica que sigue el principio LIFO (Last In, First Out).
 * La pila es una estructura de datos lineal donde el último elemento que se inserta es el primero en salir.
 * La implementación utiliza un arreglo de tamaño fijo para almacenar los elementos.
 *
 * @param <T> el tipo de los elementos que contiene la pila
 */
public class Pila<T> {
    public static final int TAMANIO_POR_DEFECTO = 10;  // Tamaño por defecto de la pila
    private T[] pila;       // Arreglo para almacenar los elementos de la pila
    private int tope;       // Índice del último elemento insertado
    private int tamanioMax; // Tamaño máximo de la pila

    /**
     * Constructor: Crea una pila vacía con un tamaño determinado.
     *
     * @param tamanio el tamaño máximo de la pila, debe ser un número positivo
     * @throws IllegalArgumentException si el tamaño es menor o igual a cero
     */
    @SuppressWarnings("unchecked")  // Suprimimos advertencias por el cast
    public Pila(int tamanio) {
        if (tamanio <= 0) {
            throw new IllegalArgumentException("El tamaño debe ser un valor positivo.");
        }
        this.tamanioMax = tamanio;
        // Creamos un arreglo de tipo Object y lo convertimos a T[]
        this.pila = (T[]) new Object[tamanio];
        this.tope = -1;  // Indica que la pila está vacía
    }

    /**
     * Constructor: Crea una pila vacía con un tamaño por defecto de 10.
     */
    public Pila() {
        this(TAMANIO_POR_DEFECTO);  // Llama al constructor con un tamaño por defecto
    }

    /**
     * Método para obtener el tamaño total de la pila.
     *
     * @return el tamaño máximo de la pila
     */
    public int tamanio() {
        return tamanioMax;
    }

    /**
     * Método para verificar si la pila está vacía.
     *
     * @return {@code true} si la pila está vacía, {@code false} si no lo está
     */
    public boolean estaVacia() {
        return tope == -1;
    }

    /**
     * Método para obtener el elemento en la cima de la pila.
     *
     * @return el elemento en la cima de la pila
     * @throws IllegalStateException si la pila está vacía
     */
    public T cima() {
        if (estaVacia()) {
            throw new IllegalStateException("Pila vacía.");
        }
        return pila[tope];
    }

    /**
     * Método para insertar un elemento en la cima de la pila.
     *
     * @param elemento el elemento que se desea insertar en la pila
     * @throws IllegalStateException si la pila está llena
     */
    public void insertarElemento(T elemento) {
        if (tope == tamanioMax - 1) {
            throw new IllegalStateException("Pila llena.");
        }
        pila[++tope] = elemento;
    }

    /**
     * Método para eliminar el elemento en la cima de la pila.
     *
     * @throws IllegalStateException si la pila está vacía
     */
    public void eliminarElemento() {
        if (estaVacia()) {
            throw new IllegalStateException("Pila vacía.");
        }
        pila[tope--] = null;  // Eliminar el elemento y reducir el tope
    }

    /**
     * Método para mostrar los elementos de la pila en orden, desde la cima hasta el fondo.
     * Si la pila está vacía, muestra un mensaje indicando que la pila está vacía.
     */
    public void mostrarPila() {
        if (estaVacia()) {
            System.out.println("Pila vacía.");
            return;
        }
        for (int i = tope; i >= 0; i--) {
            System.out.println(pila[i]);
        }
    }
}
