package ejercicio2;

public class MainEjercicio2 {
    public static void main(String[] args) {
        OrdenComplejidad2 orden = new OrdenComplejidad2();

        // Test metodo2
        int[] lista = {1, 2, 3, 4, 5};
        int[] listaGrande = generarListaGrande(100000);

        System.out.println("Resultado de metodo2: " + orden.metodo2(lista));
        System.out.println("Resultado de metodo2: " + orden.metodo2(listaGrande));

    }

    private static int[] generarListaGrande(int cantidad) {
        int[] listaGrande = new int[cantidad];
        for (int i = 0; i < listaGrande.length; i++) {
            listaGrande[i] = (int) (Math.random() * 1000.0); // Genera números aleatorios entre 0 y 999
        }
        return listaGrande;
    }


}
