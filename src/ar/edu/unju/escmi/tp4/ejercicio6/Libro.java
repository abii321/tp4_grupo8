package ar.edu.unju.escmi.tp4.ejercicio6;

public class Libro implements Comparable<Libro> {
    private String isbn;
    private String titulo;
    private int cantidadPaginas;
    private String autor;

    public Libro() { }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public void setCantidadPaginas(int cantidadPaginas) { this.cantidadPaginas = cantidadPaginas; }

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
