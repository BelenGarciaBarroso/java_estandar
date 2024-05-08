package principal;

import tareas.TareaAscendente;
import tareas.TareaDescendente;

public class Lanzador {

	public static void main(String[] args) {
		var t1=new TareaAscendente();
		var t2= new TareaDescendente();
		t1.start();
		t2.start();

	}

}
