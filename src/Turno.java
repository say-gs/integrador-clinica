
public class Turno {

    // Atributos privados según el diagrama UML
    private Paciente paciente;
    private int prioridad;
    private long orden;
    private boolean urgente;

    // Constructor
    public Turno(Paciente paciente, int prioridad,
                 long orden, boolean urgente) {
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

    // Mostrar los datos del turno en consola
    @Override
    public String toString() {
        String tipo = urgente ? "URGENTE" : "NORMAL";

        return "Turno " + tipo
                + " | " + paciente.getNombre()
                + " | DNI: " + paciente.getDni()
                + " | Prioridad: " + prioridad
                + " | Orden: " + orden;
    }
}
