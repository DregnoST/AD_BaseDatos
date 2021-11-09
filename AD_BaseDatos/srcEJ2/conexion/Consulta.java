package conexion;

import java.sql.Connection;
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
	
	

}
