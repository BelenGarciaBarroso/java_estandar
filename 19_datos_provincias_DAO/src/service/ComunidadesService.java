package service;

import java.util.List;

import model.Comunidad;
import model.Municipio;
import model.Provincia;

public interface ComunidadesService {
	
	
	// Salva la lista de comundades, evitando guardar por segunda vez comunidades que ya están 
	// en la bbdd.Devuelve el total de comunidades guardadas
	int saveComunidades(List<Comunidad> comunidades);

	// Salva la lista de provincias, evitando guardar por segunda vez provincias que ya están 
	// en la bbdd.Devuelve el total de provincias guardadas
	int saveProvincias(List<Provincia> provincias);

	// Salva la lista de municipios, evitando guardar por segunda vez municipios que ya están 
	// en la bbdd.Devuelve el total de municipios guardadas
	int saveMunicipios(List<Municipio> municipios);

}