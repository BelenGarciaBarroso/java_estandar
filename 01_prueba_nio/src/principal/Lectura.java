package principal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lectura {

	public static void main(String[] args) {
		String ruta="nombres.txt";
		Path pt=Path.of(ruta);
		try {
			Files.lines(pt)//Stream<String>
			.forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
