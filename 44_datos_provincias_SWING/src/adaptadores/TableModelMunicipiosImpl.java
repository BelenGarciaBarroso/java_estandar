package adaptadores;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Municipio;
import service.DatosProvinciasFactory;


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
		return switch (columnIndex) {
		case 0-> municipios.get(rowIndex).getNombreMunicipio();
		case 1->municipios.get(rowIndex).getPoblacion();
		case 2->municipios.get(rowIndex).getAltitud();
		case 3->municipios.get(rowIndex).getSuperficie();
		default->"";
		};
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
		return switch (columnIndex) {
		case 0->String.class;
		case 1->String.class;
		case 2->String.class;
		case 3->Double.class;
		default->String.class;
		};
	}
	

}
