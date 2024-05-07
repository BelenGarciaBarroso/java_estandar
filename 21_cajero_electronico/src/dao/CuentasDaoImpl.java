package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import locator.LocatorConnection;
import model.Cuenta;

public class CuentasDaoImpl implements CuentasDao {

	@Override
	public Cuenta findById(int idcuenta) {
		try (Connection con=LocatorConnection.getConnection();){
			String sql="insert into provincias(codigo,nombre,codComunidad) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			con.setAutoCommit(false);//cancelamos autocommit
		return null;
	}

	@Override
	public void updateSaldo(int idcuenta, double nuevoSaldo) {
		// TODO Auto-generated method stub

	}

}
