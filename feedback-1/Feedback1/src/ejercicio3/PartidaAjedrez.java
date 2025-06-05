package ejercicio3;

import java.util.*;

public class PartidaAjedrez {
    private String jugadorBlancas;
    private String jugadorNegras;
    private LinkedList<String> movimientos;
    private Map<String, Pieza> tablero;
    private static final Set<String> POSICIONES_VALIDAS;
    private String turno;  // "BLANCA" o "NEGRA"
    private Set<String> peonesPrimerMovimiento; // Conjunto de peones que han realizado su primer movimiento
    private boolean mostrarDebug = false; // Variable para mostrar información de depuración

    static {
        // Inicializamos el conjunto de posiciones válidas del tablero
        POSICIONES_VALIDAS = new HashSet<>();
        char[] columnas = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        for (char columna : columnas) {
            for (int fila = 1; fila <= 8; fila++) {
                POSICIONES_VALIDAS.add(columna + String.valueOf(fila));  // Ejemplo: "a1", "b2", ..., "h8"
            }
        }
    }

    // Constructor
    public PartidaAjedrez() {
        movimientos = new LinkedList<>();
        tablero = new HashMap<>();
        peonesPrimerMovimiento = new HashSet<>();  // Inicializamos el conjunto de primer movimiento


    }

    // Iniciar la partida
    public void iniciarPartida(String jugadorBlancas, String jugadorNegras) {
        this.jugadorBlancas = jugadorBlancas;
        this.jugadorNegras = jugadorNegras;
        this.turno = "BLANCA";  // El primer turno es de las piezas blancas
        this.movimientos.clear();
        this.tablero.clear();
        // Aquí también deberíamos inicializar el tablero con las piezas en sus posiciones iniciales
        peonesPrimerMovimiento.clear();  // Reseteamos el conjunto de primer movimiento
        inicializarTablero();
    }

    // Método para obtener el turno actual
    public String obtenerTurno() {
        return turno;
    }

    public void setMostrarDebug(boolean mostrarDebug) {
        this.mostrarDebug = mostrarDebug;  // Cambia el estado de la variable de depuración
    }

    // Método que valida si una posición es válida
    public boolean esPosicionValida(String posicion) {
        return POSICIONES_VALIDAS.contains(posicion);  // Retorna true si la posición está en el conjunto de posiciones válidas
    }

    // Inicializar el tablero con las piezas en las posiciones iniciales
    private void inicializarTablero() {
// Colocamos las piezas en sus posiciones iniciales para las blancas y negras
        // Blancas
        tablero.put("a1", new Pieza(TipoPieza.TORRE, ColorPieza.BLANCA, "a1"));
        tablero.put("h1", new Pieza(TipoPieza.TORRE, ColorPieza.BLANCA, "h1"));
        tablero.put("b1", new Pieza(TipoPieza.CABALLO, ColorPieza.BLANCA, "b1"));
        tablero.put("g1", new Pieza(TipoPieza.CABALLO, ColorPieza.BLANCA, "g1"));
        tablero.put("c1", new Pieza(TipoPieza.ALFIL, ColorPieza.BLANCA, "c1"));
        tablero.put("f1", new Pieza(TipoPieza.ALFIL, ColorPieza.BLANCA, "f1"));
        tablero.put("d1", new Pieza(TipoPieza.REINA, ColorPieza.BLANCA, "d1"));
        tablero.put("e1", new Pieza(TipoPieza.REY, ColorPieza.BLANCA, "e1"));
        for (char columna = 'a'; columna <= 'h'; columna++) {
            tablero.put(columna + "2", new Pieza(TipoPieza.PEON, ColorPieza.BLANCA, columna + "2"));
        }

        // Negras
        tablero.put("a8", new Pieza(TipoPieza.TORRE, ColorPieza.NEGRA, "a8"));
        tablero.put("h8", new Pieza(TipoPieza.TORRE, ColorPieza.NEGRA, "h8"));
        tablero.put("b8", new Pieza(TipoPieza.CABALLO, ColorPieza.NEGRA, "b8"));
        tablero.put("g8", new Pieza(TipoPieza.CABALLO, ColorPieza.NEGRA, "g8"));
        tablero.put("c8", new Pieza(TipoPieza.ALFIL, ColorPieza.NEGRA, "c8"));
        tablero.put("f8", new Pieza(TipoPieza.ALFIL, ColorPieza.NEGRA, "f8"));
        tablero.put("d8", new Pieza(TipoPieza.REINA, ColorPieza.NEGRA, "d8"));
        tablero.put("e8", new Pieza(TipoPieza.REY, ColorPieza.NEGRA, "e8"));
        for (char columna = 'a'; columna <= 'h'; columna++) {
            tablero.put(columna + "7", new Pieza(TipoPieza.PEON, ColorPieza.NEGRA, columna + "7"));
        }
    }

