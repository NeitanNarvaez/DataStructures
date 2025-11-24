package Bancoprueba;

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
        int llave;       // nivel jerárquico
        Object contenido; // nombre del rol

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

    // Insertar un rol en el árbol
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
                if (aux.derecha == null) break;
                aux = aux.derecha;
            } else {
                if (aux.izquierda == null) break;
                aux = aux.izquierda;
            }
        }

        if (nuevo.llave < nuevo.padre.llave) {
            nuevo.padre.izquierda = nuevo;
        } else {
            nuevo.padre.derecha = nuevo;
        }
    }

    // Buscar rol por llave
    public String buscarRol(int llave) {
        Nodo aux = raiz;

        while (aux != null) {
            if (aux.llave == llave) {
                return aux.contenido.toString();
            }
            if (llave < aux.llave) {
                aux = aux.izquierda;
            } else {
                aux = aux.derecha;
            }
        }
        return null;
    }

    // Verificar autoridad:
    // Si el nivel del usuario es menor o igual, puede realizar la acción
    public boolean tieneAutoridad(int nivelUsuario, int nivelMinimo) {
        return nivelUsuario <= nivelMinimo;
    }

    // Recorrido IN-ORDER
    private void recorrer(Nodo n) {
        if (n != null) {
            recorrer(n.izquierda);
            System.out.println("Rol: " + n.contenido + " (Jerarquía: " + n.llave + ")");
            recorrer(n.derecha);
        }
    }

    // Mostrar árbol
    public void mostrarArbol() {
        System.out.println(" ARBOL DE JERARQUÍA DE ROLES");
        if (raiz == null) {
            System.out.println("arbol vacio.");
        } else {
            recorrer(raiz);
        }
    }
}
