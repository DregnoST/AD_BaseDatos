package conexion;

import java.sql.Connection;
import java.sql.Statement;

public class CrearBD {

	public static void crear(String bd) { // bd es el nombre de la base de datos a crear
		Connection miCon = Conexion.conectar();
		String consulta = "CREATE DATABASE IF NOT EXISTS " + bd;
		
		try {
			Statement crearBD = miCon.createStatement();
			crearBD.execute(consulta);
			System.out.println("base de datos lista");
		} catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
		
	}
}
