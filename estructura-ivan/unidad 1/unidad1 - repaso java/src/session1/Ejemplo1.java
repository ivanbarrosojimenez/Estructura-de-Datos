import session1.Persona;
import session2.Figura;

public static void main(String[] args) {

    byte mybyte = 1;//8 bits 1 byte -128 127
    short myshort = 1;// 16bits 2 bytes -32768 32767
    int myint = 1; //32 bits 4 bytes
    long mylong = 1;// 64 bits 8 bytes

    //coma flotante números con decimales
    float myfloat = 1; // 32 bits
    double mydouble = 1;// 64 bits

    //caracteres
    char mychar = 1;

    //booleano (true o false)
    boolean myboolean = true;

    // Enteros
    byte edad = 30;
    short poblacionCiudad = 32767;
    int distancia = 1500000;
    long poblacionMundial = 7900000000L;
    // Punto Flotante
    float precioProducto = 19.99f;
    double pi = 3.14159265359;
    // Caracteres
    char inicialNombre = 'J';
    char simboloCopyright = '\u00A9'; // Símbolo de copyright
    // Booleanos
    boolean esMayorDeEdad = true;
    // Imprimiendo los valores con formato para mejor legibilidad
    System.out.printf("Edad: %d \n", edad);
    System.out.print("Edad: "+edad+" ");
    System.out.printf("Población de la ciudad: %d%n", poblacionCiudad);
    System.out.printf("Distancia: %d%n", distancia);
    System.out.printf("Población mundial: %d%n", poblacionMundial);
    System.out.printf("Precio del producto: %.2f%n", precioProducto); //Formato con 2 decimales
    System.out.printf("Valor de PI: %f%n", pi);
    System.out.printf("Inicial del nombre: %c%n", inicialNombre);
    System.out.printf("Símbolo de copyright: %c%n", simboloCopyright);
    System.out.printf("¿Es mayor de edad?: %b%n", esMayorDeEdad);


    System.out.println("Población de la ciudad: " + poblacionCiudad);
    System.out.println("Distancia: " + distancia);
    System.out.println("Población mundial: " + poblacionMundial);

// Para onservar el formato de dos decimales:
    System.out.println("Precio del producto: " + String.format("%.2f", precioProducto)); // Formato con 2 decimales

// Si deseas mostrar PI con un formato específico, puedes hacer:
    System.out.println("Valor de PI: " + String.format("%f", pi));

    System.out.println("Inicial del nombre: " + inicialNombre);
    System.out.println("Símbolo de copyright: " + simboloCopyright);
    System.out.println("¿Es mayor de edad?: " + esMayorDeEdad);




    //Tipos referneciados
    String mensaje = "hola";
    int [] numeros = {1,2,3,4};
    Persona mypersona = new Persona("Aday", 45);

    int i = 7;
    i -= 5;// i = i - 5;
    i += 5;// i = i + 5;
    // i *= 5;// i = i * 5;

     i++; // i = i + 1;
    ++i;
    int w = 5, z = 5;
    int c = w++;
    int d = ++z;
    System.out.println("W:"+w+" Z:"+z);
    System.out.println("C:"+c);
    System.out.println("D:"+d);


    for (int j = 0; j < 10; j++)
        System.out.println("Adios");
    System.out.println("Hola12");


    //Flujos de control
    if (d == 5) {
        System.out.println("D: 5");
    }else
        System.out.println("D: 6");


    Figura myfigure = new Figura();
    myfigure.ancho = 10;
    
}


