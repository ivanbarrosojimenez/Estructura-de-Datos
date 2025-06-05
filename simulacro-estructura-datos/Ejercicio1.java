public class Ejercicio1 {
    /*
    Determine y justifique el orden de complejidad de los siguientes métodos. Justifique cual
    es el tamaño del problema y cómo ha calculado los órdenes de complejidad de cada uno
    de los métodos:
    public void m1(int var1){
        char c = (char)var1;
        System.out.print(c);
        int px = var1*2/5;
        for (int i=1; i<=var1; i++){
            px++;
            for (int j=1; j<=var1; j++){
                System.out.print("*");
                break;
            }
            System.out.println();
        }
    }



    public static void m2(int x1, int x2[]){
        int neg_x1 = 0;
        if(x1 > 0){
         neg_x1 = x1*-1;
        }
         int tamaño = x2.length;
        int cuenta = 0;
        for (int i = 1; (neg_x1 <=0 && i <= tamaño); i++)
         for (int j = 1; j <= tamaño; j = 2 * j)
        cuenta++;
        }
     */


    public static void main(String[] args) {
        System.out.println("Ejercicio 1.m1:");
        m1(5);
        System.out.println("Ejercicio 1.m2:");
        m2(2, new int[]{1, 2, 3, 4, 5});
    }

    public static void m1(int var1) {
        char c = (char) var1;//Asignacion de valor O(1)
        System.out.print(c);//Impresion de caracter O(1)
        int px = var1 * 2 / 5;//Asignacion de valor O(1)
        for (int i = 1; i <= var1; i++) { //iterar hasta el numero de entrada n
            px++;//Incremento de variable O(1)
            for (int j = 1; j <= var1; j++) {//Itera desde j = 1 hasta j = entrada var1 es O(n), pero al tener un break dentro pasa a O(1)
                System.out.print("*");//Impresion de asterisco O(1)
                break;//Sale del bucle interno O(1)
            }
            System.out.println();//Impresion de salto de linea O(1)
        }
    } // El resultado de complejidad es O(n) ya que itera una sola vez por cada elemento,
    // el segundo bucle interno tiene un break, por lo que nunca itera más de una vez.
    // Operaciones iniciales: O(1) + O(1) + O(1) = O(1)
    // Bucle externo : O(n) (iterando var1 veces)
    // Interior de bucle externo: O(1) + O(1) + O(1) = O(1)
    // Por la regla del producto al multiplicar queda: O(n) * O(1) = O(n)
    // Aplicando la regla de la suma queda: O(n) + O(1) = O(n)


    public static void m2(int x1, int x2[]) {
        int neg_x1 = 0;
        if (x1 > 0) {//Condicion para verificar si x1 es positivo O(1)
            neg_x1 = x1 * -1; //Poner el valor en negativo O(1)
        }
        int tamaño = x2.length; //Asignacion del tamaño del array O(1)
        int cuenta = 0; //Inicializacion de contador O(1)
        for (int i = 1; (neg_x1 <= 0 && i <= tamaño); i++)//Itera desde 1 hasta el tamaño del array O(n)
            for (int j = 1; j <= tamaño; j = 2 * j) {//Itera desde 1 hasta el tamaño del array, pero incrementando j por 2 en cada iteracion O(log n)
                cuenta++; //Incrementa el contador O(1)
                //System.out.println(cuenta);
            }
    } //Operaciones iniciales: O(1) + O(1) + O(1) + O(1) + O(1) = O(1)
    // Bucle externo: O(n) (iterando tamaño veces), la condicion neg_x1 <= 0 es O(1)
    // Bucle interno: se ejecuta log n veces por iteracion por incrementar j por 2, es O(log n) y cada iteracion cuesta O(1)
    // Por tanto la complejidad del bucle interno es O(log n)
    // Por la regla del producto queda: O(n) * O(log n) = O(n log n)
    // Finalmente, por la regla de la suma con las operaciones iniciales: O(n log n) + O(1) = O(n log n)
    //
}
