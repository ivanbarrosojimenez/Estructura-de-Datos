package session3;

import session2.Figura;

public class Ejemplo3 {
    public static void main(String[] args) {
        Figura f = new Figura();
        System.out.println(f);
        String nombreArchivo = "mibackup.txt";
        String texto = "Hola, este es un ejemplo de escritura y lectura de una rchivo de texto";
        GestionArchivo archivo = new GestionArchivo();
        archivo.escribirArchivo(nombreArchivo, texto);


        System.out.println(archivo.leerArchivo(nombreArchivo));
        nombreArchivo = "mibackup2.txt";
        Figura f2 = new Figura();
        archivo.guardarObjeto(nombreArchivo, f2);
        f2 = null;
        System.out.println(f2);
        f2 = archivo.leerObjeto(nombreArchivo,Figura.class);
        System.out.println(f2);



    }
}
