package Taller;

public class Libro2 {
    private String titulo;
    private String autor;
    private int precio;

    public Libro2(String titulo, String autor, int precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

    public void mostrarInfo() {
        System.out.println("Título: " + titulo + ", Autor: " + autor + ", Precio: " + precio);
    }
    // metodo para actualizar el precio
    public void nuevoPrecio(int nPrecio) {
        this.precio = nPrecio;
    }
    public String getTitulo() {
        return titulo;
    }
}
