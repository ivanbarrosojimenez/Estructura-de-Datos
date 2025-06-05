# feedback-2

> **Asignatura:** Estructura de Datos  
> **Autor:** Iván Barroso Jiménez

#Se puede clonar el proyecto desde:

### git@gitlab.com:estructura-de-datos2842616/feedback-2.git

### https://gitlab.com/estructura-de-datos2842616/feedback-2.git

##                              

## Ejercicio 3

Calcule la complejidad de los métodos de la clase MetodosPrueba que está contenida en el archivo complejidad.jar
adjunto. Para ello puede hacer uso de la clase
Cronómetro (también en complejidad.jar).
Debe medir el tiempo que tarda en ejecutarse cada uno de los métodos y estu- diar
cómo varía este tiempo en función del parámetro de entrada.
Debe entregar una tabla de tiempos de ejecución y estimar el orden de compleji- dad
de cada uno de los métodos.
Para utilizar el archivo complejidad.jar añádalo como librería al proyecto y despliéguelo para obtener su contenido.

## Resultados

He escrito algunos metodos para que los resultados sean legibles y muy visuales, se puede revisar el código en la clase
Main y la Clase UtilidadObtenerResultados (que usa la clase Main)

Se han realizado 10 iteraciones de cada método, midiendo el tiempo en milisegundos (ms) que tarda en ejecutarse cada
uno. A continuación se muestran las tablas de tiempos y los incrementos porcentuales entre iteraciones.
Los valores han sido una lista con los valores del 1 al 10.

## Método m1

| Método | Iteración | Tiempo (ms) | Incremento (%) |
|--------|-----------|-------------|----------------|
| m1     | 1         | 61          | N/A            |
| m1     | 2         | 251         | 311,48         |
| m1     | 3         | 563         | 124,30         |
| m1     | 4         | 996         | 76,91          |
| m1     | 5         | 1562        | 56,83          |
| m1     | 6         | 2229        | 42,70          |
| m1     | 7         | 3043        | 36,52          |
| m1     | 8         | 3973        | 30,56          |
| m1     | 9         | 5038        | 26,81          |
| m1     | 10        | 6226        | 23,58          |

Gráfica de tiempos (x: iteraciones, y: tiempo en ms):

1 |  (61,00 ms)  
2 | ** (251,00 ms)  
3 | **** (563,00 ms)  
4 | ******* (996,00 ms)  
5 | ************ (1562,00 ms)  
6 | ***************** (2229,00 ms)  
7 | ************************ (3043,00 ms)  
8 | ******************************* (3973,00 ms)  
9 | **************************************** (5038,00 ms)  
10 | ************************************************** (6226,00 ms)

```java
   public void m1(int n) {
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            try {
                Thread.sleep(50L);
            } catch (InterruptedException var5) {
            }
        }
    }
}
```

### Orden de complejidad: O(n^2) contiene un bucle anidado doble por lo que el tiempo aumenta exponencialmente

## Método m2

| Método | Iteración | Tiempo (ms) | Incremento (%) |
|--------|-----------|-------------|----------------|
| m2     | 1         | 12          | N/A            |
| m2     | 2         | 32          | 166,67         |
| m2     | 3         | 46          | 43,75          |
| m2     | 4         | 62          | 34,78          |
| m2     | 5         | 78          | 25,81          |
| m2     | 6         | 94          | 20,51          |
| m2     | 7         | 108         | 14,89          |
| m2     | 8         | 124         | 14,81          |
| m2     | 9         | 140         | 12,90          |
| m2     | 10        | 156         | 11,43          |

Gráfica de tiempos (x: iteraciones, y: tiempo en ms):

1 | *** (12,00 ms)   
2 | ********** (32,00 ms)   
3 | ************** (46,00 ms)   
4 | ******************* (62,00 ms)   
5 | ************************* (78,00 ms)   
6 | ****************************** (94,00 ms)   
7 | ********************************** (108,00 ms)   
8 | *************************************** (124,00 ms)   
9 | ******************************************** (140,00 ms)   
10 | ************************************************** (156,00 ms)

```java
    public void m2(int n) {
    for (int i = 0; i < n; ++i) {
        try {
            Thread.sleep(10L);
        } catch (InterruptedException var4) {
        }
    }
}
```

### Orden de complejidad: O(n) contiene un bucle simple por lo que el resultado es lineal

| Método | Iteración | Tiempo (ms) | Incremento (%) |
|--------|-----------|-------------|----------------|
| m3     | 1         | 73          | N/A            |
| m3     | 2         | 127         | 73,97          |
| m3     | 3         | 188         | 48,03          |
| m3     | 4         | 249         | 32,45          |
| m3     | 5         | 312         | 25,30          |
| m3     | 6         | 372         | 19,23          |
| m3     | 7         | 434         | 16,67          |
| m3     | 8         | 495         | 14,06          |
| m3     | 9         | 560         | 13,13          |
| m3     | 10        | 617         | 10,18          |

