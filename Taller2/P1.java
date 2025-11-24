package Taller2;

import java.util.Stack;

public class P1 {
    
    // Método que hace la resta
    public static int getVoteCount(int upvotes, int downvotes) {
        Stack<Integer> pila = new Stack<>();
        
        // Guardamos primero los positivos y luego los negativos
        pila.push(upvotes);
        pila.push(downvotes);

        // Sacamos primero los negativos (último en entrar)
        int negativos = pila.pop();
        // Luego los positivos
        int positivos = pila.pop();

        // Retornamos la resta
        return positivos - negativos;
    }

    public static void main(String[] args) {
        // Probamos los ejemplos
        System.out.println(getVoteCount(13, 0));     // 13
        System.out.println(getVoteCount(2, 33));     // -31
        System.out.println(getVoteCount(132, 132));  // 0
    }
}
