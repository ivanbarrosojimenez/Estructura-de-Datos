package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class EjemploArrayDeque {
    public static void main(String[] args) {
        Queue<String> cola = new ArrayDeque<>();
        cola.offer("Primero");
        cola.offer("Segundo");
        cola.offer("Tercero");
        System.out.println("Cola: "+cola); //imporimie la cola
        System.out.println("Poll:"+cola.poll());//saca el primero y lo muestra (ya no está en la cola)
        System.out.println("Peek:"+cola.peek()); //muestra el segundo sin sacarlo
        System.out.println("Size:"+cola);

        Deque<String> pila = new ArrayDeque<>();
        pila.push("Primero");
        pila.push("Segundo");
        pila.push("Tercero");
        System.out.println("Pila: "+pila);
        System.out.println("Pop:"+pila.pop());
        System.out.println("Peek: "+pila.peek());
        System.out.println("Pila: "+pila);
        System.out.println("----------------- ");

        Deque<String> deque = new ArrayDeque<>();
        deque.offerFirst("Primero");
        System.out.println("Deque: "+deque);
        deque.offerLast("Segundo");
        System.out.println("Deque: "+deque);
        deque.offerFirst("Cero");

        System.out.println("Deque: "+deque);
        System.out.println("Pool First: "+deque.pollFirst());
        System.out.println("Pool Last: "+deque.pollLast());
        System.out.println("Pool Last: "+deque.pollFirst());
        System.out.println("Deque: "+deque);
        deque.remove("Primero")
    }
}
