package pruebasSQlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionLite {
	
	public static Connection conectarLite() {
		
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection("jdbc:sqlite:chinook.db");
			System.out.println("Conexion ok");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conexion;
	}

}
