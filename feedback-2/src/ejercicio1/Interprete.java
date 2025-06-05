package ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type ejercicio1.Interprete.
 */
public class Interprete implements Comparable<Interprete> {
    private String nombre;
    private Boolean enActivo;
    private List<Disco> listaDiscos = new ArrayList<>();
    private TipoInterprete tipo;

    /**
     * Instantiates a new ejercicio1.Interprete.
     *
     * @param nombre      the nombre
     * @param enActivo    the en activo
     * @param listaDiscos the lista discos
     * @param tipo        the tipo
     */
    public Interprete(String nombre, Boolean enActivo, List<Disco> listaDiscos, TipoInterprete tipo) {
        this.nombre = nombre;
        this.enActivo = enActivo;
        this.listaDiscos = listaDiscos;
        this.tipo = tipo;
    }

    /**
     * Instantiates a new ejercicio1.Interprete.
     *
     * @param nombre the nombre
     */
    public Interprete(String nombre) {
        this.nombre = nombre;

    }

    /**
     * Instantiates a new ejercicio1.Interprete.
     */
    public Interprete() {
    }

    /**
     * Gets tipo.
     *
     * @return the tipo
     */
    public TipoInterprete getTipo() {
        return tipo;
    }


    /**
     * Gets nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Gets lista discos.
     *
     * @return the lista discos
     */
    public List<Disco> getListaDiscos() {
        return listaDiscos;
    }


    /**
     * Agregar disco.
     * Inserta disco en su orden por año
     *
     * @param disco the disco
     */
    public void agregarDisco(Disco disco) {
        int posicion = 0;
        for (Disco d : listaDiscos) {
            if (d.compareTo(disco) >= 0) break;
            posicion++;
        }
        listaDiscos.add(posicion, disco);
    }


    /**
     * Imprimir discos.
     */
    public void imprimirDiscos() {
        if (listaDiscos.isEmpty()) {
            System.out.println("No hay discos asociados a este intérprete o no existe el interprete.");
        } else {
            System.out.println("Discos de " + nombre + ":");
            listaDiscos.forEach(disco -> System.out.println(disco.toString()));
        }
    }

    /**
     * Comparamos en minusculas para evitar errores
     */
    @Override
    public int compareTo(Interprete interprete) {
        return this.nombre.toLowerCase().compareTo(interprete.getNombre().toLowerCase());
    }

    @Override
    public String toString() {
        return "ejercicio1.Interprete :" +
                "nombre='" + (nombre != null ? nombre : "") + '\'' +
                ", enActivo=" + (enActivo != null ? enActivo : "") +
                ", listaDiscos=" + (listaDiscos != null ? listaDiscos.stream().map(Disco::getTituloDisco).collect(Collectors.joining(", ")) : "") +
                ", tipo=" + (tipo != null ? tipo.toString() : "") +
                '.';
    }
}
