package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tareas.Multiplicacion;


public class Lanzador {

	public static void main(String[] args) {
		ExecutorService executor=Executors.newCachedThreadPool();
		executor.submit(new Multiplicacion(5));
		executor.submit(new Multiplicacion(7));
		executor.submit(new Multiplicacion(3));

		// una vez lanzadas las tareas hay que parar el executor
		
		executor.shutdown();

	}

}
