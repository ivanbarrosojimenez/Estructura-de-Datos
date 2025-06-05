package ejercicio2;

public class MainEjercicio1 {
    public static void main(String[] args) {
        OrdenComplejidad orden = new OrdenComplejidad();

        // Test metodo1
        var a = 0;
        var b = 1;
        var c = 2;
        var d = 3;
        System.out.println("Resultado de metodo1(" + a + "): " + orden.metodo1(a));
        System.out.println("Resultado de metodo1(" + b + "): " + orden.metodo1(b));
        System.out.println("Resultado de metodo1(" + d + "): " + orden.metodo1(d));
        System.out.println("Resultado de metodo1(" + c + "): " + orden.metodo1(c));

        //Resultado de método 1:
        // - En el peor de los casos no se puede calcular la complejidad (case 2) por ser infinito (i inicia con 0,
        //   se multiplica por 3, igual a 0, y repite infinito.
        //   ** En caso de que la variable i sea mayor que 0 se convierte en complejidad O(log n) porque i se multiplica por 3 en cada iteración
        // - En el mejor de los casos (case 0 y case default) es O(1) porque solo hace una asignación que no depende de la entrada.
        // - En el caso medio (case 1) es O(n) por tener una iteración lineal O(n) y una asignación fuera del bucle O(1).
        //
        // La complejidad del metodo 1 es O(n)

    }
}
