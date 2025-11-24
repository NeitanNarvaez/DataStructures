package Bancoprueba;

import java.util.Stack;

/*
 * Pila(stack) para registrar historial de transacciones.
 * Última transacción en entrar es la primera en salir (LIFO).
 */

public class HistorialPila {

    private Stack<String> pila = new Stack<>();
    //registra un (push)

    public void registrar(String evento) {
        pila.push(evento);
    }
 /**
     * Muestra el historial desde el mas reciente al mas antiguo.
     * Aqui imprimimos con índice descendente para que se vea LIFO.
     */
    public void mostrarHistorial() {
        System.out.println(" historial de transacciones");
        if (pila.isEmpty()) {
            System.out.println("no hay transacciones");
            return;
        }
        for (int i = pila.size() - 1; i >= 0; i--) {
            System.out.println(pila.get(i));
        }
    }
}
