public class Paciente {

    //Atributos que almacenan los datos del paciente
    private String dni;
    private String nombre;
    private int edad;

    //Constructor: permite crear un los datos del paciente
    public Paciente(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    //Devuelve el dni del paciente
    public String getDni() {
        return this.dni;
    }

    //Devuelve el nombre del paciente
    public String getNombre() {
        return this.nombre;
    }

    //Devuelve la edad del paciente
    public int getEdad() {
        return this.edad;
    }

    //toString para imprimir los datos en la consola

    @Override
    public String toString() {
    return "Paciente [DNI: " + dni
            + " | Nombre: " + nombre
            + " | Edad: " + edad + "]";
}

}
