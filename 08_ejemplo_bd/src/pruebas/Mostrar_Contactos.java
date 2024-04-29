package pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mostrar_Contactos {

	public static void main(String[] args) {
		String cadenaConexion="jdbc:mysql://localhost:3306/agenda";
		String usuario="root";
		String password="root";
		
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){
			String sql="select * from contactos";
			Statement st=con.createStatement();
			ResultSet rd=st.executeQuery(sql);
			while (rd.next()) {
				System.out.println(rd.getString("nombre")+"-"+rd.getString("edad"));			
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

}
