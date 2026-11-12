package interfaz;

import java.util.Scanner;

public class Validacion {
    private static Scanner sc = new Scanner (System.in);

    public static String leerString(String mensaje){
        String nombre;
        System.out.print(mensaje);
        nombre = sc.nextLine();
        while(nombre == null || nombre.trim().isEmpty()){
            System.out.println("Lectura Invalida. Vuelva a Ingresar.");
            System.out.print(mensaje);
            nombre = sc.nextLine();
        }
        return nombre;
    }
    //Validar que sea un int
    public static int leerInt(String mensaje){
        while(!sc.hasNextInt()){
            System.out.println("Lectura Inválida. Debe ingresar un número entero.");
            if(sc.nextLine().trim().isEmpty() && sc.hasNextLine()){
                sc.nextLine();
            }
            System.out.print(mensaje);
        }
        return sc.nextInt();
    }

    //Validar que sea un double
    public static double leerDouble(String mensaje){
        while(!sc.hasNextDouble()){
            System.out.println("Lectura Inválida. Debe ingresar un número.");
            if(sc.nextLine().trim().isEmpty() && sc.hasNextLine()){
                sc.nextLine();
            }
            System.out.print(mensaje);
        }
        return sc.nextDouble();
    }

    //Leer double positivo
    public static double leerDoublePositivo(String mensaje){
        double dato;
        System.out.print(mensaje);
        dato = leerDouble(mensaje);
        while(dato <= 0){
            System.out.println("Lectura Inválida. Vuelva a Ingresar.");
            System.out.println(mensaje);
            dato = leerDouble(mensaje);

        }
        sc.nextLine();
        return dato;
    }

    //Leer double mayor que algun valor
    public static double leerDoubleMayor(String mensaje, double base){
        double dato;
        System.out.print(mensaje + "(Mayor que " + base + "): ");
        dato = leerDouble(mensaje + "(Mayor que " + base + "): ");
        while(dato <= base){
            System.out.println("El valor no es mayor que " + base + ". Vuelva a Ingresar.");
            System.out.print(mensaje + "(Mayor que " + base + "): ");
            dato = leerDouble(mensaje + "(Mayor que " + base + "): ");

        }
        sc.nextLine();
        return dato;
    }
    //Leer double mayor o igual que algun valor
    public static double leerDoubleMayorIgual(String mensaje, double base){
        double dato;
        System.out.print(mensaje + "(Mayor o Igual que " + base + "): ");
        dato = leerDouble(mensaje + "(Mayor o Igual que " + base + "): ");
        while(dato < base){
            System.out.println("El valor no es mayor o igual que " + base + ". Vuelva a Ingresar.");
            System.out.print(mensaje + "(Mayor o Igual que " + base + ")");
            dato = leerDouble(mensaje + "(Mayor o Igual que " + base + ")");

        }
        sc.nextLine();
        return dato;
    }

    //Leer double menor que algun valor
    public static double leerDoubleMenor(String mensaje, double techo){
        double dato;
        System.out.print(mensaje + "(Menor que " + techo + "): ");
        dato = leerDouble(mensaje + "(Menor que " + techo + "): ");
        while(dato >= techo){
            System.out.println("El valor no es menor que " + techo + ". Vuelva a Ingresar.");
            System.out.print(mensaje + "(Menor que " + techo + "): ");
            dato = leerDouble(mensaje + "(Menor que " + techo + "): ");

        }
        sc.nextLine();
        return dato;
    }
    //Leer double menor o igual que algun valor
    public static double leerDoubleMenorIgual(String mensaje, double techo){
        double dato;
        System.out.print(mensaje + "(Menor o Igual que " + techo + "): ");
        dato = leerDouble(mensaje + "(Menor o Igual que " + techo + "): ");
        while(dato > techo){
            System.out.println("El valor no es menor o igual que " + techo + ". Vuelva a Ingresar.");
            System.out.print(mensaje + "(Menor o Igual que " + techo + "): ");
            dato = leerDouble(mensaje + "(Menor o Igual que " + techo + "): ");

        }
        sc.nextLine();
        return dato;
    }

