package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class SistemaDeAtencionAlCliente {
    public static void main(String[] args) {

        Queue<Ticket> colaDeTickets = new LinkedList<>();

        colaDeTickets.offer(new Ticket("Aday Guerra"));
        colaDeTickets.offer(new Ticket("Juan Perez"));
        colaDeTickets.offer(new Ticket("Antonio Martinez"));
        colaDeTickets.offer(new Ticket("Ana Gomez"));

        System.out.println("Imprimimos cola de tickets: ");
        for (Ticket ticket : colaDeTickets) {
            System.out.println(ticket);
        }


        System.out.println("-----Atendiendo cola de clientes-----");
        while(!(colaDeTickets.size() == 2)) {
            Ticket ticket = colaDeTickets.poll();//Elimina el ticket de la cola
            System.out.println("Atendiendo al cliente: "+ticket);
        }

        for (Ticket ticket : colaDeTickets) {
            System.out.println(ticket);
        }

        System.out.println("Todo los clientes han sido atendidos");
    }
}
