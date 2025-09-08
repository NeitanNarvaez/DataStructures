package Amazonn;

class CasilleroAmazon {
    private Paquete[][] casilleros;

    public CasilleroAmazon(int filas, int columnas) {
        casilleros = new Paquete[filas][columnas];
    }

    // Registrar un paquete en un casillero especifico
    public int registrarPaquete(int f, int c, Paquete p) {
        if (f < 0 || f >= casilleros.length || c < 0 || c >= casilleros[0].length) {
            System.out.println("posicion invalida.");
            return -1; // Código para posición inválida
        }

        if (casilleros[f][c] == null) {
            casilleros[f][c] = p;
            return 1; // almacena el codigo o lo acepta 
        }

        return 0; // sale casillero ocupado
    }

        // buscar un casillero disponible
    public void consultarDisponibles() {
        System.out.println("Casilleros disponibles:");
        for (int i = 0; i < casilleros.length; i++) {
            for (int j = 0; j < casilleros[i].length; j++) {
                if (casilleros[i][j] == null) {
                    System.out.print("[ ] ");
                } else {
                    System.out.print("[X] ");
                }
            }
            System.out.println();
        }
    }

    // se muestra la informacion de un casillero
    public void mostrarPaquete(int f, int c) {
        if (f < 0 || f >= casilleros.length || c < 0 || c >= casilleros[0].length) {
            System.out.println("posicion invalida.");
            return;
        }

        if (casilleros[f][c] != null) {
            System.out.println("Informacion: " + casilleros[f][c]);
        } else {
            System.out.println("Casillero vacio.");
        }
    }
}