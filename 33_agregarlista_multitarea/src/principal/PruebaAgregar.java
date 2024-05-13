package principal;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PruebaAgregar {

	public static void main(String[] args) {
		CopyOnWriteArrayList<Integer> lista= new CopyOnWriteArrayList<Integer>();
		ExecutorService executor=Executors.newCachedThreadPool();
		for (int i=1;i<=100000;i++) {
			executor.submit(()->lista.add((int)(Math.random()*500+1)));
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Tamano de la lista: " + lista.size());
		
	}

}
