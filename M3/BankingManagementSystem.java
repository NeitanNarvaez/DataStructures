import java.util.*;

public class BankingManagementSystem {
    private static BankDatabase db = new BankDatabase();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\n--- Menú Banco ---");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Transferir");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Reporte ordenado (merge sort)");
            System.out.println("7. Buscar por N° cuenta (búsqueda binaria)");
            System.out.println("8. Borrar cuenta");
            System.out.println("9. Salir");
            System.out.print("Elige opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1: crearCuenta(); break;
                case 2: depositar(); break;
                case 3: retirar(); break;
                case 4: transferir(); break;
                case 5: consultarSaldo(); break;
                case 6: reporteOrdenado(); break;
                case 7: buscarBinaria(); break;
                case 8: borrarCuenta(); break;
                case 9: System.out.println("Saliendo del sistema..."); break;
                default: System.out.println("Opción inválida.");
            }
        } while (option != 9);
    }

    static void crearCuenta() {
        System.out.print("Titular: ");
        scanner.nextLine();
        String holder = scanner.nextLine();
        System.out.print("Número de cuenta: ");
        String number = scanner.nextLine();
        System.out.print("Saldo inicial: ");
        double balance = scanner.nextDouble();
        BankAccount nueva = new BankAccount(number, holder, balance);
        boolean agregado = db.addAccount(nueva);
        System.out.println(agregado ? "Cuenta creada con éxito." : "La cuenta ya existe.");
    }

    static void depositar() {
        System.out.print("N° cuenta: ");
        scanner.nextLine();
        String number = scanner.nextLine();
        BankAccount acc = db.findAccount(number);
        if (acc != null) {
            System.out.print("Monto a depositar: ");
            double monto = scanner.nextDouble();
            acc.deposit(monto);
            System.out.println(acc);
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    static void retirar() {
        System.out.print("N° cuenta: ");
        scanner.nextLine();
        String number = scanner.nextLine();
        BankAccount acc = db.findAccount(number);
        if (acc != null) {
            System.out.print("Monto a retirar: ");
            double monto = scanner.nextDouble();
            boolean ok = acc.withdraw(monto);
            System.out.println(ok ? acc : "Monto inválido o fondos insuficientes.");
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    static void transferir() {
        System.out.print("Cuenta origen: ");
        scanner.nextLine();
        String origen = scanner.nextLine();
        BankAccount accOrigen = db.findAccount(origen);
        System.out.print("Cuenta destino: ");
        String destino = scanner.nextLine();
        BankAccount accDestino = db.findAccount(destino);
        if (accOrigen != null && accDestino != null && !origen.equals(destino)) {
            System.out.print("Monto a transferir: ");
            double monto = scanner.nextDouble();
            if (accOrigen.withdraw(monto)) {
                accDestino.deposit(monto);
                System.out.println("Transferencia realizada.");
                System.out.println("Origen: " + accOrigen);
                System.out.println("Destino: " + accDestino);
            } else {
                System.out.println("Monto inválido o fondos insuficientes.");
            }
        } else {
            System.out.println("Cuenta(s) no encontrada(s) o iguales.");
        }
    }

    static void consultarSaldo() {
        System.out.print("N° cuenta: ");
        scanner.nextLine();
        String number = scanner.nextLine();
        BankAccount acc = db.findAccount(number);
        System.out.println(acc != null ? acc : "Cuenta no encontrada.");
    }

    static void reporteOrdenado() {
        List<BankAccount> reporte = db.getAccountsSortedByBalance();
        System.out.println("Reporte ordenado por saldo:");
        for (BankAccount acc : reporte)
            System.out.println(acc);
    }

    static void buscarBinaria() {
        System.out.print("N° cuenta a buscar: ");
        scanner.nextLine();
        String number = scanner.nextLine();
        BankAccount acc = db.binarySearch(number);
        System.out.println(acc != null ? "Cuenta encontrada: " + acc : "No se encontró la cuenta.");
    }

    static void borrarCuenta() {
        System.out.print("N° cuenta a borrar: ");
        scanner.nextLine();
        String number = scanner.nextLine();
        boolean borrada = db.removeAccount(number);
        System.out.println(borrada ? "Cuenta eliminada." : "No se encontró la cuenta.");
    }
}
