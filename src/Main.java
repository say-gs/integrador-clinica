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
        System.out.println("1° atendido: " + clinica.atenderUrgencia());
        System.out.println("2° atendido: " + clinica.atenderUrgencia());
        System.out.println("3° atendido: " + clinica.atenderUrgencia());
    }
}
