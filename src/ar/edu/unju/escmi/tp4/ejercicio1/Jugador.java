package ar.edu.unju.escmi.tp4.ejercicio1;

public class Jugador {
    private String dni;
    private String nombre;
    private String equipo;
    private String nacionalidad;
    private double estatura;

    // Constructor por defecto
    public Jugador() {
        this.dni = "";
        this.nombre = "";
        this.equipo = "";
        this.nacionalidad = "";
        this.estatura = 0.0;
    }

    // Constructor parametrizado (opcionalmente útil)
    public Jugador(String dni, String nombre, String equipo, String nacionalidad, double estatura) {
        this.dni = dni;
        this.nombre = nombre;
        this.equipo = equipo;
        this.nacionalidad = nacionalidad;
        this.estatura = estatura;
    }

    // Getters y Setters
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEquipo() { return equipo; }
    public void setEquipo(String equipo) { this.equipo = equipo; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public double getEstatura() { return estatura; }
    public void setEstatura(double estatura) { this.estatura = estatura; }

    // Método para mostrar todos los datos del jugador
    public void mostrarDatos() {
        System.out.println("----- Jugador -----");
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Equipo: " + equipo);
        System.out.println("Nacionalidad: " + nacionalidad);
        System.out.println("Estatura: " + estatura);
    }

    @Override
    public String toString() {
        return "Jugador{dni='" + dni + "', nombre='" + nombre + "', equipo='" + equipo +
                "', nacionalidad='" + nacionalidad + "', estatura=" + estatura + "}";
    }
}
