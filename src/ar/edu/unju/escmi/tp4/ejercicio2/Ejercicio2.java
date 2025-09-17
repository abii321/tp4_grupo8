package ar.edu.unju.escmi.tp4.ejercicio2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio2 {

    private static HashMap<String, Empleado> mapa = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);
    
    private static void mostrarMenu() {
        System.out.println("\n===== MENU EJERCICIO 2 =====");
        System.out.println("1 – Alta de empleado.");
        System.out.println("2 – Mostrar empleados.");
        System.out.println("3 – Eliminar empleado.");
        System.out.println("4 – Consultar los datos de un empleado.");
        System.out.println("5 – Salir.");
    }

    private static void altaEmpleado() {
        System.out.println("\n-- ALTA DE EMPLEADO (constructor parametrizado) --");
        String dni = leerString("DNI: ");
        char categoria = leerCategoria("Categoría (una letra, ej: A): ");
        String clave = dni + categoria;
        if (mapa.containsKey(clave)) {
            System.out.println("La clave ya existe en el HashMap. Alta cancelada.");
            return;
        }
        String nombre = leerString("Nombre: ");
        String apellido = leerString("Apellido: ");
        double sueldo = leerDouble("Sueldo: ");
        Empleado e = new Empleado(dni, nombre, apellido, sueldo, categoria);
        mapa.put(clave, e);
        System.out.println("Empleado agregado con clave: " + clave);
    }

    private static void mostrarEmpleados() {
        System.out.println("\n-- MOSTRAR EMPLEADOS (usando While + Iterator) --");
        if (mapa.isEmpty()) {
            System.out.println("No hay empleados cargados.");
            return;
        }
        Iterator<Map.Entry<String, Empleado>> it = mapa.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Empleado> entry = it.next();
            System.out.println("Clave: " + entry.getKey());
            entry.getValue().mostrarDatos();
            System.out.println("-----------------------");
        }
    }

    private static void eliminarEmpleado() {
        System.out.println("\n-- ELIMINAR EMPLEADO --");
        String clave = leerString("Ingrese la clave (dni+categoria) del empleado a eliminar: ");
        if (mapa.containsKey(clave)) {
            mapa.remove(clave);
            System.out.println("Empleado eliminado.");
        } else {
            System.out.println("La clave no existe en el HashMap.");
        }
    }

    private static void consultarEmpleado() {
        System.out.println("\n-- CONSULTAR EMPLEADO --");
        String clave = leerString("Ingrese la clave (dni+categoria): ");
        if (mapa.containsKey(clave)) {
            Empleado e = mapa.get(clave);
            System.out.println("Empleado encontrado:");
            e.mostrarDatos();
        } else {
            System.out.println("No se encontró la clave.");
        }
    }

    // Helpers
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

    private static char leerCategoria(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            if (s.length() == 1) return s.charAt(0);
            System.out.println("Ingrese una sola letra para la categoría.");
        }
    }
    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerInt("Ingrese una opción: ");
            switch (opcion) {
                case 1:
                    altaEmpleado();
                    break;
                case 2:
                    mostrarEmpleados();
                    break;
                case 3:
                    eliminarEmpleado();
                    break;
                case 4:
                    consultarEmpleado();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }
}
