import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SistemaClinica clinica = new SistemaClinica();
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        System.out.println("=== BIENVENIDO A CLÍNICA SAN BERNARDITO ===");

        while (opcion != 0) {
            mostrarMenu();
            opcion = leerEntero(scanner, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    // Módulo 1: Registro de paciente (Set y Map)
                    System.out.println("\n--- REGISTRAR PACIENTE ---");
                    String dniReg = leerTextoNoVacio(scanner, "Ingrese DNI: ");
                    String nombre = leerTextoNoVacio(scanner, "Ingrese Nombre completo: ");
                    int edad = leerEnteroPositivo(scanner, "Ingrese Edad: ");
                    
                    clinica.registrarPaciente(dniReg, nombre, edad);
                    break;

                case 2:
                    // Módulo 2: Turno Normal (Queue FIFO)
                    System.out.println("\n--- ASIGNAR TURNO NORMAL ---");
                    String dniNormal = leerTextoNoVacio(scanner, "Ingrese DNI del paciente: ");
                    clinica.agregarTurnoNormal(dniNormal);
                    break;

                case 3:
                    // Módulo 3: Turno Urgente (PriorityQueue)
                    System.out.println("\n--- ASIGNAR TURNO DE URGENCIA ---");
                    String dniUrgente = leerTextoNoVacio(scanner, "Ingrese DNI del paciente: ");
                    int prioridad = leerPrioridad(scanner);
                    clinica.agregarTurnoUrgente(dniUrgente, prioridad);
                    break;

                case 4:
                    // Módulo 4: Atender siguiente (Prioriza urgencias sobre normales)
                    System.out.println("\n--- ATENDER SIGUIENTE PACIENTE ---");
                    clinica.atenderSiguiente();
                    break;

                case 5:
                    // Módulo 5: Deshacer última acción (Stack)
                    System.out.println("\n--- DESHACER ÚLTIMA ACCIÓN ---");
                    clinica.deshacer();
                    break;

                case 0:
                    System.out.println("\nCerrando sistema... ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Error: Opción no válida. Elija un número del 0 al 5.");
                    break;
            }
        }

        scanner.close();
    }

    // --- MÉTODOS AUXILIARES Y DE VALIDACIÓN ---

    private static void mostrarMenu() {
        System.out.println("\n=========================================");
        System.out.println("      MENÚ PRINCIPAL - CLÍNICA");
        System.out.println("=========================================");
        System.out.println("1. Registrar nuevo paciente");
        System.out.println("2. Asignar turno normal");
        System.out.println("3. Asignar turno de urgencia");
        System.out.println("4. Atender siguiente paciente");
        System.out.println("5. Deshacer última acción");
        System.out.println("0. Salir");
        System.out.println("-----------------------------------------");
    }

    // Valida que el usuario escriba un texto y no deje el campo vacío
    private static String leerTextoNoVacio(Scanner scanner, String mensaje) {
        String entrada = "";
        while (entrada.isEmpty()) {
            System.out.print(mensaje);
            entrada = scanner.nextLine().trim();
            if (entrada.isEmpty()) {
                System.out.println("Error: Este campo no puede quedar vacío.");
            }
        }
        return entrada;
    }

    // Valida que el usuario ingrese un número entero sin romper el programa si pone letras
    private static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.");
            }
        }
    }

    // Valida que la edad sea mayor a 0
    private static int leerEnteroPositivo(Scanner scanner, String mensaje) {
        while (true) {
            int numero = leerEntero(scanner, mensaje);
            if (numero > 0 && numero <= 120) {
                return numero;
            }
            System.out.println("Error: Ingrese una edad válida (entre 1 y 120).");
        }
    }

    // Valida que la prioridad esté dentro de la escala (1 = Baja, 2 = Media, 3 = Alta)
    private static int leerPrioridad(Scanner scanner) {
        while (true) {
            int p = leerEntero(scanner, "Ingrese nivel de prioridad (1 = Baja, 2 = Media, 3 = Alta): ");
            if (p >= 1 && p <= 3) {
                return p;
            }
            System.out.println("Error: La prioridad debe ser 1, 2 o 3.");
        }
    }
}
