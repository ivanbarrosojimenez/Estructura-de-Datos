feedback-3# feedback-3

> **Asignatura:** Estructura de Datos  
> **Autor:** Iván Barroso Jiménez

#Se puede clonar el proyecto desde:

### git@gitlab.com:barrosojimenezivan/feedback-3.git

### https://gitlab.com/barrosojimenezivan/feedback-3.git

##                               

## Ejercicio 3

Para la aplicación de la Universidad se necesita un Comparador para publicar la
información de alumnos ordenada de una determinada manera:

```java
 public class Alumno {
    String nombre;
    String apellidos;
    String provincia;
    int NP;
    // Otros datos del alumno y sus métodos
}
```

## a) Se desea un método de comparación permita ordenar los alumnos de forma que se ordenen por provincia, para la misma provincia por apellidos y si coinciden por NP. Escriba un método de la siguiente forma

```java
    public static boolean comparar(Alumno alum1, Alumno alum2) {
    if (!alum1.provincia.equals(alum2.provincia)) {
        return alum1.provincia.compareTo(alum2.provincia) < 0;
    }
    if (!alum1.apellidos.equals(alum2.apellidos)) {
        return alum1.apellidos.compareTo(alum2.apellidos) < 0;
    }
    return alum1.NP < alum2.NP;
}
```

En el Main he probado los caoss posibles para validarlo.

## Resulto de la compración de los resultados:

```java
  boolean comparar(Alumno alum1, Alumno alum2);
```

Esta función devuelve true si alum1 va antes que alum2 y false en caso
contrario

## b) ¿Qué método de ordenación es preferible y porqué desde el punto de vista de complejidad algorítmica: Inserción directa, Selección directa, Intercambio directo, si el tiempo de copia se considera despreciable con respecto al tiempo de comparación?.

Inserción directa es más rápida en el caso de tener un tiempo de comparación más alto en comparación con el tiempo de
copia.

Para verificarlo he realizado la clase Java ComprarOrdenaciones.java.

Resultado de la comparación de los resultados:

```text
[5, 3, 4, 1, 2, 6, 8, 7, 9, 10]  //Array desordenado
Inserción directa → Comparaciones: 16 | Tiempo total: 160ms  
Selección directa → Comparaciones: 45 | Tiempo total: 450ms  
Intercambio directo → Comparaciones: 45 | Tiempo total: 450ms  

[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]  //Array ordenado
Inserción directa ordenado → Comparaciones: 9 | Tiempo total: 90ms  
Selección directa ordenado → Comparaciones: 45 | Tiempo total: 450ms  
Intercambio directo ordenado → Comparaciones: 45 | Tiempo total: 450ms  

[10, 9, 8, 7, 6, 5, 4, 3, 2, 1]  //Array inversamente ordenado
Inserción directa desordenado → Comparaciones: 45 | Tiempo total: 450ms  
Selección directa desordenado → Comparaciones: 45 | Tiempo total: 450ms  
Intercambio directo desordenado → Comparaciones: 45 | Tiempo total: 450ms  
```

