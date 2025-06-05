package Queue;

public class Ticket {

    private static int contador = 1;
    private final int id;
    private final String nombreCliente;

    public Ticket(String nombreCliente) {
        this.id = contador++;
        this.nombreCliente = nombreCliente;
    }

    public int getId() {
        return id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", nombreCliente='" + nombreCliente + '\'' +
                '}';
    }
}
