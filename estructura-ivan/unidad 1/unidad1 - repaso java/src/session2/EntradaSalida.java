package session2;

import java.io.IOException;
import java.util.Scanner;

public class EntradaSalida {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Figura figura = new Figura();
        System.out.println(figura);


        
        System.out.println("Dime tu edad:");
        try {
            int edad = teclado.nextInt();
            teclado.nextLine();
            throw new ExcepcionUAX("ERror");
        }catch (ExcepcionUAX e){
            System.out.println("La edad introducida es incorrecta");
            System.out.println(e.getMessage());
            System.out.println("lo que yo considere");
        }
        System.out.println("Dime tu altura:");
        int altura = Integer.parseInt(teclado.nextLine());
        System.out.println("Dime tu nombre:");
        String nombre = teclado.nextLine();
        System.out.println("Dime tu altura:");
        int altura2 = teclado.nextInt();

        throw new ExcepcionUAX("ERror");



    }

}
