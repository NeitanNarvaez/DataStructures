public class Tarea {
    
    private String id;
    private String descripcion;
    private int prioridad;
    private long tiempoLlegada;  // Usamos long para el timestamp
    
    // Constructor
    public Tarea(String id, String descripcion, int prioridad, long tiempoLlegada) {
        this.id = id;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.tiempoLlegada = tiempoLlegada;
    }
    
    // Getters
    public String getId() {
        return id;
    }
    
    public int getPrioridad() {
        return prioridad;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public long getTiempoLlegada() {
        return tiempoLlegada;
    }
    
    // toString()
    public String toString() {
        return "Tarea { id: " + id + " Descripción: " + descripcion + 
               " Prioridad: " + prioridad + " TiempoLlegada: " + tiempoLlegada + " }";
    }
}