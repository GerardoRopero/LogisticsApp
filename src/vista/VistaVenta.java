package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VistaVenta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lblIdVenta;
	public JLabel lblFecha;
	public JLabel lblIdCliente;
	public JLabel lblNombreCliente;
	public JLabel lblIdProducto;
	public JLabel lblTotalVenta;
	public JTextField textFIdVenta;
	public JTextField textFFecha;
	public JTextField textFIdCliente;
	public JTextField textFNombreCliente;
	public JTextField textFIdProducto;
	public JButton btnBuscarVenta;
	public JButton btnBuscarCliente;
	public JButton btnBuscarProducto;
	public JButton btnRegistrarVenta;
	public JButton btnLimpiarDatos;
	public JButton btnCalcularTotal;
	public JTable tableDetalleCompra;
	public JTextField textFTotalVenta;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaVenta frame = new VistaVenta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VistaVenta() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblIdVenta = new JLabel("ID VENTA");
		lblIdVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdVenta.setBounds(10, 11, 59, 14);
		contentPane.add(lblIdVenta);
		
		textFIdVenta = new JTextField();
		textFIdVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFIdVenta.setBounds(79, 10, 100, 20);
		contentPane.add(textFIdVenta);
		textFIdVenta.setColumns(10);
		
		btnBuscarVenta = new JButton("BUSCAR");
		btnBuscarVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarVenta.setBounds(189, 9, 89, 20);
		contentPane.add(btnBuscarVenta);
		
		lblFecha = new JLabel("FECHA");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(10, 36, 41, 14);
		contentPane.add(lblFecha);
		
		textFFecha = new JTextField();
		textFFecha.setBounds(61, 35, 100, 20);
		contentPane.add(textFFecha);
		textFFecha.setColumns(10);
		
		lblIdCliente = new JLabel("ID CLIENTE");
		lblIdCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdCliente.setBounds(10, 61, 71, 14);
		contentPane.add(lblIdCliente);
		
		textFIdCliente = new JTextField();
		textFIdCliente.setBounds(91, 60, 86, 20);
		contentPane.add(textFIdCliente);
		textFIdCliente.setColumns(10);
		
		btnBuscarCliente = new JButton("BUSCAR");
		btnBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarCliente.setBounds(189, 59, 89, 20);
		contentPane.add(btnBuscarCliente);
		
		lblNombreCliente = new JLabel("NOMBRE CLIENTE");
		lblNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreCliente.setBounds(10, 86, 111, 14);
		contentPane.add(lblNombreCliente);
		
		textFNombreCliente = new JTextField();
		textFNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFNombreCliente.setBounds(131, 85, 125, 20);
		contentPane.add(textFNombreCliente);
		textFNombreCliente.setColumns(10);
		
		lblIdProducto = new JLabel("ID PRODUCTO");
		lblIdProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdProducto.setBounds(10, 111, 91, 14);
		contentPane.add(lblIdProducto);
		
		textFIdProducto = new JTextField();
		textFIdProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFIdProducto.setBounds(111, 111, 86, 20);
		contentPane.add(textFIdProducto);
		textFIdProducto.setColumns(10);
		
		btnBuscarProducto = new JButton("BUSCAR");
		btnBuscarProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarProducto.setBounds(207, 109, 89, 20);
		contentPane.add(btnBuscarProducto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 136, 414, 114);
		contentPane.add(scrollPane);
		
		tableDetalleCompra = new JTable();
		tableDetalleCompra.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID PRODUCTO", "NOMBRE", "PRECIO FINAL", "CANTIDAD"
			}
		));
		tableDetalleCompra.getColumnModel().getColumn(0).setPreferredWidth(84);
		tableDetalleCompra.getColumnModel().getColumn(2).setPreferredWidth(81);
		tableDetalleCompra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(tableDetalleCompra);
		
		btnRegistrarVenta = new JButton("REGISTRAR VENTA");
		btnRegistrarVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrarVenta.setBounds(10, 286, 151, 23);
		contentPane.add(btnRegistrarVenta);
		
		lblTotalVenta = new JLabel("TOTAL VENTA");
		lblTotalVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotalVenta.setBounds(10, 261, 89, 14);
		contentPane.add(lblTotalVenta);
		
		textFTotalVenta = new JTextField();
		textFTotalVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFTotalVenta.setBounds(111, 258, 118, 20);
		contentPane.add(textFTotalVenta);
		textFTotalVenta.setColumns(10);
		
		btnCalcularTotal = new JButton("CALCULAR TOTAL");
		btnCalcularTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCalcularTotal.setBounds(238, 257, 156, 23);
		contentPane.add(btnCalcularTotal);
		
		btnLimpiarDatos = new JButton("LIMPIAR DATOS");
		btnLimpiarDatos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiarDatos.setBounds(171, 286, 156, 23);
		contentPane.add(btnLimpiarDatos);
	}
}

