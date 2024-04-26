package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*1.-Nuevo Contacto
2.-Eliminar Contacto
3.-Actualizar edad
4.-Salir

1: Se piden los datos del nuevo contacto y se guarda
2: Solicita el email y borra el contacto con dicho email
3: Solicita email y nueva edad, y sustituye la edad anterior por la nueva en ese contacto */

public class AgendaService {
	String cadenaConexion="jdbc:mysql://localhost:3306/agenda";
	String usuario="root";
	String password="root";
	
	private void abrirConexion() {
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public boolean agregarContacto(String nombre,String )
	
	
}
