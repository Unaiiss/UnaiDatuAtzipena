package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class añadirMensaje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEmisor;
	private JTextField textFieldDestinatario;
	private JTextField textFieldAsunto;

	/**
	 * Create the frame.
	 */
	public añadirMensaje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmisor = new JLabel("Emisor");
		lblEmisor.setFont(new Font("Arial", Font.BOLD, 12));
		lblEmisor.setBounds(47, 28, 46, 14);
		contentPane.add(lblEmisor);
		
		JLabel lblDestinatario = new JLabel("Destinatario");
		lblDestinatario.setFont(new Font("Arial", Font.BOLD, 12));
		lblDestinatario.setBounds(205, 28, 73, 14);
		contentPane.add(lblDestinatario);
		
		JLabel lblAsunto = new JLabel("Asunto");
		lblAsunto.setFont(new Font("Arial", Font.BOLD, 12));
		lblAsunto.setBounds(47, 78, 46, 14);
		contentPane.add(lblAsunto);
		
		JLabel lblContenido = new JLabel("Contenido");
		lblContenido.setFont(new Font("Arial", Font.BOLD, 12));
		lblContenido.setBounds(47, 132, 67, 14);
		contentPane.add(lblContenido);
		
		textFieldEmisor = new JTextField();
		textFieldEmisor.setBounds(47, 47, 86, 20);
		contentPane.add(textFieldEmisor);
		textFieldEmisor.setColumns(10);
		
		textFieldDestinatario = new JTextField();
		textFieldDestinatario.setColumns(10);
		textFieldDestinatario.setBounds(205, 47, 86, 20);
		contentPane.add(textFieldDestinatario);
		
		textFieldAsunto = new JTextField();
		textFieldAsunto.setColumns(10);
		textFieldAsunto.setBounds(47, 92, 86, 20);
		contentPane.add(textFieldAsunto);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				menu frame = new menu();
				frame.setVisible(true);
			}
		});
		btnVolver.setBounds(335, 11, 89, 23);
		contentPane.add(btnVolver);
		
		JTextArea textAreaContenido = new JTextArea();
		textAreaContenido.setBounds(47, 153, 333, 93);
		contentPane.add(textAreaContenido);
	}
}
