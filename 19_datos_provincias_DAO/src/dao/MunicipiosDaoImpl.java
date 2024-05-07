package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import locator.LocatorConnection;
import model.Municipio;

public class MunicipiosDaoImpl implements MunicipiosDao {

	@Override
	public void saveMunicipios(List<Municipio> municipios) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> findCodigos() {
		List<String> codigos=new ArrayList<String>();
		try (Connection con=LocatorConnection.getConnection();){
			String sql="select codigo from municipios";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while( rs.next ()) {
					codigos.add(rs.getString(1));
				}
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			return codigos;
		} 

}
