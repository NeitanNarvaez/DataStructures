package Banco;

/*
 * Clase Banco - administra cuentas con un arreglo fijo.
 * Incluye Merge Sort para ordenar por saldo (requisito).
 * Incluye ordenamiento por número + búsqueda binaria.
 * Historial de transacciones (opcional paso de HistorialPila).
 */
public class Banco {

    private Cuenta[] cuentas;
    private int contador;

    public Banco(int maxCuentas) {
        cuentas = new Cuenta[maxCuentas];
        contador = 0;
    }

    // Crear cuenta
    public boolean crearCuenta(int numero, String titular, double saldoInicial) {
        if (contador >= cuentas.length) {
            System.out.println("Capacidad máxima alcanzada.");
            return false;
        }
        if (buscarCuentaLineal(numero) != -1) {
            System.out.println("La cuenta ya existe.");
            return false;
        }
        cuentas[contador++] = new Cuenta(numero, titular, saldoInicial);
        System.out.println("Cuenta creada.");
        return true;
    }

    // Actualizar titular
    public boolean actualizarTitular(int numero, String nuevo) {
        int pos = buscarCuentaLineal(numero);
        if (pos == -1) {
            System.out.println("Cuenta no encontrada.");
            return false;
        }
        cuentas[pos].setTitular(nuevo);
        System.out.println("Titular actualizado.");
        return true;
    }

    // Eliminar cuenta
    public boolean eliminarCuenta(int numero) {
        int pos = buscarCuentaLineal(numero);
        if (pos == -1) {
            System.out.println("Cuenta no encontrada.");
            return false;
        }
        for (int i = pos; i < contador - 1; i++) {
            cuentas[i] = cuentas[i + 1];
        }
        cuentas[--contador] = null;
        System.out.println("Cuenta eliminada.");
        return true;
    }

    // Búsqueda lineal
    public int buscarCuentaLineal(int numero) {
        for (int i = 0; i < contador; i++) {
            if (cuentas[i].getNumero() == numero) return i;
        }
        return -1;
    }

    // Ordenar por número (burbuja simple) para preparar búsqueda binaria
    public void ordenarPorNumero() {
        for (int i = 0; i < contador - 1; i++) {
            for (int j = i + 1; j < contador; j++) {
                if (cuentas[i].getNumero() > cuentas[j].getNumero()) {
                    Cuenta aux = cuentas[i];
                    cuentas[i] = cuentas[j];
                    cuentas[j] = aux;
                }
            }
        }
    }

    // Búsqueda binaria (requiere ordenar por número)
    public int buscarCuentaBinaria(int numero) {
        if (contador == 0) return -1;
        ordenarPorNumero();
        int ini = 0;
        int fin = contador - 1;
        while (ini <= fin) {
            int mid = (ini + fin) / 2;
            if (cuentas[mid].getNumero() == numero) return mid;
            if (cuentas[mid].getNumero() < numero) ini = mid + 1;
            else fin = mid - 1;
        }
        return -1;
    }

    // Depositar
    public void depositar(int numero, double monto, HistorialPila hist) {
        int pos = buscarCuentaLineal(numero);
        if (pos == -1) {
            System.out.println("Cuenta no encontrada.");
            return;
        }
        cuentas[pos].depositar(monto);
        if (hist != null) hist.registrar("Depósito a " + numero + " por " + monto);
    }

    // Retirar
    public void retirar(int numero, double monto, HistorialPila hist) {
        int pos = buscarCuentaLineal(numero);
        if (pos == -1) {
            System.out.println("Cuenta no encontrada.");
            return;
        }
        if (cuentas[pos].retirar(monto)) {
            if (hist != null) hist.registrar("Retiro de " + numero + " por " + monto);
        }
    }

    // Transferir
    public void transferir(int origen, int destino, double monto, HistorialPila hist) {
        int o = buscarCuentaLineal(origen);
        int d = buscarCuentaLineal(destino);
        if (o == -1 || d == -1) {
            System.out.println("Cuenta origen o destino no encontrada.");
            return;
        }
        if (origen == destino) {
            System.out.println("No puede transferirse a la misma cuenta.");
            return;
        }
        if (cuentas[o].retirar(monto)) {
            cuentas[d].depositar(monto);
            if (hist != null) hist.registrar("Transferencia de " + origen + " a " + destino + " por " + monto);
            System.out.println("Transferencia realizada.");
        }
    }

    // Listar cuentas
    public void listarCuentas() {
        System.out.println("\n--- CUENTAS REGISTRADAS ---");
        if (contador == 0) {
            System.out.println("No hay cuentas.");
            return;
        }
        for (int i = 0; i < contador; i++) {
            System.out.println(cuentas[i]);
        }
    }

    // --------- MERGE SORT para ordenar por saldo (cumple requisito 4) ----------
    public void ordenarPorSaldoMergeSort() {
        if (contador > 0) mergeSort(cuentas, 0, contador - 1);
    }

    private void mergeSort(Cuenta[] arr, int izq, int der) {
        if (izq < der) {
            int mid = (izq + der) / 2;
            mergeSort(arr, izq, mid);
            mergeSort(arr, mid + 1, der);
            merge(arr, izq, mid, der);
        }
    }

    private void merge(Cuenta[] arr, int izq, int mid, int der) {
        int n1 = mid - izq + 1;
        int n2 = der - mid;

        Cuenta[] L = new Cuenta[n1];
        Cuenta[] R = new Cuenta[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[izq + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = izq;
        while (i < n1 && j < n2) {
            if (L[i].getSaldo() <= R[j].getSaldo()) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
    // -------------------------------------------------------------------------

    public void mostrarCuentasOrdenadasPorSaldo() {
        if (contador == 0) {
            System.out.println("No hay cuentas para ordenar.");
            return;
        }
        // hacemos una copia para no alterar el orden "original" de cuentas en memoria
        Cuenta[] copia = new Cuenta[contador];
        for (int i = 0; i < contador; i++) copia[i] = cuentas[i];

        // aplicamos merge sort sobre la copia
        mergeSort(copia, 0, copia.length - 1);

        System.out.println("\n--- CUENTAS ORDENADAS POR SALDO (menor a mayor) ---");
        for (int i = 0; i < copia.length; i++) {
            System.out.println(copia[i]);
        }
    }

    // Reporte total y promedio
    public void reporteTotales() {
        if (contador == 0) {
            System.out.println("No hay cuentas.");
            return;
        }
        double total = 0;
        for (int i = 0; i < contador; i++) total += cuentas[i].getSaldo();
        System.out.println("Total en el banco: " + total);
        System.out.println("Promedio por cuenta: " + (total / contador));
    }
}
