package biblioteca;

import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import conexion.ManejoTabla;

public class ManejoBiblioteca {
	
	static ArrayList<Libro> libros = new ArrayList<>();
	static ArrayList<Socio> socios = new ArrayList<>();
	static ArrayList<Prestamo> prestamos = new ArrayList<>();
	
	public static Date fecha(String d) {
		Date fecha = null;
		java.util.Date date = new java.util.Date();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String fechaConFormato = formatoFecha.format(d);
			fecha = Date.valueOf(fechaConFormato);
			
		} catch (Exception e) {;
			// si hay algun error asignará la fecha actual del sistema
			String fechaConFormato = formatoFecha.format(date);
			fecha = Date.valueOf(fechaConFormato);
		}
		return fecha;
	}
	
	public static void crearDatos() {
		// libros
		libros.add(new Libro(0, "El retorno de Nagash", "Magallanes", "timunmas", 2014, "123-456-789", 120, 480));
		libros.add(new Libro(1, "La caida de Altdorf", "Magallanes", "timunmas", 2014, "123-456-790", 100, 450));
		libros.add(new Libro(2, "La rata cornuda", "Eustaquio", "debolsillo", 2014, "123-456-791", 60, 500));
		libros.add(new Libro(3, "Khaine", "Fernando", "timunmas", 2014, "123-456-792", 130, 400));
		libros.add(new Libro(4, "Archaon", "Magallanes", "paqueveas", 2014, "123-456-793", 105, 401));
		
		// socios
		socios.add(new Socio(0, "Carlos", "Matias de la Cruz", fecha("16-03-1996"), "Calle la colcha", "623456789"));
		socios.add(new Socio(1, "Marcos", "de Alcordón", fecha("26-09-1986"), "Calle Buenavista", "623456321"));
		socios.add(new Socio(2, "Jose Luis", "López Oscarra", fecha("26-09-1986"), "Calle Buenavista", "623456321"));
		
		// prestamos
		prestamos.add(new Prestamo(1, 0, fecha(""), fecha("20-12-2021")));
		prestamos.add(new Prestamo(3, 2, fecha(""), fecha("29-01-2022")));
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
				consulta = miCon.prepareStatement("INSERT OR IGNORE INTO socio (codigo, nombre, apellidos, fechaNacimiento, domicilio, telefono) VALUES (?,?,?,?)");
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
