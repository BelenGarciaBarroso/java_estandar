package graficos;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import model.Cuenta;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class VentanaMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	Cuenta cuenta;

	/**
	 * Create the frame.
	 */
	public VentanaMenu(Cuenta cuenta) {
		this.cuenta=cuenta;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 178, 206);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("OPERACIONES");
		menuBar.add(mnNewMenu);
		
		JMenuItem titulares = new JMenuItem("Titulares");
		mnNewMenu.add(titulares);
		
		JMenuItem ingreso = new JMenuItem("Ingreso");
		mnNewMenu.add(ingreso);
		
		JMenuItem extraciones = new JMenuItem("Extraciones");
		mnNewMenu.add(extraciones);
		
		JMenuItem transfers = new JMenuItem("Transferencias");
		mnNewMenu.add(transfers);
		
		JMenuItem saldoMovi = new JMenuItem("Saldo y Mov.");
		saldoMovi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new VentanaMovimientos(cuenta);
			}
		});
		mnNewMenu.add(saldoMovi);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setVisible(true);
	}

	
}
