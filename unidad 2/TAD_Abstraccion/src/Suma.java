public class Suma {

    public static <T extends Number> double suma(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }


    public static void main(String[] args) {

        System.out.println("suma de entero:"+suma(10, 5));
        System.out.println("suma de flotante:"+suma(5.5f, 3.5f));
        System.out.println("suma de double:"+suma(3.5, 3.5));
        System.out.println("suma de byte:"+suma((byte)5, (byte)3));
        System.out.println("suma de long:"+suma(1000000000L,500L));

    }
}
