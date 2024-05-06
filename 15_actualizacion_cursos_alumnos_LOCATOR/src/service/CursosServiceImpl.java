package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import locator.LocatorConnection;
import model.Curso;

public class CursosServiceImpl implements CursosService {
		
// COMPROBAR SI EXISTE EL CURSO ******************************************************
	
		private Curso existeCursoPorId (int idcurso) {
		try(Connection con=LocatorConnection.getConnection();){		
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
	
		@Override
		public boolean agregarCurso (Curso curso, int idCurso ) {
		try(Connection con=LocatorConnection.getConnection();){		
			Curso cursoNuevo=existeCursoPorId(idCurso);
			
			if(cursoNuevo==null) {
				return false;
			
			}
			String sql="insert into cursos(idCurso,curso,duracion,precio,null) values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
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
