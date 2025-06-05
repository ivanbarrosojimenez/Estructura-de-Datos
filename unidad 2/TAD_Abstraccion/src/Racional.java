public class Racional {
    private int numerador;
    private int denominador;

// CONSTRUCTORES
/*  * Objetivo: Crear un número racional unidad.
    * Necesita: Nada
    * Modifica: Nada
    * Produce:  Crear un racional cuyo numerador y denominador es 1*/
    public Racional() {
        this.numerador = 1;
        this.denominador = 1;
    }


/*  * Objetivo: Crear un número racional dados un numerador y un denominador.
    * Necesita: Dos valore enteros, el primero para el númerador y el segundo para el denominador
    * Excepción: Si el valor para el denominador vale cero se debe lanzar una excepción "Denominador cero"
    * Modifica: Nada
    * Produce:  Crear un racional cuyos valores se corresponden con los valores dle numerador y denominador dados.
                Si el denominador es negativo, se creará el racional equivalente con el denominador positivo.
*/

    public Racional(int numerador, int denominador) throws Exception{
        if(denominador == 0) {
            throw new Exception("Denominador cero");
        }
        this.numerador = numerador;
        this.denominador = denominador;
        simplificar();

    }

// ACCESO
/*
     * Objetivo: devolver el valor del número
     * Necesita: el racional
     * Modifica: Nada
     * Produce:  Devuelve el valor del numerador del racional dado
 */
    public int getNumerador() {
        return this.numerador;
    }

/*
     * Objetivo: devolver el valor del número
     * Necesita: el racional
     * Modifica: Nada
     * Produce:  Devuelve el valor del denominador del racional dado
 */
    public int getDenominador() {
        return this.denominador;
    }


/*
    * Objetivo: Modificar el valor del numerador.
    * Necesita: el racional y numero entero
    * Modifica: El racional dado, cambiando el valor de su numerador por el
                nuevo valor entero dado
    * Produce:  Nada
 */
    public void setNumerador(int numerador) {
         this.numerador = numerador;
    }


/*
    * Objetivo: Modificar el valor del denominador.
    * Necesita: el racional y número entero diferente de 0
        * Excepción: En caso de que el nuevo denominador dado valga cero, se debe lanzar la excepción "Denominador Cero"
    * Modifica: El racional dado, cambiando el valor de su numerador por el
                nuevo valor entero dado
    * Produce:  Nada
 */
    public void setDenominador(int denominador) throws Exception {
        if(denominador == 0) {
            throw new Exception("Denominador cero");
        }
        this.denominador = denominador;
        simplificar();
    }



   /*
    * Objetivo: Sumar dos números racionales.
    * Necesita: Dos números racionales.
    * Modifica: Nada.
    * Produce: Un nuevo número racional suma de los dos racionales dados.  a/b + c/d = (ad + bc)/bd
    */

    public Racional suma(Racional r){
        Racional nuevo = null;
        try{
            nuevo = new Racional(
                    this.numerador * r.getDenominador() + r.getNumerador()*this.denominador,
                    this.denominador*r.getDenominador()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return nuevo;
    }

   /*
    * Objetivo: Restar dos números racionales
    * Necesita: Dos números racionales
    * Modifica: Nada
    * Produce: Un nuevo racional resultado de la resta del segundo número
    *          del primero de los dos racionales dados. El nuevo número
    *          racional se calculade la siguiente manera: a/b - c/d = (ad - bc)/bd
    */

    public Racional resta(Racional r){
        Racional nuevo = null;
        try{
            nuevo = new Racional(
                    this.numerador * r.getDenominador() - r.getNumerador()*this.denominador,
                    this.denominador*r.getDenominador()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return nuevo;
    }

    /*
    * Objetivo: Multiplicar dos números racionales
    * Necesita: Dos números racionales
    * Modifica: Nada
    * Produce: Un nuevo número racional resultado de la multiplicación
    *          de los dos racionales dados. El nuevo racional se calcula
    *          de la siguiente forma a/b x c/d = ac/bd. El resultado de
    *          la operación se dará en forma simplificada o canónica.
    */
    public Racional multiplicacion(Racional r){
        Racional nuevo = null;
        try{
            nuevo = new Racional(
                    this.numerador * r.getNumerador(),
                    this.denominador * r.getDenominador()
            );
            nuevo.simplificar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return nuevo;
    }

    /*
    * Objetivo: Dividir dos números racionales
    * Necesita: Dos números racionales
    * Modifica: Nada
    * Produce: Un nuevo número racional resultado de la división del primer racional
               entre el segundo. El nuevo número racional se calcula de la siguiente
               manera:  en primer lugar se calcula el inverso del segundo racional (a/b -> b/a)
               si el numerador es cero dará un problema siempre que a /= 0
               Para hacer la división a/b ÷ c/d = a/b * d/c = ad/bc. y este resultado
               se tendría que simplificar.
     */
    public Racional division(Racional r) throws Exception{
       if(r.getNumerador() == 0)
           throw new Exception("Divisor vale cero");

       return this.multiplicacion(r.inverso());

    }


    private void simplificar() {
        int div = mcd(this.numerador, this.denominador);
        this.numerador /= div;
        this.denominador /= div;
        if(this.denominador < 0){
            this.numerador *= -1;
            this.denominador *= -1;
        }
    }

   /*
    * Objetivo: Calcular el inverso de un racional
    * Necesita: Un números racionales
    *       Excepción: Si el numerador del racional vale cero lanza una excepción "denominador cero"
    * Modifica: Nada
    * Produce:  Un nuevo número racional cuyo valor es el inverso del racional dado. Si el racional es
    *           a/b --> b/a siempre que a sea distinto de cero.
    */
    private Racional inverso() throws Exception {
        if(this.numerador == 0) {
            throw new Exception("Denominador cero");
        }
        return new Racional(this.denominador, this.numerador);
    }

    /**
     * Calcular el máximo común divisor de dos números a y b
     * @param a el primer numero
     * @param b El segundo número
     * @return el máximo común divisor de ambos valores
     */
    private int mcd(int a, int b){
        if(a == 0 || b == 0)
            return 1;

        a = Math.abs(a); //obtenemos el valor absoluto del número, lo dejamos en positivo.
        b = Math.abs(b);

        while (a != b){
            if( a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }

    /*
     * Convierte un racional a una representación textual del mismo, de
     * forma que se pueda escribir por la pantalla. Se utilizar la represen-
     * tación “a/b”, donde a es el numerador del racional y b es el deno-
     * minador del racional.
     * Objetivo: Convertir un racional en una representación textual del mismo.
     * Necesita: Nada
     * Modifica: Nada
     * Produce: Generae un texto en formato "a/b". donde a es el numerador y b
        es el denominador. Si el racional es 6/8 genera el texto "3/4"
     *
     */
    public String convertirATexto(){
        return this.numerador+"/"+this.denominador;
    }




    /*
     * Crea un nuevo número racional a partir de una representación textual del
     * mismo. Si se utiliza el texto “6/8”, crea el número racional que
     * corresponde con 6/8 donde el numerador vale 6 y el denominador vale 8.
     * El texto debe estar bien formado y su denominador no debe valer cero.
     * Objetivo: Construir un nuevo racional a partir de una representación textual
                del mismo de la forma "a/b"
     * Necesita: Un texto de un racional
            Excepciones: Si el texto no tiene la fomra de un entero una barra y otro
                         entero, debe lanzar una excepción de "Texto mal formado".
                         Si el texto está bien formado y representa un racional, pero
                         su denominador vale cero lanza la excepción "Denominador cero".
     * Modifica: Nada
     * Produce: Genera un nuevo racional, que es una representación canónica del racional introducido como texto.
     */
    public Racional(String texto) throws Exception{
        if(texto == null){
            throw new Exception("Texto mal formado");
        }
        String validacion[] = texto.split("/");
        if(validacion.length != 2){
            throw new Exception("Texto mal formado");
        }

        try{
            this.numerador = Integer.parseInt(validacion[0]);
            this.denominador = Integer.parseInt(validacion[1]);
        } catch (NumberFormatException e) {
            throw new Exception("Texto mal formado"); // "a/8"
        }
        if(this.denominador == 0){
            throw new Exception("Denominador cero");
        }
        simplificar();//para obtener el valor canonico (10/12 -> 5/6)
    }

    public static void main(String[] args) throws Exception {
        Racional a = new Racional();
        System.out.println("Racional a = "+ a.convertirATexto());
        Racional b = new Racional(10,6);
        System.out.println("Racional b = "+ b.convertirATexto());
        Racional c = a.suma(b);
        System.out.println("Racional c = a + b => "+ c.convertirATexto());
        Racional d = c.resta(b);
        System.out.println("Racional d = c - b => "+ d.convertirATexto());
        Racional e = b.multiplicacion(c);
        System.out.println("Racional e = c * b => "+ e.convertirATexto());
        Racional f = b.division(c);
        System.out.println("Racional f = c / b => "+ f.convertirATexto());
        Racional g = new Racional("9/18");
        System.out.println("Racional g = "+ g.convertirATexto());

    }


}



