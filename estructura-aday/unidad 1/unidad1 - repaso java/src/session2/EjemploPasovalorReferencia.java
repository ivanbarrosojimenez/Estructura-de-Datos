package session2;

import javax.sound.midi.Soundbank;

public class EjemploPasovalorReferencia {
    public static void cambiarValor(int numero){
        numero = 10;
    }

    public static void cambiarReferencia(ObjetoSimple obj){
        obj.valor = 10;
    }


    public static void main(String[] args) {
        int numero = 5;

        System.out.println("ante de cambair valor: "+ numero);
        cambiarValor(numero);
        System.out.println("Despues de cambiar valor "+numero);

        ObjetoSimple obj = new ObjetoSimple();
        obj.valor = 5;
        System.out.println("Antes de cambiar referencia: "+obj.valor);
        cambiarReferencia(obj);
        System.out.println("Despues de cambiar referencia: "+obj.valor);
    }
}
