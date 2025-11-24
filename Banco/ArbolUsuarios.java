package Banco;

/*
 * Árbol binario simple para representar una jerarquía real de roles.
 * Mientras más pequeño el número, mayor autoridad.
 *
 * 1 = Gerente (máxima autoridad)
 * 2 = Administrador
 * 3 = Supervisor
 * 4 = Cajero
 * 5 = Usuario (mínima autoridad)
 */

public class ArbolUsuarios {

    private class Nodo {
        Nodo izquierda;
        Nodo derecha;
        Nodo padre;
        int llave;      // nivel jerárquico
        Object contenido;  // rol

        public Nodo(int llave) {
            this.llave = llave;
            this.izquierda = null;
            this.derecha = null;
            this.padre = null;
            this.contenido = null;
        }
    }

    private Nodo raiz;

    public ArbolUsuarios() {
        raiz = null;
    }

    // Insertar nodo según un árbol binario normal
    public void insertar(int llave, Object rol) {
        Nodo nuevo = new Nodo(llave);
        nuevo.contenido = rol;

        if (raiz == null) {
            raiz = nuevo;
            return;
        }

        Nodo aux = raiz;

        while (aux != null) {
            nuevo.padre = aux;
            if (nuevo.llave >= aux.llave) {
                aux = aux.derecha;
            } else {
                aux = aux.izquierda;
            }
        }

        if (nuevo.llave < nuevo.padre.llave) {
            nuevo.padre.izquierda = nuevo;
        } else {
            nuevo.padre.derecha = nuevo;
        }
    }

    // Recorrido IN-ORDER
    public void recorrer(Nodo n) {
        if (n != null) {
            recorrer(n.izquierda);
            System.out.println("Rol: " + n.contenido + " (Jerarquía: " + n.llave + ")");
            recorrer(n.derecha);
        }
    }

    public void mostrarArbol() {
        System.out.println("\n------ ÁRBOL DE JERARQUÍA DE ROLES ------");
        if (raiz == null) {
            System.out.println("Árbol vacío.");
        } else {
            recorrer(raiz);
        }
    }
}               
