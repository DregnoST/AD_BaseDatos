package conexion;

import java.lang.module.InvalidModuleDescriptorException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static String url = "jdbc:sqlite:biblioteca.db";
	
	
	public static Connection conectar() {
		
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(url);
			
			//System.out.println("Conexion OK");		
			
		} catch (SQLException e) {
			System.out.println("Error de conexion");
			e.printStackTrace();
		} catch (InvalidModuleDescriptorException e) {
			System.out.println("Error PAM");
		}
		return conexion;
	}
}
