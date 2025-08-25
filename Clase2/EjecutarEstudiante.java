package Clase2;

import java.util.Arrays;

public class EjecutarEstudiante {
    
    public static void main(String[] args){

        //Forma 1
        //Creación de los objetos
        Estudiante objEst1 = new Estudiante(909876, "Juanito", "Perez", "Ingeniería");
        Estudiante objEst2 = new Estudiante(456098, "Anita", "Cano", "software");
        Estudiante objEst3 = new Estudiante(235621, "Mercedes", "De Jesús", "matemáticas");

        System.out.println(objEst1);
        System.out.println(objEst2);
        System.out.println(objEst3);

        System.out.println("--------------------------");
        //Crear arreglo de objetos
        // int[] a = new int[5];
        Estudiante[] est = new Estudiante[5];
        
        est[0] = objEst1;
        est[1] = objEst2;
        est[2] = objEst3;

        //Forma 2

        est[3] = new Estudiante(506070, "Byron", "Beltran", "Psicología");
        est[4] = new Estudiante(304050, "Antonio", "Buitrago", "Derecho");

        System.out.println(Arrays.toString(est));

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXx");

        for(Estudiante e: est){
            System.out.println(e);
        }

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXx");

        for(int i = 0; i < est.length; i++){
            System.out.println(est[i]);
        }
         System.out.println("--------------------------");
        // se martricula los cursos
        objEst1.matricularCursos(909876, new String[]{"Calculo integral","POO"});
        objEst2.matricularCursos(456098, new String[]{"POO","Bases de Datos"});
        objEst3.matricularCursos(235621, new String[]{"Calculo integral"});
        est[3].matricularCursos(506070, new String[]{"Ingles 1"});
        est[4].matricularCursos(304050, new String[]{"Ingles 2","POO"});

        System.out.println("--------------------------");
        // estudiantes en facultad
        Estudiante.contarFacultad(est);

        System.out.println("--------------------------");
        // estudiantes en curso
        Estudiante.contarCurso(est);
    }
}

   