package graficos;

import java.awt.Color;

import javax.swing.JFrame;

public class MiVentana extends JFrame {
	public MiVentana() {
		super("Primera ventana swing");
		this.setBounds(100, 100, 700, 300);
		this.getContentPane().setBackground(Color.BLUE); // para que al cerraar la ventana se acabe el programa
		this.setVisible(true);
		
	}

}
