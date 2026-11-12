
public class Turno {

    private Paciente paciente;
    private int prioridad;
    private long orden;
    private boolean urgente;

    public Turno(Paciente paciente, int prioridad,
                 long orden, boolean urgente) {
        this.paciente = paciente;
        this.prioridad = prioridad;
        this.orden = orden;
        this.urgente = urgente;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public long getOrden() {
        return orden;
    }

    public boolean isUrgente() {
        return urgente;
    }

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
