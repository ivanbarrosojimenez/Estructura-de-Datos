package src.ejercicio7;

public class Jugador {
    private String nombre;
    private String equipo;
    private String posición;
    private int sueldo;
    private int primas;

    public Jugador(String nombre, String equipo, String posicion, int sueldo, int primas) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.posición = posicion;
        this.sueldo = sueldo;
        this.primas = primas;
    }

    public Jugador() {
    }

    public int getSueldo() {
        return sueldo;
    }

    public int getPrimas() {
        return primas;
    }

    public int getSueldoTotal() {
        return sueldo + primas;
    }
}