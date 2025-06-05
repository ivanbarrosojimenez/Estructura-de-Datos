package Set;

public class Coche implements Comparable<Coche>{
    private String matricula;
    private String marca;
    private String modelo;
    private int potencia;

    public Coche(String matricula, String marca, String modelo, int potencia) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", potencia=" + potencia +
                '}';
    }

    /**


     * @return the value 0 if both plates are equal; a value less than 0 if this string is lexicographically less than the string argument;
     *  and a value greater than 0 if this string is lexicographically greater than the string argument.
     *  0 = sin son iguales
     *  <0 = si es menor el string que el que me pasan
     *  >0 = si es mayor mi string del que me pasan
     */

    @Override
    public int compareTo(Coche coche) {

        String letras1 = this.matricula.split("-")[1];
        String letras2 = coche.matricula.split("-")[1];
        int resultado = letras1.compareTo(letras2);
        if(resultado != 0){
            return resultado;
        }

        int num1 = Integer.parseInt(this.matricula.split("-")[0]);
        int num2 = Integer.parseInt(coche.matricula.split("-")[0]);


        if(this.matricula.compareTo(coche.matricula)<0){
            return -1;
        }else if(this.matricula.compareTo(coche.matricula)>0){
            return 1;
        }

        if(this.modelo.compareTo(coche.modelo)<0){
            return -1;
        }else if(this.modelo.compareTo(coche.modelo)>0){
            return 1;
        }

        return Integer.compare(num1, num2);
    }
}
