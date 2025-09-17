package ar.edu.unju.escmi.tp4.ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[5];

        // Cargar el array
        System.out.println("Ingrese 5 números enteros:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        // Mostrar el array
        System.out.println("\nLos números ingresados son:");
        for (int num : numeros) {
            System.out.println(num);
        }

        scanner.close();}
}