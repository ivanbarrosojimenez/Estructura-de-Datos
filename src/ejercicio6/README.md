feedback-3# feedback-3

> **Asignatura:** Estructura de Datos  
> **Autor:** Iván Barroso Jiménez

#Se puede clonar el proyecto desde:

### git@gitlab.com:barrosojimenezivan/feedback-3.git

### https://gitlab.com/barrosojimenezivan/feedback-3.git

##                                                

## Ejercicio 6

Dada la siguiente clase Libro:

```java
public class Libro {
    String autor;
    String numRegistro; // De la forma 1234ABC
    int añoEdición;
// resto de la clase
```

## Escriba un método que dado un TreeSet de objetos Libro devuelva cual es el autor que más libros tiene escritos. Para resolver este ejercicio debe crear inicialmente una estructura donde estén todos los autores distintos que tengan libros publicados, y posteriormente calcule usando dicha lista cual es el autor con mayor número de libros publicados.

```java
    public static String autorConMasLibros(TreeSet<Libro> libros) {
    Map<String, Integer> mapa = new HashMap<>();
    for (Libro libro : libros) {
        mapa.put(libro.autor, mapa.getOrDefault(libro.autor, 0) + 1);
    }
    return Collections.max(mapa.entrySet(), Map.Entry.comparingByValue()).getKey();
}
```

## Resultados ejecutando la clase Main

```text
Auto con más libros: Autor D
```