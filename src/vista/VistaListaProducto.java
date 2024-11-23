package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class VistaListaProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnConsultarProductos;
	public JTable tableListaProductos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaListaProducto frame = new VistaListaProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VistaListaProducto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnConsultarProductos = new JButton("CONSULTAR LISTA PRODUCTOS");
		btnConsultarProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultarProductos.setBounds(90, 11, 244, 23);
		contentPane.add(btnConsultarProductos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 37, 414, 213);
		contentPane.add(scrollPane);
		
		tableListaProductos = new JTable();
		tableListaProductos.setModel(new DefaultTableModel(
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
				"CODIGO", "NOMBRE", "PRECIO FINAL", "TIPO"
			}
		));
		tableListaProductos.getColumnModel().getColumn(1).setPreferredWidth(84);
		tableListaProductos.getColumnModel().getColumn(2).setPreferredWidth(93);
		tableListaProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(tableListaProductos);
	}
}

