package Taller2;

import java.util.Stack;

public class P5 {
    public static void main(String[] args) {
        
        // Ejemplo 1
        Stack<Integer> pila1 = new Stack<>();
        pila1.push(10); pila1.push(40); pila1.push(30); pila1.push(20); pila1.push(50);
        
        int mayor1 = 0;
        int segundo1 = 0;
        Stack<Integer> temp1 = new Stack<>();
        
        // Buscar el mayor
        while (!pila1.isEmpty()) {
            int num = pila1.pop();
            temp1.push(num);
            if (num > mayor1) mayor1 = num;
        }
        
        // Buscar el segundo mayor
        while (!temp1.isEmpty()) {
            int num = temp1.pop();
            if (num > segundo1 && num < mayor1) segundo1 = num;
        }
        
        System.out.println("Ejemplo 1: " + segundo1);
        
        
        // Ejemplo 2
        Stack<Integer> pila2 = new Stack<>();
        pila2.push(25); pila2.push(143); pila2.push(89); pila2.push(13); pila2.push(105);
        
        int mayor2 = 0;
        int segundo2 = 0;
        Stack<Integer> temp2 = new Stack<>();
        
        while (!pila2.isEmpty()) {
            int num = pila2.pop();
            temp2.push(num);
            if (num > mayor2) mayor2 = num;
        }
        
        while (!temp2.isEmpty()) {
            int num = temp2.pop();
            if (num > segundo2 && num < mayor2) segundo2 = num;
        }
        
        System.out.println("Ejemplo 2: " + segundo2);
        
        
        // Ejemplo 3
        Stack<Integer> pila3 = new Stack<>();
        pila3.push(54); pila3.push(23); pila3.push(11); pila3.push(17); pila3.push(10);
        
        int mayor3 = 0;
        int segundo3 = 0;
        Stack<Integer> temp3 = new Stack<>();
        
        while (!pila3.isEmpty()) {
            int num = pila3.pop();
            temp3.push(num);
            if (num > mayor3) mayor3 = num;
        }
        
        while (!temp3.isEmpty()) {
            int num = temp3.pop();
            if (num > segundo3 && num < mayor3) segundo3 = num;
        }
        
        System.out.println("Ejemplo 3: " + segundo3);
    }
}