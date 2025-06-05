feedback-3# feedback-3

> **Asignatura:** Estructura de Datos  
> **Autor:** Iván Barroso Jiménez

#Se puede clonar el proyecto desde:

### git@gitlab.com:barrosojimenezivan/feedback-3.git

### https://gitlab.com/barrosojimenezivan/feedback-3.git

##                                             

## Ejercicio 5

Dada la siguiente clase Libro:

```java
public class Libro {
    String autor;
    String numRegistro; // De la forma 1234ABC
    int añoEdición;
// resto de la clase
```

## Por razones de eficiencia se ha pensado manejar todos los libros con un TreeSet para mantenerlos ordenados por año de edición y número de registro. Es decir, se ordenan por año de edición y, si hay dos libros con el mismo año de edición éstos se ordenan entre sí por el número de registro. Escriba las modificaciones que hay que realizar y los métodos que hay que añadir en la clase Libro indicada al inicio del examen para poder utilizarla junto con el TreeSet.

```java
public class Libro implements Comparable<Libro> {
    String autor;
    String numRegistro; // De la forma 1234ABC
    int anioEdicion;

    public Libro(String autor, String numRegistro, int anioEdicion) {
        this.autor = autor;
        this.numRegistro = numRegistro;
        this.anioEdicion = anioEdicion;
    }

    @Override
    public String toString() {
        return autor + " - " + numRegistro + " (" + anioEdicion + ")";
    }

    @Override
    public int compareTo(Libro otro) {
        // Primero comparamos por año de edición
        int cmpAño = Integer.compare(this.anioEdicion, otro.anioEdicion);
        if (cmpAño != 0) return cmpAño;

        // Si el año es igual, comparamos por número de registro
        return this.numRegistro.compareTo(otro.numRegistro);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Libro)) return false;
        Libro otro = (Libro) obj;
        return this.anioEdicion == otro.anioEdicion &&
                this.numRegistro.equals(otro.numRegistro);
    }

    @Override
    public int hashCode() {
        return 31 * anioEdicion + numRegistro.hashCode();
    }
}

```

## Resultados ejecutando la clase Main

```text
Libros ordenados:  
Autor B - 5678XYZ (2018)  
Autor C - 0001AAA (2020)  
Autor A - 1234ABC (2020)  
Autor D - 1111ABB (2022)  
Autor D - 1111BBB (2022)  
Autor D - 1112BBB (2022)  
```