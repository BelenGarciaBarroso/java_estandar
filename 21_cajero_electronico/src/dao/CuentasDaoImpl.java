package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import locator.LocatorConnection;
import model.Cuenta;

public class CuentasDaoImpl implements CuentasDao {

	@Override
	public Cuenta findById(int idcuenta) {
		try (Connection con=LocatorConnection.getConnection();){
			String sql="select * from cuentas where numeroCuenta=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, idcuenta);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return new Cuenta(rs.getInt("numeroCuenta"),
						rs.getDouble("saldo"),
						rs.getString("tipocuenta"));
			}
			return null;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	
	}

	@Override
	public void updateSaldo(int idcuenta, double nuevoSaldo) {
		try (Connection con=LocatorConnection.getConnection();){
			String sql="UPDATE cuentas SET saldo = ? WHERE numeroCuenta = ?"; 
			PreparedStatement ps=con.prepareStatement(sql);

			
			ps.setDouble(1, nuevoSaldo);
			ps.setInt(2, idcuenta);
			ps.execute();

		}catch(SQLException ex) {
			ex.printStackTrace();
			
		}
	}

}
