package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import modelo.Partido;
import modelo.funcionesFichero;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class menu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldEquipoLocal;
    private JTextField textFieldEquipoVisit;
    private JTextField textFieldGolesLocal;
    private JTextField textFieldGolesVisit;
    private JTextField textFieldLugar;
    private JTextField textFieldFecha;
    private JTable table;
    
    // Ahora el ArrayList es un campo de clase
    private ArrayList<Partido> partidoArray = new ArrayList<>();
    private DefaultTableModel tableModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    menu frame = new menu();
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
    public menu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 559, 534);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblEquipoLocal = new JLabel("Equipo local");
        lblEquipoLocal.setBounds(33, 23, 74, 14);
        contentPane.add(lblEquipoLocal);
        
        JLabel lblEquipoVisitante = new JLabel("Equipo visitante");
        lblEquipoVisitante.setBounds(33, 53, 97, 14);
        contentPane.add(lblEquipoVisitante);
        
        JLabel lblGolesLocal = new JLabel("Goles local");
        lblGolesLocal.setBounds(33, 87, 74, 14);
        contentPane.add(lblGolesLocal);
        
        JLabel lblGolesVisitante = new JLabel("Goles visitante");
        lblGolesVisitante.setBounds(33, 117, 97, 14);
        contentPane.add(lblGolesVisitante);
        
        JLabel lblLugar = new JLabel("Lugar");
        lblLugar.setBounds(33, 146, 74, 14);
        contentPane.add(lblLugar);
        
        JLabel lblFecha = new JLabel("Fecha");
        lblFecha.setBounds(33, 182, 74, 14);
        contentPane.add(lblFecha);
        
        textFieldEquipoLocal = new JTextField();
        textFieldEquipoLocal.setBounds(137, 20, 133, 20);
        contentPane.add(textFieldEquipoLocal);
        textFieldEquipoLocal.setColumns(10);
        
        textFieldEquipoVisit = new JTextField();
        textFieldEquipoVisit.setColumns(10);
        textFieldEquipoVisit.setBounds(137, 50, 133, 20);
        contentPane.add(textFieldEquipoVisit);
        
        textFieldGolesLocal = new JTextField();
        textFieldGolesLocal.setColumns(10);
        textFieldGolesLocal.setBounds(137, 84, 133, 20);
        contentPane.add(textFieldGolesLocal);
        
        textFieldGolesVisit = new JTextField();
        textFieldGolesVisit.setColumns(10);
        textFieldGolesVisit.setBounds(137, 114, 133, 20);
        contentPane.add(textFieldGolesVisit);
        
        textFieldLugar = new JTextField();
        textFieldLugar.setColumns(10);
        textFieldLugar.setBounds(137, 143, 133, 20);
        contentPane.add(textFieldLugar);
        
        textFieldFecha = new JTextField();
        textFieldFecha.setColumns(10);
        textFieldFecha.setBounds(137, 179, 133, 20);
        contentPane.add(textFieldFecha);
        
        // Botón "Añadir" para agregar el partido al ArrayList y actualizar el JTable
        JButton btnAñadir = new JButton("Añadir");
        btnAñadir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crear un nuevo partido con los datos ingresados
                Partido partido = new Partido(
                    textFieldEquipoLocal.getText(),
                    textFieldEquipoVisit.getText(),
                    Integer.parseInt(textFieldGolesLocal.getText()),
                    Integer.parseInt(textFieldGolesVisit.getText()),
                    textFieldLugar.getText(),
                    textFieldFecha.getText()
                );
                
                // Añadir el partido al ArrayList
                partidoArray.add(partido);
                
                // Limpiar los campos de texto
                textFieldEquipoLocal.setText("");
                textFieldEquipoVisit.setText("");
                textFieldGolesLocal.setText("");
                textFieldGolesVisit.setText("");
                textFieldLugar.setText("");
                textFieldFecha.setText("");

                // Actualizar el JTable
                actualizarTabla(partidoArray);
                
            }
        });
        btnAñadir.setBounds(10, 227, 89, 23);
        contentPane.add(btnAñadir);
        
        JButton btnCargar = new JButton("Cargar");
        btnCargar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		partidoArray = funcionesFichero.leerFichero();
        		actualizarTabla(partidoArray);
        		partidoArray.clear();
        		JOptionPane.showMessageDialog(null, "Se han cargado correctamente los datos");
        	}
        });
        btnCargar.setBounds(128, 227, 89, 23);
        contentPane.add(btnCargar);
        
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		funcionesFichero.escribirFichero(partidoArray);
                // Limpiar el modelo de la tabla después de agregar los nuevos datos
                tableModel.setRowCount(0);
        		JOptionPane.showMessageDialog(null, "Se han guardado correctamente los datos");
        	}
        });
        btnGuardar.setBounds(250, 227, 89, 23);
        contentPane.add(btnGuardar);
        
        // Configuración del JTable con JScrollPane
        tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Equipo Local", "Equipo Visitante", "Goles Local", "Goles Visitante", "Lugar", "Fecha"});
        table = new JTable(tableModel);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 261, 513, 223);  // Ajusta las dimensiones según sea necesario
        contentPane.add(scrollPane);
    }
    
    // Método para actualizar el JTable con los datos del ArrayList
    private void actualizarTabla(ArrayList<Partido> partidoArray) {
        
        // Agregar cada partido del ArrayList al JTable
        for (Partido partido : partidoArray) {
            tableModel.addRow(new Object[]{
                partido.getEquipoLocal(),
                partido.getEquipoVisitante(),
                partido.getGolesLocal(),
                partido.getGolesVisitante(),
                partido.getLugar(),
                partido.getFecha()
            });
        }
    }
}
