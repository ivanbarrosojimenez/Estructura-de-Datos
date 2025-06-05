package ejercicio3;

import java.util.LinkedList;

public class Pieza {
    private TipoPieza tipo;  // El tipo de pieza (Reina, Rey, Peón, etc.)
    private ColorPieza colorPieza; // El color de la pieza (BLANCA o NEGRA)
    private String posicion; // La posición de la pieza en el tablero (por ejemplo, "e2")

    // Constructor
    public Pieza(TipoPieza tipo, ColorPieza colorPieza, String posicion) {
        this.tipo = tipo;  // Usamos el enum para el tipo de pieza
        this.colorPieza = validarColor(colorPieza);  // Validamos el color de la pieza
        this.posicion = posicion;
    }

    // Método privado que valida que el color sea correcto
    private ColorPieza validarColor(ColorPieza colorPieza) {
        if (colorPieza == null) {
            throw new IllegalArgumentException("El color de la pieza debe ser 'Blanca' o 'Negra'.");
        }
        return colorPieza;  // Si el color es válido, lo retornamos
    }

    // Métodos getters y setters
    public TipoPieza getTipo() {
        return tipo;
    }

    public void setTipo(TipoPieza tipo) {
        this.tipo = tipo;
    }

    public ColorPieza getColor() {
        return colorPieza;
    }

    public void setColor(ColorPieza colorPieza) {
        this.colorPieza = colorPieza;  // Validación de color no es necesaria, ya que es un enum
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return TipoPieza.getNombre(tipo) + " (" + ColorPieza.getNombreFormal(colorPieza) + ") en " + posicion;
    }

    // Método que devuelve el emoticono de la pieza con color ANSI
    public String getIconoColor() {
        String icono = "";

        // Emoticonos de las piezas
        String[] piezasBlancas = {"♕", "♔", "♖", "♗", "♘", "♙"};
        String[] piezasNegras = {"♕", "♔", "♖", "♗", "♘", "♙"};

        // Colores ANSI
        String colorBlanco = "\u001B[93m"; // Color blanco para las piezas blancas
        String colorNegro = "\u001B[90m"; // Color negro para las piezas negras
        String resetColor = "\u001B[0m";  // Reset de color

        // Según el color de la pieza, asignamos el icono adecuado
        if (colorPieza == ColorPieza.BLANCA) {
            icono = colorBlanco + piezasBlancas[tipo.ordinal()] + resetColor; // Emoticono con color blanco
        } else {
            icono = colorNegro + piezasNegras[tipo.ordinal()] + resetColor; // Emoticono con color negro
        }

        return icono;
    }

    // Método que devuelve el emoticono de la pieza con color ANSI
    public String getIcono() {
        String icono = "";

        // Emoticonos de las piezas
        String[] piezasBlancas = {"♕", "♔", "♖", "♗", "♘", "♙"};
        String[] piezasNegras = {"♕", "♔", "♖", "♗", "♘", "♙"};

        // Según el color de la pieza, asignamos el icono adecuado
        if (colorPieza == ColorPieza.BLANCA) {
            icono = piezasBlancas[tipo.ordinal()]; // Emoticono con color blanco
        } else {
            icono = piezasNegras[tipo.ordinal()]; // Emoticono con color negro
        }

        return icono;
    }


    // Método que valida si el movimiento es posible
    public boolean puedeMover(String origen, String destino, boolean primerMovimiento) {
        // Lógica para cada tipo de pieza
        switch (this.tipo) {
            case PEON:
                if (primerMovimiento) {
                    return puedeMoverPrimerMovimiento(origen, destino); // Primer movimiento del peón
                } else {
                    return puedeMoverResto(origen, destino); // Movimiento posterior del peón
                }
            case TORRE:
                return puedeMoverTorre(origen, destino);
            case CABALLO:
                return puedeMoverCaballo(origen, destino);
            case ALFIL:
                return puedeMoverAlfil(origen, destino);
            case REINA:
                return puedeMoverReina(origen, destino);
            case REY:
                return puedeMoverRey(origen, destino);
            default:
                return false;
        }
    }

    // Lógica de movimiento para el primer movimiento del PEON
    private boolean puedeMoverPrimerMovimiento(String origen, String destino) {
        char columnaOrigen = origen.charAt(0);
        int filaOrigen = Integer.parseInt(origen.substring(1));
        char columnaDestino = destino.charAt(0);
        int filaDestino = Integer.parseInt(destino.substring(1));

        // Determinar la dirección del movimiento según el color del peón
        int direccion = (this.colorPieza == ColorPieza.BLANCA) ? 1 : -1;

        // El peón puede moverse hacia adelante dos casillas en su primer movimiento
        if (columnaOrigen == columnaDestino && filaDestino == filaOrigen + 2 * direccion) {
            return true;
        }
        return false;
    }

