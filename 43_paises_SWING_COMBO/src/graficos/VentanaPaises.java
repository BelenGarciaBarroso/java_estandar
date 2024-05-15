package graficos;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adaptadores.ComboBoxModelContinentesImpl;
import service.PaisesServiceFactory;

public class VentanaPaises extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPaises frame = new VentanaPaises();
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
	public VentanaPaises() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Continentes:");
		lblNewLabel.setBounds(30, 27, 81, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox<String> comboContinentes = new JComboBox();
		comboContinentes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) { // con esto hacemos que solo muestre el diálogo una vez. ItemEvent.SELECTED es lo que hemos seleccinado con el cursor
					String seleccionado=(String)comboContinentes.getSelectedItem();
					var service= PaisesServiceFactory.getPaisesService();
					JOptionPane.showMessageDialog(VentanaPaises.this, "Paises de "+seleccionado+" :"+service.getPaisesFiltradosPor(seleccionado).size());
				}	
			}
		});
		comboContinentes.setBounds(97, 23, 117, 18);
		contentPane.add(comboContinentes);
		comboContinentes.setModel(new ComboBoxModelContinentesImpl());
		
			
		
		
	}
}
