feedback-3# feedback-3

> **Asignatura:** Estructura de Datos  
> **Autor:** Iván Barroso Jiménez

#Se puede clonar el proyecto desde:

### git@gitlab.com:barrosojimenezivan/feedback-3.git

### https://gitlab.com/barrosojimenezivan/feedback-3.git

##                  

## Ejercicio 2

Se dispone de la siguiente secuencia de números:
1 0 6 4 8 2 4 7 7
Esta secuencia se va ordenar por el método de inserción directa

# Parte 1. Escriba cómo queda el array después de cada fase de recorrido en que un dato más queda ordenado (no paso a paso).

Iteracion 0 con i=1 [0, 1, 6, 4, 8, 2, 4, 7, 7]  
Iteracion 1 con i=2 [0, 1, 6, 4, 8, 2, 4, 7, 7]   ** Sin cambios  
Iteracion 2 con i=3 [0, 1, 4, 6, 8, 2, 4, 7, 7]  
Iteracion 3 con i=4 [0, 1, 4, 6, 8, 2, 4, 7, 7]   ** Sin cambios  
Iteracion 4 con i=5 [0, 1, 2, 4, 6, 8, 4, 7, 7]  
Iteracion 5 con i=6 [0, 1, 2, 4, 4, 6, 8, 7, 7]  
Iteracion 6 con i=7 [0, 1, 2, 4, 4, 6, 7, 8, 7]  
Iteracion 7 con i=8 [0, 1, 2, 4, 4, 6, 7, 7, 8]

Código usado:

```java
    public static void insercion(int[] a) {
    int temp;
    int i, j;

    for (i = 1; i < a.length; i++) {
        temp = a[i];
        String cambios = "" + a[i] + " se cambia por ";
        for (j = i; j > 0 && imprimeCondicion("Temp=" + temp + "<" + a[j - 1] + ", j=" + j, temp < a[j - 1]) && temp < a[j - 1]; j--) {
            cambios += "" + a[j - 1] + ", ";
            a[j] = a[j - 1];
        }
        a[j] = temp;
        System.out.println("Iteracion " + (i - 1) + " con i=" + i + " " + Arrays.toString(a));
    }
}
```

# Parte 2. En el método de ordenación quicksort existe un elemento privilegiado que se denomina pivote. ¿A qué se llama pivote y por qué es tan importante una elección apropiada del mismo?. Ponga un ejemplo en el que la elección del pivote genera complejidad O(n2)

### El pivote en quicksrot es la posición del índice por donde vamos a partir los arrays para llamar de forma recursiva mientras sigan desordenados.

### Una mala elección es por ejemplo elegir siempre el primer elemento como pivote, ya que si el array está ordenado o casi ordenado resulta una complejidad O(n^2), porque en cada iteración se va a recorrer todo el array para encontrar los elementos menores o mayores al pivote, y al ser el primer elemento siempre el pivote, no se va a dividir el array de forma eficiente.

### Ejemplo de salida con las pruebas realizadas sobre un array ordenado de 20 elemetos selecccionando como pivote el primero, último, medio y aleatorio.

