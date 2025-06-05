package ejercicio3;

public enum ColorPieza {
    BLANCA, NEGRA;

    // Método para obtener el valor en formato con la primera letra en mayúscula
    public static String getNombreFormal(ColorPieza colorPieza) {
        return colorPieza.name().charAt(0) + colorPieza.name().substring(1).toLowerCase();
    }
}
