import java.util.*;

public class colas {
    public static void main(String[] args) {
        System.out.println("\n=== COLA (Queue) ===");
        Queue<Integer> cola = new LinkedList<>();
        cola.offer(10);
        cola.offer(20);
        cola.offer(30);
        
        System.out.println("Cola: " + cola);
        System.out.println("Poll: " + cola.poll()); // Sale 10
        System.out.println("Después del poll: " + cola);
    }
}                                                             