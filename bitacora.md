## Día 1 (9/11/2026)
- Qué hicimos: Hoy realizamos el tablón de Trello con el cronograma y todas las actividades pendientes, junto con la bitácora y el README.
- Quién hizo qué: Verónica realizo el cronograma en Trello, mientras que Bautista y Santiago hicieron la parte del repositorio que incluye la bitácora y el archivo README
- Qué nos trabó: La interfaz de Github.
- Qué sigue: Mañana realizaremos parte del código del programa que permitirá organizar a los pacientes por urgencia.
- Captura del tablero: <img width="1425" height="663" alt="Trello-dia1" src="https://github.com/user-attachments/assets/42ceba75-fe6b-4831-bc4b-c3830dd1fc2c" />

## Día 2 (10/11/2026)
- Qué hicimos: Se creo la carpeta docs, con el archivo de análisis para comenzar a mostrar el diagrama de clases, modelo  de datos, etc.
- Quién hizo qué: Santiago Giustolisi, se encargó de la creación de las carpetas indicadas.
- Qué nos trabó: Establecer que colocar en los archivos dentro de docs, en análisis, modelos de datos.
- Qué sigue: Comenzar a crear carpeta /src donde se comenzara a desarrollar el código correspondiente al sistema, además se va a realizar un diagrama de clases, modelo de datos o bocetos dentro de la carpeta docs.
  - Captura del tablero: <img width="1000" height="557" alt="Trello-dia2" src="https://github.com/user-attachments/assets/1c58aacc-fce2-4213-9722-3dc7f24b3bca" />


## Día 2 (10/11/2026) – Turnos normales con Queue

- Qué hicimos: Avanzamos en el desarrollo del sistema de gestión clínica en Java. Implementamos y probamos la gestión de turnos normales mediante la estructura Queue<Turno> utilizando ArrayDeque. Verificamos el funcionamiento de los métodos offer() y poll(), respetando el orden FIFO (primero en entrar, primero en salir).

- Quién hizo qué: Verónica Soledad González trabajó en la implementación y prueba de los turnos normales, revisó la compatibilidad de las clases Paciente, Turno y SistemaClinica, creó la rama Turnos-Normales en GitHub y subió la clase Turno.java al repositorio remoto.

- Qué nos trabó: Encontramos dificultades al importar el repositorio en Eclipse, corregir la extensión del archivo `Turno.java` y configurar la autenticación de GitHub para subir los cambios. Logramos resolver estos inconvenientes.

- Qué sigue:Continuaremos con la integración de Queue<Turno> en la versión compartida de SistemaClinica.java, coordinaremos los cambios con los demás integrantes y prepararemos la Pull Request para incorporar el trabajo a la rama principal.
 <img width="1207" height="586" alt="image" src="https://github.com/user-attachments/assets/5eb7eef2-b085-4471-9f75-5a199c4309b8" />
 
## Día 3 (11/11/2026)
- Qué hicimos: Se realizo el diseño del sistema, el diagrama de clases y se creó la carpeta src con las clases Main, Paciente, Turno y SistemaClinica.
- Quién hizo qué: Santiago se encargó de redactar el documento con el diseño del sistema, Verónica realizó el diagrama de clases y Bautista creó la carpeta src con sus clases.
- Qué nos trabó: Nos costó un poco armar el diseño del sistema, pero pudimos hacerlo sin mucho problema.
- Qué sigue: A partir de mañana nos centraremos en escribir el código.
 - Captura del tablero: <img width="1228" height="712" alt="image" src="https://github.com/user-attachments/assets/516247af-0c02-418e-a7ba-28689328588c" />

 ## Día 4 (12/11/2026)
- Qué hicimos: Se programó la gestión de urgencias utilizando PriorityQueue junto con un Comparator para ordenar por gravedad y desempatar por orden de llegada, además de corregir las extensiones .java y realizar las pruebas en consola.
- Quién hizo qué: Santiago se encargó de completar la clase Turno, implementar el Comparator en SistemaClinica y ejecutar las pruebas desde Main.java.
- Qué nos trabó: Configurar el entorno para ejecutar Java y corregir los archivos que no tenían la extensión .java asignada.
- Qué sigue: Implementar la cola de turnos normales con Queue, el historial de deshacer con Stack y armar el menú interactivo de consola.
 - Captura del tablero: <<img width="1572" height="853" alt="image" src="https://github.com/user-attachments/assets/47565a51-5a84-471c-b1a6-bb69052fd7b3" />


