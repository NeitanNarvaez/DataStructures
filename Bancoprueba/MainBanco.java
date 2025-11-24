package Bancoprueba;

import java.util.Scanner;

public class MainBanco {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco(10);
        HistorialPila historial = new HistorialPila();
        ArbolUsuarios arbol = new ArbolUsuarios();
        GrafoAccesos grafo = new GrafoAccesos();

        // son lass jerarquía de roles
        arbol.insertar(1, "Gerente");
        arbol.insertar(2, "Administrador");
        arbol.insertar(3, "Supervisor");
        arbol.insertar(4, "Cajero");
        arbol.insertar(5, "Usuario");

        int opcion = -1;

        System.out.println("Banking Management System - versión básica");

        while (opcion != 0) {

            System.out.println(" MENU BANCO ");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Actualizar titular");
            System.out.println("3. Eliminar cuenta");
            System.out.println("4. Depositar");
            System.out.println("5. Retirar");
            System.out.println("6. Transferir");
            System.out.println("7. Listar cuentas");
            System.out.println("8. Mostrar cuentas ordenadas por saldo");
            System.out.println("9. Reporte totales");
            System.out.println("10. Historial");
            System.out.println("11. Árbol roles");
            System.out.println("12. Grafo accesos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Número cuenta: ");
                    int nc = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Titular: ");
                    String t = sc.nextLine();
                    System.out.print("Saldo inicial: ");
                    double s = sc.nextDouble();
                    System.out.print("Rol (1-Gerente ... 5-Usuario): ");
                    int r = sc.nextInt();
                    banco.crearCuenta(nc, t, s, r);
                    break;

                case 2:
                    System.out.print("Número cuenta: ");
                    int nu = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo titular: ");
                    String nt = sc.nextLine();
                    banco.actualizarTitular(nu, nt);
                    break;

                case 3:
                    System.out.print("Número cuenta: ");
                    int ne = sc.nextInt();
                    System.out.print("Ingrese su nivel de rol (1 a 5): ");
                    int rolE = sc.nextInt();
                    banco.eliminarCuenta(ne, rolE, arbol);
                    break;

                case 4:
                    System.out.print("Número cuenta: ");
                    int nd = sc.nextInt();
                    System.out.print("Monto a depositar: ");
                    double md = sc.nextDouble();
                    System.out.print("Ingrese su nivel de rol (1 a 5): ");
                    int rolD = sc.nextInt();
                    banco.depositar(nd, md, rolD, arbol, historial);
                    break;

                case 5:
                    System.out.print("Número cuenta: ");
                    int nr = sc.nextInt();
                    System.out.print("Monto a retirar: ");
                    double mr = sc.nextDouble();
                    System.out.print("Ingrese su nivel de rol (1 a 5): ");
                    int rolR = sc.nextInt();
                    banco.retirar(nr, mr, rolR, arbol, historial);
                    break;

                case 6:
                    System.out.print("Cuenta origen: ");
                    int co = sc.nextInt();
                    System.out.print("Cuenta destino: ");
                    int cd = sc.nextInt();
                    System.out.print("Monto a transferir: ");
                    double mt = sc.nextDouble();
                    System.out.print("Ingrese su nivel de rol (1 a 5): ");
                    int rolT = sc.nextInt();
                    banco.transferir(co, cd, mt, rolT, arbol, historial);
                    break;

                case 7:
                    banco.listarCuentas();
                    break;

                case 8:
                    banco.mostrarCuentasOrdenadasPorSaldo();
                    break;

                case 9:
                    banco.reporteTotales();
                    break;

                case 10:
                    historial.mostrarHistorial();
                    break;

                case 11:
                    arbol.mostrarArbol();
                    break;

                case 12:
                    grafo.mostrarGrafo();
                    break;

                case 0:
                    System.out.println("Saliendo");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        }

        sc.close();
    }
}
