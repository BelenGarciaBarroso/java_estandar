package tareas;

public class TareaDescendente extends Thread {

	@Override
	public void run() {
		for (int j=100;j>=1;j--) {
			System.out.println("descendente: "+j);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
