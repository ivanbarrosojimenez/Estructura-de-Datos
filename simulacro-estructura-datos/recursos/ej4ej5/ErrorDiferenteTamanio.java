package recursos.ej4ej5;

public class ErrorDiferenteTamanio extends Throwable {
    public ErrorDiferenteTamanio(String desbordamientoInferiorDeLaPila) {
        super(desbordamientoInferiorDeLaPila);
    }
}
