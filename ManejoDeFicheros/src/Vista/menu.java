package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton btnCargarMensajes = new JButton("Cargar mensajes");
		btnCargarMensajes.setBounds(52, 56, 148, 23);
		btnCargarMensajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnCargarMensajes);

		JButton btnGuardarMensajes = new JButton("Guardar Mensajes");
		btnGuardarMensajes.setBounds(239, 56, 148, 23);
		btnGuardarMensajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnGuardarMensajes);

		JButton btnAñadirMensaje = new JButton("Añadir Mensaje");
		btnAñadirMensaje.setBounds(52, 139, 148, 23);
		btnAñadirMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				añadirMensaje añadirM = new añadirMensaje();
				añadirM.setVisible(true);

			}
		});
		contentPane.add(btnAñadirMensaje);

		JButton btnImprimirMensajes = new JButton("Imprimir Mensajes");
		btnImprimirMensajes.setBounds(239, 139, 148, 23);
		btnImprimirMensajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnImprimirMensajes);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(298, 212, 89, 23);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnSalir);
	}
}
