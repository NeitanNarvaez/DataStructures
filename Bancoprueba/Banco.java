package Bancoprueba;

/*
 * Clase Banco - administra cuentas con arreglo fijo.
 * Incluye validaciones y uso del árbol para permisos.
 * Incluye Merge Sort y búsqueda binaria (en arreglo).
 */

public class Banco {

    // arreglo fijo de cuentas con contador para saber cuantas cuentas hay
    private Cuenta[] cuentas;
    private int contador;

    // constructor con la capcidad del banco
    public Banco(int capacidad) {
        cuentas = new Cuenta[capacidad];
        contador = 0;
    }

    // Crea una cuenta si hay espacio y no existe duplicado
    // mira que no este otra cuenta con el mismo numero y la aegraga la cuenta al
    // arreglo
    // si se cumple se incrementa el contador
    public boolean crearCuenta(int numero, String titular, double saldo, int rol) {
        if (contador >= cuentas.length) {
            System.out.println("No se puede crear la cuenta: capacidad máxima alcanzada.");
            return false;
        }
        if (buscarCuentaLineal(numero) != -1) {
            System.out.println("No se puede crear la cuenta: número ya existe.");
            return false;
        }
        cuentas[contador++] = new Cuenta(numero, titular, saldo, rol);
        System.out.println("Cuenta creada.");
        return true;
    }

    // Actualizar titular
    // busca la cuenta por número y actualiza el titular con busqueda lineal
    public boolean actualizarTitular(int numero, String nuevoTitular) {
        int pos = buscarCuentaLineal(numero);
        if (pos == -1) {
            System.out.println("Cuenta no encontrada.");
            return false;
        }
        cuentas[pos].setTitular(nuevoTitular);
        System.out.println("Titular actualizado.");
        return true;
    }

    // Eliminar cuenta con verificación de autoridad (usa el árbol)
    // Requiere nivel <= 3 (1=Gerente,2=Admin,3=Supervisor)
    public boolean eliminarCuenta(int numero, int rolUsuario, ArbolUsuarios arbol) {
        // Requiere nivel <= 3 (Gerente, Admin, Supervisor)
        if (!arbol.tieneAutoridad(rolUsuario, 3)) {
            System.out.println("error: No tiene autoridad para eliminar cuentas.");
            return false;
        }

        int pos = buscarCuentaLineal(numero);
        if (pos == -1) {
            System.out.println("Cuenta no encontrada.");
            return false;
        }

        // el arreglo elliminaa el hueco que deja la cuenta eliminada
        for (int i = pos; i < contador - 1; i++) {
            cuentas[i] = cuentas[i + 1];
        }
        // reduce el contador y elimina la ultima posición repetida
        cuentas[--contador] = null;
        System.out.println("Cuenta eliminada por: " + arbol.buscarRol(rolUsuario));
        return true;
    }

    // Depositar con verificación (Cajero o superior -> nivel <=4)
    // Agrega registro al historial si se pasa la referencia
    public void depositar(int numero, double monto, int rolUsuario, ArbolUsuarios arbol, HistorialPila hist) {
        if (!arbol.tieneAutoridad(rolUsuario, 4)) {
            System.out.println("errorr: No tiene permiso para depositar.");
            return;
        }
        if (monto <= 0) {
            System.out.println("Monto invalido.");
            return;
        }

        int pos = buscarCuentaLineal(numero);
        if (pos == -1) {
            System.out.println("Cuenta no encontrada.");
            return;
        }
        cuentas[pos].depositar(monto);
        // guarda el movimiento en la pila del historial
        // hist es el nombre de la variable que le puse con referencia al historial
        if (hist != null)
            hist.registrar("Depósito de " + monto + " a cuenta " + numero
                    + " por rol " + arbol.buscarRol(rolUsuario));
        System.out.println("Depósito realizado. Nuevo saldo: " + cuentas[pos].getSaldo());
    }

    // Retirar con verificación (Cajero o superior)
    public void retirar(int numero, double monto, int rolUsuario, ArbolUsuarios arbol, HistorialPila hist) {
        if (!arbol.tieneAutoridad(rolUsuario, 4)) {
            System.out.println("errorr: No tiene permiso para retirar.");
            return;
        }
        if (monto <= 0) {
            System.out.println("Monto invalido.");
            return;
        }

        int pos = buscarCuentaLineal(numero);
        if (pos == -1) {
            System.out.println("Cuenta no encontrada.");
            return;
        }
        // en la clsase cuenta mira si hay fondos suficientes y guarda el retiro
        // si es exitoso en el historial muestra el nuevo saldo
        if (cuentas[pos].retirar(monto)) {
            if (hist != null)
                hist.registrar("Retiro de " + monto + " en cuenta " + numero
                        + " por rol " + arbol.buscarRol(rolUsuario));
            System.out.println("Retiro realizado. Nuevo saldo: " + cuentas[pos].getSaldo());
        }
    }

