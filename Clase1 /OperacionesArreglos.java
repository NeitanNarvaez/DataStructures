package Clase14AGO2025;


import java.util.Random;

public class OperacionesArreglos {
    
    //Método para llenar un arreglo de enteros
    public int[] llenarArregloEnteros(int tam){

        Random rand = new Random();

        int[] numeros = new int[tam];

        for(int i = 0; i < numeros.length; i++){
            numeros[i] = rand.nextInt(100 - 1) + 1;   //Números del 1 al 100         
        }

        return numeros;
    }

    //// Método para sumar los elementos del arreglo de enteros
    public int sumarElementos(int[] arreglo){
        int suma = 0;
        for(int i = 0; i < arreglo.length; i++){
            suma += arreglo[i];
        }
        return suma;
    }

    // Método para obtener el promedio de los elementos del arreglo
    public double obtenerPromedio(int[] arreglo){
        int suma = sumarElementos(arreglo);
        return (double) suma / arreglo.length;
    }

    // Método para obtener los números repetidos del arreglo
    public void obtenerNumerosRepetidos(int[] arreglo){
        System.out.print("Números repetidos: ");
        boolean hayRepetidos = false;
        for(int i = 0; i < arreglo.length; i++){
            for(int j = i + 1; j < arreglo.length; j++){
                if(arreglo[i] == arreglo[j]){
                    System.out.print(arreglo[i] + " ");
                    hayRepetidos = true;
                    break;
                }
            }
        }
        if(!hayRepetidos){
            System.out.print("No hay números repetidos");
        }
        System.out.println();
    }

    // Método para obtener el número mayor del arreglo
    public int obtenerMayor(int[] arreglo){
        int mayor = arreglo[0];
        for(int i = 1; i < arreglo.length; i++){
            if(arreglo[i] > mayor){
                mayor = arreglo[i];
            }
        }
        return mayor;
    }

    // Método para obtener el número menor del arreglo
    public int obtenerMenor(int[] arreglo){
        int menor = arreglo[0];
        for(int i = 1; i < arreglo.length; i++){
            if(arreglo[i] < menor){
                menor = arreglo[i];
            }
        }
        return menor;
    }


}