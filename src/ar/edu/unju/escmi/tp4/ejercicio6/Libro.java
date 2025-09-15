package ar.edu.unju.escmi.tp4.ejercicio6;

public class Libro implements Comparable<Libro> {
    private String isbn;
    private String titulo;
    private int cantidadPaginas;
    private String autor;

    public Libro() { }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getCantidadPaginas() { return cantidadPaginas; }
    public void setCantidadPaginas(int cantidadPaginas) { this.cantidadPaginas = cantidadPaginas; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public void mostrarDatos() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Título: " + titulo);
        System.out.println("Páginas: " + cantidadPaginas);
        System.out.println("Autor: " + autor);
        System.out.println("---------------------------");
    }

    @Override
    public int compareTo(Libro o) {
        if (o == null || o.titulo == null) return 1;
        if (this.titulo == null) return -1;
        return this.titulo.compareToIgnoreCase(o.titulo);
    }
}
