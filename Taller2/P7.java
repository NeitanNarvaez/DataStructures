package Taller2;

import java.util.Stack;

public class P7 {
    public static void main(String[] args) {
        
        System.out.println("=== PALABRAS DE 4 LETRAS O MENOS ===");
        
        // Ejemplo 1
        Stack<String> p1 = new Stack<>();
        p1.push("Tomate"); p1.push("Papa"); p1.push("Par");
        
        Stack<String> r1 = new Stack<>();
        Stack<String> t1 = new Stack<>();
        
        while (!p1.isEmpty()) {
            String palabra = p1.pop();
            t1.push(palabra);
            if (palabra.length() <= 4) {
                r1.push(palabra);
            }
        }
        
        System.out.println("Ejemplo 1:");
        while (!r1.isEmpty()) {
            System.out.println(r1.pop());
        }
        
        // Ejemplo 2
        Stack<String> p2 = new Stack<>();
        p2.push("Canguro"); p2.push("Oso"); p2.push("Zorro");
        
        Stack<String> r2 = new Stack<>();
        Stack<String> t2 = new Stack<>();
        
        while (!p2.isEmpty()) {
            String palabra = p2.pop();
            t2.push(palabra);
            if (palabra.length() <= 4) {
                r2.push(palabra);
            }
        }
        
        System.out.println("Ejemplo 2:");
        while (!r2.isEmpty()) {
            System.out.println(r2.pop());
        }
        
        // Ejemplo 3
        Stack<String> p3 = new Stack<>();
        p3.push("Ryan"); p3.push("Kieran"); p3.push("Jason"); p3.push("Matt");
        
        Stack<String> r3 = new Stack<>();
        Stack<String> t3 = new Stack<>();
        
        while (!p3.isEmpty()) {
            String palabra = p3.pop();
            t3.push(palabra);
            if (palabra.length() <= 4) {
                r3.push(palabra);
            }
        }
        
        System.out.println("Ejemplo 3:");
        while (!r3.isEmpty()) {
            System.out.println(r3.pop());
        }
    }
}