package Clase2;

public class Estudiante {

    // Atributos de la clase
    private int id;
    private String nombre;
    private String apellido;
    private String facultad;
    private String[] cursos;

    // Constructor de la clase
    public Estudiante(int id, String nombre, String apellido, String facultad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.facultad = facultad;
        this.cursos = new String[0];
    }

    public int getId() {
        return id;
    }

    public String getFacultad() {
        return facultad;
    }

    public String[] getCursos() {
        return cursos;
    }

    public void matricularCursos(int id, String[] cursos) {
        this.cursos = cursos;
        String cad = "";
        for (int i = 0; i < cursos.length; i++) {
            cad += cursos[i] + " ";
        }
        System.out.println("id:" + id + "Cursos Matriculados: " + cad);
    }

    public String toString() {
        return "Estudiante { id: " + id + " Nombre: " + nombre + " Apellido: " + apellido + " Facultad: " + facultad
                + " }";
    }

    public static void contarFacultad(Estudiante[] estudiantes) {
        System.out.println("Cantidad estudiantes em facultad:");
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] != null) {
                String fac = estudiantes[i].getFacultad();
                int contador = 0;
                for (int j = 0; j < estudiantes.length; j++) {
                    if (estudiantes[j] != null && estudiantes[j].getFacultad().equals(fac)) {
                        contador++;
                    }
                }
                System.out.println("Facultad: " + fac + " ** " + contador + " estudiante.");
            }
        }
    }

    public static void contarCurso(Estudiante[] estudiantes) {
        System.out.println("Cantidad estudiantes en curso:");
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] != null) {
                String[] cursosEst = estudiantes[i].getCursos();
                for (int k = 0; k < cursosEst.length; k++) {
                    String curso = cursosEst[k];
                    int contador = 0;
                    for (int j = 0; j < estudiantes.length; j++) {
                        if (estudiantes[j] != null) {
                            String[] cursosJ = estudiantes[j].getCursos();
                            for (int x = 0; x < cursosJ.length; x++) {
                                if (cursosJ[x].equals(curso)) {
                                    contador++;
                                }
                            }
                        }
                    }
                    System.out.println("Curso: " + curso + " ** " + contador + " estudiante.");
                }
            }
        }
    }
}

// implementar el método +matricularCursos(id:int, cursos[]:String):void
// implementar un método que permita saber cuántos estudiantes hay en cada
// facultad
// implementar un método que permita saber cuantos estudiantes hay en cada
// curso.

