package graficos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import adaptadores.ComboboxModelProvincias;
import service.DatosProvinciasFactory;

public class VentanaProvincias extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaProvincias frame = new VentanaProvincias();
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
	public VentanaProvincias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbComunidades = new JLabel("Comunidades");
		lbComunidades.setHorizontalAlignment(SwingConstants.RIGHT);
		lbComunidades.setFont(new Font("Verdana", Font.BOLD, 12));
		lbComunidades.setBounds(30, 29, 111, 14);
		contentPane.add(lbComunidades);
		
		JComboBox cbProvincias = new JComboBox();
		
		JComboBox cbComunidades = new JComboBox();
		cbComunidades.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) { // con esto hacemos que solo muestre el diálogo una vez. ItemEvent.SELECTED es lo que hemos seleccinado con el cursor
					String seleccionado=(String)cbComunidades.getSelectedItem();
					var service= DatosProvinciasFactory.DatosProvinciasService();
					//JOptionPane.showMessageDialog(VentanaPaises.this, "Paises de "+seleccionado+" :"+service.getPaisesFiltradosPor(seleccionado).size());
					// Creamos adaptador con los datos de los paises y lo volcamos a JTable
					var comboProvincias=new ComboboxModelProvincias(seleccionado);
					cbProvincias.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent e) {
							
						}
					});
				}	
			}
		});
		
		cbComunidades.setBounds(151, 25, 167, 22);
		contentPane.add(cbComunidades);
		
		JLabel lbProvincias = new JLabel("Provincias");
		lbProvincias.setHorizontalAlignment(SwingConstants.RIGHT);
		lbProvincias.setFont(new Font("Verdana", Font.BOLD, 12));
		lbProvincias.setBounds(30, 61, 111, 14);
		contentPane.add(lbProvincias);
		
		
		
		
		cbProvincias.setBounds(151, 57, 167, 22);
		contentPane.add(cbProvincias);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 127, 414, 223);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
