package principal;

import recursos.Recurso;
import tareas.HiloConductor;
import tareas.HiloConsumidor;

public class Lanzador {

	public static void main(String[] args) {
		Recurso recurso=new Recurso();
		new Thread(new HiloConductor(recurso)).start();
		new Thread(new HiloConsumidor(recurso)).start();
		

	}

}
