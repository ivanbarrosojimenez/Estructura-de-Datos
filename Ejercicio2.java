import java.util.Arrays;

public class Ejercicio2 {
    /*
    Ejercicio 2: (2 puntos).
    Se dispone de la siguiente secuencia de números:
    21 45 20 3 31 10 8 50 9 3
    Esta secuencia se va ordenar por el método shellsort con un intervalo que se divide en 2
    (y no en 2.2) en cada iteración.
    1. Escriba cómo se va realizando el proceso de ordenación utilizando este algoritmo
    mostrando cómo quedaría al final de cada iteración (cada valor de intervalo).
    2. En el caso de que un número se repita, justifique si se mantiene su orden natural
    (el orden en el que aparecen en el array original) o no y en qué ocasiones ocurre
    una cosa o la otra.

    Resultado 1:
        [10, 8, 20, 3, 3, 21, 45, 50, 9, 31]
        [3, 3, 9, 8, 10, 21, 20, 31, 45, 50]
        [3, 3, 8, 9, 10, 20, 21, 31, 45, 50]
    Resultado 2:

       Shellsort no garantiza el orden natural, por ejemplo para: {7, 5, 6, 5, 9, 2} el orden natural no se mantiene porque el primer 5 se cambia con el 7
        En la segunda pasada se cambia el 2 con el segundo 5 y luego por el primer 5, quedando el el array con el el primer cinco en orden natural
        en segunda posición, en este caso no se cumple.

        Resultado: Shellsort no garantiza el orden natural de los números, pero en algunos casos sí se mantiene.
     */

    public static void main(String[] args) {
        int[] array = {21, 45, 20, 3, 31, 10, 8, 50, 9, 3};
        System.out.println("Array antes del ordenar:" + Arrays.toString(array));
        shellSort(array);
        System.out.println("Array ordenado: ");
        System.out.println(Arrays.toString(array));

        int[] array2 = {21, 45, 20, 10, 31, 5, 8, 50, 9, 10};
        System.out.println("\nArray antes del ordenar:" + Arrays.toString(array2));
        System.out.println("Array ordenado: ");
        shellSort(array2);
        System.out.println(Arrays.toString(array2));

        int[] array3 = {7, 5, 6, 5, 9, 2};
        System.out.println("\nArray antes del ordenar:" + Arrays.toString(array3));
        System.out.println("Array ordenado: ");
        shellSort(array3);
        System.out.println(Arrays.toString(array3));
    }

    public static void shellSort(int[] a) {
        int n = a.length;
        for (int gap = n / 2; gap > 0; gap /= 2) { // divide el intervalo entre 2
            for (int i = gap; i < n; i++) {
                int temp = a[i];
                int j;
                for (j = i; j >= gap && a[j - gap] > temp; j -= gap) {
                    System.out.println("Intercambiando " + temp + " con " + a[j - gap]);
                    a[j] = a[j - gap];
                }
                a[j] = temp;
            }
            System.out.println("  " + Arrays.toString(a));
        }
    }


}
