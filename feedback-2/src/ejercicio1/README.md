feedback-2# feedback-2

> **Asignatura:** Estructura de Datos  
> **Autor:** Iván Barroso Jiménez

#Se puede clonar el proyecto desde:

### git@gitlab.com:estructura-de-datos2842616/feedback-2.git

### https://gitlab.com/estructura-de-datos2842616/feedback-2.git

##             

## Ejercicio 1

### En el fichero MainInteractivo se encuentra la solución proporcionada, en el fichero MainStatico se puede ver una ejecución de prueba no interactiva.

# Enunciado

## Ejercicio 1

Se desea realizar un programa para poder tener un control de los discos que tenemos en nuestra colección. Para ello se
desea ordenar los discos por **Intérprete** (que puede ser bien un solista o un grupo). Para cada intérprete se desea
guardar la siguiente información:

- **Nombre**: ya sea del cantante o del grupo
- **En activo**: indica si el cantante o grupo sigue editando discos, o bien el grupo se ha disuelto (por ejemplo)
- **Lista de discos**: los discos que ha editado el cantante o el grupo

Para guardar la información de los intérpretes se va a utilizar un **árbol de búsqueda por el nombre del intérprete**.
Fíjese, que se cumple en este caso que sólo puede haber un nodo en el árbol con el nombre de un intérprete dado. De esta
forma vamos a poder manejar el conjunto de intérpretes de forma ordenada por nombre.

Para guardar la información de los discos de cada uno de los intérpretes se va a utilizar una **lista ordenada de discos
**. La ordenación se realizará por el año de edición del disco. La información que se guardará de cada disco será la
siguiente:

- **Título del disco**
- **Año de edición**
- **Duración en minutos**

El programa debe tener un conjunto de opciones que permitan al usuario mantener la información sobre los discos. Las
opciones que debe presentar son las siguientes:

- **Añadir un nuevo intérprete**: solicita al usuario el nombre del intérprete, y si sigue en activo o no.
- **Añadir un nuevo disco**: en primer lugar solicita al usuario el nombre del intérprete del disco. Si al introducir el
  nombre del intérprete éste no existe en el árbol debe solicitar al usuario si dicho intérprete sigue en activo o no.
  Si el intérprete ya existe en el árbol, esta información no debe solicitarla más. Después debe solicitar al usuario el
  título del disco, el año de edición y su duración en minutos.
- **Eliminar un disco**: solicita al usuario el nombre del intérprete. A continuación, se presenta en pantalla la lista
  de todos los títulos de los discos de dicho intérprete. El usuario debe elegir cuál de ellos desea eliminar, del 1 en
  adelante. Debe existir la opción de salir sin eliminar ninguno.
- **Listar intérpretes**: escribe en pantalla la lista de todos intérpretes por orden alfabético, indicando para cada
  uno si está en activo o no.
- **Discos de un intérprete**: solicita al usuario el nombre de un intérprete e imprime la información de la lista de
  discos ordenados por año de edición.
- **Discos editados en un año**: solicita al usuario un año de edición y escribe en la pantalla todos los discos, de
  todos los intérpretes que se editaron en ese año.

# Diagrama estructural

```text
+-------------------+
|  MenuPrincipal    |
+-------------------+
|                   |
| - ArbolInterpretes|
|                   |
+--------+----------+
         |
         | gestiona (invoca operaciones sobre)
         V
+-----------------------+
|  ArbolInterpretes     | <---- árbol binario por nombre
+-----------------------+
| - nombre: String      |
| - enActivo: Boolean   |
| - discos: ListaDiscos |
+----------+------------+
         |
         | contiene (1 intérprete → N discos)
         V
+----------------------------+
|       ListaDiscos         | <-- lista ordenada por año
+----------------------------+
| - titulo: String           |
| - anio: Int                |
| - duracion: Int            |
+----------------------------+
```

### TAD: ejercicio1.Disco

- **Objetivo**: Representar un disco musical con su información básica.
- **Necesita**: Título, año de edición y duración.
- **Modifica**: Nada (TAD inmutable).
- **Produce**: Una instancia de ejercicio1.Disco.

#### Atributos:

- titulo: String
- anio: Int
- duracion: Int

### TAD: src.ejercicio1.Interprete

- **Objetivo**: Representar un intérprete (solista o grupo) con su información asociada y discos editados.
- **Necesita**: Nombre, estado (activo o no), lista de discos.
- **Modifica**: Lista de discos.
- **Produce**: Instancia de src.ejercicio1.Interprete con su información y su colección de discos.

#### Atributos:

- nombre: String
- enActivo: Boolean
- discos: ListaDiscos

### TAD: MenuPrincipal

- **Objetivo**: Permitir la interacción del usuario con el sistema para mantener la colección de discos.
- **Necesita**: Árbol de intérpretes.
- **Modifica**: Árbol de intérpretes y listas de discos.
- **Produce**: Resultados en consola o acciones ejecutadas según entrada del usuario.

#### Operaciones:

- **añadirIntérprete(nombre: String, enActivo: Boolean)**
    - Inserta un nuevo intérprete en el árbol si no existe.
- **añadirDisco(nombreIntérprete: String, disco: ejercicio1.Disco)**
    - Busca el intérprete y añade el disco a su lista.
- **eliminarDisco(nombreIntérprete: String, índice: Int)**
    - Elimina el disco en la posición indicada.
- **listarIntérpretes()**
    - Muestra todos los intérpretes por orden alfabético.
- **listarDiscos(nombreIntérprete: String)**
    - Muestra todos los discos del intérprete dado.
- **listarDiscosPorAño(anio: Int)**
    - Muestra todos los discos editados en el año dado por todos los intérpretes.

### TAD: ArbolInterpretes

- **Objetivo**: Gestionar los intérpretes ordenados alfabéticamente por nombre en un árbol binario de búsqueda.
- **Necesita**: Nodos con objetos src.ejercicio1.Interprete.
- **Modifica**: Estructura del árbol (inserciones, búsquedas, recorridos).
- **Produce**: Acceso eficiente y ordenado a los intérpretes.

#### Operaciones:

- **insertar(interprete: src.ejercicio1.Interprete)**
    - Añade un nuevo nodo al árbol, si no existe ya por nombre.
- **buscar(nombre: String) → src.ejercicio1.Interprete?**
    - Devuelve el intérprete con ese nombre, si existe.
- **recorrerInOrden()**
    - Devuelve todos los intérpretes ordenados alfabéticamente.
- **recorrer()**
    - Permite recorrer el árbol completo (sin orden estricto).

### TAD: ListaDiscos

- **Objetivo**: Gestionar una lista ordenada de discos por año de edición.
- **Necesita**: Objetos ejercicio1.Disco.
- **Modifica**: La lista interna de discos.
- **Produce**: Una colección ordenada de discos de un intérprete.

#### Operaciones:

- **insertar(disco: ejercicio1.Disco)**
    - Inserta el disco manteniendo la ordenación por año.
- **eliminarPorIndice(i: Int)**
    - Elimina el disco situado en la posición indicada.
- **mostrar()**
    - Devuelve la lista completa de discos en orden.
- **filtrarPorAño(anio: Int)**
    - Devuelve los discos con el año especificado.