Gráfica de tiempos (x: iteraciones, y: tiempo en ms):

1 | ***** (73,00 ms)   
2 | ********** (127,00 ms)   
3 | *************** (188,00 ms)   
4 | ******************** (249,00 ms)   
5 | ************************* (312,00 ms)   
6 | ****************************** (372,00 ms)   
7 | *********************************** (434,00 ms)   
8 | **************************************** (495,00 ms)   
9 | ********************************************* (560,00 ms)   
10 | ************************************************** (617,00 ms)

```java
public void m3(int n) {
    for (int i = 0; i < n; ++i) {
        try {
            Thread.sleep(60L);
        } catch (InterruptedException var4) {
        }
    }

}
```

### Orden de complejidad: O(n) contiene un bucle simple por lo que el resultado es lineal

## Método m4

| Método | Iteración | Tiempo (ms) | Incremento (%) |
|--------|-----------|-------------|----------------|
| m4     | 1         | 13          | N/A            |
| m4     | 2         | 124         | 853,85         |
| m4     | 3         | 354         | 185,48         |
| m4     | 4         | 670         | 89,27          |
| m4     | 5         | 1848        | 175,82         |
| m4     | 6         | 3352        | 81,39          |
| m4     | 7         | 5333        | 59,10          |
| m4     | 8         | 7977        | 49,58          |
| m4     | 9         | 11341       | 42,17          |
| m4     | 10        | 15535       | 36,98          |

Gráfica de tiempos (x: iteraciones, y: tiempo en ms):

1 |  (13,00 ms)   
2 |  (124,00 ms)   
3 | * (354,00 ms)   
4 | ** (670,00 ms)   
5 | ***** (1848,00 ms)   
6 | ********** (3352,00 ms)   
7 | ***************** (5333,00 ms)   
8 | ************************* (7977,00 ms)   
9 | ************************************ (11341,00 ms)   
10 | ************************************************** (15535,00 ms)

```java
    public void m4(int n) {
    for (int k = 0; k < n; ++k) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException var6) {
                }
            }
        }
    }

}
```

### Order de complejidad: O(n^3) contiene un bucle anidado triple por lo que el tiempo aumenta exponencialmente

## Método m5

| Método | Iteración | Tiempo (ms) | Incremento (%) |
|--------|-----------|-------------|----------------|
| m5     | 1         | 1           | N/A            |
| m5     | 2         | 306         | 30500,00       |
| m5     | 3         | 623         | 103,59         |
| m5     | 4         | 621         | -0,32          |
| m5     | 5         | 928         | 49,44          |
| m5     | 6         | 930         | 0,22           |
| m5     | 7         | 929         | -0,11          |
| m5     | 8         | 932         | 0,32           |
| m5     | 9         | 1249        | 34,01          |
| m5     | 10        | 1237        | -0,96          |

Gráfica de tiempos (x: iteraciones, y: tiempo en ms):

1 |  (1,00 ms)   
2 | ************ (306,00 ms)   
3 | ************************ (623,00 ms)   
4 | ************************ (621,00 ms)   
5 | ************************************* (928,00 ms)   
6 | ************************************* (930,00 ms)   
7 | ************************************* (929,00 ms)   
8 | ************************************* (932,00 ms)   
9 | ************************************************** (1249,00 ms)   
10 | ************************************************* (1237,00 ms)   
'

```java
    public void m5(int n) {
    for (int i = 1; i < n; i *= 2) {
        try {
            Thread.sleep(300L);
        } catch (InterruptedException var4) {
        }
    }

}
```

### Complejidad: O(log n) contiene un bucle que se ejecuta log(n) veces, por lo que el tiempo aumenta logarítmicamente

## Método m6

| Método | Iteración | Tiempo (ms) | Incremento (%) |
|--------|-----------|-------------|----------------|
| m6     | 1         | 2           | N/A            |
| m6     | 2         | 4           | 100,00         |
| m6     | 3         | 4           | 0,00           |
| m6     | 4         | 5           | 25,00          |
| m6     | 5         | 10          | 100,00         |
| m6     | 6         | 12          | 20,00          |
| m6     | 7         | 12          | 0,00           |
| m6     | 8         | 12          | 0,00           |
| m6     | 9         | 14          | 16,67          |
| m6     | 10        | 12          | -14,29         |

Gráfica de tiempos (x: iteraciones, y: tiempo en ms):

