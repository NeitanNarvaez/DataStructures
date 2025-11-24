import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class GestorTareas {
    
    private Queue<Tarea> colaEspera;
    private Stack<Tarea> pilaPrioritaria;
    private Map<String, String> mapaTrazabilidad;

    public GestorTareas(){
        colaEspera = new LinkedList<>();
        pilaPrioritaria = new Stack<>();
        mapaTrazabilidad = new HashMap<>();
    }
    
    public void agregarTarea(Tarea tarea){
        if(tarea.getPrioridad() == 3){
            pilaPrioritaria.push(tarea);
        } else {
            colaEspera.offer(tarea);
        }
    }
    
    public Tarea procesarSiguienteTarea(){
        Tarea tareaProcesada = null;
        
        if(!pilaPrioritaria.empty()){
            tareaProcesada = pilaPrioritaria.pop();
        }
        else if(!colaEspera.isEmpty()){
            tareaProcesada = colaEspera.poll();
        }
        else {
            return null;
        }
        
        long tiempoProcesamiento = System.currentTimeMillis();
        String registro = "Completada - TiempoLlegada: " + tareaProcesada.getTiempoLlegada() + 
                         " - TiempoProcesamiento: " + tiempoProcesamiento;
        mapaTrazabilidad.put(tareaProcesada.getId(), registro);
        
        return tareaProcesada;
    }
    
    
    
    public String consultarEstadoTarea(String idTarea){
        if(mapaTrazabilidad.containsKey(idTarea)){
            return "Completada";
        }
        
        Stack<Tarea> tempPila = new Stack<>();
        boolean enPila = false;
        
        while(!pilaPrioritaria.empty()){
            Tarea tarea = pilaPrioritaria.pop();
            tempPila.push(tarea);
            if(tarea.getId().equals(idTarea)){
                enPila = true;
            }
        }
        
        while(!tempPila.empty()){
            pilaPrioritaria.push(tempPila.pop());
        }
        
        if(enPila){
            return "Pendiente en Pila Prioritaria";
        }
        
        Queue<Tarea> tempCola = new LinkedList<>();
        boolean enCola = false;
        
        while(!colaEspera.isEmpty()){
            Tarea tarea = colaEspera.poll();
            tempCola.offer(tarea);
            if(tarea.getId().equals(idTarea)){
                enCola = true;
            }
        }
        
        while(!tempCola.isEmpty()){
            colaEspera.offer(tempCola.poll());
        }
        
        if(enCola){
            return "Pendiente en Cola de Espera";
        }
        
        return "ID no encontrado";
    }
    
    public void mostrarEstadoSistema(){
        System.out.println("Tareas en Pila Prioritaria: " + pilaPrioritaria.size());
        System.out.println("Tareas en Cola de Espera: " + colaEspera.size());
        System.out.println("Tareas Completadas: " + mapaTrazabilidad.size());
    }
    
    public void mostrarTrazabilidad(){
        System.out.println(" trazabilidad de las tareas completas ");
        for(Map.Entry<String, String> entry : mapaTrazabilidad.entrySet()){
            System.out.println("ID: " + entry.getKey() + " -> " + entry.getValue());
        }
    }
    public void listarTareas(){

        ArrayList<Tarea> listaTareas = new ArrayList<>();
        listaTareas.addAll(colaEspera);
        listaTareas.addAll(pilaPrioritaria);
        System.out.println("mostrar todas las tareas ");
        for(Tarea tarea : listaTareas){
            System.out.println("el id de la tarea es : " + tarea.getId() + " la prioridad es: " + tarea.getPrioridad());
        }
    }
     public void listarTareastoda(){

        ArrayList<Tarea> listaTareas = new ArrayList<>();
        listaTareas.addAll(colaEspera);
        listaTareas.addAll(pilaPrioritaria);
        System.out.println("tareas pendinetes.");
        for(Tarea tarea : listaTareas){
            System.out.println("ID: " + tarea.getId() + ", Prioridad: " + tarea.getPrioridad());
        }

        System.out.println("todas las tareas completadas");
        for (Map.Entry<String, String> entry : mapaTrazabilidad.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " ---- " + entry.getValue());
        }
    }
}
