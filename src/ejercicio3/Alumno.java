package src.ejercicio3;

public class Alumno {
    String nombre;
    String apellidos;
    String provincia;
    int NP;

    public Alumno(String nombre, String apellidos, String provincia, int NP) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.provincia = provincia;
        this.NP = NP;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + " | " + provincia + " | NP: " + NP;
    }
}