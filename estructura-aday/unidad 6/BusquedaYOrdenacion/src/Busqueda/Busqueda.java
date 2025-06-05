package Busqueda;

public class Busqueda {

    /**
     * @param a Array sobre el que se hace la búsqueda
     * @param b Elemento buscado dentro del Array
     * @return -1 si no se encuentra o la posición i si se ha encontrado dentro del Array
     * Orden(N)
     */
    public int BusquedaLineal (int []a , int b){
        
        for(int i = 0 ; i < a.length ; i++){  //O(a) --> depende del tamaño de la que será igual N (no sabemos puede ser de 1 a 100000000000
            if(a[i] == b){ //O(1)
                return i; //O(1)
            }
        }
        return -1;//O(1)
    }


    /**
     * @param a
     * @param b
     * @return
     */
    public int BusquedaBinaria(int []a , int b){
        int inf = 0;
        int sup = a.length-1;
        int med;

        while (inf <= sup){
            med = (inf+sup)/2;

            if(a[med] == b){
                return med;
            }
            if(a[med] > b){
                sup = med-1;
            }else{
                inf = med + 1;
            }
        }
        return -1;
    }


}
