package biblioteca;

import java.sql.Date;

public class Socio {
	
	int codigo;
	Date fechaNacimiento;
	String nombre, apellidos, domicilio, telefono;
	
	public Socio(int codigo, String nombre, String apellidos, Date fechaNacimiento, String domicilio, String telefono) {
		this.codigo = codigo;
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.domicilio = domicilio;
		this.telefono = telefono;
	}
	
	
}
