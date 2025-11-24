package Taller;
public class EjecutarEstudiante {
    public static void main(String[] args) {
        // Creamos un arreglo con espacio para 5 estudiantes
        Estudiante[] estudiantes = new Estudiante[6];
        int contador = 0;


    //objetos del arreglo
    estudiantes[contador] = new Estudiante("Juan", 101, 4.5);
    contador++;
    estudiantes[contador] = new Estudiante("Ana", 102, 3.8);contador++;
    estudiantes[contador] = new Estudiante("Luis", 103, 4.2);contador++;
    estudiantes[contador] = new Estudiante("Marta", 104, 3.9);contador++;
    estudiantes[contador] = new Estudiante("Carlos", 105, 4.0);contador++;
        
    // agregar estudiante
    estudiantes[contador] = new Estudiante("Ney ", 106, 4.0);
    contador++;
    System.out.println("se agrego el estudiante : Ney");
    // Mostrar todos
        System.out.println("lista de estudiantes");
        for (int i = 0; i < contador; i++) {
            estudiantes[i].mostrarInfo();
        }


        // buscar estudiante
        String buscarNombre = "jean";
        boolean encontrado = false;
        // revisar la bsuqedad o es contador
       for (int i = 0; i < estudiantes.length; i++) {  
            if (estudiantes[i].getNombre().equals(buscarNombre)) {
                System.out.println("si esta el estudiante");
                estudiantes[i].mostrarInfo();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("el estudiante no esta en la lista");
        }

        // eliminar estudiante
        int matriculaEliminar = 102;
        for (int i = 0; i < contador; i++) {
            if (estudiantes[i].getMatricula() == matriculaEliminar) {
                // Mover los siguientes una posición atrás
                for (int j = i; j < contador - 1; j++) {
                    estudiantes[j] = estudiantes[j + 1];
                }
                estudiantes[contador - 1] = null;
                contador--;
                System.out.println("Estudiante con matricula " + matriculaEliminar + " eliminado.");
                break;
            }
        }

        // Mostrar lista después de eliminar
        System.out.println("Nueva lista:");
        for (int i = 0; i < contador; i++) {
            estudiantes[i].mostrarInfo();
        }
    }
}
