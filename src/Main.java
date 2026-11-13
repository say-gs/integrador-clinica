public class Main {
    public static void main(String[] args) {
        SistemaClinica clinica = new SistemaClinica();

        // 1. Registramos tres pacientes
        clinica.registrarPaciente("111", "Juan (Leve)", 30);
        clinica.registrarPaciente("222", "Ana (Crítica 1)", 45);
        clinica.registrarPaciente("333", "Luis (Crítica 2)", 25);

        // 2. Cargamos urgencias en desorden de gravedad
        clinica.agregarTurnoUrgente("111", 1); // Juan llega primero, pero es leve (prioridad 1)
        clinica.agregarTurnoUrgente("222", 3); // Ana es crítica (prioridad 3)
        clinica.agregarTurnoUrgente("333", 3); // Luis también es crítico (empata con Ana, pero llegó después)

        // 3. Mostramos el orden en el que los llama el sistema

        System.out.println("1° atendido: " + clinica.atenderSiguiente());
        System.out.println("2° atendido: " + clinica.atenderSiguiente());
        System.out.println("3° atendido: " + clinica.atenderSiguiente());



        // PRUEBA DE TURNOS NORMALES - QUEUE FIFO
        clinica.registrarPaciente("444", "María", 40);
        clinica.registrarPaciente("555", "Pedro", 35);
        clinica.registrarPaciente("666", "Lucía", 28);

        clinica.agregarTurnoNormal("444");
        clinica.agregarTurnoNormal("555");
        clinica.agregarTurnoNormal("666");

        System.out.println("\n--- TURNOS NORMALES ---");

        System.out.println("1° atendido: " + clinica.atenderTurnoNormal());
        System.out.println("2° atendido: " + clinica.atenderTurnoNormal());
        System.out.println("3° atendido: " + clinica.atenderTurnoNormal());

        System.out.println("\n--- PRUEBA DE DESHACER ---");

        clinica.agregarTurnoNormal("444");
        clinica.deshacer();

        System.out.println("Siguiente turno normal: "
        + clinica.atenderTurnoNormal());

    } // Cierra el método main
} // Cierra la clase Main

    

