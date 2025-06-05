public class Cronometro {
    private long inicio, fin;
    public void iniciar() {
        this.inicio = System.currentTimeMillis();
    }
    public void finalizar() {
        this.fin = System.currentTimeMillis();
    }
    public long getTiempo(){
        return this.fin - this.inicio;
    }
}
