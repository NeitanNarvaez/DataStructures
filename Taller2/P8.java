package Taller2;

import java.util.Stack;

public class P8 {
    public static void main(String[] args) {
        
        // Ejemplo 1
        Stack<Integer> pila1 = new Stack<>();
        pila1.push(2); pila1.push(8); pila1.push(7); pila1.push(5);
        System.out.println("Ejemplo 1: " + guerraNumeros(pila1));
        
        // Ejemplo 2
        Stack<Integer> pila2 = new Stack<>();
        pila2.push(12); pila2.push(90); pila2.push(75);
        System.out.println("Ejemplo 2: " + guerraNumeros(pila2));
        
        // Ejemplo 3
        Stack<Integer> pila3 = new Stack<>();
        pila3.push(5); pila3.push(9); pila3.push(45); pila3.push(6);
        pila3.push(2); pila3.push(7); pila3.push(34); pila3.push(8);
        pila3.push(6); pila3.push(90); pila3.push(5); pila3.push(243);
        System.out.println("Ejemplo 3: " + guerraNumeros(pila3));
    }
    
    public static int guerraNumeros(Stack<Integer> numeros) {
        int sumaPares = 0;
        int sumaImpares = 0;
        Stack<Integer> temp = new Stack<>();
        
        // Revisar cada número
        while (!numeros.isEmpty()) {
            int numero = numeros.pop();
            temp.push(numero);
            
            // Verificar si es par (divisible entre 2)
            if (numero % 2 == 0) {
                sumaPares = sumaPares + numero;
            } else {
                sumaImpares = sumaImpares + numero;
            }
        }
        
        // Calcular diferencia absoluta
        if (sumaPares > sumaImpares) {
            return sumaPares - sumaImpares;
        } else {
            return sumaImpares - sumaPares;
        }
    }
}