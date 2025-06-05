package ejercicio3;

public class Main {
    public static void main(String[] args) {
        // Crear una nueva partida de ajedrez
        PartidaAjedrez partida = new PartidaAjedrez();
        partida.iniciarPartida("Iván", "Aday");
        partida.setMostrarDebug(true); // Activar el modo de depuración
        // Mostrar el tablero visual
        System.out.println("Estado del tablero:");
        partida.mostrarTableroVisual();

        // Realizar un movimiento válido
        try {
            //Blancas peon
            var piezaSeleccionada = partida.obtenerPiezaEnPosicion("e2");
            partida.obtenerMovimientosPosibles(piezaSeleccionada.getPosicion());
            partida.mostrarMovimientosVisual(piezaSeleccionada);
            partida.realizarMovimiento(piezaSeleccionada.getPosicion().concat("-e4"));  // Movimiento válido

            //Negras peon
            piezaSeleccionada = partida.obtenerPiezaEnPosicion("e7");
            partida.obtenerMovimientosPosibles(piezaSeleccionada.getPosicion());
            partida.mostrarMovimientosVisual(piezaSeleccionada);
            partida.realizarMovimiento(piezaSeleccionada.getPosicion().concat("-e5"));  // Movimiento válido

            //Blancas caballo
            piezaSeleccionada = partida.obtenerPiezaEnPosicion("g1");
            partida.obtenerMovimientosPosibles(piezaSeleccionada.getPosicion());
            partida.mostrarMovimientosVisual(piezaSeleccionada);
            partida.realizarMovimiento(piezaSeleccionada.getPosicion().concat("-h3"));  // Movimiento válido

            //Negras caballo
            piezaSeleccionada = partida.obtenerPiezaEnPosicion("g8");
            partida.obtenerMovimientosPosibles(piezaSeleccionada.getPosicion());
            partida.mostrarMovimientosVisual(piezaSeleccionada);
            partida.realizarMovimiento(piezaSeleccionada.getPosicion().concat("-f6"));  // Movimiento válido

            //Blancas torre
            piezaSeleccionada = partida.obtenerPiezaEnPosicion("h1");
            partida.obtenerMovimientosPosibles(piezaSeleccionada.getPosicion());
            partida.mostrarMovimientosVisual(piezaSeleccionada);
            partida.realizarMovimiento(piezaSeleccionada.getPosicion().concat("-h4"));   // Movimiento válido

            //Negras torre
            piezaSeleccionada = partida.obtenerPiezaEnPosicion("h8");
            partida.obtenerMovimientosPosibles(piezaSeleccionada.getPosicion());
            partida.mostrarMovimientosVisual(piezaSeleccionada);
            partida.realizarMovimiento(piezaSeleccionada.getPosicion().concat("-h6"));    // Movimiento válido

            //Blancas Alfil
            piezaSeleccionada = partida.obtenerPiezaEnPosicion("c1");
            partida.obtenerMovimientosPosibles(piezaSeleccionada.getPosicion());
            partida.mostrarMovimientosVisual(piezaSeleccionada);
            partida.realizarMovimiento(piezaSeleccionada.getPosicion().concat("-e3"));  // Movimiento válido

            //Negras Alfil
            piezaSeleccionada = partida.obtenerPiezaEnPosicion("f8");
            partida.obtenerMovimientosPosibles(piezaSeleccionada.getPosicion());
            partida.mostrarMovimientosVisual(piezaSeleccionada);
            partida.realizarMovimiento(piezaSeleccionada.getPosicion().concat("-c5"));  // Movimiento válido

            //Blancas Reina vertical
            piezaSeleccionada = partida.obtenerPiezaEnPosicion("d1");
            partida.obtenerMovimientosPosibles(piezaSeleccionada.getPosicion());
            partida.mostrarMovimientosVisual(piezaSeleccionada);
            partida.realizarMovimiento(piezaSeleccionada.getPosicion().concat("-d4"));  // Movimiento válido

            //Negras Reina vertical
            piezaSeleccionada = partida.obtenerPiezaEnPosicion("d8");
            partida.obtenerMovimientosPosibles(piezaSeleccionada.getPosicion());
            partida.mostrarMovimientosVisual(piezaSeleccionada);
            partida.realizarMovimiento(piezaSeleccionada.getPosicion().concat("-d6"));  // Movimiento válido

            //Blancas Reina horizontal
            piezaSeleccionada = partida.obtenerPiezaEnPosicion("d4");
            partida.obtenerMovimientosPosibles(piezaSeleccionada.getPosicion());
            partida.mostrarMovimientosVisual(piezaSeleccionada);
            partida.realizarMovimiento(piezaSeleccionada.getPosicion().concat("-h4"));  // Movimiento válido

            //Negras Reina horizontal
            piezaSeleccionada = partida.obtenerPiezaEnPosicion("d6");
            partida.obtenerMovimientosPosibles(piezaSeleccionada.getPosicion());
            partida.mostrarMovimientosVisual(piezaSeleccionada);
            partida.realizarMovimiento(piezaSeleccionada.getPosicion().concat("-a6"));  // Movimiento válido

            //Blancas Rey vertical
            piezaSeleccionada = partida.obtenerPiezaEnPosicion("e1");
            partida.obtenerMovimientosPosibles(piezaSeleccionada.getPosicion());
            partida.mostrarMovimientosVisual(piezaSeleccionada);
            partida.realizarMovimiento(piezaSeleccionada.getPosicion().concat("-e2"));  // Movimiento válido

            //Negras Rey vertical
            piezaSeleccionada = partida.obtenerPiezaEnPosicion("e8");
            partida.obtenerMovimientosPosibles(piezaSeleccionada.getPosicion());
            partida.mostrarMovimientosVisual(piezaSeleccionada);
            partida.realizarMovimiento(piezaSeleccionada.getPosicion().concat("-e7"));  // Movimiento válido

            //Blancas Rey diagonal
            piezaSeleccionada = partida.obtenerPiezaEnPosicion("e2");
            partida.obtenerMovimientosPosibles(piezaSeleccionada.getPosicion());
            partida.mostrarMovimientosVisual(piezaSeleccionada);
            partida.realizarMovimiento(piezaSeleccionada.getPosicion().concat("-f3"));  // Movimiento válido

            //Negras Rey diagonal
            piezaSeleccionada = partida.obtenerPiezaEnPosicion("e7");
            partida.obtenerMovimientosPosibles(piezaSeleccionada.getPosicion());
            partida.mostrarMovimientosVisual(piezaSeleccionada);
            partida.realizarMovimiento(piezaSeleccionada.getPosicion().concat("-f8"));  // Movimiento válido

            //Blancas Rey horizontal
            piezaSeleccionada = partida.obtenerPiezaEnPosicion("f3");
            partida.obtenerMovimientosPosibles(piezaSeleccionada.getPosicion());
            partida.mostrarMovimientosVisual(piezaSeleccionada);
            partida.realizarMovimiento(piezaSeleccionada.getPosicion().concat("-g3"));  // Movimiento válido

            //Negras Rey horizontal
            piezaSeleccionada = partida.obtenerPiezaEnPosicion("f8");
            partida.obtenerMovimientosPosibles(piezaSeleccionada.getPosicion());
            partida.mostrarMovimientosVisual(piezaSeleccionada);
            partida.realizarMovimiento(piezaSeleccionada.getPosicion().concat("-f7"));  // Movimiento válido


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Mostrar el tablero después del movimiento
        System.out.println("\nEstado del tablero después del movimiento:");
        partida.mostrarTableroVisual();
    }
}
