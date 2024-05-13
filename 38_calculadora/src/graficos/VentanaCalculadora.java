package graficos;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaCalculadora extends JFrame {
	
	public VentanaCalculadora () {
		super("CALCULADORA");
		this.setBounds(100,80,600,400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(Color.GRAY);
		this.setLayout(null);
		numeroUno();
		this.setVisible(true);
		
	}
	
	private void numeroUno() {
		JLabel jbn1=new JLabel ("Número Uno");
		JLabel jbn2=new JLabel ("Número Dos");
		JTextField jtf1=new JTextField ();
		JTextField jtf2=new JTextField ();
		JButton sumar=new JButton("Sumar");
		JButton multiplicar=new JButton("Multiplicar");
		
		jbn1.setBounds(150,50,200,50);
		jbn2.setBounds(150,150,200,30);
		jtf1.setBounds(300,70,100,20);
		jtf2.setBounds(300,150,100,20);
		sumar.setBounds(150,250,100,30);
		multiplicar.setBounds(300,250,100,30);
		
		
		this.add(jbn1);this.add(jbn2);this.add(jtf1);
		this.add(jtf2);this.add(sumar);this.add(multiplicar);
		
		//ActionListener listenerSumar
	}
		
		
	public int suma (String num1, String num2) {
		int numero1=Integer.parseInt(num1);
		int numero2=Integer.parseInt(num2);
		
		
			
			return numero1+numero2;
			
		}
		
	
	}
	
	

}
