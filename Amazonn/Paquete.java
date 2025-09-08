package Amazonn;

class Paquete {
    private String destinatario;
    private String fechaIngreso;

    public Paquete(String destinatario, String fechaIngreso) {
        this.destinatario = destinatario;
        this.fechaIngreso = fechaIngreso;
    }

    public String toString() {
        return "Destinatario: " + destinatario + ", Fecha: " + fechaIngreso;
    }
}
