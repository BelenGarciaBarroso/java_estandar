package principal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class EscrituraLista {

	public static void main(String[] args) {
		String ruta="nombres.txt";
		Path pt=Path.of(ruta);
		List<String> dias=List.of("lunes","martes","miercoles","jueves","vienes");
		try {
			if (Files.notExists(pt)) {
				Files.createFile(pt);
			}
			Files.write(pt,dias,StandardOpenOption.APPEND);
		} catch(IOException ex) {
			// comentario
			ex.printStackTrace();
		}

	}

}
