package src.ejercicio6;

public class Libro implements Comparable<Libro> {
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

    @Override
    public int compareTo(Libro otro) {
        // Primero comparamos por año de edición
        int cmpAño = Integer.compare(this.anioEdicion, otro.anioEdicion);
        if (cmpAño != 0) return cmpAño;

        // Si el año es igual, comparamos por número de registro
        return this.numRegistro.compareTo(otro.numRegistro);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Libro)) return false;
        Libro otro = (Libro) obj;
        return this.anioEdicion == otro.anioEdicion &&
                this.numRegistro.equals(otro.numRegistro);
    }

    @Override
    public int hashCode() {
        return 31 * anioEdicion + numRegistro.hashCode();
    }
}