package session3;

import java.io.*;

public class GestionArchivo {


    public void escribirArchivo(String nombreArchivo, String texto) {

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo));
            bw.write(texto);
            bw.close();
            System.out.println("Archivo escritado exitosamente");
        }catch(IOException ioe){
            System.err.println(ioe);
        }

    }

    public String leerArchivo(String nombreArchivo) {

        try{
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String texto = "", linea;
            while((linea = br.readLine()) != null)
            {
                texto = texto + linea;
            }
            br.close();
            return texto;
        }catch(IOException ioe){
            System.err.println(ioe);
        }
        return "";
    }

    public <T extends Serializable> void guardarObjeto(String nombreArchivo, T objeto) {
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            oos.writeObject(objeto);
            oos.close();
            System.out.println("Archivo guardado exitosamente");
        }catch(IOException ioe){
            System.err.println(ioe);
        }
    }

    public <T extends Serializable> T leerObjeto(String nombreArchivo, Class<T> clase) {
        try{

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo));
            Object obj = ois.readObject();
            if (clase.isInstance(obj)) {
                return clase.cast(obj);
            } else {
                throw new ClassCastException("El objeto leído no es del tipo esperado: " + clase.getName());
            }

        }catch(ClassNotFoundException | IOException ioe){
            System.err.println(ioe);
        }
        return null;
    }


}
