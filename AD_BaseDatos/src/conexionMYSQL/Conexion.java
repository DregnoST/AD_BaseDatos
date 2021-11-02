package conexionMYSQL;

import java.lang.module.InvalidModuleDescriptorException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static String url = "jdbc:mysql://localhost:3306/";
	private static final String USUARIO = "usuario2";
	private static final String CLAVE = "usuario2";
	
	public static Connection conectar() {
		
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(url, USUARIO, CLAVE);
			System.out.println("Conexion OK");		
			
		} catch (SQLException e) {
			System.out.println("Error de conexion");
			e.printStackTrace();
		} catch (InvalidModuleDescriptorException e) {
			System.out.println("Error PAM");
		}
		
		return conexion;
	}
	
	public static Connection conectar(String bd) {
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(url + bd, USUARIO, CLAVE);
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
