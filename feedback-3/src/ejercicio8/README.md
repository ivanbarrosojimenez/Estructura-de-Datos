feedback-3# feedback-3

> **Asignatura:** Estructura de Datos  
> **Autor:** Iván Barroso Jiménez

#Se puede clonar el proyecto desde:

### git@gitlab.com:barrosojimenezivan/feedback-3.git

### https://gitlab.com/barrosojimenezivan/feedback-3.git

##                                                          

## Ejercicio 8

## Suponga que se realiza un árbol de búsqueda ordenado por nombre de equipo y nombre de jugador de la siguiente forma:

```java
public class NodoJugador {
    Jugador jugador;
    NodoJugador izq;
    NodoJugador der;
    // El resto de métodos como en la clase NodoBúsqueda
}

public class ArbolBúsquedaJugador {
    NodoJugador raiz;
    // El resto de métodos como en la clase ArbolBúsqueda
}
```

# 1. Escriba un método en la clase ArbolBúsquedaJugador de nombre imprimeSueldosAltos que reciba por parámetro un valor de sueldo y escribe por pantalla el nombre y equipo de todos los jugadores cuyo sueldo completo el superior al valor dado.

```java
//Ejercicio 8
public void imprimeSueldosAltos(int limite) {
    imprimeSueldosAltosRec(raiz, limite);
}

private void imprimeSueldosAltosRec(NodoJugador nodo, int limite) {
    if (nodo == null) return;

    // Recorrer subárbol izquierdo
    imprimeSueldosAltosRec(nodo.izq, limite);

    // Evaluar condición
    if (nodo.jugador.getSueldoTotal() > limite) {
        System.out.println("Jugador: " + nodo.jugador.getNombre() +
                ", Equipo: " + nodo.jugador.getEquipo() +
                ", Sueldo total: " + nodo.jugador.getSueldoTotal());
    }

    // Recorrer subárbol derecho
    imprimeSueldosAltosRec(nodo.der, limite);
}
```

## Resultados ejecutando la clase Main con set de datos de ejemplo

```text
Jugadores con sueldo total mayor que 4000:
Jugador: Pedro, Equipo: Barcelona, Sueldo total: 5600
Jugador: Carlos, Equipo: Real Madrid, Sueldo total: 5200
Jugador: Luis, Equipo: Real Madrid, Sueldo total: 5000

Jugadores con sueldo total mayor que 5000:
Jugador: Pedro, Equipo: Barcelona, Sueldo total: 5600
Jugador: Carlos, Equipo: Real Madrid, Sueldo total: 5200

Jugadores con sueldo total mayor que 6000:

Process finished with exit code 0
```

