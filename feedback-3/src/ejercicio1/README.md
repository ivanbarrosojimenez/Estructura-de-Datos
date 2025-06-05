feedback-3# feedback-3

> **Asignatura:** Estructura de Datos  
> **Autor:** Iván Barroso Jiménez

#Se puede clonar el proyecto desde:

### git@gitlab.com:barrosojimenezivan/feedback-3.git

### https://gitlab.com/barrosojimenezivan/feedback-3.git

##           

## Ejercicio 1

Determine y justifique el orden de complejidad de los siguientes métodos:

# Método 1
```java
public static int metodo1(int x) { //Variable de entrada x = n
  if (x < 0) {} // O(1) comprobación de condición, si es menor a 0 no hace nada
  x = -x;// O(1) asignación, cambia el signo de la entrada
  switch ((int)(Math.random() * 3)) { // O(1) Genera un número aleatorio entre 0 y 2 + switch
    case 0:
      return 0;// O(1), operacion de retorno directo sin modificaciones.
    case 1:
      int ac = 1;// O(1) asignacion
      for (int i = 1; i < x; i *= 2) {} //Bucle sin contenido, inicia en 1 y llega hasta x, multiplicando i por 2 en cada iteración.
      ac = ac * 2;// O(1) multiplicación y asignación.
      return ac;// O(1) retorno de valor, al estar fuera del for siempre es 2.
    default://He cambiado 2 por default, no cambia el resultado y asi compila.
      int i = x; // O(1) asignación, i toma el valor de x.
      ac = x; // O(1) asignación, ac toma el valor de x.
      while (i > 1) {//Es un orden n, pero si entra dentro es un bucle infinito.
        //Por ejemplo con una entrada de x= -2 el blucle nunca termine, no se puede calcular su orden.
        //Si la entrada tiene un valor donde X sea menor o igual a 1 (una vez cambiado el signo), el bucle no se ejecuta y tiene un orden O(n).
        ac = x * i; // O(1) multiplicación y asignación, ac toma el valor de x por i.
      }
      i = i / 2;  //En el caso de llegar a esta parte O(1) división y asignación, i se divide por 2.
      return ac; //Retorno de ac, O(1)
  }
  // Complejidad total:
  // Cuando la entrada del método es <= -1
  //  Parte fuera swich + case 0: O(1) + O(1) + O(1) + O(1)
  //  Parte case 1: O(1) + O(n) + O(1) + O(1)
  //  case 2 (cambiado por default) + O(1) + O(1) + O(n) + O(1) + O(1) + (1) = O(n)
  //  Por lo tanto, la complejidad total es O(n) en el peor de los casos.
  // Cuando la entrada del método es <= -2 la complejidad no se puede determinar porque entra en el peor de los casos del bucle infinito.
```

## Resulto método 1:
Complejidad total:
- Cuando la entrada del método es <= -1
  - Parte fuera swich + case 0: O(1) + O(1) + O(1) + O(1)
  - Parte case 1: O(1) + O(n) + O(1) + O(1)
  - Parte case 2 (cambiado por default) + O(1) + O(1) + O(n) + O(1) + O(1) + (1) = O(n)
Por lo tanto, la complejidad total es O(n) en el peor de los casos.
- Cuando la entrada del método es <= -2 la complejidad no se puede determinar porque entra en el peor de los casos del bucle infinito.

# Método 2
```java
    public void metodo2(int x) { //Variable de entrada x = n
        long y = x; // O(1) asignación, y toma el valor de x.
        int i = 0; // Añado para que compile sin modificar el resultado, añade unu o(1) de inicializar (que antes teniamos en en el for, mismo resultado)
        for (i = 1; i < x; i++) {// O(1) Iteración lineal comenzando por el valor 1 hasta el valor de entrada -1 (con valor de entrada negativo no entra)
            for (int j = 1; j < x; j *= 2) {}//Bucle interno O(log n), itera desde 1 hasta x, multiplicando j por 2 en cada iteración.
        }
        y = y * i; // O(1) multiplicación y asignación, y toma el valor de y por i.
        System.out.println(y);// O(1) impresión del valor de y.
        // Complejidad total:
        // Parte fuera del for: O(1) + O(1)
        // Parte del for: O(n) + O(log n)
        // Por lo tanto, la complejidad total es O(n log n) en el peor de los casos.
    }
```

## Resulto método 2:
- Complejidad total:
  - Parte fuera del for: O(1) + O(1)
  - Parte del for: O(n) + O(log n)
- Por lo tanto, la complejidad total es O(n log n) en el peor de los casos.

