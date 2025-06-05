feedback-3# feedback-3

> **Asignatura:** Estructura de Datos  
> **Autor:** Iván Barroso Jiménez

#Se puede clonar el proyecto desde:

### git@gitlab.com:barrosojimenezivan/feedback-3.git

### https://gitlab.com/barrosojimenezivan/feedback-3.git

##                                        

## Ejercicio 4

Dada la siguiente clase Libro:

```java
public class Libro {
    String autor;
    String numRegistro; // De la forma 1234ABC
    int añoEdición;
// resto de la clase
```

## Escriba un método de nombre librosPares que tome como parámetro un ArrayList de Libros y devuelva un ArrayList con todos las libros cuyo nú- mero de registro (sin las letras) es un número par.

```java
    public static ArrayList<Libro> librosPares(ArrayList<Libro> libros) {
    ArrayList<Libro> resultado = new ArrayList<>();

    for (Libro libro : libros) {
        String numRegistro = libro.numRegistro;

        // Extraemos los dígitos del principio (antes de las letras)
        String parteNumerica = "";
        for (int i = 0; i < numRegistro.length(); i++) {
            char c = numRegistro.charAt(i);
            if (Character.isDigit(c)) {
                parteNumerica += c;
            } else {
                break; // dejamos de leer cuando aparecen letras
            }
        }

        // Convertimos y comprobamos si es par
        if (!parteNumerica.isEmpty()) {
            int numero = Integer.parseInt(parteNumerica);
            if (numero % 2 == 0) {
                resultado.add(libro);
            }
        }
    }
    return resultado;
}
```

En la Clase Main.java hay pruebas con este método para validar los resultados.

## Resultados:

Lista inicial:  
[Autor A - 1234ABC (2020), Autor B - 5678DEF (2019), Autor C - 789ABC (2020), Autor D - 2468XYZ (2021), Autor D - 0XYZ (2021)]  
Lista con pares:  
[Autor A - 1234ABC (2020), Autor B - 5678DEF (2019), Autor D - 2468XYZ (2021), Autor D - 0XYZ (2021)]  