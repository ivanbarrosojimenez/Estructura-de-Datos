package src.ejercicio4;

public class Libro {
    String autor;
    String numRegistro; // De la forma 1234ABC
    int anioEdicion;

    public Libro(String autor, String numRegistro, int anioEdicion) {
        this.autor = autor;
        this.numRegistro = numRegistro;
        this.anioEdicion = anioEdicion;
    }

    @Override
    public String toString() {
        return autor + " - " + numRegistro + " (" + anioEdicion + ")";
    }
}