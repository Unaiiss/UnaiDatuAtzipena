package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import modelo.DAOs.MunicipiosDAO;
import modelo.Municipios;
import modelo.Provincias;

import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class VerMunicipios extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private MunicipiosDAO municipiosDAO = new MunicipiosDAO();
    private Municipios municipio = null;

    /**
     * Create the frame.
     */
    public VerMunicipios(Provincias provincia) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String nombreMunicipio = (String) table.getValueAt(table.getSelectedRow(), 0);
        		municipio = municipiosDAO.obtenerMunicipio(nombreMunicipio);
        		MeteoVista meteo = new MeteoVista(municipio);
        		meteo.setVisible(true);
        		dispose();
        	}
        });
        btnSeleccionar.setBounds(285, 214, 119, 23);
        contentPane.add(btnSeleccionar);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(23, 11, 191, 202);
        contentPane.add(scrollPane);
        
                table = new JTable();
                scrollPane.setViewportView(table);
                table.setModel(new DefaultTableModel(
                    new Object[][] {}, // Inicialmente vacío
                    new String[] {"Nombre"} // Una columna para los nombres
                    
                ));
               table.setDefaultEditor(Object.class, null); // Deshabilitar la edición de celdas

        // Llamar al método para llenar la tabla con los municipios
        llenarTablaMunicipios(provincia);
    }

    /**
     * Método para llenar la tabla con los nombres de los municipios
     */
    private void llenarTablaMunicipios(Provincias provincia) {
        // Obtener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Obtener la lista de municipios de la provincia
        ArrayList<Municipios> listaMunicipios = municipiosDAO.obtenerMunicipios(provincia);

        // Recorrer los municipios y añadirlos al modelo de la tabla
        for (Municipios municipio : listaMunicipios) {
            model.addRow(new Object[]{municipio.getNombre()});
        }
    }
}
