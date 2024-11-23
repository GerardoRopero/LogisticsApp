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

public class VistaInforme extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnConsultarInformes;
	public JTable tableInforme;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaInforme frame = new VistaInforme();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("serial")
	public VistaInforme() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 645, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnConsultarInformes = new JButton("CONSULTAR INFORMES");
		btnConsultarInformes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultarInformes.setBounds(210, 11, 196, 23);
		contentPane.add(btnConsultarInformes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 609, 208);
		contentPane.add(scrollPane);
		
		tableInforme = new JTable();
		tableInforme.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, "", null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"#FACTURA", "FECHA", "ID CLIENTE", "NOMBRE CLIENTE", "REDUCCION", "AUMENTO", "TOTAL VENTA"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableInforme.getColumnModel().getColumn(3).setPreferredWidth(99);
		tableInforme.getColumnModel().getColumn(6).setPreferredWidth(82);
		tableInforme.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(tableInforme);
	}

}

