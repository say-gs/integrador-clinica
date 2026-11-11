# Diseño del Sistema - Clínica San Bernardito

Para organizar el programa dividimos el proyecto en distintas clases según lo que hace cada parte:

* **Paciente:** Guarda los datos básicos de cada persona (`dni`, `nombre` y `edad`) como atributos privados, con su constructor, sus *getters* (`getDni`, `getNombre`, `getEdad`) y `toString()`.
* **Turno:** Representa cada turno médico. Guarda el `paciente` al que pertenece, su nivel de `prioridad`, el `orden` de llegada y si es `urgente` o no, junto con sus *getters* y `toString()`.
* **SistemaClinica:** Es el motor principal del proyecto. Registra pacientes, administra los turnos normales y urgentes, atiende al siguiente en espera, muestra los listados y permite deshacer la última acción.
* **Main:** Es la clase principal que muestra el menú por consola para interactuar con el sistema.
* **PruebasClinica:** Clase aparte usada para ejecutar pruebas y verificar que todas las reglas de negocio funcionen bien.

## Diagrama de Clases
![Diagrama de Clases UML](./diagrama_clases.png)

## Elección de Colecciones (Java)
Dentro de `SistemaClinica` elegimos estas estructuras de datos de `java.util` para resolver cada regla de la clínica:

* **`Set<String> dnis` (`HashSet`):** Lo usamos para guardar los DNI sin que se repitan. Si alguien intenta registrar un DNI que ya existe, el sistema lo frena al instante.
* **`Map<String, Paciente> pacientes` (`HashMap`):** Nos sirve para buscar rápido a un paciente usando su DNI como clave.
* **`Deque<Turno> turnosNormales` (`ArrayDeque`):** Funciona como una fila común (el primero que llega es el primero que se atiende).
* **`PriorityQueue<Turno> turnosUrgentes`:** Ordena las urgencias solas según la gravedad. Si dos tienen la misma gravedad, pasa primero el que tiene menor número de `orden` (el que llegó antes).
* **`Stack<Runnable> historial`:** Funciona como una pila para el botón "deshacer". Guarda lo contrario a la última acción realizada para poder volver atrás si hay un error.
