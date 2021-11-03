package biblioteca;

public class Libro {
	
	int codigo, a�o, numeroEjemplares, numeroPaginas;
	String titulo, autor, editorial;
	
	public Libro(int codigo, String titulo, String autor, String editorial, 
			int a�o, String isbn, int numeroEjemplares, int numeroPaginas) {
		
		this.codigo = codigo;
		this.a�o = a�o;
		this.numeroEjemplares = numeroEjemplares;
		this.numeroPaginas = numeroPaginas;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", a�o=" + a�o + ", numeroEjemplares=" + numeroEjemplares
				+ ", numeroPaginas=" + numeroPaginas + ", titulo=" + titulo + ", autor=" + autor + ", editorial="
				+ editorial + "]";
	}
	
	
	
	
}
