package interfaz;

import modelo.AppStore;
import modelo.Juego;

import javax.swing.*;

public class Main {

    private static AppStore tienda = new AppStore();

    static void main() {

        int opc = 0;
        tienda.inicializarDatos();
        do {
            menu();
            opc = Validacion.leerIntRango("Ingrese una opcion ", 1, 7);
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
                    buscarJuego();
                }
                break;
                case 4: {
                    comprar();
                }
                break;
                case 5: {
                    vender();
                }
                break;
                case 6: {
                    juegoMasVendido();
                }
                break;
                case 7: {
                    System.out.println("Hasta luego");
                }
                break;

                default: {
                    System.out.printf("Opcion invalida");
                }
            }
        } while (opc != 7);
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
    }

    public static void ingresarJuego(){
        System.out.println("*******Ingreso de datos********");
        String nombre = Validacion.leerString("Ingrese el nombre: ");
        String categoria = Validacion.leerString("Ingrese la categoria: ");
        int tamanio = Validacion.leerIntPositivo("Ingrese el tamanio: ");
        double precio = Validacion.leerDoublePositivo("Ingrese el precio: ");
        int licenciasDisponibles = Validacion.leerIntMayorIgual("Ingrese el stock inicial ", 0);

        if (tienda.agregarJuego(new Juego(nombre, categoria, tamanio, precio, licenciasDisponibles))) {
            JOptionPane.showMessageDialog(null, "Juego ingresado con exito");
        } else {
            JOptionPane.showMessageDialog(null, "No fue posible agregar el juego");
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

    public static void buscarJuego(){
        String nombre = Validacion.leerString("Ingrese el nombre, no puede ser nulo ni blanco: ");
        Juego j = tienda.buscarJuego(nombre);
        if(j != null){
            System.out.println(j);
        }else{
            System.out.println("No se encontro el juego " + nombre);
        }
    }

    public static void comprar(){
        String nombre = Validacion.leerString("Ingrese el nombre, no puede ser nulo ni blanco: ");
        int cantidad = Validacion.leerIntPositivo("Ingrese la cantidad: ");
        if(tienda.comprar(nombre, cantidad)){
            System.out.println("Se agregaron " + cantidad + " licencias al juego " + nombre);
        }else{
            System.out.println("No fue posible realizar la compra");
        }
    }

    public static void vender(){
        String nombre = Validacion.leerString("Ingrese el nombre, no puede ser nulo ni blanco: ");
        int cantidad = Validacion.leerIntPositivo("Ingrese la cantidad: ");
        double totalVenta = tienda.vender(nombre,cantidad);
        if( totalVenta == 0){
            System.out.println("No fue posible realizar la venta");
        }else{
            System.out.println("Usted ha comprado " +cantidad+ " licencias del juego " + nombre);
            System.out.println("Valor a pagar: "+totalVenta);
        }
    }

    public static void juegoMasVendido(){
        String nombre = tienda.juegoMasVendido();
        if(nombre.isEmpty()){
            System.out.println("No hay juegos registrados");
        }else if(tienda.buscarJuego(nombre).getLicenciasVendidas() == 0){
            System.out.println("Aun no se han realizado ventas");
        }else{
            System.out.println("El juego mas vendido es: " + nombre);
        }
    }
}
