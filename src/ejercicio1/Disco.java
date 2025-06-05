package ejercicio1;

/**
 * The type ejercicio1.Disco.
 */
public class Disco implements Comparable {
    private String tituloDisco;
    private Integer anio;
    private Integer duracionEnMinutos;

    /**
     * Instantiates a new ejercicio1.Disco.
     *
     * @param tituloDisco       the titulo disco
     * @param anio              the anio
     * @param duracionEnMinutos the duracion en minutos
     */
    public Disco(String tituloDisco, Integer anio, Integer duracionEnMinutos) {
        this.tituloDisco = tituloDisco;
        this.anio = anio;
        this.duracionEnMinutos = duracionEnMinutos;
    }

    /**
     * Instantiates a new ejercicio1.Disco.
     */
    public Disco() {
    }

    /**
     * Gets anio.
     *
     * @return the anio
     */
    public Integer getAnio() {
        return anio;
    }

    /**
     * Gets titulo disco.
     *
     * @return the titulo disco
     */
    public String getTituloDisco() {
        return tituloDisco;
    }

    /**
     * Ordenamos por año, si son iguales por título
     */
    @Override
    public int compareTo(Object obj) {
        Disco disco = (Disco) obj;
        int comparacionAnio = this.anio.compareTo(disco.getAnio());
        if (comparacionAnio != 0) {
            return comparacionAnio;
        }
        return this.tituloDisco.compareTo(disco.getTituloDisco());
    }

    @Override
    public String toString() {
        return "ejercicio1.Disco: [" +
                "tituloDisco='" + tituloDisco + '\'' +
                ", anio=" + anio +
                ", duracionEnMinutos=" + duracionEnMinutos +
                ']';
    }
}
