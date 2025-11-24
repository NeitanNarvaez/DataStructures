package Banco;

import java.util.Scanner;

/*
 * Interfaz de consola básica para demostrar todas las funcionalidades.
 */
public class MainBanco {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Banco banco = new Banco(10); // capacidad 10
        HistorialPila historial = new HistorialPila();
        ArbolUsuarios arbol = new ArbolUsuarios();
        GrafoAccesos grafo = new GrafoAccesos();

        // Insertamos roles como haría el profesor en clase
        arbol.insertar(1, "Gerente");
        arbol.insertar(2, "Administrador");
        arbol.insertar(3, "Supervisor");
        arbol.insertar(4, "Cajero");
        arbol.insertar(5, "Usuario");

        System.out.println("Banking Management System - versión básica");
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Actualizar titular");
            System.out.println("3. Eliminar cuenta");
            System.out.println("4. Depositar");
            System.out.println("5. Retirar");
            System.out.println("6. Transferir");
            System.out.println("7. Buscar (lineal)");
            System.out.println("8. Buscar (binaria)");
            System.out.println("9. Listar cuentas");
            System.out.println("10. Mostrar cuentas ordenadas por saldo (Merge Sort)");
            System.out.println("11. Totales (total y promedio)");
            System.out.println("12. Historial de transacciones (pila)");
            System.out.println("13. Mostrar árbol de roles (tree)");
            System.out.println("14. Mostrar grafo de accesos (graph)");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Número de cuenta: "); int n = sc.nextInt(); sc.nextLine();
                    System.out.print("Titular: "); String t = sc.nextLine();
                    System.out.print("Saldo inicial: "); double s = sc.nextDouble();
                    banco.crearCuenta(n, t, s);
                    break;
                case 2:
                    System.out.print("Número de cuenta: "); int na = sc.nextInt(); sc.nextLine();
                    System.out.print("Nuevo titular: "); String nt = sc.nextLine();
                    banco.actualizarTitular(na, nt);
                    break;
                case 3:
                    System.out.print("Número de cuenta a eliminar: "); int ne = sc.nextInt();
                    banco.eliminarCuenta(ne);
                    break;
                case 4:
                    System.out.print("Número de cuenta: "); int nd = sc.nextInt();
                    System.out.print("Monto a depositar: "); double md = sc.nextDouble();
                    banco.depositar(nd, md, historial);
                    break;
                case 5:
                    System.out.print("Número de cuenta: "); int nr = sc.nextInt();
                    System.out.print("Monto a retirar: "); double mr = sc.nextDouble();
                    banco.retirar(nr, mr, historial);
                    break;
                case 6:
                    System.out.print("Cuenta origen: "); int co = sc.nextInt();
                    System.out.print("Cuenta destino: "); int cd = sc.nextInt();
                    System.out.print("Monto a transferir: "); double mt = sc.nextDouble();
                    banco.transferir(co, cd, mt, historial);
                    break;
                case 7:
                    System.out.print("Número de cuenta a buscar (lineal): "); int bl = sc.nextInt();
                    System.out.println(banco.buscarCuentaLineal(bl) == -1 ? "No encontrada." : "Cuenta encontrada.");
                    break;
                case 8:
                    System.out.print("Número de cuenta a buscar (binaria): "); int bb = sc.nextInt();
                    System.out.println(banco.buscarCuentaBinaria(bb) == -1 ? "No encontrada." : "Cuenta encontrada.");
                    break;
                case 9:
                    banco.listarCuentas();
                    break;
                case 10:
                    banco.mostrarCuentasOrdenadasPorSaldo();
                    break;
                case 11:
                    banco.reporteTotales();
                    break;
                case 12:
                    historial.mostrarHistorial();
                    break;
                case 13:
                    arbol.mostrarArbol();
                    break;
                case 14:
                    grafo.mostrarGrafo();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }
}
