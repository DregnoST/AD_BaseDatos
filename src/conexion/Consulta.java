package conexion;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consulta {
	public static void insertarRegistro(String nombre, int edad) {
		Connection miCon = Conexion.conectar();
		PreparedStatement consulta;
		
		try {
			consulta = miCon.prepareStatement("INSERT INTO personas (nombre, edad) VALUES (?,?)");
			consulta.setString(1, nombre);
			consulta.setInt(1, edad);
			consulta.executeUpdate();
			
			System.out.println("insercion ok");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void borrarRegistro(String nombre) {
		Connection miCon = Conexion.conectar();
		PreparedStatement consulta;
		
		try {
			consulta = miCon.prepareStatement("");
			consulta.setString(1, nombre);
			consulta.executeUpdate();
			System.out.println("borrado ok");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void filtrarRegistro(String nombre) {
		Connection miCon = Conexion.conectar();
		PreparedStatement consulta;
		
		try {
			consulta = miCon.prepareStatement("SELECT * FROM personas WHERE nombre LIKE ?");
			consulta.setString(1, nombre);
			ResultSet resultados = consulta.executeQuery();
			
			while (resultados.next()) {
				System.out.println("--------------------------------------");
				System.out.println("Nombre: " + resultados.getString("nombre"));
				System.out.println("Edad: " + resultados.getString("edad"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void verTablas() {
		Connection miCon = Conexion.conectar();
		DatabaseMetaData dbmd;
		System.out.println("\nTABLAS\n==============");
		
		try {
			dbmd = miCon.getMetaData();
			String[] tipos = {"TABLE", "VIEW"};
			ResultSet tablas = dbmd.getTables(null, null, null, tipos);
			
			while (tablas.next()) {
				String nombre = tablas.getString("TABLE_NAME");
				System.out.println(nombre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("==============");
	}

	public static void verTodoLibros() {
		Connection miCon = Conexion.conectar();
		PreparedStatement consulta;
		
		System.out.println("\nLIBROS\n==============");
		try {
			consulta = miCon.prepareStatement("SELECT * FROM libro");
			ResultSet resultados = consulta.executeQuery();
			while (resultados.next()) {
				System.out.println("LIBRO");
				System.out.println("Codigo: " + resultados.getInt("codigo"));
				System.out.println("Titulo: " + resultados.getString("titulo"));
				System.out.println("Autor: " + resultados.getString("autor"));
				System.out.println("Editorial: " + resultados.getString("editorial"));
				System.out.println("Año: " + resultados.getInt("año"));
				System.out.println("ISBN: " + resultados.getString("isbn"));
				System.out.println("Ejemplares: " + resultados.getInt("numeroEjemplares"));
				System.out.println("Paginas: " + resultados.getInt("numeroPaginas") + "\n");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("==============");
	}
	
	public static void verTodoSocios() {
		Connection miCon = Conexion.conectar();
		PreparedStatement consulta;
		
		System.out.println("\nSOCIOS\n==============");
		
		try {
			consulta = miCon.prepareStatement("SELECT * FROM socio");
			ResultSet resultados = consulta.executeQuery();
			while (resultados.next()) {
				System.out.println("SOCIO");
				System.out.println("Codigo: " + resultados.getInt("codigo"));
				System.out.println("Nombre " + resultados.getString("nombre"));
				System.out.println("Apellidos " + resultados.getString("apellidos"));
				System.out.println("Fecha nacimiento " + resultados.getDate("fechaNacimiento"));
				System.out.println("Domicilio " + resultados.getString("domicilio"));
				System.out.println("Telefono: " + resultados.getString("telefono") + "\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("==============");
	}
	
	public static void verTodosPrestamos() {
		Connection miCon = Conexion.conectar();
		PreparedStatement consulta;
		
		System.out.println("\nPRESTAMOS\n==============");
		
		try {
			consulta = miCon.prepareStatement("SELECT * FROM prestamo");
			ResultSet resultados = consulta.executeQuery();
			while (resultados.next()) {
				System.out.println("PRESTAMO");
				System.out.println("Codigo libro: " + resultados.getInt("codigoLibro"));
				System.out.println("Codigo socio: " + resultados.getInt("codigoSocio"));
				System.out.println("Inicio del prestamo: " + resultados.getDate("fechaInicioPrestamo"));
				System.out.println("Expiracion del prestamo: " + resultados.getDate("fechaFinPrestamo") + "\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("==============");
	}
	
	public static void librosPrestados() {
		Connection miCon = Conexion.conectar();
		PreparedStatement consulta;
		
		System.out.println("\nLIBROS PRESTADOS:");
		
		try {
			consulta = miCon.prepareStatement("SELECT * FROM libro WHERE codigo IN (SELECT codigoLibro FROM prestamo)");
			ResultSet resultados = consulta.executeQuery();
			while (resultados.next()) {
				System.out.println("LIBRO");
				System.out.println("Codigo: " + resultados.getInt("codigo"));
				System.out.println("Titulo: " + resultados.getString("titulo"));
				System.out.println("ISBN: " + resultados.getString("isbn") + "\n");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void librosPrestadosSocio(int codigoSocio) {
		Connection miCon = Conexion.conectar();
		PreparedStatement consulta;
		
		System.out.print("\nNumero de libros prestados al cliente con el código: " + codigoSocio + " --> ");
		
		try {
			consulta = miCon.prepareStatement("SELECT COUNT(codigoSocio) FROM prestamo WHERE codigoSocio = " + codigoSocio);
			ResultSet resultados = consulta.executeQuery();
			while (resultados.next()) {
				System.out.println(resultados.getInt(1) + "\n");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void librosPrestamoExpirado() {
		Connection miCon = Conexion.conectar();
		PreparedStatement consulta;
		long ahora = System.currentTimeMillis();
		Date hoy = new Date(ahora);
		

		System.out.println("\nLibros que han superado la fecha de fin de prestamo:");
		
		try {
			consulta = miCon.prepareStatement("SELECT * FROM libro WHERE codigo IN (SELECT codigoLibro FROM prestamo WHERE fechaFinPrestamo <= " + hoy.getTime() + ")");
			ResultSet resultados = consulta.executeQuery();
			while (resultados.next()) {
				System.out.println("LIBRO");
				System.out.println("Codigo: " + resultados.getInt("codigo"));
				System.out.println("Titulo: " + resultados.getString("titulo"));
				System.out.println("ISBN: " + resultados.getString("isbn") + "\n");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void sociosLibrosPrestamoExpirado() {
		Connection miCon = Conexion.conectar();
		PreparedStatement consulta;
		long ahora = System.currentTimeMillis();
		Date hoy = new Date(ahora);
		
		System.out.println("\nSocios que tienen libros que han superado la fecha de fin de préstamo:");
		
		try {
			consulta = miCon.prepareStatement("SELECT * FROM socio WHERE codigo IN (SELECT codigoSocio FROM prestamo WHERE fechaFinPrestamo <= " + hoy.getTime() + ")");
			ResultSet resultados = consulta.executeQuery();
			while (resultados.next()) {
				System.out.println("SOCIO");
				System.out.println("Codigo: " + resultados.getInt("codigo"));
				System.out.println("Nombre " + resultados.getString("nombre"));
				System.out.println("Apellidos " + resultados.getString("apellidos"));
				System.out.println("Telefono: " + resultados.getString("telefono") + "\n");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
