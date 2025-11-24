package Taller2;

import java.util.Stack;

public class P2 {
    public static void main(String[] args) {
        
        // PRIMER EJEMPLO - deben ser IGUALES (true)
        System.out.println("--- Ejemplo 1 ---");
        
        // Crear primer sándwich en una PILA
        Stack<String> sandwich1 = new Stack<>();
        sandwich1.push("pan blanco");  // ← ÚLTIMO: pan de arriba
        sandwich1.push("lechuga");     // ← MEDIO: ingrediente  
        sandwich1.push("pan blanco");  // ← PRIMERO: pan de abajo
        
        // Crear segundo sándwich en otra PILA
        Stack<String> sandwich2 = new Stack<>();
        sandwich2.push("pan blanco");  // ← ÚLTIMO: pan de arriba
        sandwich2.push("tomate");      // ← MEDIO: ingrediente
        sandwich2.push("pan blanco");  // ← PRIMERO: pan de abajo
        
        // COMPARAR: Sacamos los elementos de las pilas
        String panArriba1 = sandwich1.pop();  // saca "pan blanco" (último)
        String panArriba2 = sandwich2.pop();  // saca "pan blanco" (último)
        
        sandwich1.pop();  // saca "lechuga" (no nos importa)
        sandwich2.pop();  // saca "tomate" (no nos importa)
        
        String panAbajo1 = sandwich1.pop();  // saca "pan blanco" (primero)
        String panAbajo2 = sandwich2.pop();  // saca "pan blanco" (primero)
        
        // Verificar si los panes son iguales
        if (panAbajo1.equals(panAbajo2) && panArriba1.equals(panArriba2)) {
            System.out.println(" Tienen el mismo pan: true");
        } else {
            System.out.println(" Tienen diferente pan: false");
        }
        
        // SEGUNDO EJEMPLO - deben ser DIFERENTES (false)
        System.out.println("--- Ejemplo 2 ---");
        
        Stack<String> sandwich3 = new Stack<>();
        sandwich3.push("pan integral");
        sandwich3.push("pollo");
        sandwich3.push("pan integral");
        
        Stack<String> sandwich4 = new Stack<>();
        sandwich4.push("pan blanco");
        sandwich4.push("pollo");
        sandwich4.push("pan blanco");
        
        String arriba3 = sandwich3.pop();
        String arriba4 = sandwich4.pop();
        
        sandwich3.pop();
        sandwich4.pop();
        
        String abajo3 = sandwich3.pop();
        String abajo4 = sandwich4.pop();
        
        if (abajo3.equals(abajo4) && arriba3.equals(arriba4)) {
            System.out.println(" Tienen el mismo pan: true");
        } else {
            System.out.println(" Tienen diferente pan: false");
        }
    }
}