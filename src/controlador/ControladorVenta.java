	package controlador;
	
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.JOptionPane;
	import javax.swing.table.DefaultTableModel;
	import modelo.dao.ClienteDAO;
	import modelo.dao.NoPerecederoDAO;
	import modelo.dao.PerecederoDAO;
	import modelo.dao.VentaDAO;
	import modelo.dto.Cliente;
	import modelo.dto.DetalleCompra;
	import modelo.dto.NoPerecedero;
	import modelo.dto.Perecedero;
	import modelo.dto.Venta;
	import vista.VistaVenta;
	
	public class ControladorVenta implements ActionListener {
		private VistaVenta vista;
		private VentaDAO modeloV;
		private Venta venta;
		private ClienteDAO modeloC;
		private Cliente cliente;
		private PerecederoDAO modeloP;
		private Perecedero perecedero;
		private NoPerecederoDAO modeloN;
		private NoPerecedero noPerecedero;
		private DetalleCompra detalleCompra;
		private DefaultTableModel modeloT;
		
		public ControladorVenta(VistaVenta vista) {
			this.vista = vista;
			this.modeloV = new VentaDAO();
			this.modeloC = new ClienteDAO();
			this.modeloP = new PerecederoDAO();
			this.modeloN = new NoPerecederoDAO();
			this.venta = new Venta();
			this.modeloT = (DefaultTableModel) this.vista.tableDetalleCompra.getModel();
			this.vista.btnBuscarVenta.addActionListener(this);
			this.vista.btnBuscarCliente.addActionListener(this);
			this.vista.btnBuscarProducto.addActionListener(this);
			this.vista.btnRegistrarVenta.addActionListener(this);
			this.vista.btnCalcularTotal.addActionListener(this);
			this.vista.btnLimpiarDatos.addActionListener(this);
			this.vista.textFFecha.setText(String.valueOf(venta.getFecha()));
			this.vista.setVisible(true);
			int filas = modeloT.getRowCount();
			for (int i = 0; i < filas; i++) {
				modeloT.removeRow(0);
			}
		}
		
		public void limpiarDatos() {
			vista.textFIdVenta.setText("");
			vista.textFIdCliente.setText("");
			vista.textFNombreCliente.setText("");
			vista.textFIdProducto.setText("");
			int filas = modeloT.getRowCount();
			for (int i = 0; i < filas; i++) {
				modeloT.removeRow(0);
			}
			vista.textFTotalVenta.setText("");
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(vista.btnBuscarVenta)) {
				venta = modeloV.read(Integer.valueOf(vista.textFIdVenta.getText()));
				limpiarDatos();
				if (venta == null) {
					JOptionPane.showMessageDialog(null, "YUCA, error, venta no existe.");
				} else {
					vista.textFIdVenta.setText(String.valueOf(venta.getId()));
					vista.textFIdCliente.setText(String.valueOf(venta.getCliente().getId()));
					vista.textFNombreCliente.setText(venta.getCliente().getNombre());
					for (DetalleCompra detalle : venta.getListaDetalles()) {
						Object[] fila = {detalle.getProducto().getId(), detalle.getProducto().getNombre(), detalle.getProducto().getPrecioFinal(), detalle.getCantidad()};
						modeloT.addRow(fila);
					}
					
					vista.textFTotalVenta.setText(String.valueOf(venta.getTotalVenta()));
				}
			}
			
			if (e.getSource().equals(vista.btnBuscarCliente)) {
				cliente = modeloC.read(Integer.valueOf(vista.textFIdCliente.getText()));
				if (cliente == null) {
					JOptionPane.showMessageDialog(null, "YUCA, error, cliente no existe.");
				} else {
					vista.textFNombreCliente.setText(cliente.getNombre());
				}
			}
			
			if (e.getSource().equals(vista.btnBuscarProducto)) {		
				perecedero = modeloP.read(Integer.valueOf(vista.textFIdProducto.getText()));
				noPerecedero = modeloN.read(Integer.valueOf(vista.textFIdProducto.getText()));
				vista.textFIdProducto.setText("");
				if (perecedero != null) {
					Object[] fila = {perecedero.getId(), perecedero.getNombre(), perecedero.getPrecioFinal()};
					modeloT.addRow(fila);
				} else if (noPerecedero != null) {
					Object[] fila = {noPerecedero.getId(), noPerecedero.getNombre(), noPerecedero.getPrecioFinal()};
					modeloT.addRow(fila);
				} else {
					JOptionPane.showMessageDialog(null, "YUCA, error, producto no existe.");
				}
			}
			
			if (e.getSource().equals(vista.btnCalcularTotal)) {
				int filas = modeloT.getRowCount();
				double totalVenta = 0.0;
				
				for (int i = 0; i < filas; i++) {
					Object cantidad = modeloT.getValueAt(i, 3);
					Object precioFinal = modeloT.getValueAt(i, 2);
					
					totalVenta += Double.valueOf(precioFinal.toString()) * Integer.valueOf(cantidad.toString());
				}
				vista.textFTotalVenta.setText(String.valueOf(totalVenta));
			}
			
			
			if (e.getSource().equals(vista.btnRegistrarVenta)) {
				venta = new Venta();
				cliente = modeloC.read(Integer.valueOf(vista.textFIdCliente.getText()));
				venta.setId(Integer.valueOf(vista.textFIdVenta.getText()));
				venta.setCliente(cliente);
				
				int filas = modeloT.getRowCount();
				
				for (int i = 0; i < filas; i++) {
					Object cantidad = modeloT.getValueAt(i, 3);
					Object id = modeloT.getValueAt(i, 0);
					perecedero = modeloP.read(Integer.valueOf(id.toString()));
					noPerecedero = modeloN.read(Integer.valueOf(id.toString()));
					if (perecedero != null) {
						detalleCompra = new DetalleCompra();
						detalleCompra.setProducto(perecedero);
						detalleCompra.setCantidad(Integer.valueOf(cantidad.toString()));
						venta.getListaDetalles().add(detalleCompra);
					} else {
						detalleCompra = new DetalleCompra();
						detalleCompra.setProducto(noPerecedero);
						detalleCompra.setCantidad(Integer.valueOf(cantidad.toString()));
						venta.getListaDetalles().add(detalleCompra);
					}
				}
				
				venta.setTotalVenta(Double.valueOf(vista.textFTotalVenta.getText()));
				
				limpiarDatos();
				
				if (modeloV.create(venta)) {
					JOptionPane.showMessageDialog(null, "Se adiciona una nueva venta a los datos.");
				} else {
					JOptionPane.showMessageDialog(null, "YUCA, error al adicionar una nueva venta.");
				}
			}
			
			if (e.getSource().equals(vista.btnLimpiarDatos)) {
				limpiarDatos();
			}
		}
	}