package principal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Lanzador {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Lanzar dos tareas que se ejecuten concurrentemente. Una de ellas calculará la suma
		// de todos los números entre 1 y 100. Y la otra, calculará el factorial de un número cualquiera.
		// Cuando las tareas finalicen, el programa principal mostrará los resultados.
		// Mientras las tareas estén en ejecución, el programa principal estará haciendo otras cosas.
		ExecutorService executor=Executors.newCachedThreadPool();
		// Tarea suma
		Future<Integer> f1=executor.submit(()-> {
			int suma=0;
			for (int i=1;i<=100;i++) {
				suma+=i;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return suma;
		});
		
		// Factorial de 6
		Future<Integer> f2=executor.submit(()->{
			int p=1;
			for (int i=1;i<=6;i++) {
				p*=i;
				try {
					Thread.sleep(100);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return p;
		});
		
		// el main sigue haciendo algo hasta que las tareas terminen,
		// momento en el que se mostrará los resultados
		while(!f1.isDone()||!f2.isDone()) {
			System.out.println("El main haciendo cosas...");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Suma de los números: "+f1.get());
		System.out.println("El factorial de 6 es: "+f2.get());
		executor.shutdown();
		
		

	}

}
