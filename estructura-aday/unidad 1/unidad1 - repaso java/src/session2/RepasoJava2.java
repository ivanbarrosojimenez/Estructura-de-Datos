package session2;

import java.util.Scanner;

public class RepasoJava2 {

    public static void main(String[] args) {

        Figura myfigure;
        myfigure = new Figura();
        System.out.println(myfigure.getAlto());

        Figura myfigure2 = new Figura();
        myfigure2.ancho = 10;
        myfigure2.alto = 20;
        myfigure2.setLargo(30);
        ///

        myfigure2.imprimelosvalores();
        System.out.println();

        Math.random();



       /* Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1. Saludar");
            System.out.println("2. Despedir");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("¡Hola!");
                    break;
                case 2:
                    System.out.println("¡Adiós!");
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
        sc.close();*/
    }
}
