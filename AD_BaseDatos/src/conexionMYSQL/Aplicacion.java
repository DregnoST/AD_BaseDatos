package conexionMYSQL;

public class Aplicacion {

	public static void main(String[] args) {
		
//		Consulta.filtrarRegistro("Paco");
//		ManejoTabla.crear();
//		ManejoTabla.borrar();
//		ManejoTabla.verCosas();
		CrearBD.crear("biblioteca");
		ManejoTabla.crear("biblioteca.libro", "(codigo INT NOT NULL, "
				+ "titulo VARCHAR(40), autor VARCHAR(40), editorial VARCHAR(40), "
				+ "año INT, isbn VARCHAR(40) NOT NULL, numeroEjemplares INT, "
				+ "numeroPaginas INT, PRIMARY KEY (codigo), UNIQUE (isbn))");
		
		ManejoTabla.crear("biblioteca.socio", "(codigo INT NOT NULL, nombre VARCHAR(40), "
				+ "");
	}

}
