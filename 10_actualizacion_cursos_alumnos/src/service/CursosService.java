package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Curso;

public class CursosService {
		String cadenaConexion="jdbc:mysql://localhost:3306/cursos";
		String usuario="root";
		String password="root";
		
	private Curso existeCursoPorId (int idcurso) {
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){		
			String sql="select * from curso where idcurso=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, idcurso);
			ResultSet rs=st.executeQuery();
			if(rs.next ()) { //Si el resultado es true es que existe, entonces devuelve los datos.
				return new Curso(rs.getInt("idCurso"),
							rs.getString("curso"),
							rs.getInt("duracion"),
							rs.getDouble("precio"),
							null);
			}
				
			return null; // si no existe devuelve nulo 
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
	} 
	
	
	public boolean agregarCurso (Curso curso, int ) {
		
	}

}
