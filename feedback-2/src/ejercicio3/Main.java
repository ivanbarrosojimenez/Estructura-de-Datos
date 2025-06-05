package ejercicio3;

import complejidad.MetodosPrueba;

import java.util.List;
import java.util.Map;

import static ejercicio3.UtilidadObtenerResultados.*;

public class Main {

    public static void main(String[] args) {
        MetodosPrueba metodos = new MetodosPrueba();
        List<String> pruebas = List.of("m1", "m2", "m3", "m4", "m5", "m6", "m7");
        //List<Integer> datosPrueba = List.of(1, 3, 5, 7, 9); // Conjunto de datos de prueba
        //List<Integer> datosPrueba = List.of(2, 4, 6, 8, 10); // Conjunto de datos de prueba
        List<Integer> datosPrueba = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); // Conjunto de datos de prueba

        for (String prueba : pruebas) {
            Map<Integer, Long> tiemposPorPrueba = medirTiempoEjecucionDinamico(metodos, datosPrueba, prueba);
            calcularIncrementoPorcentual(tiemposPorPrueba, prueba);
            graficarTiempos(tiemposPorPrueba);
        }

    }


}
