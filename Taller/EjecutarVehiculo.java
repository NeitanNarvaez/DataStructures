package Taller;

public class EjecutarVehiculo {

    public static void main(String[] args) {
        // arreglo de 5 carros 
        Vehiculo[] v = new Vehiculo[5];

        // objetos de arreglo
        v[0] = new Vehiculo("Rojo", "BMW", "M3", 2021, true);
        v[1] = new Vehiculo("Azul", "Toyota", "Corolla", 2000, false);
        v[2] = new Vehiculo("Negro", "Chevrolet", "Onix", 1990, true);
        v[3] = new Vehiculo("Blanco", "Mazda", "CX-5", 2017, true);
        v[4] = new Vehiculo("Gris", "Honda", "Civic", 1980, false);

        // mostar con for 
        //for (int i = 0; i < v.length; i++) {
        //v[i].mostrarInfo();
        System.out.println(v[0].iterarVehiculo(v));
    }
}
