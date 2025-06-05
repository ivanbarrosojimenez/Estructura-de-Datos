import recursos.ej4ej5.Moto;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio3 {
    /*
    Dada la siguiente clase recursos.ej4ej5.Moto:
    public class recursos.ej4ej5.Moto {

     private int cilindrada;
     private String marca;
     private String tipo; //scooter u otro
     private boolean inspecciónFavorable; // Insp. Técn. favorable
     public recursos.ej4ej5.Moto(int cilindrada, String marca, String tipo) {
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
    4
    return "recursos.ej4ej5.Moto{" + "cilindrada=" + cilindrada + ", marca="
    + marca + ", tipo=" + tipo + ", inspecciónFavorable=" +
    inspecciónFavorable + '}';
     }

}
    Escriba un método que reciba un ArrayList de recursos.ej4ej5.Moto y una cilindrada de tipo entero. El
    método debe devolver el número de Motos que existen en la lista con una cilindrada
    superior o igual al límite recibido por parámetro y una inspección técnica favorable
    (ambas condiciones simultáneamente).
    int cuentaMotosFavorablesCilindrada(ArrayList<recursos.ej4ej5.Moto> lista, int
    limite)
     */

    public static void main(String[] args) {
        var listaMotos = new ArrayList<Moto>();
        var moto1 = new Moto(125, "Yamaha", "scooter");
        moto1.setInspecciónFavorable(true);
        var moto2 = new Moto(300, "Ducati", "deportiva");
        moto2.setInspecciónFavorable(true);
        var moto3 = new Moto(400, "Honda", "scooter");
        var moto4 = new Moto(550, "Kawasaki", "deportiva");
        var moto5 = new Moto(500, "Suzuki", "deportiva");
        moto5.setInspecciónFavorable(true);
        var moto6 = new Moto(600, "BMW", "touring");
        moto6.setInspecciónFavorable(true);
        listaMotos.addAll(List.of(moto1, moto2, moto3, moto4, moto5, moto6));
        //Hay 3 motos que tienen la cilindrada >= 500, pero solo 2 tienen inspección favorable
        System.out.println("Listado de motos con inspección favorable y cilindrada >= 500: "
                + cuentaMotosFavorablesCilindrada(listaMotos, 500));
    }

    static int cuentaMotosFavorablesCilindrada(ArrayList<Moto> lista, int limite) {
        int contador = 0;
        for (Moto moto : lista) {
            if (moto.getCilindrada() >= limite && moto.isInspecciónFavorable()) {
                contador++;
            }
        }
        return contador;
    }


}
