package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.CentrosMeteorologicos;
import modelo.Municipios;
import modelo.Provincias;
import modelo.DAOs.CentroMetDao;
import modelo.DAOs.EspacioNatDao;
import modelo.DAOs.MedicionCMDao;
import modelo.DAOs.MunicipiosDAO;
import modelo.DAOs.ProvinciasDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ProvinciasDAO provinDao = new ProvinciasDAO();
	private EspacioNatDao enDao = new EspacioNatDao();
	private MunicipiosDAO muniDao = new MunicipiosDAO();
	private CentroMetDao centroMetDao = new CentroMetDao();
	private MedicionCMDao medicionDao = new MedicionCMDao();
	private Provincias provincia = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox listaDeProvincias = new JComboBox();
		listaDeProvincias.setBounds(242, 204, 189, 36);
		contentPane.add(listaDeProvincias);
		ArrayList<Provincias> listaProvincias = provinDao.obtenerNombres();
		for (int i = 0; i < listaProvincias.size(); i++) {
			listaDeProvincias.addItem(listaProvincias.get(i).getNombre());
		}
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//HACER TODO EN EL MISMO METODO
				Provincias provincia = provinDao.añadirProvincia();
				Municipios municipio = muniDao.añadirMunicipio(provincia);
				enDao.añadirEspacioNatural();
				CentrosMeteorologicos centroMet = centroMetDao.añadirCentroMet(municipio);
				medicionDao.añadirMediCentroMet(centroMet);
			}
		});
		btnIncluir.setBounds(40, 23, 102, 23);
		contentPane.add(btnIncluir);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String provinElegida = (String) listaDeProvincias.getSelectedItem();
				provincia = provinDao.obtenerProvincia(provinElegida);
				VerMunicipios frame = new VerMunicipios(provincia);
				//aqui mostrare la ventana de municipios pasandole la provincia y disabilitare esta ventana
				frame.setVisible(true);
				dispose();
			}
		});
		btnSeleccionar.setBounds(266, 305, 144, 23);
		contentPane.add(btnSeleccionar);
		

	}
}
