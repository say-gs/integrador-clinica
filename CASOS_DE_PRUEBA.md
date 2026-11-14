# Casos de prueba - Sistema de Gestión de Clínica

## CP-01: Registro de paciente

**Objetivo:** Verificar que el sistema permita registrar un paciente nuevo.

**Datos de prueba:**
- Nombre: María López
- DNI: 12345678
- Edad: 35

**Pasos:**
1. Ejecutar Main.java.
2. Seleccionar la opción 1: Registrar nuevo paciente.
3. Ingresar los datos del paciente.
4. Confirmar el registro.

**Resultado esperado:** El sistema registra correctamente al paciente.

**Resultado obtenido:** El paciente fue registrado correctamente.

**Estado:** APROBADO


## CP-02: Registro de DNI duplicado

**Objetivo:** Verificar que HashSet impida registrar dos pacientes con el mismo DNI.

**Precondición:** María López ya está registrada con DNI 12345678.

**Pasos:**
1. Ejecutar Main.java.
2. Seleccionar la opción 1: Registrar nuevo paciente.
3. Ingresar el DNI 12345678.
4. Observar la respuesta del sistema.

**Resultado esperado:** El sistema rechaza el registro porque el DNI ya existe.

**Resultado obtenido:** El sistema mostró el mensaje "El DNI ya está registrado".

**Estado:** APROBADO


## CP-03: Atención de turnos normales (FIFO)

**Objetivo:** Verificar que Queue atienda los turnos normales en el mismo orden en que fueron asignados.

**Precondición:** María López y Pedro Gómez están registrados en el sistema.

**Datos de prueba:**
- María López - DNI: 12345678
- Pedro Gómez - DNI: 87654321

**Pasos:**
1. Seleccionar la opción 2: Asignar turno normal.
2. Asignar un turno a María López.
3. Asignar un turno a Pedro Gómez.
4. Seleccionar la opción 4: Atender siguiente paciente.
5. Repetir la opción 4 para atender al siguiente.

**Resultado esperado:** María López debe ser atendida primero y Pedro Gómez después.

**Resultado obtenido:** El sistema atendió primero a María López y luego a Pedro Gómez.

**Estado:** APROBADO


## CP-04: Atención de urgencias según prioridad

**Objetivo:** Verificar que PriorityQueue atienda primero al paciente con mayor prioridad de urgencia.

**Precondición:** Carlos Ruiz y Laura Fernández están registrados en el sistema.

**Datos de prueba:**
- Carlos Ruiz - DNI: 33445566 - Prioridad: 1 (baja)
- Laura Fernández - DNI: 44556677 - Prioridad: 3 (alta)

**Pasos:**
1. Seleccionar la opción 3: Asignar turno de urgencia.
2. Asignar un turno a Carlos Ruiz con prioridad 1.
3. Asignar un turno a Laura Fernández con prioridad 3.
4. Seleccionar la opción 4: Atender siguiente paciente.
5. Repetir la opción 4 para atender al siguiente paciente.

**Resultado esperado:** Laura Fernández debe ser atendida primero por tener prioridad 3, seguida de Carlos Ruiz con prioridad 1.

**Resultado obtenido:** El sistema atendió primero a Laura Fernández y después a Carlos Ruiz.

**Estado:** APROBADO


## CP-05: Urgencias con igual prioridad

**Objetivo:** Verificar que PriorityQueue respete el orden de llegada cuando dos pacientes tienen la misma prioridad.

**Precondición:** María López y Pedro Gómez están registrados en el sistema.

**Datos de prueba:**
- María López - DNI: 12345678 - Prioridad: 2 (media)
- Pedro Gómez - DNI: 87654321 - Prioridad: 2 (media)

**Pasos:**
1. Seleccionar la opción 3: Asignar turno de urgencia.
2. Asignar un turno a María López con prioridad 2.
3. Asignar un turno a Pedro Gómez con prioridad 2.
4. Seleccionar la opción 4: Atender siguiente paciente.
5. Repetir la opción 4 para atender al siguiente paciente.

**Resultado esperado:** María López debe ser atendida primero y Pedro Gómez después, porque ambos tienen la misma prioridad y María recibió su turno antes.

**Resultado obtenido:** El sistema atendió primero a María López y luego a Pedro Gómez.

**Estado:** APROBADO


## CP-06: Deshacer una atención con Stack

