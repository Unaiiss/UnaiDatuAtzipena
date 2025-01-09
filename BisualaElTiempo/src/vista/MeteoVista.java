package vista;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.EspaciosNaturales;
import modelo.Municipios;
import modelo.DAOs.EspacioNatDao;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class MeteoVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaCentrosMet;
	private JTable tablaEspaciosNat;
	private JScrollPane scrollPane_1;
	private JButton btnSeleccionar;
	private EspacioNatDao enDao = new EspacioNatDao();

	/**
	 * Create the frame.
	 */
	public MeteoVista(Municipios municipio) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 30, 215, 202);
		contentPane.add(scrollPane);

		tablaCentrosMet = new JTable();
		tablaCentrosMet.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Centros meteorologicos" }) {
			Class[] columnTypes = new Class[] { String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tablaCentrosMet);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(312, 30, 245, 202);
		contentPane.add(scrollPane_1);

		tablaEspaciosNat = new JTable();
		tablaEspaciosNat.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Espacios naturales" }) {
			Class[] columnTypes = new Class[] { String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setViewportView(tablaEspaciosNat);

		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(400, 278, 157, 23);
		contentPane.add(btnSeleccionar);

		llenarTablaEspaciosNat(municipio);

	}

	private void llenarTablaEspaciosNat(Municipios municipio) {
		// Obtener el modelo de la tabla
		DefaultTableModel model = (DefaultTableModel) tablaEspaciosNat.getModel();

		// Obtener la lista de municipios de la provincia
		ArrayList<EspaciosNaturales> listaEspNaturales = enDao.obtenerEspaciosNaturales(municipio);

		// Recorrer los municipios y añadirlos al modelo de la tabla
		for (EspaciosNaturales espNatural : listaEspNaturales) {
			model.addRow(new Object[] { espNatural.getNombre() });
		}
	}

}
