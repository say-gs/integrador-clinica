import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
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

    // Historial para poder deshacer acciones
    private Stack<Runnable> historial = new Stack <>();
    
    // Cola de prioridad para urgencias usando el Comparator
    private PriorityQueue<Turno> turnosUrgentes = new PriorityQueue<>(comparadorUrgencias);
    private long contadorOrden = 1;

    // Registrar un paciente nuevo
    public boolean registrarPaciente(String dni, String nombre, int edad) {
        if (dnis.contains(dni)) {

            System.out.println("El DNI ya esta registrado.");
            return false;
        }
        
        dnis.add(dni);
        pacientes.put(dni, new Paciente(dni, nombre, edad));

        historial.push(() -> {
            dnis.remove(dni);
            pacientes.remove(dni);
        });
            
        System.out.println("Paciente registrado correctamente.");
            return true; 
    }

    // Agregar un turno normal
    public boolean agregarTurnoNormal(String dni) {

    Paciente p = pacientes.get(dni);

    if (p == null) {
        System.out.println("Paciente no encontrado.");
            return false;
    }
    Turno nuevoTurno = new Turno(p, 0, contadorOrden++, false);
        turnosNormales.add(nuevoTurno);
        historial.push(() -> turnosNormales.remove(nuevoTurno));

        System.out.println("Turno agregado.");
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
        historial.push(() -> turnosUrgentes.remove(nuevoTurno));

        System.out.println("Turno urgente agregado.");
            return true;
    }

    // Atender al sigiuiente paciente
    public Turno atenderSiguiente() {

        // Primero se atienden urgencias
        if (!turnosUrgentes.isEmpty()) {
        
            Turno nuevoTurno = turnosUrgentes.poll();

            historial.push(() -> turnosUrgentes.offer(nuevoTurno));

            System.out.println("Atendiendo urgencia:");
            System.out.println(nuevoTurno);
            return nuevoTurno;
        }

        // Si no hay urgencias, se atienden los turnos normales
        if (!turnosNormales.isEmpty()) {

            Turno nuevoTurno = turnosNormales.poll();

            historial.push(() -> {
                ArrayDeque<Turno> cola = (ArrayDeque<Turno>) turnosNormales;
                cola.addFirst(nuevoTurno);
            });

            System.out.println("Atendiendo turno normal:");
            System.out.println(nuevoTurno);
            return nuevoTurno;
        }

        System.out.println("No hay turnos pendientes.");
        return null;
    }

    // Deshacer la última operación realizada
    public void deshacer() {

        if (historial.isEmpty()) {
            System.out.println("No hay operaciones para deshacer.");
            return;
        }

        Runnable accion = historial.pop();
        accion.run();

        System.out.println("Última operación deshecha correctamente.");
    }
}