1 | ******* (2,00 ms)   
2 | ************** (4,00 ms)   
3 | ************** (4,00 ms)   
4 | ***************** (5,00 ms)   
5 | *********************************** (10,00 ms)   
6 | ****************************************** (12,00 ms)   
7 | ****************************************** (12,00 ms)   
8 | ****************************************** (12,00 ms)   
9 | ************************************************** (14,00 ms)   
10 | ****************************************** (12,00 ms)

```java
    public void m6(int n) {
    for (int i = 0; i < n; ++i) {
        try {
            Thread.sleep(1L);
        } catch (InterruptedException var4) {
        }
    }
}
```

### Orden de complejidad: O(n) contiene un bucle simple por lo que el resultado es lineal

| Método | Iteración | Tiempo (ms) | Incremento (%) |
|--------|-----------|-------------|----------------|
| m7     | 1         | 1           | N/A            |
| m7     | 2         | 108         | 10700,00       |
| m7     | 3         | 217         | 100,93         |
| m7     | 4         | 220         | 1,38           |
| m7     | 5         | 326         | 48,18          |
| m7     | 6         | 326         | 0,00           |
| m7     | 7         | 325         | -0,31          |
| m7     | 8         | 327         | 0,62           |
| m7     | 9         | 439         | 34,25          |
| m7     | 10        | 433         | -1,37          |

Gráfica de tiempos (x: iteraciones, y: tiempo en ms):

1 |  (1,00 ms)   
2 | ************ (108,00 ms)   
3 | ************************ (217,00 ms)   
4 | ************************* (220,00 ms)   
5 | ************************************* (326,00 ms)   
6 | ************************************* (326,00 ms)   
7 | ************************************* (325,00 ms)   
8 | ************************************* (327,00 ms)   
9 | ************************************************** (439,00 ms)   
10 | ************************************************* (433,00 ms)

```java
    public void m7(int n) {
    for (int i = 1; i < n; i *= 2) {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException var4) {
        }
    }
}
```

### Orden de complejidad: O(log n) contiene un bucle que se ejecuta log(n) veces, por lo que el tiempo aumenta logarítmicamente

## Resultados con otra bateria de pruebas

### Prueba con valores impares

| Método | Iteración | Tiempo (ms) | Incremento (%) |
|--------|-----------|-------------|----------------|
| m1     | 1         | 61          | N/A            |
| m1     | 3         | 564         | 824,59         |
| m1     | 5         | 1560        | 176,60         |
| m1     | 7         | 3056        | 95,90          |
| m1     | 9         | 5041        | 64,95          |

Gráfica de tiempos (x: iteraciones, y: tiempo en ms):

1 |  (61,00 ms)   
3 | ***** (564,00 ms)   
5 | *************** (1560,00 ms)   
7 | ****************************** (3056,00 ms)   
9 | ************************************************** (5041,00 ms)

| Método | Iteración | Tiempo (ms) | Incremento (%) |
|--------|-----------|-------------|----------------|
| m2     | 1         | 12          | N/A            |
| m2     | 3         | 46          | 283,33         |
| m2     | 5         | 76          | 65,22          |
| m2     | 7         | 109         | 43,42          |
| m2     | 9         | 140         | 28,44          |

Gráfica de tiempos (x: iteraciones, y: tiempo en ms):

1 | **** (12,00 ms)   
3 | **************** (46,00 ms)   
5 | *************************** (76,00 ms)   
7 | ************************************** (109,00 ms)   
9 | ************************************************** (140,00 ms)

| Método | Iteración | Tiempo (ms) | Incremento (%) |
|--------|-----------|-------------|----------------|
| m3     | 1         | 75          | N/A            |
| m3     | 3         | 186         | 148,00         |
| m3     | 5         | 307         | 65,05          |
| m3     | 7         | 435         | 41,69          |
| m3     | 9         | 572         | 31,49          |

Gráfica de tiempos (x: iteraciones, y: tiempo en ms):

1 | ****** (75,00 ms)   
3 | **************** (186,00 ms)   
5 | ************************** (307,00 ms)   
7 | ************************************** (435,00 ms)   
9 | ************************************************** (572,00 ms)

| Método | Iteración | Tiempo (ms) | Incremento (%) |
|--------|-----------|-------------|----------------|
| m4     | 1         | 13          | N/A            |
| m4     | 3         | 418         | 3115,38        |
| m4     | 5         | 1942        | 364,59         |
| m4     | 7         | 5322        | 174,05         |
| m4     | 9         | 11332       | 112,93         |

Gráfica de tiempos (x: iteraciones, y: tiempo en ms):

1 |  (13,00 ms)   
3 | * (418,00 ms)   
5 | ******** (1942,00 ms)   
7 | *********************** (5322,00 ms)   
9 | ************************************************** (11332,00 ms)

