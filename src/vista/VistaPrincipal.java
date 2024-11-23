package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;

public class VistaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JMenuBar menuBar;
	public JMenu mnDatos;
	public JMenuItem mntmPerecedero;
	public JMenuItem mntmNoPerecedero;
	public JMenuItem mntmCliente;
	public JMenu mnVenta;
	public JMenuItem mntmCrearVenta;
	public JMenu mnConsultas;
	public JMenuItem mntmListaProductos;
	public JMenuItem mntmInformeVentas;
	public JMenuItem mntmProductosPerecederos;
	public JMenu mnSalir;
	public JMenuItem mntmSalir;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal frame = new VistaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VistaPrincipal() {
		setTitle("LOGISTICS APP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 22);
		contentPane.add(menuBar);
		
		mnDatos = new JMenu("DATOS");
		mnDatos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(mnDatos);
		
		mntmPerecedero = new JMenuItem("PERECEDERO");
		mntmPerecedero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mnDatos.add(mntmPerecedero);
		
		mntmNoPerecedero = new JMenuItem("NO PERECEDERO");
		mntmNoPerecedero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mnDatos.add(mntmNoPerecedero);
		
		mntmCliente = new JMenuItem("CLIENTE");
		mntmCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mnDatos.add(mntmCliente);
		
		mnVenta = new JMenu("VENTA");
		mnVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(mnVenta);
		
		mntmCrearVenta = new JMenuItem("CREAR VENTA");
		mntmCrearVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mnVenta.add(mntmCrearVenta);
		
		mnConsultas = new JMenu("CONSULTAS");
		mnConsultas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(mnConsultas);
		
		mntmListaProductos = new JMenuItem("LISTA DE PRODUCTOS");
		mntmListaProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mnConsultas.add(mntmListaProductos);
		
		mntmProductosPerecederos = new JMenuItem("LISTA DE PRODUCTOS PERECEDEROS");
		mntmProductosPerecederos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mnConsultas.add(mntmProductosPerecederos);
		
		mntmInformeVentas = new JMenuItem("INFORME DE VENTAS");
		mntmInformeVentas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mnConsultas.add(mntmInformeVentas);
		
		mnSalir = new JMenu("SALIR");
		mnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(mnSalir);
		
		mntmSalir = new JMenuItem("SALIR");
		mntmSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mnSalir.add(mntmSalir);
	}
}

