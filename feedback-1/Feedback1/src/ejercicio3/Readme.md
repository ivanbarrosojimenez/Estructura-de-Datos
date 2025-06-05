###########################################################

# TIPO ABSTRACTO DE DATOS - PARTIDAAJEDREZ

###########################################################

###########################################################

# Una partida de ajedrez entre dos jugadores, donde se

# lleva el registro de los jugadores (blancas y negras),

# los movimientos realizados y el estado actual del tablero.

###########################################################

###########################################################

# Atributos:

###########################################################

- Jugador Blancas: String
    - Representa el nombre del jugador que controla las piezas blancas.

- Jugador Negras: String
    - Representa el nombre del jugador que controla las piezas negras.

- Movimientos: LinkedList<String>
    - Guarda los movimientos realizados durante la partida.
    - Cada movimiento se representa como un String en formato "e2-e4".

- Tablero: Map<String, Pieza>
    - Guarda la posición actual de todas las piezas en el tablero.
    - Las claves son las posiciones en el tablero (por ejemplo, "a1", "b2"),
    - y los valores son objetos de la clase Pieza.

###########################################################

# Métodos:

###########################################################

## Iniciar partida

iniciarPartida(jugadorBlancas: String, jugadorNegras: String)

### Inicializa una nueva partida, asignando los nombres de los jugadores y vaciando

### la lista de movimientos y el mapa del tablero.

* Objetivo: Iniciar la partida con los jugadores especificados.
* Necesita: Los nombres de los jugadores.
* Modifica: La lista de movimientos y el tablero.
* Produce: Nada.

## Realizar movimiento

realizarMovimiento(movimiento: String)

### Realiza un movimiento en el tablero, actualizando el mapa y la lista de movimientos.

* Objetivo: Ejecutar un movimiento en la partida.
* Necesita: El movimiento a realizar.
* Modifica: La lista de movimientos y el mapa del tablero.
* Produce: Nada.
* Excepciones: Si el movimiento es inválido (por ejemplo, movimiento fuera de turno o pieza equivocada), se lanza una
  excepción.

## Obtener pieza en una posición

obtenerPiezaEnPosicion(posicion: String): Pieza

### Devuelve la pieza en la posición dada del tablero.

* Objetivo: Obtener la pieza en la posición especificada.
* Necesita: La posición del tablero.
* Modifica: Nada.
* Produce: La pieza en la posición.

## Es Jaque Mate

esJaqueMate(): Boolean

### Comprueba si la partida ha terminado por jaque mate.

* Objetivo: Verificar si es jaque mate.
* Necesita: Nada.
* Modifica: Nada.
* Produce: Devuelve true si es jaque mate, false si no lo es.

## Es Empate

esEmpate(): Boolean

### Comprueba si la partida ha terminado en empate.

* Objetivo: Verificar si es empate.
* Necesita: Nada.
* Modifica: Nada.
* Produce: Devuelve true si es empate, false si no lo es.

## Obtener movimientos posibles

obtenerMovimientosPosibles(posicion: String): LinkedList<String>

### Devuelve los movimientos posibles para una pieza en una posición determinada.

* Objetivo: Obtener todos los movimientos posibles para la pieza en la posición indicada.
* Necesita: La posición de la pieza.
* Modifica: Nada.
* Produce: Devuelve una lista de movimientos posibles.

## Obtener movimientos

obtenerMovimientos(): LinkedList<String>

### Devuelve todos los movimientos realizados hasta el momento en la partida.

* Objetivo: Obtener todos los movimientos registrados.
* Necesita: Nada.
* Modifica: Nada.
* Produce: Devuelve una lista de movimientos.

### Imprimir tablero

* Objetivo: Mostrar en pantalla el tablero.
* Necesita: Una Partida de Ajedrez
* Modifica: Nada
* Produce: Muestra por pantalla el tablero de la partida.

### Mostrar debug

* Objetivo: Mostrar información de depuración por pantalla.
* Necesita: Una Partida de Ajedrez
* Modifica: Nada
* Produce: Muestra por pantalla información adicional de cada acción de la partida
  (jugadores, movimientos, piezas, etc.).