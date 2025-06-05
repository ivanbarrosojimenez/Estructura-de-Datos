package session2;

import java.io.Serializable;

public class Figura  implements Serializable {
    public int ancho;
    protected int alto;
    private int largo;
    private int altura;

    public int getAncho() {
        return ancho;
    }

    public Figura(){
        ancho = 10;

        alto = 40;
        largo = 3;
        altura = 10;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }



    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
        setAncho(largo);
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    //int void String Figura Persona
    public  Figura nombreDelMetodo(int param1, int param2, int param3){

        return new Figura();
    }

    public void imprimelosvalores() throws ExcepcionUAX {
        System.out.println("Ancho: " + this.getAncho());
        System.out.println("Alto: " + this.getAlto());
        System.out.println("Largo: " + this.getLargo());
        throw new ExcepcionUAX("hol");

    }

    public float divide(int a, int b) throws ExcepcionUAX {
        if(b == 0)
            throw new ExcepcionUAX("No pueded divir por cero");
        else
            return (float)a / b;

    }


    @Override
    public String toString() {
        return "Figura{" +
                "ancho=" + ancho +
                ", alto=" + alto +
                ", largo=" + largo +
                ", altura=" + altura +
                '}';
    }
}