    // Lógica de movimiento para el PEON en turnos posteriores
    private boolean puedeMoverResto(String origen, String destino) {
        char columnaOrigen = origen.charAt(0);
        int filaOrigen = Integer.parseInt(origen.substring(1));
        char columnaDestino = destino.charAt(0);
        int filaDestino = Integer.parseInt(destino.substring(1));

        // Determinar la dirección del movimiento según el color del peón
        int direccion = (this.colorPieza == ColorPieza.BLANCA) ? 1 : -1;

        // El peón puede moverse hacia adelante una casilla
        if (columnaOrigen == columnaDestino && filaDestino == filaOrigen + direccion) {
            return true;
        }
        return false;
    }

    // Lógica de movimiento para la TORRE
    private boolean puedeMoverTorre(String origen, String destino) {
        char columnaOrigen = origen.charAt(0);
        int filaOrigen = Integer.parseInt(origen.substring(1));
        char columnaDestino = destino.charAt(0);
        int filaDestino = Integer.parseInt(destino.substring(1));

        // La torre se mueve en línea recta (horizontal o vertical)
        return columnaOrigen == columnaDestino || filaOrigen == filaDestino;
    }

    // Lógica de movimiento para el CABALLO
    private boolean puedeMoverCaballo(String origen, String destino) {
        char columnaOrigen = origen.charAt(0);
        int filaOrigen = Integer.parseInt(origen.substring(1));
        char columnaDestino = destino.charAt(0);
        int filaDestino = Integer.parseInt(destino.substring(1));

        // El caballo se mueve en forma de "L" (dos en una dirección, uno en perpendicular)
        return (Math.abs(columnaDestino - columnaOrigen) == 2 && Math.abs(filaDestino - filaOrigen) == 1) ||
                (Math.abs(columnaDestino - columnaOrigen) == 1 && Math.abs(filaDestino - filaOrigen) == 2);
    }

    // Lógica de movimiento para el ALFIL
    private boolean puedeMoverAlfil(String origen, String destino) {
        char columnaOrigen = origen.charAt(0);
        int filaOrigen = Integer.parseInt(origen.substring(1));
        char columnaDestino = destino.charAt(0);
        int filaDestino = Integer.parseInt(destino.substring(1));

        // El alfil se mueve en diagonal
        return Math.abs(columnaDestino - columnaOrigen) == Math.abs(filaDestino - filaOrigen);
    }

    // Lógica de movimiento para la REINA
    private boolean puedeMoverReina(String origen, String destino) {
        // La reina combina el movimiento de la torre y el alfil
        return puedeMoverTorre(origen, destino) || puedeMoverAlfil(origen, destino);
    }

    // Lógica de movimiento para el REY
    private boolean puedeMoverRey(String origen, String destino) {
        char columnaOrigen = origen.charAt(0);
        int filaOrigen = Integer.parseInt(origen.substring(1));
        char columnaDestino = destino.charAt(0);
        int filaDestino = Integer.parseInt(destino.substring(1));

        // El rey se mueve solo una casilla en cualquier dirección
        return Math.abs(columnaDestino - columnaOrigen) <= 1 && Math.abs(filaDestino - filaOrigen) <= 1;
    }

    // Método que devuelve los movimientos posibles
    public LinkedList<String> obtenerMovimientos() {
        LinkedList<String> movimientosPosibles = new LinkedList<>();

        switch (this.tipo) {
            case PEON:
                movimientosPosibles = obtenerMovimientosPosiblesPeon();
                break;
            case TORRE:
                movimientosPosibles = obtenerMovimientosPosiblesTorre();
                break;
            case CABALLO:
                movimientosPosibles = obtenerMovimientosPosiblesCaballo();
                break;
            case ALFIL:
                movimientosPosibles = obtenerMovimientosPosiblesAlfil();
                break;
            case REINA:
                movimientosPosibles = obtenerMovimientosPosiblesReina();
                break;
            case REY:
                movimientosPosibles = obtenerMovimientosPosiblesRey();
                break;
        }
        //System.out.println("Movimientos posibles: " + movimientosPosibles);
        return movimientosPosibles;
    }

    // Métodos de movimiento para cada tipo de pieza

