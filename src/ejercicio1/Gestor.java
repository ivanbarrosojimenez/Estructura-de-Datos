package ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gestor {

    private ArbolBinario arbolBinario;
    private Scanner scanner;

    public Gestor() {
        this.scanner = new Scanner(System.in);
        arbolBinario = new ArbolBinario();
    }

    public ArbolBinario getArbolBinario() {
        return arbolBinario;
    }

    public void imprimirMenu() {
        System.out.println("#########################################");
        System.out.println("Control de Discos. Selecciona una opción:");
        System.out.println("1. Añadir nuevo interprete:");
        System.out.println("2. Añadir nuevo ejercicio1.Disco:");
        System.out.println("3. Eliminar un ejercicio1.Disco:");
        System.out.println("4. Listar Intérpretes");
        System.out.println("5. Discos de un Intérprete");
        System.out.println("6. Discos editados en un año");
        System.out.println(" ");
        System.out.println("0. Salir");
        System.out.println("#########################################");

    }

    public String obtenerEntradaUsuario(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    //Intenta convertir un texto en un entero, en caso de error retorna -1
    public Integer convertirTextoAEntero(String texto) {
        Integer resultado = -1;
        try {
            resultado = Integer.parseInt(texto);
        } catch (Exception e) {
            //System.err.println("Error al convertir texto a integer");
        }
        return resultado;
    }

    //Control para textos, no se permite vacio o nulo
    public Boolean validarTexto(String texto) {
        return (texto == null || texto.isBlank());
    }

    public String obtenerEntradaValidaTexto(String mensaje, String... opcionesValidas) {
        String entrada = null;
        while (validarTexto(entrada)) {
            if (opcionesValidas != null) {
                for (String opcion : opcionesValidas) {
                    System.out.println(opcion);
                }
            }
            entrada = this.obtenerEntradaUsuario(mensaje);
            if (opcionesValidas != null && opcionesValidas.length > 0) {
                Boolean valido = false;
                for (String opcion : opcionesValidas) {

                    if (entrada.equals(opcion.substring(0, 1))) {
                        valido = true;
                    }
                }
                if (!valido) {
                    //Forzar pedir de nuevo los datos
                    entrada = null;
                }

            }

        }
        return entrada;
    }

    public Interprete obtenerOCrearInterprete(String nommbre) {

        Interprete interprete = new Interprete(nommbre);
        try {
            interprete = arbolBinario.buscar(new Interprete(nommbre)).getInterprete();
        } catch (Error | Exception e) {

        }
        return interprete;


    }

    //Desde el 1700 hasta el 9999
    public List<Integer> obtenerAniosValidos() {
        List<Integer> resultado = new ArrayList<>();
        for (int i = 1700; i <= 9999; i++) {
            resultado.add(i);
        }
        return resultado;
    }

    //Tope 24 horas
    public List<Integer> obtenerMinutosValidos() {
        List<Integer> resultado = new ArrayList<>();
        for (int i = 1; i <= 1440; i++) {
            resultado.add(i);
        }
        return resultado;
    }


}
