package src.ejercicio3;

public class Main {
    public static void main(String[] args) {

        Alumno p1 = new Alumno("Juan", "Perez", "A", 1);
        Alumno p2 = new Alumno("Ana", "Lopez", "B", 1);   // provincia: A < B
        Alumno p3 = new Alumno("Ana", "Lopez", "A", 1);   // A > A pero apellido: C < D
        Alumno p4 = new Alumno("Luis", "Zapata", "A", 1);
        Alumno p5 = new Alumno("Luis", "Zapata", "A", 3);
        Alumno p6 = new Alumno("Luis", "Zapata", "A", 9);
        Alumno p7 = new Alumno("Luis", "Zapata", "A", 5);
        Alumno p8 = new Alumno("Luis", "Zapata", "A", 1);
        Alumno p9 = new Alumno("Luis", "Zapata", "A", 2);

        System.out.println("1. provincia A < B: " + comparar(p1, p2)); // true
        System.out.println("2. provincia B > A: " + comparar(p2, p1)); // false
        System.out.println("3. apellidos Lopez < Zapata: " + comparar(p3, p4)); // true
        System.out.println("4. apellidos Zapata > Lopez: " + comparar(p4, p3)); // false
        System.out.println("5. NP 3 < 9: " + comparar(p5, p6)); // true
        System.out.println("6. NP 9 > 3: " + comparar(p6, p5)); // false
        System.out.println("7. NP 5 == 5: " + comparar(p7, p7)); // false
        System.out.println("8. NP 1 < 2: " + comparar(p8, p9)); // true
        System.out.println("9. NP 2 > 1: " + comparar(p9, p8)); // false
    }

    public static boolean comparar(Alumno alum1, Alumno alum2) {
        if (!alum1.provincia.equals(alum2.provincia)) {
            return alum1.provincia.compareTo(alum2.provincia) < 0;
        }
        if (!alum1.apellidos.equals(alum2.apellidos)) {
            return alum1.apellidos.compareTo(alum2.apellidos) < 0;
        }
        return alum1.NP < alum2.NP;
    }
}
