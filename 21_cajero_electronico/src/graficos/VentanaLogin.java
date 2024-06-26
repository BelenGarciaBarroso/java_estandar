package graficos;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Cuenta;
import service.CajeroServiceFactory;

public class VentanaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TxNumCuenta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel textoCuenta = new JLabel("Nº de Cuenta:");
		textoCuenta.setBounds(35, 67, 79, 29);
		contentPane.add(textoCuenta);
		
		TxNumCuenta = new JTextField();
		TxNumCuenta.setBounds(124, 71, 131, 20);
		contentPane.add(TxNumCuenta);
		TxNumCuenta.setColumns(10);
		
		
		JButton Entrar = new JButton("ENTRAR");
		Entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var service =CajeroServiceFactory.getCajeroService();
				Cuenta cuenta=service.obtenerCuenta(Integer.parseInt(TxNumCuenta.getText()));
				
				if (cuenta!=null) {
					new VentanaMenu(cuenta);
					VentanaLogin.this.dispose();
				} else {
					String mensaje ="La cuenta NO existe";
					JOptionPane.showMessageDialog(VentanaLogin.this, mensaje);
					
					
				}
			}
		});
		Entrar.setBounds(104, 157, 89, 23);
		contentPane.add(Entrar);
		
		
	}
}
