package Ejemplos;

public class ClaseParametrizada <T>{
    private T valor;

    public ClaseParametrizada(T valor) {
        this.valor = valor;
    }


    public T getValor() {
        return valor;
    }

    public static void main(String[] args) {
        ClaseParametrizada<Integer> claseInteger = new ClaseParametrizada<Integer>(new Integer("19"));
        ClaseParametrizada<String> claseString = new ClaseParametrizada<String>("9");
        System.out.println(claseInteger.getValor().getClass());
        System.out.println(claseString.getValor().getClass());
    }

}
