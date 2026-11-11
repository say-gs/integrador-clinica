## Análisis del Sistema de Gestión de Turnos Médicos

### 1. Contexto del Problema y Justificación
En el esquema operativo diario de la Clínica San Bernardito, la asignación manual o desorganizada de turnos impacta directamente en la calidad de la atención y en la salud de las personas. La saturación en salas de espera y la falta de un criterio automatizado para clasificar la gravedad de los pacientes en la guardia hacen crítico el desarrollo de esta herramienta.

Este programa resuelve la problemática central mediante la automatización del flujo de pacientes, asegurando que:
* Nadie pierda su lugar en la fila convencional.
* Las emergencias críticas sean detectadas y antepuestas según su nivel de riesgo.
* Los datos de identidad (DNI) sean consistentes y no sufran duplicaciones.

---

### 2. Actores del Sistema
* **Operador / Recepcionista:** Es el usuario principal que interactúa con la consola del sistema. Se encarga de registrar a los pacientes, asignar los turnos normales o urgentes, llamar al siguiente paciente para su atención y deshacer acciones si comete algún error de carga.

---

### 3. Reglas de Negocio Clave
1. **DNI Único:** No se puede registrar dos veces al mismo paciente. Cada persona se identifica únicamente por su DNI.
2. **Urgencias Primero:** Siempre se atiende antes a los pacientes de urgencia. Los turnos normales solo avanzan cuando no quedan urgencias en espera.
3. **Orden de Llegada:** Si hay dos urgencias con la misma gravedad, se atiende primero a quien haya llegado antes.
4. **Opción Deshacer:** Si el operador se equivoca al cargar un paciente o un turno, puede revertir la última acción realizada sin afectar al resto.

