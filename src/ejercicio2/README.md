feedback-2# feedback-2

> **Asignatura:** Estructura de Datos  
> **Autor:** Iván Barroso Jiménez

#Se puede clonar el proyecto desde:

### git@gitlab.com:estructura-de-datos2842616/feedback-2.git

### https://gitlab.com/estructura-de-datos2842616/feedback-2.git

##           

## Ejercicio 2

Determina y justifica el orden de complejidad de los métodos que se presentan a
continuación.
Para cada uno de ellos justifica cual es el tamaño del problema y cómo has calculado
los órdenes de complejidad.

### Resultado método 1:

- En el peor de los casos no se puede calcular la complejidad (case 2) por ser infinito (i inicia con 0,
  se multiplica por 3, igual a 0, y repite infinito.
  **En caso de que la variable i sea mayor que 0 se convierte en complejidad O(log n) porque i se multiplica por 3 en
  cada iteración
- En el mejor de los casos (case 0 y case default) es O(1) porque solo hace una asignación que no depende de la entrada.
- En el caso medio (case 1) es O(n) por tener una iteración lineal O(n) y una asignación fuera del bucle O(1).

  **La complejidad del metodo 1 es O(n)**

### Resultado método 2:

- Primera parte O(n^2) por los dos bucles anidados, segunda parte O(n) por el bucle lineal.
  **Por la regla de la suma queda con O(n^2) porque es el orden de mayor complejidad.**
