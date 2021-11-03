package biblioteca;

import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.Octets;

import conexionMYSQL.CrearBD;
import conexionMYSQL.ManejoTabla;

public class ManejoBiblioteca {
	
	static ArrayList<Libro> libros;
	static ArrayList<Socio> socios;
	

	public static void crearDatos() {
		
		// libros
		libros.add(new Libro(0, "El retorno de Nagash", "Magallanes", "timunmas", 2014, "123-456-789", 120, 480));
		libros.add(new Libro(1, "La caida de Altdorf", "Magallanes", "timunmas", 2014, "123-456-790", 100, 450));
		libros.add(new Libro(2, "La rata cornuda", "Eustaquio", "debolsillo", 2014, "123-456-791", 60, 500));
		libros.add(new Libro(3, "Khaine", "Fernando", "timunmas", 2014, "123-456-792", 130, 400));
		libros.add(new Libro(4, "Archaon", "Magallanes", "paqueveas", 2014, "123-456-792", 105, 401));
		
		// socios
		
		
	}
	
	public static void crearBiblioteca() {
		CrearBD.crear("biblioteca");
		ManejoBiblioteca.crearTablas();
	}
	
	public static void crearTablas() {
		ManejoTabla.crear("biblioteca.libro", 
				"(codigo INT NOT NULL, "
				+ "titulo VARCHAR(40), "
				+ "autor VARCHAR(40), "
				+ "editorial VARCHAR(40), "
				+ "año INT, "
				+ "isbn VARCHAR(40) NOT NULL, "
				+ "numeroEjemplares INT, "
				+ "numeroPaginas INT, "
				+ "PRIMARY KEY (codigo), UNIQUE (isbn))");
		
		ManejoTabla.crear("biblioteca.socio", 
				"(codigo INT NOT NULL, "
				+ "nombre VARCHAR(40), "
				+ "apellidos VARCHAR(40), "
				+ "fechaNacimiento DATE, "
				+ "domicilio VARCHAR(40), "
				+ "telefono VARCHAR(40), "
				+ "PRIMARY KEY (codigo))");
		
		ManejoTabla.crear("biblioteca.prestamo", 
				"(codigoLibro INT NOT NULL, "
				+ "codigoSocio INT NOT NULL, "
				+ "fechaInicioPrestamo DATE, "
				+ "fechaFinPrestamo DATE, "
				+ "PRIMARY KEY (codigoLibro, codigoSocio), "
				+ "FOREIGN KEY (codigoSocio) REFERENCES socio(codigo), "
				+ "FOREIGN KEY (codigoLibro) REFERENCES libro(codigo))");
	}
	
	

}
