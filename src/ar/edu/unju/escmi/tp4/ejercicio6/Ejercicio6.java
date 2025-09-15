package ar.edu.unju.escmi.tp4.ejercicio6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio6 {
    private static int buscarPorIsbn(ArrayList<Libro> libros, String isbn) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIsbn().equalsIgnoreCase(isbn)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Libro> libros = new ArrayList<>();

        int opc;
        do {
            System.out.println("1. Alta de Libro.");
            System.out.println("2. Mostrar libros.");
            System.out.println("3. Buscar y mostrar un libro.");
            System.out.println("4. Ordenar libros.");
            System.out.println("5. Modificar datos de un libro.");
            System.out.println("6. Eliminar un libro.");
            System.out.println("7. Salir.");
            System.out.print("Seleccione una opción: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    Libro l = new Libro();
                    System.out.print("Ingrese ISBN: ");
                    l.setIsbn(sc.nextLine());
                    System.out.print("Ingrese título: ");
                    l.setTitulo(sc.nextLine());
                    System.out.print("Ingrese cantidad de páginas (entero): ");
                    l.setCantidadPaginas(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Ingrese autor: ");
                    l.setAutor(sc.nextLine());
                    libros.add(l);
                    System.out.println(">> Libro agregado.\n");
                    break;

                case 2:
                    if (libros.isEmpty()) {
                        System.out.println("No hay libros cargados.\n");
                    } else {
                        for (Libro li : libros) {
                            li.mostrarDatos();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese ISBN a buscar: ");
                    String buscIsbn = sc.nextLine();
                    int idx = buscarPorIsbn(libros, buscIsbn);
                    if (idx == -1) {
                        System.out.println("Libro no encontrado.\n");
                    } else {
                        libros.get(idx).mostrarDatos();
                    }
                    break;

                case 4:
                    if (libros.isEmpty()) {
                        System.out.println("No hay libros para ordenar.\n");
                    } else {
                        Collections.sort(libros);
                        System.out.println(">> Libros ordenados por título.\n");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese ISBN del libro a modificar: ");
                    String modIsbn = sc.nextLine();
                    int pos = buscarPorIsbn(libros, modIsbn);
                    if (pos == -1) {
                        System.out.println("Libro no encontrado.\n");
                    } else {
                        Libro m = libros.get(pos);
                        m.mostrarDatos();
                        System.out.print("Nuevo título: ");
                        m.setTitulo(sc.nextLine());
                        System.out.print("Nueva cantidad de páginas (entero): ");
                        m.setCantidadPaginas(sc.nextInt());
                        sc.nextLine();
                        System.out.print("Nuevo autor: ");
                        m.setAutor(sc.nextLine());
                        System.out.println(">> Libro modificado.\n");
                    }
                    break;

                case 6:
                    System.out.print("Ingrese ISBN del libro a eliminar: ");
                    String delIsbn = sc.nextLine();
                    int p = buscarPorIsbn(libros, delIsbn);
                    if (p == -1) {
                        System.out.println("Libro no encontrado.\n");
                    } else {
                        libros.remove(p);
                        System.out.println(">> Libro eliminado.\n");
                    }
                    break;

                case 7:
                    System.out.println("Fin del programa.");
                    break;

                default:
                    System.out.println("Opción inválida.\n");
                    break;
            }
        } while (opc != 7);

        sc.close();
    }
}
