package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class HistoriaNavegador {
    public static void main(String[] args) {
        Deque<String> atras = new ArrayDeque<>();
        Deque<String> adelante = new ArrayDeque<>();

        String paginaActual = "inicio.com";

        Scanner sc = new Scanner(System.in);
        String comando;

        while(true) {
            System.out.println("\nComando: [visitar <url>] [atras] [adelante] [salir]");
            System.out.print(">");
            comando = sc.nextLine().trim();


            if(comando.equals("salir")) break;

            if(comando.contains("visitar")) {
                String nuevaPagina = comando.substring(8).trim();
                atras.push(paginaActual);
                paginaActual = nuevaPagina;
                adelante.clear();
                System.out.println("Visitando: "+paginaActual);
            }else if(comando.equals("atras")) {
                if(!atras.isEmpty()) {
                    adelante.push(paginaActual);
                    paginaActual = atras.pop();
                    System.out.println("Visitando: "+paginaActual);
                }else{
                    System.out.println("No hay atras");
                }
            }else if(comando.equals("adelante")) {
                if(!adelante.isEmpty()) {
                    atras.push(paginaActual);
                    paginaActual = adelante.pop();
                    System.out.println("Avanzando a: "+paginaActual);
                }else{
                    System.out.println("No hay adelante");
                }
            }else {
                System.out.println("Comando invalido");
            }


        }
        sc.close();
        System.out.println("Navegador cerrado");
    }
}
