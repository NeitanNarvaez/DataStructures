package Taller2;

import java.util.Stack;

public class P4SuperSimple {
    public static void main(String[] args) {
        
        // Ejemplo 1 - Todo en líneas simples
        Stack<Integer> p1 = new Stack<>();
        p1.push(0); p1.push(9); p1.push(8); p1.push(7); p1.push(6); 
        p1.push(5); p1.push(4); p1.push(3); p1.push(2); p1.push(1);
        
        System.out.println("(" + p1.pop() + p1.pop() + p1.pop() + ") " + 
                          p1.pop() + p1.pop() + p1.pop() + "-" + 
                          p1.pop() + p1.pop() + p1.pop() + p1.pop());
        
        // Ejemplo 2
        Stack<Integer> p2 = new Stack<>();
        p2.push(8); p2.push(6); p2.push(4); p2.push(4); p2.push(5);
        p2.push(5); p2.push(5); p2.push(9); p2.push(1); p2.push(5);
        
        System.out.println("(" + p2.pop() + p2.pop() + p2.pop() + ") " + 
                          p2.pop() + p2.pop() + p2.pop() + "-" + 
                          p2.pop() + p2.pop() + p2.pop() + p2.pop());
        
        // Ejemplo 3
        Stack<Integer> p3 = new Stack<>();
        p3.push(7); p3.push(2); p3.push(5); p3.push(2); p3.push(1);
        p3.push(0); p3.push(5); p3.push(5); p3.push(4); p3.push(3);
        
        System.out.println("(" + p3.pop() + p3.pop() + p3.pop() + ") " + 
                          p3.pop() + p3.pop() + p3.pop() + "-" + 
                          p3.pop() + p3.pop() + p3.pop() + p3.pop());
    }
}