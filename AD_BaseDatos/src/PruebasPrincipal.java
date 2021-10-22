import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PruebasPrincipal {

	public static void main(String[] args) {

		try {
			Connection miCon = PruebaConexion.conectar();
			PreparedStatement stat = miCon.prepareStatement("select * from personas");
			ResultSet results = stat.executeQuery();
			
			while (results.next()) {
				System.out.println("--------------------------------------");
				System.out.println("Nombre: " + results.getString("nombre"));
				System.out.println("Edad: " + results.getString("edad"));
			}
			
		} catch (SQLException e) {
			System.out.println("Excepcion" + e);
		}

	}

}
