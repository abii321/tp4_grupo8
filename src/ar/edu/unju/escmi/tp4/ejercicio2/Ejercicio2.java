package ar.edu.unju.escmi.tp4.ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nombres = new String[5];

        // Cargar nombres
        System.out.println("Ingrese 5 nombres:");
        for (int i = 0; i < nombres.length; i++) {
            System.out.print("Nombre " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();
        }

        // Buscar nombre
        System.out.print("\nIngrese el nombre que desea buscar: ");
        String nombreBuscado = scanner.nextLine();
        boolean encontrado = false;

        for (String nombre : nombres) {
            if (nombre.equalsIgnoreCase(nombreBuscado)) {
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("El nombre \"" + nombreBuscado + "\" fue encontrado.");
        } else {
            System.out.println("El nombre \"" + nombreBuscado + "\" no está en la lista.");
        }

        scanner.close();
    }
}