**Objetivo:** Verificar que Stack permita deshacer la atención de un paciente y restaurar su turno pendiente.

**Precondición:** María López está registrada en el sistema.

**Datos de prueba:**
- María López - DNI: 12345678
- Tipo de turno: Normal

**Pasos:**
1. Seleccionar la opción 2: Asignar turno normal.
2. Asignar un turno a María López.
3. Seleccionar la opción 4: Atender siguiente paciente.
4. Verificar que María López fue atendida.
5. Seleccionar la opción 5: Deshacer última acción.
6. Seleccionar nuevamente la opción 4: Atender siguiente paciente.

**Resultado esperado:** El sistema debe restaurar el turno de María López y permitir atenderla nuevamente.

**Resultado obtenido:** Después de deshacer la atención, María López volvió a aparecer al seleccionar la opción 4.

**Estado:** APROBADO


## CP-07: Deshacer la asignación de un turno

**Objetivo:** Verificar que Stack permita deshacer la última asignación de turno sin eliminar otros turnos pendientes.

**Precondición:** María López y Pedro Gómez están registrados en el sistema.

**Datos de prueba:**
- María López - DNI: 12345678
- Pedro Gómez - DNI: 87654321
- Tipo de turno: Normal

**Pasos:**
1. Tener un turno normal pendiente de María López.
2. Seleccionar la opción 2: Asignar turno normal.
3. Asignar un turno a Pedro Gómez.
4. Seleccionar la opción 5: Deshacer última acción.
5. Seleccionar la opción 4: Atender siguiente paciente.
6. Seleccionar nuevamente la opción 4.

**Resultado esperado:** El turno de Pedro Gómez debe cancelarse, mientras que el turno pendiente de María López debe conservarse.

**Resultado obtenido:** El sistema atendió a María López y después mostró "No hay turnos pendientes". Pedro Gómez no fue atendido.

**Estado:** APROBADO


## CP-08: Asignación de turno a paciente no registrado

**Objetivo:** Verificar que el sistema impida asignar turnos a pacientes que no están registrados.

**Precondición:** El DNI 87654321 no está registrado en el sistema al momento de ejecutar la prueba.

**Datos de prueba:**
- DNI: 87654321
- Tipo de turno: Normal

**Pasos:**
1. Ejecutar Main.java sin registrar previamente al paciente.
2. Seleccionar la opción 2: Asignar turno normal.
3. Ingresar el DNI 87654321.
4. Observar el mensaje del sistema.

**Resultado esperado:** El sistema debe impedir la asignación del turno e indicar que el paciente no está registrado.

**Resultado obtenido:** El sistema mostró el mensaje "Paciente no encontrado. Primero hay que agregarlo".

**Estado:** APROBADO


## CP-09: Atención sin turnos pendientes

**Objetivo:** Verificar que el sistema informe correctamente cuando no existen turnos pendientes.

**Precondición:** Las colas de turnos normales y urgentes están vacías.

**Pasos:**
1. Ejecutar Main.java con las colas de turnos vacías.
2. Seleccionar la opción 4: Atender siguiente paciente.
3. Observar el mensaje mostrado en la consola.

**Resultado esperado:** El sistema debe informar que no hay turnos pendientes, sin generar errores.

**Resultado obtenido:** El sistema mostró el mensaje "No hay turnos pendientes".

**Estado:** APROBADO


## CP-10: Atención de urgencias antes que turnos normales

**Objetivo:** Verificar que el sistema atienda los turnos urgentes antes que los normales, independientemente del orden de asignación.

**Precondición:** María López y Carlos Ruiz están registrados en el sistema.

**Datos de prueba:**
- María López - DNI: 12345678 - Turno normal
- Carlos Ruiz - DNI: 33445566 - Turno urgente - Prioridad: 1 (baja)

**Pasos:**
1. Seleccionar la opción 2: Asignar turno normal.
2. Asignar un turno a María López.
3. Seleccionar la opción 3: Asignar turno de urgencia.
4. Asignar un turno a Carlos Ruiz con prioridad 1.
5. Seleccionar la opción 4: Atender siguiente paciente.
6. Seleccionar nuevamente la opción 4.

**Resultado esperado:** Carlos Ruiz debe ser atendido primero por tener un turno urgente. Después debe ser atendida María López.

**Resultado obtenido:** El sistema atendió primero a Carlos Ruiz y después a María López.

**Estado:** APROBADO