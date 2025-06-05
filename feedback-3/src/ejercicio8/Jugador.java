package src.ejercicio8;

public class Jugador implements Comparable<Jugador> {
    // ordenado por nombre de equipo y
    //nombre de jugador
    @Override
    public int compareTo(Jugador o) {
        int cmp = this.equipo.compareTo(o.equipo);
        if (cmp != 0) {
            return cmp;
        }
        return this.nombre.compareTo(o.nombre);
    }

    private String nombre;
    private String equipo;
    private String posicion;
    private int sueldo;
    private int primas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getPrimas() {
        return primas;
    }

    public void setPrimas(int primas) {
        this.primas = primas;
    }

    public Jugador(String nombre, String equipo, String posicion, int sueldo, int primas) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.posicion = posicion;
        this.sueldo = sueldo;
        this.primas = primas;
    }

    public Jugador() {

    }

    //Sueldo total que se pide en ejercicio 8
    public int getSueldoTotal() {
        return sueldo + primas;
    }

}