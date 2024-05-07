package dao;

import java.util.List;

import model.Comunidad;

public interface ComunidadesDao {
	
	void saveComunidad (List<Comunidad> comunidades); // Los volcados son siempre Dao
	boolean existComunidad (String codigo); // comprueba si existe una comunidad

	
	
	
	
		
}


