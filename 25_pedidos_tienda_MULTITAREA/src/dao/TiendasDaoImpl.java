package dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Pedido;

public class TiendasDaoImpl implements TiendasDao {

	private Stream <Pedido> getPedido(String ruta) {
		try {
			Gson gson=new Gson();
			return Arrays.stream(gson.fromJson(new FileReader(ruta), Pedido[].class)); //Stream<Pedido>
			
		}catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Stream.empty();
		}
	}
	
	@Override
	public List<Pedido> getPedidos(String ruta) {
		// TODO Auto-generated method stub
		return getPedido(ruta)
				.toList();
	}

}
