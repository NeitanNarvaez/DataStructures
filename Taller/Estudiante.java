package Taller;
public class Estudiante {
    
    private String nombre;
    private int matricula;
    private double promedio;
    
    //constructor
    public Estudiante(String nombre, int  matricula, double  promedio) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.promedio = promedio;
        
    }
    
    //metodo mostar info
    public void mostrarInfo() {
            System.out.println("nommbre: " + nombre + ", Matricula: " + matricula + ", promedio: " + promedio);
    }
    // get titulo
    public String getNombre() {
        return nombre;
    }
    public int getMatricula() {
        return matricula;
    }
}
