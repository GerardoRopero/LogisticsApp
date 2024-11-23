package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaCliente extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lblId;
	public JLabel lblNombre;
	public JButton btnBuscar;
	public JButton btnRegistrar;
	public JButton btnModificar;
	public JButton btnEliminar;
	public JButton btnLimpiarDatos;
	public JTextField textFId;
	public JTextField textFNombre;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCliente frame = new VistaCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VistaCliente() {
		setTitle("DATOS DEL CLIENTE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(10, 11, 14, 14);
		contentPane.add(lblId);
		
		textFId = new JTextField();
		textFId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFId.setBounds(34, 10, 86, 20);
		contentPane.add(textFId);
		textFId.setColumns(10);
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(10, 36, 54, 14);
		contentPane.add(lblNombre);
		
		textFNombre = new JTextField();
		textFNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFNombre.setBounds(74, 35, 255, 20);
		contentPane.add(textFNombre);
		textFNombre.setColumns(10);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(130, 9, 89, 20);
		contentPane.add(btnBuscar);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrar.setBounds(10, 61, 110, 23);
		contentPane.add(btnRegistrar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificar.setBounds(130, 61, 110, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(250, 61, 110, 23);
		contentPane.add(btnEliminar);
		
		btnLimpiarDatos = new JButton("LIMPIAR DATOS");
		btnLimpiarDatos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiarDatos.setBounds(10, 95, 140, 23);
		contentPane.add(btnLimpiarDatos);
	}
}

