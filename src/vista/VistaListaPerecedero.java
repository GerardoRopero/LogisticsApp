package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VistaListaPerecedero extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JButton btnConsultarPerecederos;
	public JTable tableListaPerecederos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaListaPerecedero frame = new VistaListaPerecedero();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("serial")
	public VistaListaPerecedero() {
		setTitle("CONSULTA DE PERECEDEROS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnConsultarPerecederos = new JButton("CONSULTAR PERECEDEROS");
		btnConsultarPerecederos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultarPerecederos.setBounds(108, 11, 209, 23);
		contentPane.add(btnConsultarPerecederos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 414, 209);
		contentPane.add(scrollPane);
		
		tableListaPerecederos = new JTable();
		tableListaPerecederos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CODIGO", "NOMBRE", "PRECIO FINAL", "DIAS CADUCA"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableListaPerecederos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(tableListaPerecederos);
	}
}
