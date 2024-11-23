package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VistaNoPerecedero extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lblId;
	public JLabel lblNombre;
	public JLabel lblPrecio;
	public JLabel lblCalidadProducto;
	public JButton btnBuscar;
	public JButton btnModificar;
	public JButton btnRegistrar;
	public JButton btnEliminar;
	public JButton btnLimpiarDatos;
	public JTextField textFId;
	public JTextField textFNombre;
	public JTextField textFPrecio;
	public JComboBox<String> comboBCalidadProducto;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaNoPerecedero frame = new VistaNoPerecedero();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VistaNoPerecedero() {
		setTitle("DATOS DE NO PERECEDERO");
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
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(130, 9, 89, 20);
		contentPane.add(btnBuscar);
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(10, 36, 54, 14);
		contentPane.add(lblNombre);
		
		textFNombre = new JTextField();
		textFNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFNombre.setBounds(74, 33, 251, 20);
		contentPane.add(textFNombre);
		textFNombre.setColumns(10);
		
		lblPrecio = new JLabel("PRECIO");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(10, 61, 48, 14);
		contentPane.add(lblPrecio);
		
		textFPrecio = new JTextField();
		textFPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFPrecio.setBounds(73, 58, 110, 20);
		contentPane.add(textFPrecio);
		textFPrecio.setColumns(10);
		
		lblCalidadProducto = new JLabel("CALIDAD PRODUCTO");
		lblCalidadProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCalidadProducto.setBounds(10, 86, 133, 14);
		contentPane.add(lblCalidadProducto);
		
		comboBCalidadProducto = new JComboBox<String>();
		comboBCalidadProducto.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3"}));
		comboBCalidadProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBCalidadProducto.setBounds(153, 84, 66, 22);
		contentPane.add(comboBCalidadProducto);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrar.setBounds(10, 110, 110, 23);
		contentPane.add(btnRegistrar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificar.setBounds(130, 110, 110, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(250, 110, 110, 23);
		contentPane.add(btnEliminar);
		
		btnLimpiarDatos = new JButton("LIMPIAR DATOS");
		btnLimpiarDatos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiarDatos.setBounds(10, 144, 140, 23);
		contentPane.add(btnLimpiarDatos);
	}
}

