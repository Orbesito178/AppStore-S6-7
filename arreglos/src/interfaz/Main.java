package interfaz;

import modelo.AppStore;
import modelo.Juego;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static AppStore tienda = new AppStore();

    static void main() {

        int opc = 0;
        tienda.inicializarDatos();
        do {
            menu();
            opc = Integer.parseInt(sc.nextLine());
            switch (opc) {
                case 1: {
                    ingresarJuego();
                }
                break;
                case 2: {
                    imprimirJuegos();
                }
                break;
                case 3: {

                }
                break;
                case 4: {

                }
                break;
                case 5: {

                }
                break;
                case 6: {

                }
                break;
                case 7: {

                }
                break;

                default: {
                    System.out.printf("Opcion invalida");
                }
            }
        } while (opc != 7);
        sc.close();
    }

    public static void menu(){
        System.out.println("=====AppStore Udla=====");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego más vendido");
        System.out.println("7. Salir");
        System.out.print("Ingrese una opcion: ");
    }

    public static void ingresarJuego(){
        System.out.println("*******Ingreso de datos********");
        System.out.print("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la categoria: ");
        String categoria = sc.nextLine();
        System.out.print("Ingrese el tamanio: ");
        int tamanio = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese el precio: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.print("Ingrese el stock inicial: ");
        int licenciasDisponibles = Integer.parseInt(sc.nextLine());

        if (tienda.agregarJuego(new Juego(nombre, categoria, tamanio, precio, licenciasDisponibles))) {
            JOptionPane.showMessageDialog(null, "Juego ingresado con exito");
        } else {
            JOptionPane.showMessageDialog(null, "No fue posible agregr el juego");
        }
    }

    public static void imprimirJuegos(){
        Juego juegos[] = tienda.getJuegos();
        for(Juego j : juegos){
            if(j != null){
                System.out.println(j);
            }
            else{
                System.out.println("No hay juegos a mostrar");
                return;
            }
        }
    }

    public String leerNombre(){
        String nombre;
        nombre = sc.nextLine();
        while(nombre == null || nombre.trim().isEmpty()){
            System.out.println("Valor incorrecto. Ingrese nuevamente");
            nombre = sc.nextLine();
        }
        return nombre;
    }

    public static void vender(){
        double costo = 0;
        String nombre;
        System.out.println("Ingrese el nombre del juego a vender: ");
        nombre = sc.nextLine();
        System.out.println("Ingrese la cantidad que va a vender: ");
        costo = tienda.vender(nombre);
    }
}