// Arán García Vallcanera
package conexion;

// clase principal que contiene el main
import biblioteca.ManejoBiblioteca;

public class Aplicacion {

	public static void main(String[] args) {
		ManejoBiblioteca.crearBiblioteca();
		
		Consulta.verTablas();
		Consulta.verTodoLibros();
		Consulta.verTodoSocios();
		Consulta.verTodosPrestamos();
		Consulta.librosPrestados();
		Consulta.librosPrestadosSocio(2);
		Consulta.librosPrestamoExpirado();
		Consulta.sociosLibrosPrestamoExpirado();

	}

}
//Arán García Vallcanera