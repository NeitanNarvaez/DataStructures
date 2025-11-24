package Banco;

/*
 * Grafo representado con matriz de adyacencia básica.
 * 0 = Cuentas
 * 1 = Transacciones
 * 2 = Reportes
 * Implementado de forma simple para cumplir el requisito "Graphs".
 */
public class GrafoAccesos {

    private int[][] matriz;

    public GrafoAccesos() {
        matriz = new int[3][3];
        matriz[0][1] = 1; // Cuentas -> Transacciones
        matriz[1][2] = 1; // Transacciones -> Reportes
    }

    public void mostrarGrafo() {
        System.out.println("\n--- GRAFO DE ACCESOS ---");
        System.out.println("0=Cuentas 1=Transacciones 2=Reportes");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
