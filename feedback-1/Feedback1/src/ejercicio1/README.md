# TIPO ABSTRACTO DE DATOS - PILA

## Descripción General

Una pila es una estructura de datos lineal que sigue el principio LIFO (Last In, First Out), es decir, el último elemento en ser insertado es el primero en ser eliminado.

Internamente, se representa mediante un arreglo de tamaño fijo y un tope que indica la posición del último elemento insertado. Cuando la pila está vacía, el valor del tope es -1.

## CONSTRUCTORES

### Crear una pila vacía con un tamaño determinado

**Pila(int tamaño)**

El constructor necesita un parámetro de entrada que será el tamaño de la pila. Este valor debe ser un número entero positivo. Si el valor es negativo, se debe lanzar una excepción indicando que el tamaño no puede ser negativo. El arreglo interno de la pila se inicializa con este tamaño, y el tope de la pila se establece en -1, indicando que está vacía.

- **Objetivo**: Crear una pila vacía con un tamaño determinado.
- **Necesita**: Un valor entero positivo, que indica el tamaño de la pila.
- **Modifica**: Nada.
- **Produce**: Crea una pila con el tamaño indicado, cuyo tope será -1.

### Crear una pila vacía con un tamaño por defecto

**Pila()**

El constructor no necesita parámetros de entrada. Se crea una pila con un tamaño fijo predeterminado (por ejemplo, 10), y el tope se establece en -1, indicando que la pila está vacía.

- **Objetivo**: Crear una pila vacía con un tamaño por defecto.
- **Necesita**: Nada.
- **Modifica**: Nada.
- **Produce**: Crea una pila con el tamaño por defecto y un tope de -1.

## DE INFORMACIÓN

### Devolver el tamaño de la pila

**getTamaño()**

El método de acceso devuelve el tamaño total de la pila, es decir, el tamaño máximo que puede tener la pila. Este valor es el mismo que se usó para inicializar la pila cuando se creó. No depende del número de elementos actualmente en la pila, sino del tamaño del arreglo interno que la contiene.

- **Objetivo**: Devolver el tamaño de la pila.
- **Necesita**: Nada.
- **Modifica**: Nada.
- **Produce**: Devuelve el tamaño total de la pila.

### Devolver si la pila está vacía o no

**estaVacia()**

El método verifica si el tope de la pila es -1, lo que indica que la pila está vacía. Si el tope es -1, la pila está vacía; si no, contiene al menos un elemento.

- **Objetivo**: Verificar si la pila está vacía.
- **Necesita**: Nada.
- **Modifica**: Nada.
- **Produce**: Devuelve un valor booleano: `True` si la pila está vacía, `False` si no lo está.

### Devolver el elemento que se encuentra en la cima de la pila

**cima()**

El método devuelve el elemento que está en la cima de la pila, es decir, el último elemento que se insertó. Si la pila está vacía, debe lanzar una excepción indicando que no se puede acceder a la cima porque la pila está vacía.

- **Objetivo**: Devolver el elemento en la cima de la pila.
- **Necesita**: Nada.
- **Modifica**: Nada.
- **Produce**: Devuelve el elemento en la cima de la pila.
    - **Excepción**: Si la pila está vacía (tope == -1), lanza la excepción "Pila vacía".

## DE MODIFICACIÓN/TRANSFORMACIÓN DEL TAD

### Insertar un elemento en la cima de la pila

**insertarElemento(E elemento)**

El método inserta un nuevo elemento en la cima de la pila, es decir, lo agrega al arreglo interno de la pila. Antes de realizar la inserción, se verifica si la pila está llena. Si el tope alcanza el tamaño máximo de la pila, se debe lanzar una excepción indicando que no se puede insertar más elementos en la pila.

- **Objetivo**: Insertar un nuevo elemento en la cima de la pila.
- **Necesita**: Un elemento para insertar en la pila.
- **Modifica**: La pila, incrementando el tope y añadiendo el nuevo elemento en la cima.
- **Produce**: Nada.
    - **Excepción**: Si la pila está llena (tope == tamaño - 1), lanza la excepción "Pila llena".

### Eliminar el elemento que se encuentra en la cima de la pila

**eliminarElemento()**

El método elimina el elemento que se encuentra en la cima de la pila, es decir, el último elemento insertado. Después de la eliminación, se actualiza el valor del tope, y si la pila está vacía (tope == -1), la pila queda vacía. Si la pila ya está vacía, se debe lanzar una excepción indicando que no se puede eliminar un elemento de una pila vacía.

- **Objetivo**: Eliminar el elemento en la cima de la pila.
- **Necesita**: Nada.
- **Modifica**: La pila, decrementando el tope y eliminando el elemento en la cima.
- **Produce**: Nada.
    - **Excepción**: Si la pila está vacía (tope == -1), lanza la excepción "Pila vacía".

## DE ENTRADA/SALIDA

### Mostrar los elementos de la pila en orden, desde el elemento en la cima hasta el fondo

**mostrarPila()**

El método muestra todos los elementos de la pila, comenzando desde el elemento en la cima y recorriendo hacia abajo, hasta el fondo. El orden será el mismo en que se insertaron los elementos, pero mostrando primero el último insertado. Si la pila está vacía, debe mostrar un mensaje indicando que la pila está vacía.

- **Objetivo**: Mostrar los elementos de la pila desde la cima hasta el fondo.
- **Necesita**: Nada.
- **Modifica**: Nada.
- **Produce**: Muestra los elementos de la pila en el orden correcto (de la cima al fondo).
    - **Excepción**: Si la pila está vacía (tope == -1), muestra el mensaje "Pila vacía".
