package Taller;

public class EjecutarLibro2 {

    public static void main(String[] args) {
        // arreglo de libros
        Libro2[] libros = new Libro2[5];

        // objetos del arreglo
        libros[0] = new Libro2("Rayuela", "Juan", 780);
        libros[1] = new Libro2("POO", "Miguel", 600);
        libros[2] = new Libro2("Matemáticas", "Samuel", 500);
        libros[3] = new Libro2("Ciencias", "Rafa", 309);
        libros[4] = new Libro2("Ingles", "Danilo", 200);

        // mostrar información de cada libro
        System.out.println("Libros Antes de cambiar precio:");
        for (int i = 0; i < libros.length; i++) {
            libros[i].mostrarInfo();
        }
        // cambiar precio del libro
        System.out.println("cambiar precio del libro POO");
        for (int i = 0; i < libros.length; i++) {
            if (libros[i].getTitulo().equals("POO")) { 
                libros[i].nuevoPrecio(790); // el precio nuevo
            }
        }
         // libros después de cambiar precio
        System.out.println("aqui muestra los libros depues de cambiar precio");
        for (int i = 0; i < libros.length; i++) {
            libros[i].mostrarInfo();
        }


        // precio total con método
        int total = calcularPrecioTotal(libros);
        System.out.println("Precio total: " + total);

        // para filtrar libros
        System.out.println("libros con precio mas que 400");
        filtrarPrecio(libros, 400);

        // ordenar
        System.out.println("libros de menor a mayor por precio");
        ordenarPrecio(libros);
        for (int i = 0; i < libros.length; i++) {
            libros[i].mostrarInfo();
        }
        // buscar secuencial
        System.out.println("buscar el libro por el titulo:");
        buscarLibro(libros, "Ingles"); // buscar libro por titulo
    }

    // Método para calcular precio total
    public static int calcularPrecioTotal(Libro2[] libros) {
        int total = 0;
        for (int i = 0; i < libros.length; i++) {
            total += libros[i].getPrecio();
        }
        return total;
    }

    // Método para filtrar libros con precio mayor a un valor
    public static void filtrarPrecio(Libro2[] libros, int valor) {
        for (int i = 0; i < libros.length; i++) {
            if (libros[i].getPrecio() > valor) {
                libros[i].mostrarInfo();
            }
        }
    }

    // Método para ordenar libros por precio (burbuja)
    public static void ordenarPrecio(Libro2[] libros) {
        int n = libros.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (libros[j].getPrecio() > libros[j + 1].getPrecio()) {
                    // intercambiar
                    Libro2 temp = libros[j];
                    libros[j] = libros[j + 1];
                    libros[j + 1] = temp;
                }
            }
        }
    }
     // buscar secuencial
    public static void buscarLibro(Libro2[] libros, String tituloBuscado) {
        boolean encontrado = false;
        for (int i = 0; i < libros.length; i++) {
            if (libros[i].getTitulo().equals(tituloBuscado)) {
                System.out.println("si esta el libro:");
                libros[i].mostrarInfo();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("libro con titulo" + tituloBuscado + "' no esta en la lista.");
        }
    }
}
