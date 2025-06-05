package ejercicio3;

public enum TipoPieza {
    REY, REINA, TORRE, ALFIL, CABALLO, PEON;

    // Método para obtener el valor en formato con la primera letra en mayúscula y el resto en minúscula
    public static String getNombre(TipoPieza tipo) {
        return tipo.name().charAt(0) + tipo.name().substring(1).toLowerCase();
    }
}