package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Timestamp;


import locator.LocatorConnection;
import model.Pedido;

public class PedidosDaoImpl implements PedidosDao {

	@Override
	public void guardarPedido(Pedido pedido) {
		try (Connection con=LocatorConnection.getConnection();){
			String sql="insert into pedidos(producto,tienda,precio) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			con.setAutoCommit(false);//cancelamos autocommit
			
			ps.setString(1, pedido.getProducto());
			ps.setString(2, pedido.getTienda());
			//ps.setTimestamp(3, Timestamp.valueOf(p.getFechaPedido()));
			ps.setDouble(4, pedido.getPrecio());
			
			ps.execute();
			
			con.commit();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}

	}

}
