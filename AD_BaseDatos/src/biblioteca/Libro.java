package biblioteca;

public class Libro {
	
	int codigo, año, numeroEjemplares, numeroPaginas;
	String titulo, autor, editorial;
	
	public Libro(int codigo, String titulo, String autor, String editorial, 
			int año, String isbn, int numeroEjemplares, int numeroPaginas) {
		
		this.codigo = codigo;
		this.año = año;
		this.numeroEjemplares = numeroEjemplares;
		this.numeroPaginas = numeroPaginas;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", año=" + año + ", numeroEjemplares=" + numeroEjemplares
				+ ", numeroPaginas=" + numeroPaginas + ", titulo=" + titulo + ", autor=" + autor + ", editorial="
				+ editorial + "]";
	}
	
	
	
	
}
