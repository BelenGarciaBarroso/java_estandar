package principal;

import java.util.concurrent.atomic.AtomicInteger;

// Se sustituye Sychroni<ee.

public class LanzarClientes {

	public static void main(String[] args)  {
		AtomicInteger cont=new AtomicInteger(); // Sustituye a Synchronized.
		//ejecutamos 100 tareas cuya misitón sea simplemente incrementar el cntador
		for (int i=1;i<=1000;i++) {
			new Thread (()-> cont.incrementAndGet()).start();
		}
		// ponemos un retardo para esperar a que todas las tareas terminen
//		try {
//			Thread.sleep(1000000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// Imprimimos el contador
		System.out.println(cont.get());
	}

}
