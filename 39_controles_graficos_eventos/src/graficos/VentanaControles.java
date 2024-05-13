package graficos;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaControles extends JFrame {
	public VentanaControles () {
		super("Ventana controles");
		this.setBounds(100, 80, 800, 400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// Creación y configuración de controles
		initComponents();
		this.setVisible(true);
	}
	
	private void initComponents() {
		this.setLayout(null);
		JButton jbt1=new JButton("Pulsar aquí");
		JLabel jbl1=new JLabel();
		JButton jbt2=new JButton("Colorear");
		jbt1.setBounds(50, 50, 300, 50);
		jbl1.setBounds(100, 100, 150, 40);
		jbt2.setBounds(380, 50, 150,50);
		this.getContentPane().setBackground(Color.GRAY);
		this.add(jbt1);
		this.add(jbl1);
		this.add(jbt2);
		// Gestión de eventos
		ActionListener listener=e->jbl1.setText("PULSADO");
		// Asociamos la acción al botón u objeto
		jbt1.addActionListener(listener);
		
		ActionListener listener2=e->VentanaControles.this.getContentPane().setBackground(Color.YELLOW);
		jbt2.addActionListener(listener2);
	}

}
