package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Pais;

public class PaisesServce {
	/*Implementar lógica de negocio de una aplicación que proporcione información
	sobre paises. Cada pais se caracteriza por: nombre,continente,capital,habitantes

	-Lista de continentes
	-Lista de paises a partir del continente
	-Pais más poblado
	-Tabla con paises agurpados por continente
	-Pais a partir de su capital */
	
String ruta="C:\\Users\\manana\\Desktop\\BELENGB\\JSON\\paises.json";
	
//**************************************************************************************
	private Stream <Pais> getPaises() {
		try {
			Gson gson=new Gson();
			return Arrays.stream(gson.fromJson(new FileReader(ruta), Pais[].class)); //Stream<Pais>
			
		}catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Stream.empty();
		}
	}
	
//*********************************************************************************************
	public List<String> listaContinentes () {
		return getPaises() //Stream<Pais>
				.map(n->n.getContinente())
				.distinct()
				.toList();
		
	}
	
//*************************************************************************************
	public List<Pais> paisContiente (String continente) {
		return getPaises()
				.filter(e->e.getContinente().equals(continente))
				.toList();	
	}
	
//***********************************************************************************
	public String paisMasPoblado() {
		return getPaises()
				.max(Comparator.comparingInt(n->n.getHabitantes()))
				.toString();
	}
	
//*****************************************************************************************
	public Map<String,List<Pais>> paisesPorContinentes() {
		return getPaises()
				.collect(Collectors.groupingBy(n->n.getContinente()));
	}
	
	public String paisPorCapital (String capital) {
		return getPaises()
				.filter(p->p.getCapital()!=null && p.getCapital().equals(capital))
				.findFirst()
				.map(p->p.getNombre())
				.orElse("");
		
		
	}

}
