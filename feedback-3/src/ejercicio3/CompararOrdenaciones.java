package src.ejercicio3;

import java.util.Arrays;
import java.util.function.Consumer;

public class CompararOrdenaciones {

    static int comparaciones = 0;

    public static void main(String[] args) {
        int[] array = {5, 3, 4, 1, 2, 6, 8, 7, 9, 10};
        System.out.println(Arrays.toString(array));
        probar("Inserción directa", array.clone(), CompararOrdenaciones::insercionDirecta);
        probar("Selección directa", array.clone(), CompararOrdenaciones::seleccionDirecta);
        probar("Intercambio directo", array.clone(), CompararOrdenaciones::intercambioDirecto);

        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(array));
        probar("Inserción directa ordenado", array.clone(), CompararOrdenaciones::insercionDirecta);
        probar("Selección directa ordenado", array.clone(), CompararOrdenaciones::seleccionDirecta);
        probar("Intercambio directo ordenado", array.clone(), CompararOrdenaciones::intercambioDirecto);

        array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(array));
        probar("Inserción directa desordenado", array.clone(), CompararOrdenaciones::insercionDirecta);
        probar("Selección directa desordenado", array.clone(), CompararOrdenaciones::seleccionDirecta);
        probar("Intercambio directo desordenado", array.clone(), CompararOrdenaciones::intercambioDirecto);
    }

    public static void probar(String nombre, int[] array, Consumer<int[]> metodoOrdenacion) {
        comparaciones = 0;
        metodoOrdenacion.accept(array);
        System.out.println(nombre + " → Comparaciones: " + comparaciones + " | Tiempo total: " + (comparaciones * 10) + "ms");
    }

    // Simulación de comparación (con retraso)
    public static boolean comparar(int a, int b) {
        comparaciones++;
        try {
            Thread.sleep(10); // simulamos que comparar cuesta 10ms
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return a > b;
    }

    public static void insercionDirecta(int[] a) {
        int temp;
        int i, j;
        for (i = 1; i < a.length; i++) {
            temp = a[i];
            for (j = i; j > 0 && comparar(a[j - 1], temp); j--) {
                a[j] = a[j - 1];
            }
            a[j] = temp;
        }
    }

    //SELECCIÓN
    public static void seleccionDirecta(int[] a) {
        int temp;
        int menor;
        int i, j;
        for (i = 0; i < a.length; i++) {
            menor = i;
            for (j = i + 1; j < a.length; j++) {
                if (comparar(a[menor], a[j])) {
                    menor = j;
                }
            }

            temp = a[i];
            a[i] = a[menor];
            a[menor] = temp;
        }
    }

    //INTERCAMBIO
    public static void intercambioDirecto(int[] a) {
        int i, j;
        int temp;
        for (i = 0; i < a.length; i++) {
            for (j = a.length - 1; j > i; j--) {
                if (comparar(a[j - 1], a[j])) {
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
