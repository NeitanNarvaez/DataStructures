package Taller2;

import java.util.Stack;

public class P3 {
    public static void main(String[] args) {
        // Crear pilas y probar los ejemplos 
        // Ejemplo 1: [4, 8] → true
        Stack<Integer> pila1 = new Stack<>();
        pila1.push(4); // Primero
        pila1.push(8); // segundo
        
        int num2_1 = pila1.pop(); // se saca 8 el último
        int num1_1 = pila1.pop();// se saca 4 el primero
        
        boolean resultado1 = Math.sqrt(num1_1) == Math.cbrt(num2_1); // raiz caudrada y raiz cubica
        System.out.println("[4, 8] → " + resultado1);  // true si son iguales
        
        // Ejemplo 2: [16, 48] → false  
        Stack<Integer> pila2 = new Stack<>();
        pila2.push(16);
        pila2.push(48);
        
        int num2_2 = pila2.pop();
        int num1_2 = pila2.pop();
        
        boolean resultado2 = Math.sqrt(num1_2) == Math.cbrt(num2_2);
        System.out.println("[16, 48] → " + resultado2);  // false
        
        // Ejemplo 3: [9, 27] → true
        Stack<Integer> pila3 = new Stack<>();
        pila3.push(9);
        pila3.push(27);
        
        int num2_3 = pila3.pop();
        int num1_3 = pila3.pop();
        
        boolean resultado3 = Math.sqrt(num1_3) == Math.cbrt(num2_3);
        System.out.println("[9, 27] → " + resultado3);  // true
    }
}