    // Realizar un movimiento
    public void realizarMovimiento(String movimiento) {
        // Dividimos el movimiento en dos partes: origen y destino
        String[] partes = movimiento.split("-");
        if (partes.length != 2 || !esPosicionValida(partes[0]) || !esPosicionValida(partes[1])) {
            throw new IllegalArgumentException("Movimiento inválido. Las posiciones deben ser válidas.");
        }

        String origen = partes[0];
        String destino = partes[1];

        // Obtener la pieza en la posición de origen
        Pieza piezaOrigen = tablero.get(origen);
        if (piezaOrigen == null) {
            throw new IllegalArgumentException("No hay ninguna pieza en la posición de origen.");
        }

        // Verificar que la pieza es del color correspondiente al jugador actual
        if ((turno.equals("BLANCA") && piezaOrigen.getColor() == ColorPieza.NEGRA) ||
                (turno.equals("NEGRA") && piezaOrigen.getColor() == ColorPieza.BLANCA)) {
            throw new IllegalArgumentException("Es el turno del otro jugador.");
        }

        // Verificar si el movimiento es válido para esa pieza
        boolean primerMovimiento = !peonesPrimerMovimiento.contains(origen);  // Verifica si ya movió el peón
        if (!piezaOrigen.puedeMover(origen, destino, primerMovimiento)) {
            throw new IllegalArgumentException("El movimiento no es válido para esta pieza.");
        }

        // Actualizar la lista de primer movimiento si es un peón que se mueve por primera vez
        if (piezaOrigen.getTipo() == TipoPieza.PEON && !peonesPrimerMovimiento.contains(origen)) {
            peonesPrimerMovimiento.add(origen);
        }

        // Mover la pieza de origen a destino
        tablero.put(destino, piezaOrigen);  // Colocar la pieza en la nueva posición
        tablero.remove(origen);  // Eliminar la pieza de la posición original
        piezaOrigen.setPosicion(destino);   // Colocar la pieza en la nueva posición
        // Registrar el movimiento
        movimientos.add(movimiento);

        // Cambiar el turno
        if (turno.equals("BLANCA")) {
            turno = "NEGRA";
        } else {
            turno = "BLANCA";
        }
        // Mostrar información de depuración
        mostrarInfoDebug("Movimiento realizado: " + movimiento);
        mostrarInfoDebug("Turno actual: " + turno + " : " + (turno.equals("BLANCA") ? jugadorBlancas : jugadorNegras));
        mostrarInfoDebug("");
    }


    // Obtener la pieza en una posición específica
    public Pieza obtenerPiezaEnPosicion(String posicion) {
        var resultado = tablero.get(posicion);
        mostrarInfoDebug("\nPieza seleccionada: " + resultado + " [" + resultado.getIconoColor() + "]");
        return resultado;
    }

    // Comprobar si es jaque mate
    public boolean esJaqueMate() {
        // Lógica para verificar si es jaque mate
        return false; // Este es solo un ejemplo
    }

    // Comprobar si es empate
    public boolean esEmpate() {
        // Lógica para verificar si es empate
        return false; // Este es solo un ejemplo
    }

    // Método que devuelve los movimientos posibles para una pieza en una posición
    public LinkedList<String> obtenerMovimientosPosibles(String posicion) {
        LinkedList<String> movimientosPosibles = new LinkedList<>();

        // Obtener la pieza en la posición indicada
        Pieza pieza = tablero.get(posicion);

        if (pieza != null) {
            // Obtener los movimientos posibles según el tipo de pieza
            movimientosPosibles = pieza.obtenerMovimientos();

            // Filtrar los movimientos según las reglas del tablero y las piezas que lo bloquean
            movimientosPosibles = filtrarMovimientosPosibles(pieza, movimientosPosibles);
        } else {
            throw new IllegalArgumentException("No hay ninguna pieza en la posición " + posicion);
        }
        mostrarInfoDebug("Movimientos posibles para " + pieza.getIconoColor() + " en la posición " + posicion + " son : " + movimientosPosibles);
        return movimientosPosibles;
    }

