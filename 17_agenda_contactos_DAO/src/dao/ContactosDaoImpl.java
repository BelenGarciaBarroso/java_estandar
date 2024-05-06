package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.Contacto;

public class ContactosDaoImpl implements ContactosDao {

	@Override
	public void save(Contacto contacto) {
		// TODO Auto-generated method stub

	}

	@Override
	public Contacto findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Contacto contacto) {
		// TODO Auto-generated method stub

	}

	@Override
	public Contacto findById(int idContacto) {
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
	

	@Override
	public List<Contacto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
