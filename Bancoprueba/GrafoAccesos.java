package Bancoprueba;

/*
 * Grafo simple representado con matriz de adyacencia.
 * Indica relaciones de permiso entre niveles (ejemplo demostrativo).
 *
 * Indices (0..4) representan roles (1..5) menos 1.
 */
public class GrafoAccesos {

    private int[][] matriz;

    // matriz de 5x5 para 5 roles
    public GrafoAccesos() {
        matriz = new int[5][5];
        // ejemplo: gerente (1) puede pasar a admin (2)
        matriz[0][1] = 1; // 1 -> 2
        matriz[1][2] = 1; // 2 -> 3
        matriz[2][3] = 1; // 3 -> 4
        matriz[3][4] = 1; // 4 -> 5
    }
//Imprime la matriz de adyacencia
    public void mostrarGrafo() {
        System.out.println(" Accesos entre roles en el grafo ");
        System.out.println("Filas = desde, Columnas = hacia (indices 0..4 = roles 1..5)");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