    // Mostrar el tablero de manera visual usando emoticonos
    public void mostrarTableroVisual() {
        for (int fila = 8; fila >= 1; fila--) {
            System.out.print(fila + " "); // Imprimir el número de la fila

            for (char columna = 'a'; columna <= 'h'; columna++) {
                String posicion = "" + columna + fila;
                Pieza pieza = tablero.get(posicion);

                if (pieza != null) {
                    // Usamos el método getIcono() de la clase Pieza para obtener el emoticono
                    System.out.print(pieza.getIconoColor() + " ");
                } else {
                    // Si no hay pieza, imprimir el icono de la casilla vacía
                    System.out.print(Pieza.getVacíaIcono() + " ");
                }
            }
            System.out.println();
        }

        //System.out.println("  Ⓐ    Ⓑ   Ⓒ   Ⓓ   Ⓔ    Ⓕ   Ⓖ   Ⓗ");  // Letras grandes dentro de círculos (mayúsculas)
        System.out.println("  🅐    🅑   🅒   🅓   🅔    🅕   🅖   🅗");  // Doble espacio (En Space - U+2002)

    }

    // Método para mostrar los movimientos posibles de una pieza
    public void mostrarMovimientosVisual(Pieza pieza) {
        // Obtener los movimientos posibles para la pieza

        // Códigos ANSI para colores
        String rojo = "\u001B[31m";  // Rojo
        String verde = "\u001B[32m"; // Verde
        String reset = "\u001B[0m";  // Reset color

        // Filtrar los movimientos posibles teniendo en cuenta las piezas en el tablero
        var movimientosPosibles = obtenerMovimientosPosibles(pieza.getPosicion());

        // Mostrar el tablero y resaltar las posiciones de los movimientos posibles
        for (int fila = 8; fila >= 1; fila--) {
            System.out.print(fila + " "); // Imprimir el número de la fila

            for (char columna = 'a'; columna <= 'h'; columna++) {
                String pos = "" + columna + fila;
                Pieza piezaEnPosicion = tablero.get(pos);

                // Si hay una pieza en la casilla, imprimir su icono
                if (piezaEnPosicion != null) {
                    // Si estamos en la casilla de la pieza que estamos moviendo, la imprimimos en verde
                    if (pos.equals(pieza.getPosicion())) {
                        System.out.print(verde + piezaEnPosicion.getIcono() + reset + " ");  // Resaltamos la pieza en verde
                    } else if (movimientosPosibles.contains(pos) && piezaEnPosicion.getColor() != pieza.getColor()) {
                        // Si la posición es un movimiento posible, pero hay una pieza rival, imprimir en rojo
                        System.out.print(rojo + piezaEnPosicion.getIcono() + reset + " ");  // Resaltamos el icono en rojo
                    } else {
                        // Si no es un movimiento posible ni la pieza que se está moviendo, mostrar el icono normal
                        System.out.print(piezaEnPosicion.getIconoColor() + " ");
                    }
                } else {
                    // Si no hay pieza, mostrar el cuadrado vacío
                    if (movimientosPosibles.contains(pos)) {
                        System.out.print(rojo + Pieza.getVacíaIcono() + reset + " ");  // Casilla vacía marcada en rojo
                    } else {
                        System.out.print(Pieza.getVacíaIcono() + " ");  // Casillas vacías normales
                    }
                }
            }
            System.out.println();  // Salto de línea al final de cada fila
        }

        // Imprimir las letras para las columnas
        System.out.println("  🅐   🅑   🅒   🅓   🅔   🅕   🅖   🅗");  // Letras de columnas con doble espacio
    }

