package Amazonn;

import java.util.Scanner;

public class EjecutarCasillero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CasilleroAmazon casillero = new CasilleroAmazon(3, 3); // matriz 3x3
        int opcion;

        do {
            System.out.println("\n Menu Casillero Amazon");
            System.out.println("1 Registrar paquete");
            System.out.println("2 Consultar casilleros disponibles");
            System.out.println("3 Ver información de un paquete");
            System.out.println("4 Salir");
            System.out.print("Seleccione opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("fila:");
                    int f = sc.nextInt();
                    System.out.print("columna");
                    int c = sc.nextInt();
                    sc.nextLine();
                    System.out.print("destinatario ");
                    String dest = sc.nextLine();
                    System.out.print("fecha de ingreso ");
                    String fecha = sc.nextLine();
                    Paquete p = new Paquete(dest, fecha);

                    int resultado = casillero.registrarPaquete(f, c, p);
                    if (resultado == 1) {
                        System.out.println("Paquete registrado ");
                    } else if (resultado == 0) {
                        System.out.println("Casillero ocupado.");
                    }
                    // No muestra mensaje para resultado -1 porque ya lo mostró el método
                    break;
                case 2:
                    casillero.consultarDisponibles();
                    break;
                case 3:
                    System.out.print("Fila: ");
                    f = sc.nextInt();
                    System.out.print("Columna: ");
                    c = sc.nextInt();
                    casillero.mostrarPaquete(f, c);
                    break;
                case 4:
                    System.out.println("Cerrar programa.");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 4);

        sc.close();
    }
}