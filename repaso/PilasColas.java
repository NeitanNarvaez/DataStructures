import java.util.*;

public class PilasColas {
    public static void main(String[] args) {
        System.out.println("=== PILA (Stack) - enteros ===");
        Stack<Integer> pila = new Stack<>();
        pila.push(10);
        pila.push(20);
        pila.push(30);
        
        System.out.println("Pila: " + pila);
        System.out.println("Pop: " + pila.pop()); // Sale 30
        System.out.println("Después del pop: " + pila);

        System.out.println("\n=== PILA (Stack) - libros ===");
        //Pilas con la clase Stack
        //Crear una pila de libros
        Stack<String> books = new Stack<>();
        //Agregando elementos a la pila
        books.push("Book 1");
        books.push("Book 2");
        books.push("Book 3");
        //Mostrando la pila
        System.out.println(books);
        //Ver el ultimo elemento
        System.out.println("ultimo elemento: " + books.peek());
        //Eliminar el ultimo elemento
        System.out.println("ultimo elemento eliminado: "+ books.pop());
        //ver luego de eliminar
        System.out.println(books);
        //buscar elemento
        System.out.println("ubicación de Book 1 respecto a la parte superior: "+ books.search("Book 1"));



        System.out.println("\n Ejemplo pila");
        String expresion = "(())()";
        System.out.println("Expresión: " + expresion + " -> balanceada? " + validarParentesis(expresion));
    }

    private static boolean validarParentesis(String expresion) {
        Stack<Character> pila = new Stack<>();
        
        for (char c : expresion.toCharArray()) {
            if (c == '(') {
                pila.push(c);
            } else if (c == '(') {
                if (pila.isEmpty() || pila.pop() != '(') {
                    return false;
                }
            }
        }
        return pila.isEmpty();
    }
}