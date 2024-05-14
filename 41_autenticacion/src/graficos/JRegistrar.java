package graficos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Cliente;
import service.ClientesService;
import service.ClientesServiceFactory;

public class JRegistrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfusuario;
	private JTextField tfpassword;
	private JTextField tfemail;
	private JTextField tftelefono;

	

	/**
	 * Create the frame.
	 */
	public JRegistrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JRegistrar frame = new JRegistrar();
		frame.setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfusuario = new JTextField();
		tfusuario.setText("Usuario");
		tfusuario.setBounds(205, 34, 86, 20);
		contentPane.add(tfusuario);
		tfusuario.setColumns(10);
		
		tfpassword = new JTextField();
		tfpassword.setText("Contraseña");
		tfpassword.setColumns(10);
		tfpassword.setBounds(205, 77, 86, 20);
		contentPane.add(tfpassword);
		
		tfemail = new JTextField();
		tfemail.setText("Email");
		tfemail.setColumns(10);
		tfemail.setBounds(205, 119, 86, 20);
		contentPane.add(tfemail);
		
		tftelefono = new JTextField();
		tftelefono.setText("Teléfono");
		tftelefono.setColumns(10);
		tftelefono.setBounds(205, 160, 86, 20);
		contentPane.add(tftelefono);
		
		JLabel lUsuario = new JLabel("Usuario");
		lUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lUsuario.setBounds(69, 37, 100, 14);
		contentPane.add(lUsuario);
		
		JLabel lpassword = new JLabel("Contraseña");
		lpassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lpassword.setBounds(69, 80, 100, 14);
		contentPane.add(lpassword);
		
		JLabel lEmail = new JLabel("Email");
		lEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lEmail.setBounds(69, 122, 100, 14);
		contentPane.add(lEmail);
		
		JLabel lTel = new JLabel("Teléfono");
		lTel.setHorizontalAlignment(SwingConstants.TRAILING);
		lTel.setBounds(69, 163, 100, 14);
		contentPane.add(lTel);
		
		JButton jbGuardar = new JButton("REGISTRAR");
		jbGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mensaje;
				String usuario=tfusuario.getText();
				String password=tfpassword.getText();
				String email=lEmail.getText();
				String tel=lTel.getText();
				ClientesService service=ClientesServiceFactory.getClientesService();
				Cliente cliente= new Cliente();
				cliente.setUsuario(usuario);
				cliente.setPassword(password);
				cliente.setEmail(email);
				cliente.setTelefono(Integer.parseInt(tel));
				if(service.registrar(cliente) ) {
					mensaje="GRABADO";
				}else {
					mensaje="el usuario ya existe";
				}	
			}
		});
		jbGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
		jbGuardar.setBounds(129, 231, 162, 41);
		contentPane.add(jbGuardar);
	}
}
