package graficos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import service.ClientesService;
import service.ClientesServiceFactory;

public class JAutenticar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfusuario;
	private JTextField tfpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JAutenticar frame = new JAutenticar();
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
	public JAutenticar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jtfusuario = new JLabel("Usuario");
		jtfusuario.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		jtfusuario.setBounds(113, 41, 58, 30);
		contentPane.add(jtfusuario);
		
		tfusuario = new JTextField();
		tfusuario.setFont(new Font("Verdana", Font.PLAIN, 12));
		tfusuario.setBounds(190, 46, 150, 20);
		contentPane.add(tfusuario);
		tfusuario.setColumns(10);
		
		JLabel jtfpassword = new JLabel("Password");
		jtfpassword.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		jtfpassword.setBounds(103, 81, 68, 30);
		contentPane.add(jtfpassword);
		
		tfpassword = new JTextField();
		tfpassword.setFont(new Font("Verdana", Font.PLAIN, 12));
		tfpassword.setColumns(10);
		tfpassword.setBounds(190, 87, 150, 20);
		contentPane.add(tfpassword);
		
		JButton jbvalidar = new JButton("Validar");
		jbvalidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mensaje;
				String usuario=tfusuario.getText();
				String password=tfpassword.getText();
				ClientesService service=ClientesServiceFactory.getClientesService();
				if(service.autenticar(usuario, password) ) {
					mensaje="VAlIDADO";
				}else {
					mensaje="Usuario o password no válidos";
				}
				JOptionPane.showMessageDialog(JAutenticar.this, mensaje);
			}
		});
		jbvalidar.setFont(new Font("Verdana Pro", Font.PLAIN, 13));
		jbvalidar.setBounds(180, 169, 89, 23);
		contentPane.add(jbvalidar);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(200, 77, 5, 22);
		contentPane.add(textArea);
		
		JButton jbregistrar = new JButton("Registrar");
		jbregistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRegistrar registrar=new JRegistrar();
				registrar.setVisible(true);
			
				
			}
		});
		jbregistrar.setBounds(10, 227, 89, 23);
		contentPane.add(jbregistrar);
	}
}
