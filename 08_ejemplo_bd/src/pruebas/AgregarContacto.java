package pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AgregarContacto {

	public static void main(String[] args) {
		String cadenaConexion="jdbc:mysql://localhost:3306/agenda";
		String usuario="root";
		String password="root";
		String name="nombrex";
		String email="emailx@gmail.com";
		int edad=20;
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){
			/*String sql="insert into contactos(nombre,email,edad) values('contacto3','email3@gmail.com',44)";
			String sql="insert into contactos(nombre,email,edad) values('contacto3','email3@gmail.com',44)";
			Statement st=con.createStatement();
			st.execute(sql);*/
			
			// Consultas preparadas
			String sql="insert into contactos (nombre,email,edad) values(?,?,?)"; //consulta preparada para cuando no se saben los valores
			PreparedStatement ps=con.prepareStatement(sql);
			//Sustituimos parámetros por valores
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setInt(3, edad);
			ps.execute(); // NO se manda otra vez la SQL
			System.out.println("Registro añadido!!");
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	

	}

}