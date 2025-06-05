package Busqueda;

import java.util.Vector;

public class Ordenacion {


    public static void main(String[] args) {

        int[] numeros = {42, 20, 17, 13, 28, 14, 23, 15};

        insercion(numeros);

        numeros[0] = 42;
        numeros[1] = 20;
        numeros[2] = 17;
        numeros[3] = 13;
        numeros[4] = 28;
        numeros[5] = 14;
        numeros[6] = 23;
        numeros[7] = 15;

        insercionBinaria(numeros);

        seleccion(numeros);

        numeros[0] = 42;
        numeros[1] = 20;
        numeros[2] = 17;
        numeros[3] = 13;
        numeros[4] = 28;
        numeros[5] = 14;
        numeros[6] = 23;
        numeros[7] = 15;

        int numeros2[]  = {10, 12, 14, 16, 18, 20, 22, 24, 26, 25,28, 30, 32, 34, 36, 38, 40, 42, 44, 46};
        int numeros3[]  = {50, 48, 46, 44, 42, 40, 38, 36, 34, 32, 30, 28, 26, 24, 22, 20, 18, 16, 14, 12};
        //50, 48, 46, 44, 42, 40, 38, 36, 34, 32, 30, 28, 26, 24, 22, 20, 18, 16, 14, 12
        //burbuja(numeros2);
       // burbujaMejorado(numeros3);
        //vibracion(numeros);
        //shellshort(numeros3);
        //mergesort(numeros);
        quicksort(numeros);
    }
 // INSERCCIÓN
    public static void insercion(int []a){
        int temp;
        int i,j;
        for(i = 1; i < a.length; i++){ // O(N) porque lo haría el numero de elementos del Array que no se cuantos son
            temp = a[i]; // en la primera interación será el valor 20 que compararemos con el valor primero posciión 0 que era un 42
            for(j = i; j >0 && temp < a[j-1];j--){ // no se haría O(1) porque no se haría en el mejor caso cuando estuviera ordenado
                a[j] = a[j-1];//intercambiamos por el valor era menor y así queda ordenado
            }
            a[j] = temp;
        } //caso peor O(n2)
    }

    public static void insercionBinaria(int []a){
        int i,j;
        int temp;
        int inf, sup, medio;

        for(i = 1; i < a.length; i++){
            temp = a[i];
            inf = 0;
            sup = i - 1;
            while(inf <= sup){
                medio = (inf+sup)/2;
                if(a[medio] < temp){
                    inf = medio+1;
                }else{
                    sup = medio-1;
                }
            }
            for(j = i; (j > inf); j--)
                a[j] = a[j-1];

            a[j] = temp;
        }
    }

//SELECCIÓN
    public static void seleccion(int[] a){
        int temp;
        int menor;
        int i,j;
        for(i = 0; i<a.length; i++){
            menor = i;
            for(j = i+1; j < a.length; j++){
                if(a[menor] > a[j]){
                    menor = j;
                }
            }

            temp = a[i];
            a[i] = a[menor];
            a[menor] = temp;
        }
    }

