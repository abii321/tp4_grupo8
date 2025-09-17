package ar.edu.unju.escmi.tp4.ejercicio3;
public class Paciente implements Comparable<Paciente> {
    private int dni;
    private String nombre;
    private String apellido;
    private int numeroHistoriaClinica;
    private String obraSocial;
    
    public Paciente() {
    }



    public int getDni() {
        return dni;
    }



    public void setDni(int dni) {
        this.dni = dni;
    }



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getApellido() {
        return apellido;
    }



    public void setApellido(String apellido) {
        this.apellido = apellido;
    }



    public int getNumeroHistoriaClinica() {
        return numeroHistoriaClinica;
    }



    public void setNumeroHistoriaClinica(int numeroHistoriaClinica) {
        this.numeroHistoriaClinica = numeroHistoriaClinica;
    }



    public String getObraSocial() {
        return obraSocial;
    }



    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public void mostrarDatos(){
        System.out.println("\nDNI del Paciente: "+dni+"\nNombre del Paciente: "+nombre+"\nApellido del Paciente: "+apellido+"\nNumero de Historia Clinica: "+ numeroHistoriaClinica+"\nObra Social: "+obraSocial);
    }

    @Override
    public int compareTo(Paciente obj) {
        if(this.numeroHistoriaClinica > obj.getNumeroHistoriaClinica())
            return 1;
        else if(this.numeroHistoriaClinica < obj.getNumeroHistoriaClinica())
            return -1;
        return 0;
    }
    @Override
    public String toString() {
        return "Paciente{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", numeroHistoriaClinica=" + numeroHistoriaClinica +
                ", obraSocial='" + obraSocial + '\'' +
                '}';
    }
    
}