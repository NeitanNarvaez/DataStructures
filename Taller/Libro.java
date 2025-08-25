package Taller;

public class Libro {
    
    private String titulo;
    private String autor;
    int  precio;
    

    public Libro(String titulo, String autor,  int precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        
    
    }


    public void mostrarInfo() {
        System.out.println("Titulo: " + titulo + ", Autor: " + autor + ", Precio: " + precio);
    }
    // metodo para iterar el arreglo
    public String iterarVehiculo(Vehiculo[] v) {
        String cad = "";
        for (int i = 0; i < v.length; i++) {
            cad += v[i].toString() + "\n";
        }
        return cad;
    }
}
