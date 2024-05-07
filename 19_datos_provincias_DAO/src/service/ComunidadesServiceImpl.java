package service;

import java.util.List;

import dao.ComunidadesDao;
import dao.ComunidadesDaoFactory;
import dao.MunicipiosDao;
import dao.ProvinciasDao;
import model.Comunidad;
import model.Municipio;
import model.Provincia;

public class ComunidadesServiceImpl implements ComunidadesService {
	ComunidadesDao comunidadesDao;
	ProvinciasDao provinciasDao;
	MunicipiosDao municipiosDao;
	
	public ComunidadesServiceImpl() {
		comunidadesDao=ComunidadesDaoFactory.getComunidadesDao();
		provinciasDao=ComunidadesDaoFactory.getProvinciasDao();
		municipiosDao=ComunidadesDaoFactory.getMunicipiosDao();
	}
	@Override
	public int saveComunidades(List<Comunidad> comunidades) {
//		int cont=0;
//		for (Comunidad c:comunidades) {
//			if (!comunidadesDao.existComunidad(c.getCodigo())) {
//				comunidadesDao.saveComunidad(c);
//				cont++;
//			}
//		}
//		return cont;
		
//		return (int)comunidades.stream()
//				.filter(c->!comunidadesDao.existComunidad(c.getCodigo()))
//				.peek(c->comunidadesDao.saveComunidad(c))
//				.count();
		
		/*List<Comunidad> comunidadesSinRepetir = new ArrayList<>();
		for (Comunidad c:comunidades) {
			if (!comunidadesDao.existComunidad(c.getCodigo())) {
				comunidadesSinRepetir.add(c);				
			}
			
		}
		comunidades.saveComunidade(comunidadesSinRepetir);*/
		List<Comunidad> comunidadesSinRepetir = comunidades.stream()
				.filter(c->!comunidadesDao.existComunidad(c.getCodigo()))
				.toList();
		comunidadesDao.saveComunidad(comunidadesSinRepetir);
		return comunidadesSinRepetir.size();
	}

	@Override
	public int saveProvincias(List<Provincia> provincias) {
		List<String> codigos=provinciasDao.findCodigos();
		List<Provincia> provinciasSinRepetir=provincias.stream()
				.filter(p->!codigos.contains(p.getCodigo()))
				.toList();
		provinciasDao.saveProvincias(provinciasSinRepetir);
		return provinciasSinRepetir.size();
	}

	@Override
	public int saveMunicipios(List<Municipio> municipios) {
		List<String> codigos=municipiosDao.findCodigos();
		List<Municipio> provinciasSinRepetir=municipios.stream()
				.filter(p->!codigos.contains(p.getCodigo()))
				.toList();
		return provinciasSinRepetir.size();
	}
	
}
