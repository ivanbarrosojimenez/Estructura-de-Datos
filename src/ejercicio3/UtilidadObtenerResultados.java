package ejercicio3;

import complejidad.Cronometro;
import complejidad.MetodosPrueba;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadObtenerResultados {


    public static Map<Integer, Long> medirTiempoEjecucionDinamico(MetodosPrueba metodos, List<Integer> datosPrueba, String nombreMetodo) {
        Cronometro cronometro = new Cronometro();
        Map<Integer, Long> tiemposPorPrueba = new HashMap<>();

        try {
            Method metodo = MetodosPrueba.class.getMethod(nombreMetodo, int.class);

            for (int dato : datosPrueba) {
                try {
                    cronometro.inicia();
                    metodo.invoke(metodos, dato); // Llama al método dinámicamente
                    cronometro.termina();
                    tiemposPorPrueba.put(dato, cronometro.tiempo());
                } catch (Exception e) {
                    System.err.println("Error al ejecutar con dato: " + dato + " - " + e.getMessage());
                }
            }
        } catch (NoSuchMethodException e) {
            System.err.println("El método " + nombreMetodo + " no existe: " + e.getMessage());
        }

        return tiemposPorPrueba;
    }


    public static void calcularIncrementoPorcentual(Map<Integer, Long> tiemposPorPrueba, String prueba) {
        Long tiempoAnterior = null;

        System.out.println("| Método    | Iteración   | Tiempo (ms)    | Incremento (%) |");
        System.out.println("|-----------|-------------|----------------|----------------|");

        for (Map.Entry<Integer, Long> entrada : tiemposPorPrueba.entrySet()) {
            Integer iteracion = entrada.getKey();
            Long tiempoActual = entrada.getValue();

            if (tiempoAnterior != null) {
                double incremento = ((double) (tiempoActual - tiempoAnterior) / tiempoAnterior) * 100;
                System.out.printf("| %9s | %9d | %11d | %14.2f |\n", prueba, iteracion, tiempoActual, incremento);
            } else {
                System.out.printf("| %9s | %9d | %11d | %14s |\n", prueba, iteracion, tiempoActual, "N/A");
            }

            tiempoAnterior = tiempoActual;
        }
    }

    public static void graficarTiempos(Map<Integer, Long> tiemposPorPrueba) {
        // Encontrar el valor máximo de tiempo para escalar la gráfica
        long maxTiempo = tiemposPorPrueba.values().stream().max(Long::compare).orElse(1L);

        System.out.println("Gráfica de tiempos (x: iteraciones, y: tiempo en ms):");
        System.out.println();

        for (Map.Entry<Integer, Long> entrada : tiemposPorPrueba.entrySet()) {
            int iteracion = entrada.getKey();
            long tiempo = entrada.getValue();

            // Escalar el tiempo para ajustarlo a la consola
            int escala = (int) ((tiempo * 50) / maxTiempo); // Escala a un máximo de 50 caracteres
            System.out.printf(" %3d | %s (%.2f ms)   \n", iteracion, "*".repeat(escala), (double) tiempo);
        }

        System.out.println();
        System.out.print("Nota: La longitud de la línea '*' está escalada proporcionalmente al tiempo.\n");
    }
}
