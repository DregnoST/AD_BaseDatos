package conexion;

import biblioteca.ManejoBiblioteca;

public class Aplicacion {

	public static void main(String[] args) {		
		ManejoBiblioteca.crearBiblioteca();
		//Consulta.verTablas();
		
		Consulta.verTodoLibros();
		Consulta.verTodoSocios();
		Consulta.verTodosPrestamos();
		
	}
}
