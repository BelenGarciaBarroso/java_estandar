package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import locator.LocatorConnection;
import model.Cliente;

public class ClientesDaoImpl implements ClientesDao {

	@Override
	public Cliente findByCuenta(int idCuenta) {
		try (Connection con=LocatorConnection.getConnection();){
			String sql="select * from clientes where dni=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, idCuenta);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return new Cliente(rs.getInt("dni"),
						rs.getString("nombre"),
						rs.getString("direccion"),
						rs.getInt("telefono"));
			}
			return null;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}

	}

}
