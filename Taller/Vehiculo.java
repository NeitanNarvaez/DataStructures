package Taller;

public class Vehiculo {
    
    private String color;
    private String marca;
    private int  modelo;
    private Boolean matriculado;

    public Vehiculo(String color, String marca, String string, int modelo, boolean  matriculado) {
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.matriculado = matriculado;
    
    }


    public void mostrarInfo() {
        System.out.println("Color: " + color + ", Marca: " + marca + ", Modelo: " + modelo+ ", Año: " + matriculado);
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
