package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Contacto;

public class ContactosService {
	String cadenaConexion="jdbc:mysql://localhost:3306/agenda";
	String usuario="root";
	String password="root";
	
	private Contacto existeContactoPorEmail(String email) {
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){		
			String sql="select * from contactos where email=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, email);
			ResultSet rs=st.executeQuery();
			//debemos movernos a la primera y única fila, para poder extraer
			//el valor de dicha fila
			if(rs.next ()) {
				return new Contacto(rs.getInt("idContacto"),
							rs.getString("nombre"),
							rs.getString("email"),
							rs.getInt("edad"));
			}
				
			return null;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
	} 
	// AGREGAR CONTACTO No se admiten contactos con email duplicado ***********************************************************
	public boolean nuevoContacto(Contacto contacto,String emailNuevo) {
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){		
			Contacto contactoNuevo=existeContactoPorEmail(emailNuevo);
			
			if (contactoNuevo==null) {
				return false;
			}
			String sql="insert into contactos(nombre,email,edad) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			ps.setString(1, contacto.getNombre());
			ps.setString(2, contacto.getEmail());
			ps.setInt(3, contacto.getEdad());
			ps.execute();
			return true;
			
				
			}catch(SQLException ex) {
				ex.printStackTrace();
				return false;
			}
	}
	
	//devuelve el contacto eliminado. Si no se ha eliminado ninguno, devuelve null**********************************	
	public Contacto eliminarContacto(String email) {
		Contacto contacto=existeContactoPorEmail(email);
		if (contacto==null) {
			return null;
		}
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){		
			String sql="delete from contactos where email=?";
			PreparedStatement ps=con.prepareStatement(sql);
			//sustituimos parámetros por valores
			ps.setString(1, email);
			return contacto;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	// Actualizar contacto
	public boolean actualizarContacto(String email, int nuevaEdad) {
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){		
			String sql="update contactos set edad=? where email=?";
			PreparedStatement ps=con.prepareStatement(sql);
			//sustituimos parámetros por valores
			ps.setInt(1, nuevaEdad);
			ps.setString(2, email);
			return ps.executeUpdate()>0;	
		}catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	//Buscar un contacto dando su id
	public Contacto buscarContactoPorId (int id) {
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){		
			String sql="seclect from contactos where idContacto=id";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			// El puntero apunta encima de la primera fila, para que lea el dato tiene que avanzar una fila por eso el rs.next.
			if (rs.next()) {
				Contacto contactoId=new Contacto (rs.getInt("idContacto"),
						rs.getString("nombre"),
						rs.getString("emial"),
						rs.getInt("edad"));	
				return contactoId;
			}
			return null;
			
			}catch(SQLException ex) {
				ex.printStackTrace();
				return null;
			}
		}
	
	public List<Contacto> getContactos() {
		List<Contacto> contactos=new ArrayList<>();
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){		
			String sql="select * from contactos";
			PreparedStatement ps=con.prepareStatement(sql);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()) {
				contactos.add(new Contacto (rs.getInt("idContacto"),
						rs.getString("nombre"),
						rs.getString("emial"),
						rs.getInt("edad")));
			}
			return contactos;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
}

