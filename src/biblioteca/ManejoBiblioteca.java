package biblioteca;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import conexion.Conexion;
import conexion.ManejoTabla;

public class ManejoBiblioteca {
	static ArrayList<Libro> libros = new ArrayList<>();
	static ArrayList<Socio> socios = new ArrayList<>();
	static ArrayList<Prestamo> prestamos = new ArrayList<>();
	
	public static void crearDatos() {
		// libros
		libros.add(new Libro(0, "El retorno de Nagash", "Magallanes", "timunmas", 2014, "123-456-789", 120, 480));
		libros.add(new Libro(1, "La caida de Altdorf", "Magallanes", "timunmas", 2014, "123-456-790", 100, 450));
		libros.add(new Libro(2, "La rata cornuda", "Eustaquio", "debolsillo", 2014, "123-456-791", 60, 500));
		libros.add(new Libro(3, "Khaine", "Fernando", "timunmas", 2014, "123-456-792", 130, 400));
		libros.add(new Libro(4, "Archaon", "Magallanes", "paqueveas", 2014, "123-456-793", 105, 401));
		
		// socios
		socios.add(new Socio(0, "Carlos", "Matias de la Cruz", Date.valueOf("1996-03-16"), "Calle la colcha", "623456789"));
		socios.add(new Socio(1, "Marcos", "de Alcordón", Date.valueOf("1986-09-26"), "Calle Buenavista", "623456321"));
		socios.add(new Socio(2, "Jose Luis", "López Oscarra", Date.valueOf("1986-09-26"), "Calle Buenavista", "623456321"));
		
		// prestamos
		prestamos.add(new Prestamo(1, 0, Date.valueOf("2001-03-16"), Date.valueOf("2021-12-20")));
		prestamos.add(new Prestamo(3, 2, Date.valueOf("2001-03-16"), Date.valueOf("2022-01-29")));
	}
	
	public static void insertarLibros() {
		Connection miCon = Conexion.conectar();
		PreparedStatement consulta;
		
		try {
			for (Libro libro : libros) {
				consulta = miCon.prepareStatement("INSERT OR IGNORE INTO libro (codigo, titulo, autor, editorial, año, isbn, numeroEjemplares, numeroPaginas) VALUES (?,?,?,?,?,?,?,?)");
				consulta.setInt(1, libro.getCodigo());
				consulta.setString(2, libro.getTitulo());
				consulta.setString(3, libro.getAutor());
				consulta.setString(4, libro.getEditorial());
				consulta.setInt(5, libro.getAño());
				consulta.setString(6, libro.getIsbn());
				consulta.setInt(7, libro.getNumeroEjemplares());
				consulta.setInt(8, libro.getNumeroPaginas());
				consulta.executeUpdate();	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static void insertarSocios() {
		Connection miCon = Conexion.conectar();
		PreparedStatement consulta;
		
		for (Socio socio : socios) {
			try {
				consulta = miCon.prepareStatement("INSERT OR IGNORE INTO socio (codigo, nombre, apellidos, fechaNacimiento, domicilio, telefono) VALUES (?,?,?,?,?,?)");
				consulta.setInt(1, socio.getCodigo());
				consulta.setString(2, socio.getNombre());
				consulta.setString(3, socio.getApellidos());
				consulta.setDate(4, socio.getFechaNacimiento());
				consulta.setString(5, socio.getDomicilio());
				consulta.setString(6, socio.getTelefono());
				consulta.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}	
	}
	
	public static void insertarPrestamos() {
		Connection miCon = Conexion.conectar();
		PreparedStatement consulta;
		
		for (Prestamo prestamo : prestamos) {
			try {
				consulta = miCon.prepareStatement("INSERT OR IGNORE INTO prestamo (codigoLibro, codigoSocio, fechaInicioPrestamo, fechaFinPrestamo) VALUES (?,?,?,?)");
				consulta.setInt(1, prestamo.getCodigoLibro());
				consulta.setInt(2, prestamo.getCodigoSocio());
				consulta.setDate(3, prestamo.getFechaInicioPrestamo());
				consulta.setDate(4, prestamo.getFechaFinPrestamo());
				consulta.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
	public static void crearBiblioteca() {
		crearTablas();
		crearDatos();
		insertarDatos();
	}
	
	public static void insertarDatos() {
		insertarLibros();
		insertarSocios();
		insertarPrestamos();
	}
	
	public static void crearTablas() {
		ManejoTabla.crear("libro", 
				"(codigo INT NOT NULL, "
				+ "titulo VARCHAR(40), "
				+ "autor VARCHAR(40), "
				+ "editorial VARCHAR(40), "
				+ "año INT, "
				+ "isbn VARCHAR(40) NOT NULL, "
				+ "numeroEjemplares INT, "
				+ "numeroPaginas INT, "
				+ "PRIMARY KEY (codigo), UNIQUE (isbn))");
		
		ManejoTabla.crear("socio", 
				"(codigo INT NOT NULL, "
				+ "nombre VARCHAR(40), "
				+ "apellidos VARCHAR(40), "
				+ "fechaNacimiento DATE, "
				+ "domicilio VARCHAR(40), "
				+ "telefono VARCHAR(40), "
				+ "PRIMARY KEY (codigo))");
		
		ManejoTabla.crear("prestamo", 
				"(codigoLibro INT NOT NULL, "
				+ "codigoSocio INT NOT NULL, "
				+ "fechaInicioPrestamo DATE, "
				+ "fechaFinPrestamo DATE, "
				+ "PRIMARY KEY (codigoLibro, codigoSocio), "
				+ "FOREIGN KEY (codigoSocio) REFERENCES socio(codigo), "
				+ "FOREIGN KEY (codigoLibro) REFERENCES libro(codigo))");
		
	}
}
