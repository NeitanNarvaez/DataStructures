public class Main {
    public static void main(String[] args) {
        
        System.out.println("SISTEMA DE GESTION DE TAREAS");
        
        GestorTareas gestor = new GestorTareas();
        
        Tarea tarea1 = new Tarea("T001", "Revisar reporte mensual", 1, 100);
        Tarea tarea2 = new Tarea("T002", "Actualizar base de datos", 2, 200);
        Tarea tarea3 = new Tarea("T003", "EMERGENCIA Servidor", 3, 300);
        Tarea tarea4 = new Tarea("T004", "Respaldar archivos", 1, 400);
        Tarea tarea5 = new Tarea("T005", "URGENTE Error critico", 3, 500);
        
        System.out.println("1. AGREGANDO TAREAS");
        gestor.agregarTarea(tarea1);
        gestor.agregarTarea(tarea2);
        gestor.agregarTarea(tarea3);
        gestor.agregarTarea(tarea4);
        gestor.agregarTarea(tarea5);
        
        System.out.println("2. ESTADO INICIAL");
        gestor.mostrarEstadoSistema();
        
        System.out.println("3. PROCESANDO TAREAS");
        Tarea t1 = gestor.procesarSiguienteTarea();
        System.out.println("Procesada: " + t1.getId());
        
        Tarea t2 = gestor.procesarSiguienteTarea();
        System.out.println("Procesada: " + t2.getId());
        
        Tarea t3 = gestor.procesarSiguienteTarea();
        System.out.println("Procesada: " + t3.getId());
        
        System.out.println("4. ESTADO FINAL");
        gestor.mostrarEstadoSistema();
        
        System.out.println("5. CONSULTANDO ESTADOS");
        System.out.println("T001: " + gestor.consultarEstadoTarea("T001"));
        System.out.println("T002: " + gestor.consultarEstadoTarea("T002"));
        System.out.println("T003: " + gestor.consultarEstadoTarea("T003"));
        System.out.println("T004: " + gestor.consultarEstadoTarea("T004"));
        System.out.println("T005: " + gestor.consultarEstadoTarea("T005"));
        
        System.out.println("6. TRAZABILIDAD");
        gestor.mostrarTrazabilidad();

        System.out.println("7. todas las tareas en arrylist");
        gestor.listarTareas();

        System.out.println("mostrars todas las tareas en el arrylisttoda");
        gestor.listarTareastoda();
    }
}