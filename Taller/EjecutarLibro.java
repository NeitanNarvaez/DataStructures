package Taller;

public class EjecutarLibro {

    public static void main(String[] args) {
        // arreglo de 5 carros 
        Libro[] v = new Libro[5];

        // objetos de arreglo
        v[0] = new Libro("Rayuela", "juan", 780);
        v[1] = new Libro("POO", "miguel", 600);
        v[2] = new Libro("Matematicas", "Samuel", 500);
        v[3] = new Libro("Ciencias", "Rafa", 309);
        v[4] = new Libro("Ingles", "Danilo", 200);

        // mostar con for 
        for (int i = 0; i < v.length; i++) {
            v[i].mostrarInfo();

        }
        //precio total de todos los libros en el arreglo
        int totalPrecio = 0;
        for (int i = 0; i < v.length; i++) {
            totalPrecio += v[i].precio;
        }
        // Muestra la informacion de cada libro y el precio total en la consola.
        System.out.println("Precio total: " + totalPrecio);
    }
}    