    // Filtra los movimientos posibles teniendo en cuenta las piezas bloqueando el camino
    private LinkedList<String> filtrarMovimientosPosibles(Pieza pieza, LinkedList<String> movimientosPosibles) {
        LinkedList<String> movimientosValidos = new LinkedList<>();
        for (String movimiento : movimientosPosibles) {
            // Si la pieza es una torre, validamos su movimiento
            if (pieza.getTipo() == TipoPieza.TORRE) {
                if (esMovimientoValidoTorre(pieza, movimiento)) {
                    movimientosValidos.add(movimiento);
                }
            } else if (pieza.getTipo() == TipoPieza.ALFIL) {
                if (esMovimientoValidoAlfil(pieza, movimiento)) {
                    movimientosValidos.add(movimiento);
                }
            } else {
                // Para otras piezas, validamos el movimiento básico
                if (esMovimientoValido(pieza, movimiento)) {
                    movimientosValidos.add(movimiento);
                }
            }
        }
        return movimientosValidos;
    }

    // Lógica de movimiento de la TORRE
    private boolean esMovimientoValidoTorre(Pieza pieza, String destino) {
        char columnaOrigen = pieza.getPosicion().charAt(0);
        int filaOrigen = Integer.parseInt(pieza.getPosicion().substring(1));
        char columnaDestino = destino.charAt(0);
        int filaDestino = Integer.parseInt(destino.substring(1));

        // La torre se mueve en línea recta (horizontal o vertical)
        if (columnaOrigen == columnaDestino) {
            // Movimiento vertical
            int inicio = Math.min(filaOrigen, filaDestino) + 1;
            int fin = Math.max(filaOrigen, filaDestino);
            for (int i = inicio; i < fin; i++) {
                String casillaIntermedia = columnaOrigen + String.valueOf(i);
                if (tablero.containsKey(casillaIntermedia)) {
                    return false; // Bloqueado por una pieza
                }
            }
            return true; // El camino está libre
        } else if (filaOrigen == filaDestino) {
            // Movimiento horizontal
            int inicio = Math.min(columnaOrigen, columnaDestino) + 1;
            int fin = Math.max(columnaOrigen, columnaDestino);
            for (char c = (char) inicio; c < fin; c++) {
                String casillaIntermedia = c + String.valueOf(filaOrigen);
                if (tablero.containsKey(casillaIntermedia)) {
                    return false; // Bloqueado por una pieza
                }
            }
            return true; // El camino está libre
        }

        return false; // El movimiento no es válido si no es horizontal ni vertical
    }

    // Lógica de movimiento del ALFIL
    private boolean esMovimientoValidoAlfil(Pieza pieza, String destino) {
        char columnaOrigen = pieza.getPosicion().charAt(0);
        int filaOrigen = Integer.parseInt(pieza.getPosicion().substring(1));
        char columnaDestino = destino.charAt(0);
        int filaDestino = Integer.parseInt(destino.substring(1));

        // El alfil se mueve en diagonal, por lo tanto la diferencia en las columnas debe ser igual a la diferencia en las filas
        if (Math.abs(columnaDestino - columnaOrigen) == Math.abs(filaDestino - filaOrigen)) {
            // Verificar que no haya piezas bloqueando el camino
            int xStep = (columnaDestino > columnaOrigen) ? 1 : -1;
            int yStep = (filaDestino > filaOrigen) ? 1 : -1;

            int col = columnaOrigen + xStep;
            int row = filaOrigen + yStep;

            // Recorrer todas las casillas intermedias entre el origen y el destino
            while (col != columnaDestino && row != filaDestino) {
                String casillaIntermedia = "" + (char) col + row;
                if (tablero.containsKey(casillaIntermedia)) {
                    return false; // Bloqueado por una pieza en el camino
                }
                col += xStep;
                row += yStep;
            }

            return true; // El movimiento es válido, no está bloqueado
        }

        return false; // No es un movimiento diagonal
    }

    // Verifica si un movimiento es válido para una pieza
    private boolean esMovimientoValido(Pieza pieza, String destino) {
        // Validación básica para que el movimiento no esté bloqueado por una pieza propia
        if (tablero.containsKey(destino)) {
            Pieza piezaDestino = tablero.get(destino);
            if (piezaDestino.getColor() == pieza.getColor()) {
                return false;  // Bloqueado por una pieza propia
            }
        }
        return true;  // El movimiento es válido
    }

    private void mostrarInfoDebug(String mensaje) {
        if (mostrarDebug) {
            System.out.println(mensaje);
        }
    }
}