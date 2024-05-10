package recursos;

public class Contador {
	private int valor;
	public synchronized void incrementar () {
		//synchronized (this) { //se incluye synchronize para que de tiempo a realizar todas las tareas
			int temp=valor;
			temp=temp+1;
			valor=temp;
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		//}
		
	}
	
	public int getValor () {
		return valor;
		
	}
}
