feedback-3# feedback-3

> **Asignatura:** Estructura de Datos  
> **Autor:** Iván Barroso Jiménez

#Se puede clonar el proyecto desde:

### git@gitlab.com:barrosojimenezivan/feedback-3.git

### https://gitlab.com/barrosojimenezivan/feedback-3.git

##                                                      

## Ejercicio 7

## Suponiendo que se dispone de las siguientes declaraciones de clases que permiten manejar una lista de Jugadores:

```java
package src.ejercicio7;

public class Jugador {
    private String nombre;
    private String equipo;
    private String posición;
    private int sueldo;
    private int primas;

    public Jugador(String nombre, String equipo, String posicion, int sueldo, int primas) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.posición = posicion;
        this.sueldo = sueldo;
        this.primas = primas;
    }

    public Jugador() {

    }

    public int getSueldo() {
        return sueldo;
    }

    public int getPrimas() {
        return primas;
    }

    public int getSueldoTotal() {
        return sueldo + primas;
    }

    public class NodoJugador<T> {
        public T jugador;
        public NodoJugador<T> siguiente;

        public NodoJugador(T jugador) {
            this.jugador = jugador;
            this.siguiente = null;
        }

        public boolean estaVacia() {
            return this.siguiente == null;
        }

        public void insertarPrimero(T dato) {
            NodoJugador<T> nuevo = new NodoJugador<>(dato);
            nuevo.siguiente = this.siguiente;
            this.siguiente = nuevo;
        }

        public void insertarUltimo(T dato) {
            NodoJugador<T> nuevo = new NodoJugador<>(dato);
            NodoJugador<T> ultimo = this;
            while (ultimo.siguiente != null) {
                ultimo = ultimo.siguiente;
            }
            ultimo.siguiente = nuevo;
        }

        public void insertarOrdenado(T dato) {
            NodoJugador<T> nuevo = new NodoJugador<>(dato);
            NodoJugador<T> anterior = this;

            while (anterior.siguiente != null && ((Comparable) anterior.siguiente.jugador).compareTo(nuevo.jugador) < 0) {
                anterior = anterior.siguiente;
            }

            nuevo.siguiente = anterior.siguiente;
            anterior.siguiente = nuevo;
        }

        public int buscar(T dato) {
            NodoJugador<T> auxiliar = this.siguiente;
            int posicion = 0;
            while (auxiliar != null) {
                if (auxiliar.jugador.equals(dato)) {
                    return posicion;
                }
                auxiliar = auxiliar.siguiente;
                posicion++;
            }
            return -1;
        }

        public boolean eliminar(T dato) {
            NodoJugador<T> auxiliar = this;

            while (auxiliar.siguiente != null && !auxiliar.siguiente.jugador.equals(dato)) {
                auxiliar = auxiliar.siguiente;
            }
            if (auxiliar.siguiente != null) {
                auxiliar.siguiente = auxiliar.siguiente.siguiente;
                return true;
            }
            return false;
        }

        public void vaciar() {
            this.siguiente = null;
        }
    }

    public class ListaJugadores<T extends Jugador> {
        NodoJugador<T> cabecera;

        public ListaJugadores() {
            cabecera = new NodoJugador<>(null);
        }

        public boolean estaVacia() {
            return cabecera.siguiente == null;
        }

        public void insertarPrimero(T dato) {
            NodoJugador<T> nuevo = new NodoJugador<>(dato);
            nuevo.siguiente = cabecera.siguiente;
            cabecera.siguiente = nuevo;
        }

        public void insertarUltimo(T dato) {
            NodoJugador<T> nuevo = new NodoJugador<>(dato);
            NodoJugador<T> ultimo = cabecera;
            while (ultimo.siguiente != null) {
                ultimo = ultimo.siguiente;
            }
            ultimo.siguiente = nuevo;
        }

        public void insertarOrdenado(T dato) {
            NodoJugador<T> nuevo = new NodoJugador<>(dato);
            NodoJugador<T> anterior = cabecera;

            while (anterior.siguiente != null && ((Comparable) anterior.siguiente.jugador).compareTo(nuevo.jugador) < 0) {
                anterior = anterior.siguiente;
            }

            nuevo.siguiente = anterior.siguiente;
            anterior.siguiente = nuevo;
        }

        public int buscar(T dato) {
            NodoJugador<T> auxiliar = cabecera.siguiente;
            int posicion = 0;
            while (auxiliar != null) {
                if (auxiliar.jugador.equals(dato)) {
                    return posicion;
                }
                auxiliar = auxiliar.siguiente;
                posicion++;
            }
            return -1;
        }

        public boolean eliminar(T dato) {
            NodoJugador<T> auxiliar = cabecera;

            while (auxiliar.siguiente != null && !auxiliar.siguiente.jugador.equals(dato)) {
                auxiliar = auxiliar.siguiente;
            }
            if (auxiliar.siguiente != null) {
                auxiliar.siguiente = auxiliar.siguiente.siguiente;
                return true;
            }
            return false;
        }

        public void vaciar() {
            cabecera.siguiente = null;
        }

        public int totalSueldos() {
            int total = 0;
            NodoJugador<T> actual = cabecera.siguiente;

            while (actual != null) {
                total += actual.jugador.getSueldo();
                actual = actual.siguiente;
            }

            return total;
        }
    }
}
```

## Resultados ejecutando la clase Main

```text
Jugador j1 = new Jugador("Juan", "FCX", "Delantero", 4000, 500);  
Jugador j2 = new Jugador("Pedro", "FCY", "Defensa", 2000, 400);  
Jugador j3 = new Jugador("Luis", "FCZ", "Portero", 2000, 300);  
Jugador j4 = new Jugador("Pepe", "FCZ", "Delantero", 2000, 300);  
Jugador j5 = new Jugador("Iván", "FCZ", "Delantero", 10000, 300);  
Jugador j6 = new Jugador("Aday", "FCZ", "Delantero", 180000, 300);  
        
        
Total de sueldos (sin primas): 200000
```