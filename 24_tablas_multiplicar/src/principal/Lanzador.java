package principal;

import tareas.Multiplicacion;


public class Lanzador {

	public static void main(String[] args) {
		new Thread(new Multiplicacion(5)).start();
		new Thread(new Multiplicacion(7)).start();
		new Thread(new Multiplicacion(3)).start();

		

	}

}
