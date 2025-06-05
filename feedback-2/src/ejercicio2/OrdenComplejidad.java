package ejercicio2;

/**
 * Determina y justifica el orden de complejidad de los métodos que se presentan a
 * continuación.
 * Para cada uno de ellos justifica cual es el tamaño del problema y cómo has calculado
 * los órdenes de complejidad.
 */
public class OrdenComplejidad {

    public int metodo1(int x) {
        int y = x % 3;//El orden de complejidad es O(1), asignación
        int result; //El orden de complejidad es O(1), asignaciones

        switch (y) { // O(1) con el resultado del modulo 3 de x.
            case 0:
                result = x;//El orden de complejidad es O(1), asignación
                break;
            case 1:
                result = 1;//Complejidad es O(1) asignación.
                for (int i = 0; i < x; i++) {//El orden es O(n) itera de forma lineal por todos los elementos sin hacer nada
                    //no hay nada dentro del for.
                }
                //result = result * i;//No compila por estar fuera del bucle for, suponiendo que está dentro
                // tendria un orden de o(1), uno por cada iteración del for.

                //Caso total: 0(1) + O(n) + O(1) = O(n)
                break;
            case 2:
                result = 0; //El orden de complejidad es O(1) porque se ejecuta una unica vez y no depende de x
                for (int i = 0; i < x; i = i * 3) {//No se puede calcular el orden de complejidad porque i vale 0, 0 por 3 es 0 y el bucle nunca termina
                    //Igual que en el bucle for anterior no se hace nada dentro del bucle.
                    //System.out.println("Iteración: " + i);
                }
                result = result + x;//El orden de complejidad es O(1) porque se ejecuta una unica vez (fuera del for)
                //Caso total: Indeterminado + O(1) No se puede determinar.
                //Si i > 0 sería O(1) +  O(log n) + O(1) = O(log n)  porque i se multiplica por 3 en cada iteración.
                break;
            default:
                System.out.println("Esto no debería pasar");
                result = -1;//Orden de complejidad O(1) porque se ejecuta una unica vez, no usa la entrada.
        }
        //He añadido el return, no cambia la complejidad del metodo ya es que es una operación constante.
        return result;
    }
}

