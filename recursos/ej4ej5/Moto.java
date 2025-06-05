package recursos.ej4ej5;

public class Moto implements Comparable {

    private int cilindrada;
    private String marca;
    private String tipo; //scooter u otro
    private boolean inspecciónFavorable; // Insp. Técn. favorable

    public Moto(int cilindrada, String marca, String tipo) {
        this.cilindrada = cilindrada;
        this.marca = marca;
        this.tipo = tipo;
        this.inspecciónFavorable = false;
    }

    public boolean isInspecciónFavorable() {
        return inspecciónFavorable;
    }

    public void setInspecciónFavorable(boolean
                                               inspecciónFavorable) {
        this.inspecciónFavorable = inspecciónFavorable;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    @Override
    public String toString() {

        return "recursos.ej4ej5.Moto{" + "cilindrada=" + cilindrada + ", marca="
                + marca + ", tipo=" + tipo + ", inspecciónFavorable=" +
                inspecciónFavorable + '}';
    }

    @Override
    public int compareTo(Object o) {
        var moto = (Moto) o;
        return this.marca.concat(tipo).compareTo(moto.marca.concat(tipo));
    }
}
