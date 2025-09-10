package ar.edu.unju.escmi.tp4.ejercicio4;

public class Cliente {
    private int dni;
    private String nombre;
    private String tipoCliente;
    
    public Cliente(int dni, String nombre, String tipoCliente) {
        this.dni = dni;
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
    }

    public int getDni() {
        return dni;
    }
    public String getTipoCliente() {
        return tipoCliente;
    }

    @Override
    public String toString() {
        return "Cliente [dni=" + dni + ", nombre=" + nombre + ", tipoCliente=" + tipoCliente + "]";
    }
}
