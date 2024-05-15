package adaptadores;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Municipio;
import service.DatosProvinciasFactory;
import service.PaisesServiceFactory;

public class TableModelMunicipiosImpl extends AbstractTableModel {
	
	List<Municipio> municipios;
	
	public TableModelMunicipiosImpl (String codigoProvincia) {
		var municipiosService=DatosProvinciasFactory.DatosProvinciasService();
		municipios=municipiosService.municipiosComunidad(codigoProvincia);
	}

	@Override
	public int getRowCount() {
		return municipios.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnName(int column) {
		return switch (column) {
		case 0-> "Nombre";
		case 1->"Población";
		case 2->"Altitud";
		case 3->"Superficie";
		default->"";
	};
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return super.getColumnClass(columnIndex);
	}
	

}