    //Leer double dentro de un rango
    public static double leerDoubleRango(String mensaje, double base, double techo){
        double dato;
        System.out.print(mensaje + "(Entre " + base + "-" + techo + "): ");
        dato = leerDouble(mensaje + "(Entre " + base + "-" + techo + "): ");
        while(dato < base  || dato > techo){
            System.out.println("El valor no está entre " + base + "-" + techo + ". Vuelva a Ingresar.");
            System.out.print(mensaje + "(Entre " + base + "-" + techo + "): ");
            dato = leerDouble(mensaje + "(Entre " + base + "-" + techo + "): ");
        }
        sc.nextLine();
        return dato;
    }

    //Leer int positivo
    public static int leerIntPositivo(String mensaje){
        int dato;
        System.out.print(mensaje);
        dato = leerInt(mensaje);
        while(dato <= 0){
            System.out.println("Lectura Inválida. Vuelva a Ingresar.");
            System.out.print(mensaje);
            dato = leerInt(mensaje);

        }
        sc.nextLine();
        return dato;
    }

    //Leer int mayor que algun valor
    public static int leerIntMayor(String mensaje, int base){
        int dato;
        System.out.print(mensaje + "(Mayor que " + base + "): ");
        dato = leerInt(mensaje + "(Mayor que " + base + "): ");
        while(dato <= base){
            System.out.println("El valor no es mayor que " + base + ". Vuelva a Ingresar.");
            System.out.print(mensaje + "(Mayor que " + base + "): ");
            dato = leerInt(mensaje + "(Mayor que " + base + "): ");

        }
        sc.nextLine();
        return dato;
    }
    //Leer int mayor o igual que algun valor
    public static int leerIntMayorIgual(String mensaje, int base){
        int dato;
        System.out.print(mensaje + "(Mayor o Igual que " + base + "): ");
        dato = leerInt(mensaje + "(Mayor o Igual que " + base + "): ");
        while(dato < base){
            System.out.println("El valor no es mayor o igual que " + base + ". Vuelva a Ingresar.");
            System.out.print(mensaje + "(Mayor o Igual que " + base + "): ");
            dato = leerInt(mensaje + "(Mayor o Igual que " + base + "): ");

        }
        sc.nextLine();
        return dato;
    }

    //Leer int menor que algun valor
    public static int leerIntMenor(String mensaje, int techo){
        int dato;
        System.out.print(mensaje + "(Menor que " + techo + "): ");
        dato = leerInt(mensaje + "(Menor que " + techo + "): ");
        while(dato >= techo){
            System.out.println("El valor no es menor que " + techo + ". Vuelva a Ingresar.");
            System.out.print(mensaje + "(Menor que " + techo + "): ");
            dato = leerInt(mensaje + "(Menor que " + techo + "): ");

        }
        sc.nextLine();
        return dato;
    }
    //Leer int menor o igual que algun valor
    public static int leerIntMenorIgual(String mensaje, int techo){
        int dato;
        System.out.print(mensaje + "(Menor o Igual que " + techo + "): ");
        dato = leerInt(mensaje + "(Menor o Igual que " + techo + "): ");
        while(dato > techo){
            System.out.println("El valor no es menor o igual que " + techo + ". Vuelva a Ingresar.");
            System.out.print(mensaje + "(Menor o Igual que " + techo + "): ");
            dato = leerInt(mensaje + "(Menor o Igual que " + techo + "): ");

        }
        sc.nextLine();
        return dato;
    }

    //Leer int dentro de un rango
    public static int leerIntRango(String mensaje, int base, int techo){
        int dato;
        System.out.print(mensaje + "(Entre " + base + "-" + techo + "): ");
        dato = leerInt(mensaje + "(Entre " + base + "-" + techo + "): ");
        while(dato < base  || dato > techo){
            System.out.println("El valor no está entre " + base + "-" + techo + ". Vuelva a Ingresar.");
            System.out.print(mensaje + "(Entre " + base + "-" + techo + "): ");
            dato = leerInt(mensaje + "(Entre " + base + "-" + techo + "): ");
        }
        sc.nextLine();
        return dato;
    }
}