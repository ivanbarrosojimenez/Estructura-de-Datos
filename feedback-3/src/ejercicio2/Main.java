package src.ejercicio2;

import java.util.Arrays;

public class Main {
    enum EstrategiaPivote {
        PRIMERO, ULTIMO, MEDIO, ALEATORIO
    }

    static int llamadas = 0;
    static int comparaciones = 0;

    public static void main(String[] args) {
        int[] numeros = {1, 0, 6, 4, 8, 2, 4, 7, 7};

        numeros = new int[]{1, 0, 6, 4, 8, 2, 4, 7, 7};
        System.out.println(Arrays.toString(numeros));

        insercion(numeros);


        //Mala elección de pivote, pruebas:
        System.out.println("Ordenación con mala elección de pivote, seleccionando el primer elemento del array:");
        llamadas = 0;
        comparaciones = 0;
        //Mejor eleccion de pivote
        int[] arreglo = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println("Arreglo original: " + Arrays.toString(arreglo));
        EstrategiaPivote estrategia = EstrategiaPivote.PRIMERO; // Cambia aquí: PRIMERO, ULTIMO, MEDIO, ALEATORIO
        quicksort(arreglo, 0, arreglo.length - 1, estrategia);

        System.out.println("\nArreglo ordenado: " + Arrays.toString(arreglo) + "  ");
        System.out.println("Llamadas a quicksort: " + llamadas + "  ");
        System.out.println("Comparaciones: " + comparaciones + "  ");

        System.out.println("Ordenación con mala elección de pivote, seleccionando la mitad de tamaño del array:");
        arreglo = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        estrategia = EstrategiaPivote.MEDIO; // Cambia aquí: PRIMERO, ULTIMO, MEDIO, ALEATORIO
        quicksort(arreglo, 0, arreglo.length - 1, estrategia);

        System.out.println("\nArreglo ordenado: " + Arrays.toString(arreglo) + "  ");
        System.out.println("Llamadas a quicksort: " + llamadas + "  ");
        System.out.println("Comparaciones: " + comparaciones + "  ");

        System.out.println("Ordenación con mala elección de pivote, seleccionando uno aleatorio del array:");
        arreglo = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        estrategia = EstrategiaPivote.ALEATORIO; // Cambia aquí: PRIMERO, ULTIMO, MEDIO, ALEATORIO
        quicksort(arreglo, 0, arreglo.length - 1, estrategia);

        System.out.println("\nArreglo ordenado: " + Arrays.toString(arreglo));
        System.out.println("Llamadas a quicksort: " + llamadas + "  ");
        System.out.println("Comparaciones: " + comparaciones + "  ");

        System.out.println("Ordenación con mala elección de pivote, seleccionando el último elemento del array:");
        arreglo = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        estrategia = EstrategiaPivote.ULTIMO; // Cambia aquí: PRIMERO, ULTIMO, MEDIO, ALEATORIO
        quicksort(arreglo, 0, arreglo.length - 1, estrategia);


        System.out.println("\nArreglo ordenado: " + Arrays.toString(arreglo));
        System.out.println("Llamadas a quicksort: " + llamadas + "  ");
        System.out.println("Comparaciones: " + comparaciones + "  ");
        System.out.println("---------");
        System.out.println("---------");
        System.out.println("---------");

    }

    // INSERCCIÓN
    public static void insercion(int[] a) {
        int temp;
        int i, j;

        for (i = 1; i < a.length; i++) {
            temp = a[i];
            String cambios = "" + a[i] + " se cambia por ";
            for (j = i; j > 0 && imprimeCondicion("Temp=" + temp + "<" + a[j - 1] + ", j=" + j, temp < a[j - 1]) && temp < a[j - 1]; j--) {
                cambios += "" + a[j - 1] + ", ";
                //System.out.println("a[" + j + "]<- " + a[j] + " = a[" + (j - 1) + "]<- " + a[j - 1]);
                a[j] = a[j - 1];
            }
            a[j] = temp;
            System.out.println("Iteracion " + (i - 1) + " con i=" + i + " " + Arrays.toString(a));
            //System.out.println(cambios);
        }
    }

    public static boolean imprimeCondicion(String condicion, boolean resultado) {
        if (resultado) {
            //System.out.println(condicion + " es verdadero");
        } else {
            // System.out.println(condicion + " es falso");
        }
        return resultado;
    }

    public static void quicksort(int[] arr, int inicio, int fin, EstrategiaPivote estrategia) {
        llamadas++;
        if (inicio < fin) {
            int indicePivote = seleccionarPivote(arr, inicio, fin, estrategia);

            System.out.print("↪ Ordenando [" + inicio + "-" + fin + "] ");
            System.out.print("(pivote = " + arr[indicePivote] + "): ");
            imprimirSubarray(arr, inicio, fin);

            int nuevaPosicionPivote = particionar(arr, inicio, fin, indicePivote);

            quicksort(arr, inicio, nuevaPosicionPivote - 1, estrategia);
            quicksort(arr, nuevaPosicionPivote + 1, fin, estrategia);
        }
    }

    public static int particionar(int[] arr, int inicio, int fin, int indicePivote) {
        intercambiar(arr, inicio, indicePivote);
        int pivote = arr[inicio];
        int i = inicio + 1;

        for (int j = i; j <= fin; j++) {
            comparaciones++;
            if (arr[j] < pivote) {
                intercambiar(arr, i, j);
                i++;
            }
        }

        intercambiar(arr, inicio, i - 1);
        return i - 1;
    }

    public static int seleccionarPivote(int[] arr, int inicio, int fin, EstrategiaPivote estrategia) {
        return switch (estrategia) {
            case PRIMERO -> inicio;
            case ULTIMO -> fin;
            case MEDIO -> inicio + (fin - inicio) / 2;
            case ALEATORIO -> inicio + (int) (Math.random() * (fin - inicio + 1));
        };
    }

    public static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void imprimirSubarray(int[] arr, int inicio, int fin) {
        System.out.print("[ ");
        for (int i = inicio; i <= fin; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

}
