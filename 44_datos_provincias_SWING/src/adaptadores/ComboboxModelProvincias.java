package adaptadores;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import model.Provincia;
import service.DatosProvinciasFactory;

public class ComboboxModelProvincias extends DefaultComboBoxModel<Provincia> {
	List<Provincia> provincias;
	
	public ComboboxModelProvincias (String comunidad) {
		var provinciasService=DatosProvinciasFactory.DatosProvinciasService();
		provincias=provinciasService.provinciasComunidad(comunidad);
	}

	@Override
	public int getSize() {
		return provincias.size();
	}

	@Override
	public Provincia getElementAt(int index) {
		return provincias.get(index);
	}
	

}