    //INTERCAMBIO
    public static void burbuja(int []a){

        int i,j;
        int temp;
        for(i = 0; i<a.length; i++){
            System.out.println("Iteración clásica #" + (i + 1));
            for(j = a.length-1; j > i; j--){
                if(a[j-1] > a[j]){
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }


    public static void burbujaMejorado(int []a){
        int temp;
        boolean hayIntercambio = true;

        for (int i = 0; (i < a.length-1)&&(hayIntercambio); i++) {
            hayIntercambio = false;
            System.out.println("Iteración mejorada #" + (i + 1));
            for(int j = a.length-1; j > i; j--){
                if(a[j-1] > a[j]){
                    hayIntercambio = true;
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }

        }


    }

    public static void vibracion(int []a){
        int temp;
        boolean hayIntercambio = true;
        int j;
        int posicionUltimoCambio, izquierda, derecha;

        izquierda = 1;
        derecha = a.length-1;

        posicionUltimoCambio = derecha;

        do{

            hayIntercambio = false;
            for ( j = derecha; j >= izquierda; j--) {
                if(a[j-1]>a[j]){
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                    hayIntercambio = true;
                    posicionUltimoCambio = j;
                }

            }
            for(j = izquierda; j <= derecha; j++){
                if(a[j-1]>a[j]){
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                    hayIntercambio = true;
                    posicionUltimoCambio = j;
                }
            }
            derecha = posicionUltimoCambio - 1;
        }while((derecha > izquierda) && hayIntercambio);
    }


    public static void shellshort(int a[]){
        int intervalo, i, j, tmp;
        for(intervalo = a.length/2; intervalo > 0; ){
            for(i = intervalo; i < a.length; i++){
                tmp = a[i];
                for(j = i; (j >= intervalo) && tmp < a[j-intervalo]; j-=intervalo){
                    a[j] = a[j-intervalo];
                }
                a[j] = tmp;
            }
            if(intervalo == 2)
                intervalo = 1;
            else
                intervalo = (int) (intervalo/2.2);
        }
    }


    public static void mergesort(int []a){
        int [] vectorAux = new int[a.length];
        mergesort(a,vectorAux, 0, a.length);
    }

    public static void mergesort(int []a, int []vectorAux, int izquierda, int derecha){
        if(izquierda < derecha){
            int centro = (izquierda+derecha)/2;
            mergesort(a,vectorAux,izquierda,centro);
            mergesort(a,vectorAux,centro+1,derecha);
            merge(a, vectorAux, izquierda, centro+1, derecha);
        }

    }

    public static void merge(int []a, int []vectorAux, int posIzq, int posDer, int posFin){
        int i;
        int finIzq = posDer-1;
        int posAux = posIzq;
        int numElemento = posFin-posIzq+1;

        //mezcla 2 arrays
        while((posIzq <= finIzq) && ( posDer <= posFin)){
            if(a[posIzq]<a[posDer]){
                vectorAux[posAux]=a[posIzq];
                posIzq++;
            }else{
                vectorAux[posAux]=a[posDer];
                posDer++;
            }
            posAux++;
        }

        //copio lo que no he tocado de la izqwuierda hasta el principio de la secci`ón
        while(posIzq <= finIzq){
            vectorAux[posAux]=a[posIzq];
            posIzq++;
            posAux++;
        }

        //copio lo que no he tocado de la derecha hastsa el final
        while(posDer <= posFin){
            vectorAux[posAux]=a[posDer];
            posDer++;
            posAux++;
        }

        //volvemos a ponerlo en el array a
        for (i = 0; i < numElemento; i++) {
            a[posFin] = vectorAux[posFin];
            posFin--;
        }

    }

    public static void quicksort(int []a){
        quicksort(a, 0, a.length-1);
    }

    public static void quicksort(int []a, int ini, int fin){

        int medio;
        int pivote;
        int i,j;

        if(fin -ini >= 1){
            medio = (ini+fin)/2;
            //i ordenar fin, medio, inicio
            if(a[medio]<a[ini]){
                intercambiar(a,ini,medio);
            }
            if(a[fin]<a[ini]){
                intercambiar(a,ini,fin);
            }
            if(a[fin]<a[medio]){
                intercambiar(a, medio, fin);
            }

            //2 ponermos el pivote, que hora esta en el medio, en la penultima posición
            intercambiar(a,medio, fin-1);
            pivote = a[fin-1];

            //empezamos a particionar
            i = ini;
            j = fin-1;
            while(i<j){
                while(i<j && a[i]<pivote){
                    i++;
                }
                while(i<j && pivote<=a[j]){
                    j--;
                }
                if(i<j){
                    intercambiar(a,i,j);
                }
            }

            //poner el pivote en la mitad
            intercambiar(a, i, fin-1);

            quicksort(a, ini, j-1);
            quicksort(a, j+1, fin);
        }
    }

    public static void intercambiar(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
