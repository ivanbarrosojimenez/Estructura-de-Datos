package ejercicio2;

public class OrdenComplejidad2 {


    public int metodo2(int[] lista) {//Complejidad total o(n^2) porque hay dos bucles anidados.
        for (int i = 0; i < lista.length; i++) {// O(n) itera de forma secuencial por toda la lista
            int aux = 0;
            for (int j = i; j < lista.length; j++) { //Entiendo que esta llave } sobra...
                //Suponiendo que la llava anterior estaba por error:
                //El orden de complejidad es O(n - i) -> O(n) porque itera desde i hasta el final de la lista.
                aux += lista[j];//Acumula el resultado de la sublista de los elementos, complejidad O(1) por cada iteración.
            }
            lista[i] = aux;//Orden o(1)
        }
        //lista[i] = aux;No compila, no tiene acceso a i ni a aux.
        //Al ser una asignacion es O(1)
        int suma = 0;//Asignación O(1)
        for (int i = 0; i < lista.length; i++) {//Tiene un orden O(n) ya que itera por todos los
            //Elementos de la lista de forma lineal una sola vez.(la lista ha sido modificada, pero contiene la misma cantidad de elementos
            //Si la llave estaba cerrada por error y este codigo esta dentro:
            //suma += lista[i] tendria un O(1) por cada elemento del bucle
        }
        //Añado i = 0 para que compile
        int i = 0;//Asignación O(1),
        suma += lista[i];//Asignación O(1), se ejecuta una sola vez.(fuera del for)
        return suma;//Complejida O(1), se ejecuta una sola vez y no depende del tamaño de la entrada.
        //Caso total: Primera parte O(n^2) por los dos bucles anidados, segunda parte O(n) por el bucle lineal.
        //Por la regla de la suma queda con O(n^2) porque es el orden de mayor complejidad.
    }

}

