package principal;

import recursos.Contador;

public class LanzarClientes {

	public static void main(String[] args)  {
		Contador cont=new Contador();
		//ejecutamos 100 tareas cuya misitón sea simplemente incrementar el cntador
		for (int i=1;i<=1000;i++) {
			new Thread (()-> cont.incrementar()).start();
		}
		// ponemos un retardo para esperar a que todas las tareas terminen
		try {
			Thread.sleep(25000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Imprimimos el contador
		System.out.println(cont.getValor());
	}

}
