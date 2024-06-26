package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
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

		Gson gson=new Gson();
		String url="http://restcountries.com/v2/all";
		//Creaamos objeto request que configura la petición
		HttpRequest resquest=HttpRequest.newBuilder()
				.uri(URI.create(url))
				.GET()
				.build();
		//creamos objeto client para hacer la llamada
		HttpClient client=HttpClient.newBuilder()
				.build();
		//realizamos la llamda
		try {
			HttpResponse<String> respuesta=client.send(resquest, BodyHandlers.ofString());
			Arrays.stream(gson.fromJson(respuesta.body(),Pais[].class));
			// Le decimos que nos traiga los datos en forma de array y luego lo convertimos a stream de Pais
		} catch (IOException | InterruptedException e) {
			// TODO
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
