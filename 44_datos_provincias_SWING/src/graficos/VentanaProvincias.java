package graficos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import adaptadores.ComboboxModelComunidadesImpl;
import adaptadores.ComboboxModelProvincias;
import adaptadores.TableModelMunicipiosImpl;
import model.Provincia;

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
		setBounds(100, 100, 519, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbComunidades = new JLabel("Comunidad");
		lbComunidades.setHorizontalAlignment(SwingConstants.RIGHT);
		lbComunidades.setFont(new Font("Verdana", Font.BOLD, 12));
		lbComunidades.setBounds(31, 50, 111, 14);
		contentPane.add(lbComunidades);
		
		JComboBox <Provincia>cbProvincias = new JComboBox<>();
		cbProvincias.setBounds(152, 78, 167, 22);
		contentPane.add(cbProvincias);
		
		cbProvincias.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String codigoProv=((Provincia)cbProvincias.getSelectedItem()).getCodigoProvincia();
				if(e.getStateChange()==ItemEvent.SELECTED) {
					table.setModel(new TableModelMunicipiosImpl(codigoProv));
				}
			}
		});
		
		JComboBox <String> cbComunidades = new <String>JComboBox();
		cbComunidades.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) { // con esto hacemos que solo muestre el diálogo una vez. ItemEvent.SELECTED es lo que hemos seleccinado con el cursor
					String comunidad=(String)cbComunidades.getSelectedItem();
					cbProvincias.setModel(new ComboboxModelProvincias(comunidad));
					//para borrar la tabla de municipios
					//de selecciones previas
					table.setModel(new DefaultTableModel());
					
				}	
			}
		});
		
		
		
		cbComunidades.setBounds(152, 46, 167, 22);
		contentPane.add(cbComunidades);
		
		
		JLabel lbProvincias = new JLabel("Provincia");
		lbProvincias.setHorizontalAlignment(SwingConstants.RIGHT);
		lbProvincias.setFont(new Font("Verdana", Font.BOLD, 12));
		lbProvincias.setBounds(31, 82, 111, 14);
		contentPane.add(lbProvincias);
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 151, 414, 199);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblMunicipios = new JLabel("Municipios");
		lblMunicipios.setFont(new Font("Verdana", Font.BOLD, 12));
		lblMunicipios.setBounds(10, 126, 111, 14);
		contentPane.add(lblMunicipios);
		
		//carga de comunidades
		cbComunidades.setModel(new ComboboxModelComunidadesImpl());
		
		JButton salir = new JButton("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaProvincias.this.dispose();
			}
		});
		salir.setFont(new Font("Verdana", Font.BOLD, 13));
		salir.setBounds(163, 365, 89, 23);
		contentPane.add(salir);
		
		JLabel lbReloj = new JLabel("");
		lbReloj.setFont(new Font("Verdana", Font.PLAIN, 12));
		lbReloj.setBounds(366, 22, 111, 14);
		contentPane.add(lbReloj);
		
		// Hilo Reloj
		ExecutorService service= Executors.newCachedThreadPool();
		service.submit(()->{
			// Actualizar reloj cada medio segundo
			while (true) {
				LocalTime hora= LocalTime.now();
				lbReloj.setText(hora.toString());
				Thread.sleep(500);
			}
		});
		// para parar de ejecurtarse el programa despues de cerrar la ventana, hay qu eparar el reloj.
		service.shutdown();
		
	}
}
