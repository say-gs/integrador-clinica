public class Turno {

    // Atributos privados según el diagrama UML
    private Paciente paciente;
    private int prioridad;
    private long orden;
    private boolean urgente;

    // Constructor
    public Turno(Paciente paciente, int prioridad, long orden, boolean urgente) {
        this.paciente = paciente;
        this.prioridad = prioridad;
        this.orden = orden;
        this.urgente = urgente;
    }

    // Getters
    public Paciente getPaciente() {
        return this.paciente;
    }

    public int getPrioridad() {
        return this.prioridad;
    }

    public long getOrden() {
        return this.orden;
    }

    public boolean isUrgente() {
        return this.urgente;
    }

    // Método toString para imprimir los datos claros en consola
    @Override
    public String toString() {
        return "Turno [Paciente=" + this.paciente.getNombre() + 
               ", Prioridad=" + this.prioridad + 
               ", Orden=" + this.orden + 
               ", Urgente=" + this.urgente + "]";
    }
}
