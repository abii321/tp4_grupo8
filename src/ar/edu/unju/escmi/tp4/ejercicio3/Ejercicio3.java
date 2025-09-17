package ar.edu.unju.escmi.tp4.ejercicio3;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Paciente> pacientes = new TreeSet<>();
        byte op;
        do {
            System.out.println("\n **** Menú de Opciones ****");
            System.out.println("1 - Alta de paciente");
            System.out.println("2 - Mostrar todos los pacientes");
            System.out.println("3 - Mostrar el paciente que se encuentra en la mitad de la lista");
            System.out.println("4 - Mostrar el primer paciente de la lista");
            System.out.println("5 - Mostrar el último paciente de la lista");
            System.out.println("6 - Filtrar por historia clínica");
            System.out.println("7 - Salir");
            System.out.print("Ingrese una opción: ");
            op = sc.nextByte();
            sc.nextLine(); // limpiar buffer

            switch (op) {
                case 1: // Alta de paciente
                    Paciente nuevoPaciente = new Paciente(); // usar constructor por defecto
                    System.out.print("Ingrese DNI: ");
                    nuevoPaciente.setDni(sc.nextInt());
                    sc.nextLine();//Limpiar el buffer
                    System.out.print("Ingrese Nombre: ");
                    nuevoPaciente.setNombre(sc.nextLine());
                    System.out.print("Ingrese Apellido: ");
                    nuevoPaciente.setApellido(sc.nextLine());
                    System.out.print("Ingrese Numero de Historia Clinica: ");
                    nuevoPaciente.setNumeroHistoriaClinica(sc.nextInt());
                    sc.nextLine();//Limpiar el buffer
                    System.out.print("Ingrese Obra Social: ");
                    nuevoPaciente.setObraSocial(sc.nextLine());

                    pacientes.add(nuevoPaciente);
                    System.out.println("Paciente Agregado Correctamente");
                    break;

                case 2: // Mostrar los pacientes
                    pacientes.stream().forEach(System.out::println);
                    break;

                case 3: // Mostrar el paciente que está en la mitad de la lista
                    int indiceMitad = pacientes.size() / 2;
                    int indice = 0;
                    Paciente pacienteDeLaMitad = null;
                    for (Paciente p : pacientes){
                        if ( indice == indiceMitad ){
                         pacienteDeLaMitad = p;
                            break;
                        }
                        indice++;
                    }
                    if ( pacienteDeLaMitad != null )
                        System.out.println(pacienteDeLaMitad);
                    else
                        System.out.println("No hay pacientes suficientes para encontrar la mitad");
                    break;

                case 4: // Mostrar el primer paciente de la lista
                    Paciente primerPaciente = ((TreeSet<Paciente>) pacientes).first(); // Cast de Set a TreeSet para acceder a métodos específicos como first()
                    System.out.println(primerPaciente);
                    break;

                case 5: // Mostrar el ultimo paciente de la lista
                    Paciente ultimoPaciente = ((TreeSet<Paciente>) pacientes).last(); // Cast de Set a TreeSet para acceder a métodos específicos como last()
                    System.out.println(ultimoPaciente);
                    break;

                case 6: // Filtrar pacientes por el Numero de Historia Clinica
                    System.out.print("Ingrese Numero de Historia Clinica a filtrar (Se mostraran mayores a ese numero): ");
                    int numeroFiltroHistoriaClinica = sc.nextInt();
                    pacientes.stream().filter(n -> n.getNumeroHistoriaClinica() > numeroFiltroHistoriaClinica).forEach(System.out::println);
                    break;

                case 7:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (op != 7);

        sc.close();
    }
}