    // Obtener los movimientos posibles para el PEON
    private LinkedList<String> obtenerMovimientosPosiblesPeon() {
        LinkedList<String> movimientos = new LinkedList<>();
        int direccion = (this.colorPieza == ColorPieza.BLANCA) ? 1 : -1;

        // Movimiento hacia adelante
        char columna = this.posicion.charAt(0);
        int fila = Integer.parseInt(this.posicion.substring(1));

        // El peón puede moverse una casilla hacia adelante
        String adelante = columna + String.valueOf(fila + direccion);
        if (esPosicionValida(adelante)) {
            movimientos.add(adelante);
        }

        // El peón puede moverse dos casillas hacia adelante si es su primer movimiento
        if ((this.colorPieza == ColorPieza.BLANCA && fila == 2) || (this.colorPieza == ColorPieza.NEGRA && fila == 7)) {
            String adelanteDoble = columna + String.valueOf(fila + 2 * direccion);
            if (esPosicionValida(adelanteDoble)) {
                movimientos.add(adelanteDoble);
            }
        }

        // Captura en diagonal
        for (int i = -1; i <= 1; i += 2) {
            String diagonal = (char) (columna + i) + String.valueOf(fila + direccion);
            if (esPosicionValida(diagonal)) {
                movimientos.add(diagonal);
            }
        }

        return movimientos;
    }

    // Obtener los movimientos posibles para la TORRE
    private LinkedList<String> obtenerMovimientosPosiblesTorre() {
        LinkedList<String> movimientos = new LinkedList<>();
        char columna = this.posicion.charAt(0);
        int fila = Integer.parseInt(this.posicion.substring(1));

        // Movimiento en vertical y horizontal
        for (char c = 'a'; c <= 'h'; c++) {
            if (c != columna) {
                movimientos.add(c + String.valueOf(fila));
            }
        }

        for (int f = 1; f <= 8; f++) {
            if (f != fila) {
                movimientos.add(columna + String.valueOf(f));
            }
        }

        return movimientos;
    }

    // Lógica de movimiento para el CABALLO
    private LinkedList<String> obtenerMovimientosPosiblesCaballo() {
        LinkedList<String> movimientos = new LinkedList<>();
        char columna = this.posicion.charAt(0);
        int fila = Integer.parseInt(this.posicion.substring(1));

        // Las direcciones posibles para el caballo: 2 casillas en una dirección y 1 en la otra
        int[] columnaMov = {2, 2, -2, -2, 1, 1, -1, -1};  // Movimientos en columna (derecha e izquierda)
        int[] filaMov = {1, -1, 1, -1, 2, -2, 2, -2};  // Movimientos en fila (arriba y abajo)

        // Iterar sobre todas las direcciones posibles
        for (int i = 0; i < 8; i++) {
            char nuevaColumna = (char) (columna + columnaMov[i]);
            int nuevaFila = fila + filaMov[i];

            // Verificar si la nueva posición está dentro del tablero y agregarla a los movimientos válidos
            String nuevaPosicion = "" + nuevaColumna + nuevaFila;
            if (esPosicionValida(nuevaPosicion)) {
                movimientos.add(nuevaPosicion);
            }
        }

        return movimientos;
    }

    // Obtener los movimientos posibles para el ALFIL
    private LinkedList<String> obtenerMovimientosPosiblesAlfil() {
        LinkedList<String> movimientos = new LinkedList<>();
        char columna = this.posicion.charAt(0);
        int fila = Integer.parseInt(this.posicion.substring(1));

        // Movimiento en diagonal
        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <= 1; j += 2) {
                for (int k = 1; k <= 8; k++) {
                    char nuevaColumna = (char) (columna + i * k);
                    int nuevaFila = fila + j * k;
                    if (esPosicionValida(String.valueOf(nuevaColumna) + nuevaFila)) {
                        movimientos.add(String.valueOf(nuevaColumna) + nuevaFila);
                    }
                }
            }
        }

        return movimientos;
    }

    // Obtener los movimientos posibles para la REINA
    private LinkedList<String> obtenerMovimientosPosiblesReina() {
        LinkedList<String> movimientos = new LinkedList<>();
        movimientos.addAll(obtenerMovimientosPosiblesTorre());
        movimientos.addAll(obtenerMovimientosPosiblesAlfil());
        return movimientos;
    }

    // Obtener los movimientos posibles para el REY
    private LinkedList<String> obtenerMovimientosPosiblesRey() {
        LinkedList<String> movimientos = new LinkedList<>();
        char columna = this.posicion.charAt(0);
        int fila = Integer.parseInt(this.posicion.substring(1));

        // El rey se mueve una casilla en cualquier dirección
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                char nuevaColumna = (char) (columna + i);
                int nuevaFila = fila + j;
                if (esPosicionValida(String.valueOf(nuevaColumna) + nuevaFila)) {
                    movimientos.add(String.valueOf(nuevaColumna) + nuevaFila);
                }
            }
        }

        return movimientos;
    }

    // Método auxiliar para verificar si la posición es válida en el tablero
    private boolean esPosicionValida(String posicion) {
        return posicion.matches("[a-h][1-8]");  // Verifica que la posición esté dentro de las coordenadas válidas
    }

    // Método que devuelve el emoticono para casillas vacías
    public static String getVacíaIcono() {
        return "▭";  // Emoticono para casilla vacía, gris
    }


}