    // Transferir (Supervisor o superior -> nivel <=3)
    // verifica fondos suficientes en la cuenta origen y que no sean la misma cuenta
    // esto lo guarda en historial
    public void transferir(int origen, int destino, double monto, int rolUsuario, ArbolUsuarios arbol,
            HistorialPila hist) {
        if (!arbol.tieneAutoridad(rolUsuario, 3)) {
            System.out.println("error: No tiene permiso para transferir.");
            return;
        }
        if (monto <= 0) {
            System.out.println("Monto invalido.");
            return;
        }
        // buscar ambas cuentas por búsqueda lineal
        // va recorriendo el arreglo desde el inicio hasta el final uno por uno 
        int posO = buscarCuentaLineal(origen);
        int posD = buscarCuentaLineal(destino);
        if (posO == -1 || posD == -1) {
            System.out.println("Cuenta origen o destino no encontrada.");
            return;
        }
        if (origen == destino) {
            System.out.println("No puede transferirse a la misma cuenta.");
            return;
        }
        if (cuentas[posO].getSaldo() < monto) {
            System.out.println("Fondos insuficientes en la cuenta origen.");
            return;
        }
        // resta en origen y suma en destino
        cuentas[posO].setSaldo(cuentas[posO].getSaldo() - monto);
        cuentas[posD].setSaldo(cuentas[posD].getSaldo() + monto);
        if (hist != null)
            hist.registrar("Transferencia de " + monto + " de " + origen + " a " + destino
                    + " por rol " + arbol.buscarRol(rolUsuario));
        System.out.println("Transferencia realizada.");
    }

    // Búsqueda lineal sobre arreglo recoriendo desde el inicio hasta el final
    // Retorna la posición o -1 si no existe o si encuntra una cuenta con el mismo
    // número devuelve la posición
    public int buscarCuentaLineal(int numero) {
        for (int i = 0; i < contador; i++) {
            if (cuentas[i] != null && cuentas[i].getNumero() == numero)
                return i;
        }
        return -1;
    }

    // Ordenar por número con burbuja para búsqueda binaria
    // calcula el punto medio, si es menor busca en la mitad izquierda, si es mayor
    // en la derecha
    // si el numero esta en el medio lo retorna
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

    // Búsqueda binaria sobre arreglo ordenado por número
    // oredna las cuentas por slado, divide en dos partes el arreglo y busca en la
    // mitad correspondiente
    // comobina amabas partes en merge tiene dos subarreglos y los une en uno solo
    // en orden
    public int buscarCuentaBinaria(int numero) {
        if (contador == 0)
            return -1;
        ordenarPorNumero();
        int ini = 0, fin = contador - 1;
        while (ini <= fin) {
            int mid = (ini + fin) / 2;
            if (cuentas[mid].getNumero() == numero)
                return mid;
            if (cuentas[mid].getNumero() < numero)
                ini = mid + 1;
            else
                fin = mid - 1;
        }
        return -1;
    }

    // Merge Sort por saldo (para reportes)
    // hace una copia del arreglo y lo ordena sin modificar el original
    // con el merge sort muetsra las cuentas ordenadas por saldo en ascendente
    public void ordenarPorSaldoMergeSort(Cuenta[] a, int izq, int der) {
        if (izq >= der)
            return;
        int medio = (izq + der) / 2;
        ordenarPorSaldoMergeSort(a, izq, medio);
        ordenarPorSaldoMergeSort(a, medio + 1, der);
        merge(a, izq, medio, der);
    }

    private void merge(Cuenta[] a, int izq, int medio, int der) {
        Cuenta[] temp = new Cuenta[der - izq + 1];
        int i = izq, j = medio + 1, k = 0;
        while (i <= medio && j <= der) {
            if (a[i].getSaldo() <= a[j].getSaldo())
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }
        while (i <= medio)
            temp[k++] = a[i++];
        while (j <= der)
            temp[k++] = a[j++];
        for (i = 0; i < temp.length; i++)
            a[izq + i] = temp[i];
    }

    // Muestra cuentas ordenadas por saldo esto hace una copia para no modificar el
    // arreglo principal
    public void mostrarCuentasOrdenadasPorSaldo() {
        if (contador == 0) {
            System.out.println("No hay cuentas para ordenar.");
            return;
        }
        Cuenta[] copia = new Cuenta[contador];
        for (int i = 0; i < contador; i++)
            copia[i] = cuentas[i];
        ordenarPorSaldoMergeSort(copia, 0, copia.length - 1);
        System.out.println("\n--- CUENTAS ORDENADAS POR SALDO ---");
        for (Cuenta c : copia)
            System.out.println(c);
    }

    // Reporte total y promedio
    // suma todos los saldos y calcula el promedio
    public void reporteTotales() {
        if (contador == 0) {
            System.out.println("No hay cuentas.");
            return;
        }
        double total = 0;
        for (int i = 0; i < contador; i++)
            total += cuentas[i].getSaldo();
        System.out.println("Total en el banco: " + total);
        System.out.println("Promedio por cuenta: " + (total / contador));
    }

    // Listar cuentas
    // muestra todas las cuentas en el arreglo con toda su información
    public void listarCuentas() {
        System.out.println(" LISTADO DE CUENTAS");
        if (contador == 0) {
            System.out.println("No hay cuentas.");
            return;
        }
        for (int i = 0; i < contador; i++) {
            if (cuentas[i] != null)
                System.out.println(cuentas[i]);
        }
    }
}