| Método | Iteración | Tiempo (ms) | Incremento (%) |
|--------|-----------|-------------|----------------|
| m5     | 1         | 0           | N/A            |
| m5     | 3         | 614         | Infinity       |
| m5     | 5         | 934         | 52,12          |
| m5     | 7         | 927         | -0,75          |
| m5     | 9         | 1246        | 34,41          |

Gráfica de tiempos (x: iteraciones, y: tiempo en ms):

1 |  (0,00 ms)   
3 | ************************ (614,00 ms)   
5 | ************************************* (934,00 ms)   
7 | ************************************* (927,00 ms)   
9 | ************************************************** (1246,00 ms)

| Método | Iteración | Tiempo (ms) | Incremento (%) |
|--------|-----------|-------------|----------------|
| m6     | 1         | 13          | N/A            |
| m6     | 3         | 47          | 261,54         |
| m6     | 5         | 79          | 68,09          |
| m6     | 7         | 109         | 37,97          |
| m6     | 9         | 137         | 25,69          |

Gráfica de tiempos (x: iteraciones, y: tiempo en ms):

1 | **** (13,00 ms)   
3 | ***************** (47,00 ms)   
5 | **************************** (79,00 ms)   
7 | *************************************** (109,00 ms)   
9 | ************************************************** (137,00 ms)

| Método | Iteración | Tiempo (ms) | Incremento (%) |
|--------|-----------|-------------|----------------|
| m7     | 1         | 1           | N/A            |
| m7     | 3         | 215         | 21400,00       |
| m7     | 5         | 326         | 51,63          |
| m7     | 7         | 323         | -0,92          |
| m7     | 9         | 434         | 34,37          |

Gráfica de tiempos (x: iteraciones, y: tiempo en ms):

1 |  (1,00 ms)   
3 | ************************ (215,00 ms)   
5 | ************************************* (326,00 ms)   
7 | ************************************* (323,00 ms)   
9 | ************************************************** (434,00 ms)

### Prueba con valores pares

| Método | Iteración | Tiempo (ms) | Incremento (%) |
|--------|-----------|-------------|----------------|
| m1     | 2         | 257         | N/A            |
| m1     | 4         | 983         | 282,49         |
| m1     | 6         | 2255        | 129,40         |
| m1     | 8         | 3981        | 76,54          |
| m1     | 10        | 6225        | 56,37          |

Gráfica de tiempos (x: iteraciones, y: tiempo en ms):

2 | ** (257,00 ms)   
4 | ******* (983,00 ms)   
6 | ****************** (2255,00 ms)   
8 | ******************************* (3981,00 ms)   
10 | ************************************************** (6225,00 ms)

| Método | Iteración | Tiempo (ms) | Incremento (%) |
|--------|-----------|-------------|----------------|
| m2     | 2         | 39          | N/A            |
| m2     | 4         | 62          | 58,97          |
| m2     | 6         | 93          | 50,00          |
| m2     | 8         | 125         | 34,41          |
| m2     | 10        | 155         | 24,00          |

Gráfica de tiempos (x: iteraciones, y: tiempo en ms):

2 | ************ (39,00 ms)   
4 | ******************** (62,00 ms)   
6 | ****************************** (93,00 ms)   
8 | **************************************** (125,00 ms)   
10 | ************************************************** (155,00 ms)

| Método | Iteración | Tiempo (ms) | Incremento (%) |
|--------|-----------|-------------|----------------|
| m3     | 2         | 135         | N/A            |
| m3     | 4         | 246         | 82,22          |
| m3     | 6         | 375         | 52,44          |
| m3     | 8         | 496         | 32,27          |
| m3     | 10        | 626         | 26,21          |

Gráfica de tiempos (x: iteraciones, y: tiempo en ms):

2 | ********** (135,00 ms)   
4 | ******************* (246,00 ms)   
6 | ***************************** (375,00 ms)   
8 | *************************************** (496,00 ms)   
10 | ************************************************** (626,00 ms)

## Resultado de pruebas con valores impares y pares

### No se aprecian diferencias significativas entre los resultados de las pruebas con valores impares y pares, lo que sugiere que la complejidad de los métodos no se ve afectada por la paridad de los números. Los incrementos porcentuales y los tiempos de ejecución son consistentes en ambas pruebas, lo que refuerza la validez de las estimaciones de complejidad realizadas anteriormente.

### Conclusión

- m1: O(n^2) - Bucle anidado doble, tiempo cuadrático.
- m2: O(n) - Bucle simple, tiempo lineal.
- m3: O(n) - Bucle simple, tiempo lineal.
- m4: O(n^3) - Bucle anidado triple, tiempo cúbico.
- m5: O(log n) - Bucle que se ejecuta log(n) veces, tiempo logarítmico.
- m6: O(n) - Bucle simple, tiempo lineal.
- m7: O(log n) - Bucle que se ejecuta log(n) veces, tiempo logarítmico.
