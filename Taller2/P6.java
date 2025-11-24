package Taller2;

import java.util.Stack;

public class P6 {
    public static void main(String[] args) {
        
        // Ejemplo 1
        Stack<String> pila1 = new Stack<>();
        pila1.push("Adam"); pila1.push("Sarah"); pila1.push("Malcolm");
        System.out.println("Ejemplo 1: " + sociedadSecreta(pila1));
        
        // Ejemplo 2
        Stack<String> pila2 = new Stack<>();
        pila2.push("Harry"); pila2.push("Newt"); pila2.push("Luna"); pila2.push("Cho");
        System.out.println("Ejemplo 2: " + sociedadSecreta(pila2));
        
        // Ejemplo 3
        Stack<String> pila3 = new Stack<>();
        pila3.push("Phoebe"); pila3.push("Chandler"); pila3.push("Rachel"); 
        pila3.push("Ross"); pila3.push("Monica"); pila3.push("Joey");
        System.out.println("Ejemplo 3: " + sociedadSecreta(pila3));
    }
    
    public static String sociedadSecreta(Stack<String> nombres) {
        // Pila para guardar las primeras letras
        Stack<Character> letras = new Stack<>();
        
        // Sacar nombres y obtener primera letra
        while (!nombres.isEmpty()) {
            String nombre = nombres.pop();
            char primeraLetra = nombre.charAt(0);
            letras.push(primeraLetra);
        }
        
        // Ordenar letras alfabéticamente
        Stack<Character> ordenadas = new Stack<>();
        
        while (!letras.isEmpty()) {
            char letra = letras.pop();
            
            // Si la pila de ordenadas está vacía, simplemente agregar
            if (ordenadas.isEmpty()) {
                ordenadas.push(letra);
            } else {
                // Buscar la posición correcta para insertar
                Stack<Character> temp = new Stack<>();
                
                // Sacar letras que son mayores que la actual
                while (!ordenadas.isEmpty() && ordenadas.peek() > letra) {
                    temp.push(ordenadas.pop());
                }
                
                // Insertar la letra actual
                ordenadas.push(letra);
                
                // Volver a poner las letras que sacamos
                while (!temp.isEmpty()) {
                    ordenadas.push(temp.pop());
                }
            }
        }
        
        // Construir el resultado en mayúsculas
        String resultado = "";
        while (!ordenadas.isEmpty()) {
            resultado += ordenadas.pop();
        }
        
        return resultado.toUpperCase();
    }
}