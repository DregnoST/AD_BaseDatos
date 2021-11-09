package biblioteca;

public class Libro {
	
	int codigo, a�o, numeroEjemplares, numeroPaginas;
	String titulo, autor, editorial, isbn;
	
	public Libro(int codigo, String titulo, String autor, String editorial, 
			int a�o, String isbn, int numeroEjemplares, int numeroPaginas) {
		
		this.codigo = codigo;
		this.a�o = a�o;
		this.numeroEjemplares = numeroEjemplares;
		this.numeroPaginas = numeroPaginas;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.isbn = isbn;
	}
	
	

	public String getIsbn() {
		return isbn;
	}



	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public int getA�o() {
		return a�o;
	}



	public void setA�o(int a�o) {
		this.a�o = a�o;
	}



	public int getNumeroEjemplares() {
		return numeroEjemplares;
	}



	public void setNumeroEjemplares(int numeroEjemplares) {
		this.numeroEjemplares = numeroEjemplares;
	}



	public int getNumeroPaginas() {
		return numeroPaginas;
	}



	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	public String getEditorial() {
		return editorial;
	}



	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}



	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", a�o=" + a�o + ", numeroEjemplares=" + numeroEjemplares
				+ ", numeroPaginas=" + numeroPaginas + ", titulo=" + titulo + ", autor=" + autor + ", editorial="
				+ editorial + "]";
	}
	
	
	
	
}
