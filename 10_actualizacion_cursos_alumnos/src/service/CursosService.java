package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import model.Curso;

public class CursosService {
		String cadenaConexion="jdbc:mysql://localhost:3306/cursos";
		String usuario="root";
		String password="root";

		
// COMPROBAR SI EXISTE EL CURSO ******************************************************
	
		public Curso existeCursoPorId (int idcurso) {
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

		
// AGREGAR CURSO no repetido **********************************************************
	
		public boolean agregarCurso (Curso curso) {
				
		if(existeCursoPorId(curso.getIdCurso())==null) {
			return false;
			
		}
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){
			String sql="insert into cursos(idCurso,curso,duracion,precio,null) values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			// Sustituimos parámetros por valores
			ps.setInt(1, curso.getIdCurso());
			ps.setString(2, curso.getCurso());
			ps.setInt(3, curso.getDuracion());
			ps.setDouble(4, curso.getPrecio());
			ps.execute();
			
			return true;
				
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}	
	}
}
