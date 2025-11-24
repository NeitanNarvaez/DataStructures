package Taller2;

import java.util.Stack;
import java.util.Queue;
import java.util.ArrayDeque;

public class P4 {
    
    // Método para formatear número telefónico
    public static String formatPhoneNumber(Stack<Integer> numeros) {
        // Verificar que tenga exactamente 10 números
        if (numeros.size() != 10) {
            return "Error: debe tener 10 números";
        }
        
        // Usar cola para reordenar los números
        Queue<Integer> cola = new ArrayDeque<>();
        
        // Pasar de pila a cola (invertir orden)
        while (!numeros.isEmpty()) {
            cola.add(numeros.pop());
        }
        
        // Volver a pila en orden correcto para formateo
        while (!cola.isEmpty()) {
            numeros.push(cola.poll());
        }
        
        // Construir número telefónico
        StringBuilder telefono = new StringBuilder("(");
        
        // Primeros 3 números - código de área
        for (int i = 0; i < 3; i++) {
            telefono.append(numeros.pop());
        }
        telefono.append(") ");
        
        // Siguientes 3 números
        for (int i = 0; i < 3; i++) {
            telefono.append(numeros.pop());
        }
        telefono.append("-");
        
        // Últimos 4 números
        for (int i = 0; i < 4; i++) {
            telefono.append(numeros.pop());
        }
        
        return telefono.toString();
    }
    
    public static void main(String[] args) {
        
        // Ejemplo 1
        Stack<Integer> pila1 = new Stack<>();
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        for (int num : nums1) {
            pila1.push(num);
        }
        System.out.println(formatPhoneNumber(pila1)); // (123) 456-7890
        
        // Ejemplo 2
        Stack<Integer> pila2 = new Stack<>();
        int[] nums2 = {5, 1, 9, 5, 5, 5, 4, 4, 6, 8};
        for (int num : nums2) {
            pila2.push(num);
        }
        System.out.println(formatPhoneNumber(pila2)); // (519) 555-4468
        
        // Ejemplo 3
        Stack<Integer> pila3 = new Stack<>();
        int[] nums3 = {3, 4, 5, 5, 0, 1, 2, 5, 2, 7};
        for (int num : nums3) {
            pila3.push(num);
        }
        System.out.println(formatPhoneNumber(pila3)); // (345) 501-2527
    }
}