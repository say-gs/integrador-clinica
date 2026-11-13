import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ArrayDeque;

public class SistemaClinica {

    // Set para evitar los DNI duplicados
    private Set<String> dnis = new HashSet<>();

    // Mapa para recuperar los pacientes por DNI
    private Map<String, Paciente> pacientes = new HashMap<>();
    
    // QUEUE: turnos normales en orden FIFO
    private Queue<Turno> turnosNormales = new ArrayDeque<>();
    
    // Comparator para ordenar las urgencias (prioridad alta primero, luego por orden de llegada)
    private Comparator<Turno> comparadorUrgencias = new Comparator<Turno>() {
        @Override
        public int compare(Turno t1, Turno t2) {
            // 1. Mayor prioridad va primero (ej: 3 antes que 1)
            int compPrioridad = Integer.compare(t2.getPrioridad(), t1.getPrioridad());
            if (compPrioridad != 0) {
                return compPrioridad;
            }
            // 2. Si empatan en gravedad, pasa el que llegó antes (menor orden)
            return Long.compare(t1.getOrden(), t2.getOrden());
        }
    };

    // Cola de prioridad para urgencias usando el Comparator
    private PriorityQueue<Turno> turnosUrgentes = new PriorityQueue<>(comparadorUrgencias);
    private long contadorOrden = 1;

    // Registrar un paciente nuevo
    public boolean registrarPaciente(String dni, String nombre, int edad) {
        if (dnis.contains(dni)) {
            return false;
        }
        dnis.add(dni);
        pacientes.put(dni, new Paciente(dni, nombre, edad));
        return true;
    }
  
    // Agregar un turno normal
    public boolean agregarTurnoNormal(String dni) {

        Paciente paciente = pacientes.get(dni);

        if (paciente == null) {
            System.out.println("Paciente no encontrado.");
            return false;
        }

        Turno turno = new Turno(
                paciente, 0, contadorOrden++, false);

        turnosNormales.offer(turno);

        System.out.println("Turno normal agregado.");
        return true;
    }
  
    // Atender turnos normales respetando FIFO
    public Turno atenderTurnoNormal() {
        return turnosNormales.poll();
    }
    // Agregar un turno a la cola de urgencias
    public boolean agregarTurnoUrgente(String dni, int prioridad) {
        Paciente p = pacientes.get(dni);
        if (p == null) {
            System.out.println("Paciente no encontrado.");
            return false;
        }
        Turno nuevoTurno = new Turno(p, prioridad, contadorOrden++, true);
        turnosUrgentes.add(nuevoTurno);
        return true;
    }

    // Atender la siguiente urgencia
    public Turno atenderUrgencia() {
        return turnosUrgentes.poll();
    }
}
