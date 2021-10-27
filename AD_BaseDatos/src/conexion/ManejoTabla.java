package conexion;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManejoTabla {

	public static void crear() {
		Connection miCon = Conexion.conectar();
		String sentencia = "create TABLE clientes (dni CHAR(9) NOT NULL, apellidos VARCHAR(32) NOT NULL, cp CHAR(5), PRIMARY KEY (dni))";
		
		try {
			Statement consulta = miCon.createStatement();
			

			if (consulta.execute(sentencia)) {
				System.out.println("tabla creada");
			}
			

			
			
		} catch (Exception e ) {
			System.out.println("Error: " + e);
		}
	}
	
	public static void borrar() {
		Connection miCon = Conexion.conectar();
		String sentencia = "DROP TABLE clientes";
		
		try {
			Statement consulta = miCon.createStatement();
			consulta.execute(sentencia);
			System.out.println("Tabla borrada");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void verCosas() {
		Connection miCon = Conexion.conectar();
	
		DatabaseMetaData dbmd;
		try {
			dbmd = miCon.getMetaData();
			String driverVersion = dbmd.getDriverVersion();
			System.out.println(driverVersion);
			String[] tipos = {"TABLE", "VIEW"};
			ResultSet tablas = dbmd.getTables(null, null, null, tipos);
			while (tablas.next()) {
				String catalogo = tablas.getString("TABLE_CAT");
				String esquema = tablas.getString("TABLE_SCHEM");
				String nombre = tablas.getString("TABLE_NAME");
				String tipo = tablas.getString("TABLE_TYPE");
				
				System.out.println("catalogo: " + nombre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
