# Clínica San Bernardito
**Integrantes:** Verónica Soledad Gonzáles (Sole-Gonzales), Bautista Valentín Sayhueque Garcia Segovia (say-gs), Santiago Giustolisi (SantiagoGiustolisi)

**Tablero Kanban:** https://trello.com/b/SCooz2G8

## Descripción del negocio
La clínica San Bernardito es una institución dedicada a brindar servicios de atención médica, ofreciendo asistencia profesional y personalizada para cada paciente.

## Problema que resuelve
Nuestro programa se encargará de organizar y gestionar a los pacientes y sus turnos médicos. 
Este sistema permite llevar un registro de los pacientes mediante su DNI, asignarles turnos normales o urgentes, organizar las prioridades de atención y consultar los turnos pendientes.

## Tema elegido
Clase 8: Sets, Queues & Stacks. Elegimos este tema porque nos gustó la idea de realizar un programa que pudiera organizar los turnos de pacientes que cuando tuvieran una urgencia, el mismo programa les dé prioridad por sobre pacientes que solo vienen por chequeos regulares.

## Tecnologías
-Eclipse, Java
-Trello


## Requisitos

Para ejecutar el sistema se necesita:

- Java JDK instalado.
- Eclipse IDE con soporte para Java.
- Git (opcional, para clonar el repositorio).

## Instalación

1. Ingresar al repositorio: https://github.com/say-gs/integrador-clinica
2. Seleccionar **Code → Download ZIP**.
3. Descomprimir el archivo descargado.
4. Abrir Eclipse IDE.
5. Seleccionar **File → Import → General → Existing Projects into Workspace**.
6. Elegir la carpeta descomprimida del proyecto y finalizar la importación.

## Ejecución

1. En Eclipse, abrir la carpeta `src`.
2. Buscar el archivo `Main.java`.
3. Hacer clic derecho sobre `Main.java`.
4. Seleccionar **Run As → Java Application**.
5. Utilizar el menú de la consola para interactuar con el sistema.

## Funcionalidades

El sistema permite:

1. Registrar pacientes evitando DNI duplicados.
2. Asignar turnos normales por orden de llegada (FIFO).
3. Asignar turnos urgentes según su prioridad.
4. Atender al siguiente paciente, priorizando las urgencias.
5. Deshacer la última operación registrada.
6. Salir del sistema.