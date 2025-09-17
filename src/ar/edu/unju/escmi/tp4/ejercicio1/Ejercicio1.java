package ar.edu.unju.escmi.tp4.ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {

    private static ArrayList<Jugador> lista = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerInt("Ingrese una opción: ");
            switch (opcion) {
                case 1:
                    altaJugador();
                    break;
                case 2:
                    modificarJugador();
                    break;
                case 3:
                    eliminarJugador();
                    break;
                case 4:
                    mostrarTodos();
                    break;
                case 5:
                    System.out.println("Cantidad de jugadores: " + lista.size());
                    break;
                case 6:
                    lista.clear();
                    System.out.println("Lista de jugadores vaciada.");
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 7);
    }

    private static void mostrarMenu() {
        System.out.println("\n===== MENU EJERCICIO 1 =====");
        System.out.println("1 – Alta de jugador.");
        System.out.println("2 – Modificar los datos de un jugador.");
        System.out.println("3 – Eliminar un jugador.");
        System.out.println("4 – Mostrar todos los jugadores.");
        System.out.println("5 – Mostrar la cantidad de jugadores en la lista.");
        System.out.println("6 – Limpiar toda la lista de jugadores.");
        System.out.println("7 - Salir");
    }

    private static void altaJugador() {
        System.out.println("\n-- ALTA DE JUGADOR (constructor por defecto) --");
        Jugador j = new Jugador(); // usar constructor por defecto
        String dni = leerString("DNI: ");
        // comprobar si ya existe dni
        if (buscarPorDni(dni) != null) {
            System.out.println("Ya existe un jugador con ese DNI. Alta cancelada.");
            return;
        }
        j.setDni(dni);
        j.setNombre(leerString("Nombre: "));
        j.setEquipo(leerString("Equipo: "));
        j.setNacionalidad(leerString("Nacionalidad: "));
        j.setEstatura(leerDouble("Estatura (ej: 1.80): "));
        lista.add(j);
        System.out.println("Jugador agregado correctamente.");
    }

    private static void modificarJugador() {
        System.out.println("\n-- MODIFICAR JUGADOR --");
        String dni = leerString("Ingrese el DNI del jugador a modificar: ");
        Jugador j = buscarPorDni(dni);
        if (j == null) {
            System.out.println("No se encuentra el dni.");
            return;
        }
        System.out.println("Datos actuales:");
        j.mostrarDatos();
        System.out.println("\nIngrese nuevos datos (dejar vacío para mantener el actual):");
        String nombre = leerStringAllowEmpty("Nombre (" + j.getNombre() + "): ");
        if (!nombre.isEmpty()) j.setNombre(nombre);
        String equipo = leerStringAllowEmpty("Equipo (" + j.getEquipo() + "): ");
        if (!equipo.isEmpty()) j.setEquipo(equipo);
        String nacionalidad = leerStringAllowEmpty("Nacionalidad (" + j.getNacionalidad() + "): ");
        if (!nacionalidad.isEmpty()) j.setNacionalidad(nacionalidad);

        String estaturaStr = leerStringAllowEmpty("Estatura (" + j.getEstatura() + "): ");
        if (!estaturaStr.isEmpty()) {
            try {
                double est = Double.parseDouble(estaturaStr);
                j.setEstatura(est);
            } catch (NumberFormatException e) {
                System.out.println("Valor de estatura inválido. Se mantiene el anterior.");
            }
        }
        System.out.println("Datos actualizados.");
    }

    private static void eliminarJugador() {
        System.out.println("\n-- ELIMINAR JUGADOR --");
        String dni = leerString("Ingrese el DNI del jugador a eliminar: ");
        Jugador j = buscarPorDni(dni);
        if (j == null) {
            System.out.println("No se encuentra el dni.");
            return;
        }
        lista.remove(j);
        System.out.println("Jugador eliminado correctamente.");
    }

    private static void mostrarTodos() {
        System.out.println("\n-- TODOS LOS JUGADORES --");
        if (lista.isEmpty()) {
            System.out.println("No hay jugadores cargados.");
            return;
        }
        for (Jugador j : lista) {
            j.mostrarDatos();
        }
    }

    // helpers
    private static Jugador buscarPorDni(String dni) {
        for (Jugador j : lista) {
            if (j.getDni().equalsIgnoreCase(dni)) return j;
        }
        return null;
    }

    private static int leerInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                int v = Integer.parseInt(sc.nextLine());
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número entero.");
            }
        }
    }

    private static double leerDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                double v = Double.parseDouble(sc.nextLine());
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número decimal válido.");
            }
        }
    }

    private static String leerString(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }

    private static String leerStringAllowEmpty(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }
}
