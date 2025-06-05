package session2;

import javax.swing.*;
import java.util.ArrayList;

public class ArrayDemo {

    public static void main(String[] args) {
        int []numeros;
        int []edad = new int[10];

        String [] nombres = {"Ana","Jose","Maria","Antonio"};
        int []numeros2 = {2,43,4,5,6,7}; //[2][43][4][5][6][7]
        //[0][1][2][3][4][5]  length-1

        for (int i = 0; i < numeros2.length ; i++) {
            System.out.println(numeros2[i]);
        }
        
        
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Aday");
        lista.add("Ana");   
        lista.add("Jose");
        lista.add("Maria");
        lista.add("Antonio");

        for (String a:lista) {
            System.out.println(a);
        }

        for (String nombre:nombres)
          { System.out.println(nombre);

        }


        for (int i = 0; i <lista.size() ; i++) {
            String a = lista.get(i);
            System.out.println(a);
        }


    }
}
