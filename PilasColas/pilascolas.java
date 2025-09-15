import java.util.Stack;
public class pilascolas{
    public static void main(String[] args) {

        Stack<Integer> pila = new Stack<>();
        System.out.println("La pila esta vacia: " + pila.isEmpty());

        pila.push(10);
        pila.push(20);
        pila.push(5);
        pila.push(9);
        pila.push(35);

        System.out.println("la pila esta vacia: " + pila.isEmpty());
        System.out.println(pila);
        System.out.println(pila.peek());
        pila.pop();
        System.out.println(pila);

    }
}