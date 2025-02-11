package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import modelo.Stock;
import java.util.ArrayList;

public class TablaStocks extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public TablaStocks(ArrayList<Stock> stockList) {

		// Configuración básica de la ventana
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255)); // Fondo azul claro
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Título de la ventana
		JLabel lblTitle = new JLabel("Erabiltzailearen Ordutegia");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
		lblTitle.setForeground(new Color(0, 51, 102)); // Azul oscuro
		lblTitle.setBounds(200, 20, 300, 30);
		contentPane.add(lblTitle);

		// Etiqueta para mostrar el usuario actual
		JLabel lblCurrentUserOrdutegia = new JLabel();
		lblCurrentUserOrdutegia.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCurrentUserOrdutegia.setForeground(new Color(0, 51, 102));
		lblCurrentUserOrdutegia.setBounds(20, 70, 400, 20);
		contentPane.add(lblCurrentUserOrdutegia);

		// Botón "Atzera"
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("Arial", Font.BOLD, 13));
		btnAtzera.setForeground(Color.WHITE);
		btnAtzera.setBackground(new Color(0, 102, 204)); // Azul intenso
		btnAtzera.setBounds(480, 60, 120, 30);
		btnAtzera.addActionListener(e -> {
		});
		contentPane.add(btnAtzera);

		// Crear y mostrar la tabla de horarios
		createTable(stockList);
	}

	private void createTable(ArrayList<Stock> stockList) {
	    // Definir nombres de columnas
	    String[] columnNames = { "Company", "Description", "Initial Price", "Price 2002", "Price 2007", "Symbol" };
	    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

	    // Llenar la tabla con los datos de stockList
	    for (Stock stock : stockList) {
	        Object[] rowData = {
	            stock.getCompany(),
	            stock.getDescription(),
	            stock.getInitialPrice(),
	            stock.getPrice2002(),
	            stock.getPrice2007(),
	            stock.getSymbol()
	        };
	        tableModel.addRow(rowData);
	    }

	    // Crear la tabla con el modelo
	    JTable table = new JTable(tableModel);
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(20, 110, 600, 280);
	    contentPane.add(scrollPane);
	}


}
