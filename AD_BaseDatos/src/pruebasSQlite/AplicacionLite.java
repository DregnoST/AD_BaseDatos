package pruebasSQlite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AplicacionLite {

	public static void main(String[] args) {
		Connection conexion = ConexionLite.conectarLite();

		Statement s;
		try {
			s = conexion.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM tracks");

			while (rs.next()) {
				System.out.println("Cancion: " + rs.getString("tracks"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
