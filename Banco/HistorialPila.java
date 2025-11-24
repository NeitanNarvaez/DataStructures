package Banco;

import java.util.Stack;

/*
 * Clase que guarda el historial de transacciones usando una Pila (Stack)
 */
public class HistorialPila {

    private Stack<String> historial = new Stack<>();

    public void registrar(String mensaje) {
        historial.push(mensaje);
    }

    public void mostrarHistorial() {
        System.out.println("\n--- HISTORIAL DE TRANSACCIONES (más reciente arriba) ---");
        if (historial.isEmpty()) {
            System.out.println("No hay transacciones.");
            return;
        }
        for (int i = historial.size() - 1; i >= 0; i--) {
            System.out.println(historial.get(i));
        }
    }
}
