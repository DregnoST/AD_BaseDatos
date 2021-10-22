package ej1;

import java.lang.module.InvalidModuleDescriptorException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static final String URL = "jdbc:mysql://localhost:3306/basepruebas";
	private static final String USUARIO = "usuario2";
	private static final String CLAVE = "usuario2";
	
	public static Connection conectar() {
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("Conexion OK");
			
			
		} catch (SQLException e) {
			System.out.println("Error de conexion");
			e.printStackTrace();
		} catch (InvalidModuleDescriptorException e) {
			System.out.println("Error PAM");
		}
		
		return conexion;
		
	}

}
