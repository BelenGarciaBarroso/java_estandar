package adaptadores;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import service.DatosProvinciasFactory;
import service.DatosProvinciasService;
import service.DatosProvinciasServiceImpl;

public class ComboboxModelComunidadesImpl extends DefaultComboBoxModel<String> {
	List<String> comunidades;
	
	public ComboboxModelComunidadesImpl () {
		var comunidadesService=DatosProvinciasFactory.DatosProvinciasService();
		comunidades=comunidadesService.comunidades();
	}

	@Override
	public int getSize() {
		return comunidades.size();
	}

	@Override
	public String getElementAt(int index) {
		return comunidades.get(index);
	}
	

}