```text
Ordenación con mala elección de pivote, seleccionando el primer elemento del array:
Arreglo original: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
↪ Ordenando [0-19] (pivote = 1): [ 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 ]
↪ Ordenando [1-19] (pivote = 2): [ 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 ]
↪ Ordenando [2-19] (pivote = 3): [ 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 ]
↪ Ordenando [3-19] (pivote = 4): [ 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 ]
↪ Ordenando [4-19] (pivote = 5): [ 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 ]
↪ Ordenando [5-19] (pivote = 6): [ 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 ]
↪ Ordenando [6-19] (pivote = 7): [ 7 8 9 10 11 12 13 14 15 16 17 18 19 20 ]
↪ Ordenando [7-19] (pivote = 8): [ 8 9 10 11 12 13 14 15 16 17 18 19 20 ]
↪ Ordenando [8-19] (pivote = 9): [ 9 10 11 12 13 14 15 16 17 18 19 20 ]
↪ Ordenando [9-19] (pivote = 10): [ 10 11 12 13 14 15 16 17 18 19 20 ]
↪ Ordenando [10-19] (pivote = 11): [ 11 12 13 14 15 16 17 18 19 20 ]
↪ Ordenando [11-19] (pivote = 12): [ 12 13 14 15 16 17 18 19 20 ]
↪ Ordenando [12-19] (pivote = 13): [ 13 14 15 16 17 18 19 20 ]
↪ Ordenando [13-19] (pivote = 14): [ 14 15 16 17 18 19 20 ]
↪ Ordenando [14-19] (pivote = 15): [ 15 16 17 18 19 20 ]
↪ Ordenando [15-19] (pivote = 16): [ 16 17 18 19 20 ]
↪ Ordenando [16-19] (pivote = 17): [ 17 18 19 20 ]
↪ Ordenando [17-19] (pivote = 18): [ 18 19 20 ]
↪ Ordenando [18-19] (pivote = 19): [ 19 20 ]

Arreglo ordenado: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]  
Llamadas a quicksort: 39  
Comparaciones: 190  
Ordenación con mala elección de pivote, seleccionando la mitad de tamaño del array:
↪ Ordenando [0-19] (pivote = 10): [ 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 ]
↪ Ordenando [0-8] (pivote = 5): [ 1 2 3 4 5 6 7 8 9 ]
↪ Ordenando [0-3] (pivote = 2): [ 1 2 3 4 ]
↪ Ordenando [2-3] (pivote = 3): [ 3 4 ]
↪ Ordenando [5-8] (pivote = 7): [ 6 7 8 9 ]
↪ Ordenando [7-8] (pivote = 8): [ 8 9 ]
↪ Ordenando [10-19] (pivote = 15): [ 11 12 13 14 15 16 17 18 19 20 ]
↪ Ordenando [10-13] (pivote = 12): [ 11 12 13 14 ]
↪ Ordenando [12-13] (pivote = 13): [ 13 14 ]
↪ Ordenando [15-19] (pivote = 18): [ 16 17 18 19 20 ]
↪ Ordenando [15-16] (pivote = 16): [ 16 17 ]
↪ Ordenando [18-19] (pivote = 19): [ 19 20 ]

Arreglo ordenado: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]  
Llamadas a quicksort: 64  
Comparaciones: 244  
Ordenación con mala elección de pivote, seleccionando uno aleatorio del array:
↪ Ordenando [0-19] (pivote = 5): [ 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 ]
↪ Ordenando [0-3] (pivote = 1): [ 1 2 3 4 ]
↪ Ordenando [1-3] (pivote = 3): [ 2 3 4 ]
↪ Ordenando [5-19] (pivote = 10): [ 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 ]
↪ Ordenando [5-8] (pivote = 8): [ 6 7 8 9 ]
↪ Ordenando [5-6] (pivote = 7): [ 6 7 ]
↪ Ordenando [10-19] (pivote = 18): [ 11 12 13 14 15 16 17 18 19 20 ]
↪ Ordenando [10-16] (pivote = 14): [ 11 12 13 14 15 16 17 ]
↪ Ordenando [10-12] (pivote = 13): [ 11 12 13 ]
↪ Ordenando [10-11] (pivote = 11): [ 11 12 ]
↪ Ordenando [14-16] (pivote = 16): [ 15 16 17 ]
↪ Ordenando [18-19] (pivote = 19): [ 19 20 ]

Arreglo ordenado: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
Llamadas a quicksort: 89  
Comparaciones: 307  
Ordenación con mala elección de pivote, seleccionando el último elemento del array:
↪ Ordenando [0-19] (pivote = 20): [ 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 ]
↪ Ordenando [0-18] (pivote = 19): [ 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 ]
↪ Ordenando [0-17] (pivote = 18): [ 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 ]
↪ Ordenando [0-16] (pivote = 17): [ 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 ]
↪ Ordenando [0-15] (pivote = 16): [ 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 ]
↪ Ordenando [0-14] (pivote = 15): [ 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 ]
↪ Ordenando [0-13] (pivote = 14): [ 1 2 3 4 5 6 7 8 9 10 11 12 13 14 ]
↪ Ordenando [0-12] (pivote = 13): [ 1 2 3 4 5 6 7 8 9 10 11 12 13 ]
↪ Ordenando [0-11] (pivote = 12): [ 1 2 3 4 5 6 7 8 9 10 11 12 ]
↪ Ordenando [0-10] (pivote = 11): [ 1 2 3 4 5 6 7 8 9 10 11 ]
↪ Ordenando [0-9] (pivote = 10): [ 1 2 3 4 5 6 7 8 9 10 ]
↪ Ordenando [0-8] (pivote = 9): [ 1 2 3 4 5 6 7 8 9 ]
↪ Ordenando [0-7] (pivote = 8): [ 1 2 3 4 5 6 7 8 ]
↪ Ordenando [0-6] (pivote = 7): [ 1 2 3 4 5 6 7 ]
↪ Ordenando [0-5] (pivote = 6): [ 1 2 3 4 5 6 ]
↪ Ordenando [0-4] (pivote = 5): [ 1 2 3 4 5 ]
↪ Ordenando [0-3] (pivote = 4): [ 1 2 3 4 ]
↪ Ordenando [0-2] (pivote = 3): [ 1 2 3 ]
↪ Ordenando [0-1] (pivote = 2): [ 1 2 ]

Arreglo ordenado: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
Llamadas a quicksort: 128  
Comparaciones: 497  
---------
---------
---------

```

## Resulto de la compración de los resultados:

Como se puede apreciar en los resultados elegir un pivote inicial o final respecto a uno medio eleva el numero de
llamadas e iteraciones exponencialmente.

```java
Código java
usado en
ejercicio3/Main.java
```
