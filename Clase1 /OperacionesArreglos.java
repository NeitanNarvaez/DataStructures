package Clase14AGO2025;


import java.util.Arrays;

public class Clase1 {
    public static void main(String[] args){

        System.out.println("Estructura de Datos");

        //Arreglos ó Arrays ó Vectores

        //Declaración del arreglo. Forma 1
        //int[] numeros;
        //numeros = new int[5];

        //Declaración del arreglo. Forma 2
        //int[] numeros = new int[5];

        //Declaración e inicialización
        //int[] numeros = {10, 20, 30, 40, 50};

        OperacionesArreglos objArreglo = new OperacionesArreglos();

        int[] numeros = objArreglo.llenarArregloEnteros(5);

        System.out.println(Arrays.toString(numeros));

        
        // Suma
        System.out.println("Suma: " + objArreglo.sumarElementos(numeros));

        // Promedio
        System.out.println("Promedio: " + objArreglo.obtenerPromedio(numeros));

        // Números repetidos
        objArreglo.obtenerNumerosRepetidos(numeros);

        // Mayor y menor
        System.out.println("Mayor: " + objArreglo.obtenerMayor(numeros));
        System.out.println("Menor: " + objArreglo.obtenerMenor(numeros));
    }
}


    